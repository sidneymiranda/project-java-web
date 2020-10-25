package br.ucsal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.model.User;

public class AuthenticatorSrv extends HttpServlet {
	private static final long serialVersionUID = -1356624146512460800L;

	public AuthenticatorSrv() {
		super();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();

		List<User> listUsers = (List<User>) session.getAttribute("listUsers");

		String registry = req.getParameter("registry");
		String password = req.getParameter("password");

		if (registry != null && password != null && listUsers != null) {

			for (User u : listUsers) {
				if (u.getRegister().equals(registry) && u.getPassword().equals(password)) {
					
					session.setAttribute("userLogado", u.getName());
					session.setAttribute("authenticated", true);
					Cookie cookieLogin = new Cookie("user", u.getName());
					cookieLogin.setMaxAge(60 * 60 * 24);
					res.addCookie(cookieLogin);

					String profile = (u.getTypeUser().equals("admin")) ? "admin" : "user";					
					
					res.sendRedirect("/ProjectJavaWebJSP/pages/profile/" + profile + "/home.jsp?user=" + u.getName());
					return;
				}
			}

			out.println("<script>alert('Usuário e/ou senha incorreto(s)');</script>");
			res.sendRedirect("/ProjectJavaWebJSP/pages/login/login.jsp");
		} else {
			out.println("<script>alert('Não há usuários cadastrados no sistema!');</script>");
			res.sendRedirect("/ProjectJavaWebJSP/pages/login/login.jsp");
		}

	}
}
