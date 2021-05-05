package br.com.garbo.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.garbo.enumerations.Niveis;
import br.com.garbo.interfaces.IDocumento;
import br.com.garbo.models.Cliente;
import br.com.garbo.models.DocumentoCPF;
import br.com.garbo.models.DocumentoCnpj;
import br.com.garbo.models.Prestador;
import br.com.garbo.models.Usuario;
import br.com.garbo.repository.Repositorio;
import br.com.garbo.utilities.Utils;

@WebServlet(urlPatterns = {"/admin/cadastro", "/admin/listaClientes"})
public class CadastrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastrosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String caminho = request.getServletPath();
		
		if (caminho.equals("/admin/cadastro")) {
			
			String opcao = request.getParameter("opcao");
			try {
				String pagina = "/WEB-INF/admin/";
				if (opcao != null) {
					switch (opcao) {
					case "u":
						pagina += "cadUsuarios.jsp";
						break;
					case "c":
						pagina += "cadClientes.jsp";

						Collection<Usuario> listaUsuarios = Repositorio.getUsuarioDao().listar().stream()
								.filter(u -> u.getNivel().equals(Niveis.CLIENTE)).collect(Collectors.toList());

						if (listaUsuarios.size() == 0) {
							throw new Exception("Não existem usuários com o nível esperado.");
						}

						request.setAttribute("usuarios", listaUsuarios);

						break;
					case "p":
						pagina += "cadPrestadores.jsp";
						break;
					default:
						throw new Exception("Esta opção é inválida: " + opcao);
					}

					request.getRequestDispatcher(pagina).forward(request, response);

				} else {
					pagina += "home.jsp";
					request.getRequestDispatcher(pagina).forward(request, response);
				}

			} catch (Exception e) {
				request.setAttribute("mensagemErro", e.getMessage());
				request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
			} 
		} else if(caminho.equals("/admin/listaClientes")){
			try {
				request.setAttribute("listaClientes", Repositorio.getClienteDao().listar());				
				request.getRequestDispatcher("/WEB-INF/admin/listaClientes.jsp").forward(request, response);	
			} catch (Exception e) {
				request.setAttribute("mensagemErro", e.getMessage());
				request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
			}			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String opcao = request.getParameter("opcao");
			
			switch (opcao) {
			case "u":
				incluirUsuario(request, response);
				break;
			case "c":
				incluirCliente(request, response);
				break;
			case "p":
				incluirPrestador(request, response);
				break;				
			default:
				break;
			}
			
		} catch (Exception e) {
			request.setAttribute("mensagemErro", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
		}
	}
	
	private void incluirUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String nome = request.getParameter("txtNome");
		String senha = request.getParameter("txtSenha");
		String nivel = request.getParameter("cmbNivel");
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setNivel(Utils.buscarNivel(nivel));
		
		Repositorio.getUsuarioDao().incluir(usuario);
		
		request.setAttribute("resultado", "Usuário incluído com sucesso.");
		request.getRequestDispatcher("/WEB-INF/admin/cadUsuarios.jsp").forward(request, response);		
	}
	
	private void incluirCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String telefone = request.getParameter("txtTelefone");
		String usuario = request.getParameter("cmbUsuario");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		cliente.setUsuario(Repositorio.getUsuarioDao().buscar(usuario));
		
		Repositorio.getClienteDao().incluir(cliente);
		
		request.setAttribute("listaClientes", Repositorio.getClienteDao().listar());
		request.getRequestDispatcher("/WEB-INF/admin/listaClientes.jsp").forward(request, response);
	}
	
	private void incluirPrestador(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		try {
			Prestador prest = new Prestador();
			Usuario usuario = new Usuario();
			IDocumento doc;
			
			if (request.getParameter("optionCPF").equals("on")) {
				doc = new DocumentoCPF();
				doc.setNumero(request.getParameter("txtDocumento"));
			}else {
				doc = new DocumentoCnpj();
				doc.setNumero(request.getParameter("txtDocumento"));
			}

			usuario.setNome(request.getParameter("txtDocumento"));
			usuario.setSenha(request.getParameter("txtSenha"));
			usuario.setNivel(Niveis.PREST);
			
			prest.setDocumento(doc);
			prest.setUsuario(usuario);

			String nome = request.getParameter("txtNome");
			String email = request.getParameter("txtEmail");
			String telefone = request.getParameter("txtTelefone");
				
			prest.setNome(nome);
			prest.setEmail(email);
			prest.setTelefone(telefone);
			
			Repositorio.getPrestadoresDao().incluir(prest);					
			
			request.setAttribute("listaPrestadores", Repositorio.getPrestadoresDao().listar());
			request.getRequestDispatcher("/WEB-INF/admin/listaPrestadores.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("mensagemErro", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
		}
	}	
}
