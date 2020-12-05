package br.ucsal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.dao.UserDao;


public class AuthenticatorSrv extends HttpServlet {
	private static final long serialVersionUID = -1356624146512460800L;

	public AuthenticatorSrv() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String registry = req.getParameter("registry");
		String password = req.getParameter("password");
		UserDao userDao = new UserDao();

		if (userDao.exists(registry, password, session)) {
			String profile = (String) session.getAttribute("profile");

			res.sendRedirect("/VirtualBookcase/pages/profile/" + profile + "/home.jsp");
			return;
		}
		res.sendRedirect("/VirtualBookcase/pages/login.jsp");

	}
}
