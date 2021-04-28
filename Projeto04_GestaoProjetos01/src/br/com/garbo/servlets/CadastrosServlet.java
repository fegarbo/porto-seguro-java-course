package br.com.garbo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.garbo.jdbc.UsuarioDao;
import br.com.garbo.models.Usuario;
import br.com.garbo.utilities.Utils;

/**
 * Servlet implementation class CadastrosServlet
 */
@WebServlet("/admin/cadastro")
public class CadastrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastrosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String opcao = request.getParameter("opcao");
			
			switch (opcao) {
			case "u":
				incluirUsuario(request, response);
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
		
		UsuarioDao dao = new UsuarioDao();
		dao.incluir(usuario);
		
		request.setAttribute("resultado", "Usuário incluído com sucesso.");
		request.getRequestDispatcher("/WEB-INF/admin/cadUsuarios.jsp").forward(request, response);		
	}

}
