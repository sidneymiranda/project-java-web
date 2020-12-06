package br.ucsal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.dao.UserDao2;
import br.ucsal.model.User;

@WebServlet("/login")
public class AuthenticatorSrv2 extends HttpServlet {
	private static final long serialVersionUID = -1356624146512460800L;

	public AuthenticatorSrv2() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String registry = req.getParameter("registry");
		String password = req.getParameter("password");
		User user = new User(registry, password);
		
		if (UserDao2.login(user)) {
			res.sendRedirect("/VirtualBookcase/pages/profile/admin/home.jsp");
			return;
		}
		res.sendRedirect("/VirtualBookcase/pages/login.jsp");

	}
}
