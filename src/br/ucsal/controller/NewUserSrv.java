package br.ucsal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.dao.UserDao;
import br.ucsal.model.User;

public class NewUserSrv extends HttpServlet {
	private static final long serialVersionUID = -3470928178875222284L;

	public NewUserSrv() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		String action = req.getParameter("action");
		switch (action) {
		
		case "insert":
			String register = req.getParameter("register");
			String name = req.getParameter("name");
			String password = req.getParameter("password");

			User user = new User(name, register, password);
			new UserDao().insert(user, session);
			res.sendRedirect("pages/login.jsp");
			break;
		default:
			break;
		}

	}
}
