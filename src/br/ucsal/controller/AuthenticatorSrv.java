package br.ucsal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.model.UserModel;

public class AuthenticatorSrv extends HttpServlet {
	private static final long serialVersionUID = -1356624146512460800L;

	public AuthenticatorSrv() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();

		List<UserModel> listUsers = (List<UserModel>) session.getAttribute("listUsers");

		String registry = req.getParameter("registry");
		String password = req.getParameter("password");

		if (registry != null && password != null && listUsers != null) {

			for (UserModel u : listUsers) {
				if (u.getRegister().equals(registry) && u.getPassword().equals(password)) {
					
					String profile = (u.getTypeUser().equals("admin")) ? "admin" : (u.getTypeUser().equals("employee")) ? "employee" : "user";
					session.setAttribute("userLogado", u.getName());
					session.setAttribute("profile", profile);

					res.sendRedirect("/VirtualBookcase/pages/profile/" + profile + "/home.jsp");
					return;
				}
			}
			
			res.sendRedirect("/VirtualBookcase/pages/login.jsp");
			out.println("<script>alert('Usuário e/ou senha incorreto(s)');</script>");
			return;
		} else {
			res.sendRedirect("/VirtualBookcase/pages/login.jsp");
			out.println("<script>alert('Não há usuários cadastrados no sistema!');</script>");
		}

	}
}
