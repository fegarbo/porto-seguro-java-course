package br.com.portoseguro.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Login Servlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//obtendo os dados de entrada do usuario
			String usuario = request.getParameter("txtUsuario");
			String password = request.getParameter("txtSenha");
			
			if (usuario.equals("admin") && password.equals("admin")) {
				request.setAttribute("mensagem", "Bem vindo, usuário autenticado.");
			}else {				
				request.setAttribute("mensagem", "Erro: Usuário ou senha inválidos.");
			}
			
		} catch (Exception e) {
			throw e;
		}
		finally {
			request.getRequestDispatcher("/WEB-INF/admin/resultado.jsp").forward(request, response);;
		}
	}

}
