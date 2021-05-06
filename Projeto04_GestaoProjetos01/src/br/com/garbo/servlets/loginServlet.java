package br.com.garbo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.garbo.models.Usuario;
import br.com.garbo.repository.Repositorio;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario)session.getAttribute("session_usuario");
		
		if (usuario != null) {
			session.invalidate();
			//session.removeAttribute("session_usuario");
		}

		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("txtNome");
			String senha = request.getParameter("txtSenha");
			
			Usuario usuario = Repositorio.getUsuarioDao().validar(nome, senha);
			
			if (usuario == null) {
				request.setAttribute("resultado", "Usuário ou Senha inválidos.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("session_usuario", usuario);
				response.sendRedirect(request.getContextPath() + "/admin/cadastro");
			}
			
		} catch (Exception e) {
			request.setAttribute("mensagemErro", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/admin/erro.jsp").forward(request, response);
		}
	}

}
