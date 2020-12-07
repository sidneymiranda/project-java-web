package br.ucsal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.dao.UserDao;
import br.ucsal.model.User;

public class CrudAdminSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL = "pages/profile/admin/users.jsp";
	
	public CrudAdminSrv() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();

		String register = req.getParameter("register");
		String name = req.getParameter("name").toUpperCase();
		String password = req.getParameter("password");
		String typeUser = req.getParameter("typeUser");
		User user = new User(name, register, password, typeUser);

		String action = req.getParameter("action");
		switch (action) {
		
		case "create":
			new UserDao().insert(user, session);
			res.sendRedirect(URL);
			break;
		case "update":
			new UserDao().update(user, session);
			res.sendRedirect(URL);
			break;
		case "delete":
			new UserDao().remove(user, session);
			res.sendRedirect(URL);
			break;
		default:
			res.sendRedirect(URL);
			break;
		}
	}
}
