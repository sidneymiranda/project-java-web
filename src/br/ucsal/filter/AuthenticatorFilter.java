package br.ucsal.filter;

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

@WebFilter(urlPatterns = {"/pages/profile/*"})
public class AuthenticatorFilter implements Filter {

	public AuthenticatorFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
//		boolean user = (Boolean) session.getAttribute("authenticated") == null ? false : (Boolean) session.getAttribute("authenticated");
		
		if (session.getAttribute("userLogado") == null) {
			res.sendRedirect("/VirtualBookcase/pages/login.jsp");
			return;
		}

		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
