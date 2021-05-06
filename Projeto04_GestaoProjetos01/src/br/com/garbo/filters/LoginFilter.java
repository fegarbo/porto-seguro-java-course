package br.com.garbo.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.garbo.models.Usuario;

@WebFilter("/admin/*")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		//Obtendo a referencia a HttpServletRequest e HttpServletResponse
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario)session.getAttribute("session_usuario");
		
		if (usuario == null) {
			resp.sendRedirect(req.getContextPath() + "/login.jsp");			
		} else {
			chain.doFilter(request, response);
		}		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
