package br.ucsal.controller;

import java.io.IOException;
import java.time.LocalDate;

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
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String typeUser = req.getParameter("typeUser");
		String action = req.getParameter("action");
		LocalDate date = LocalDate.now();
		
		User user = new User(name, register, password, typeUser);

		switch (action) {
		
		case "create":
			new UserDao().insert(user, session);

			res.sendRedirect(URL);
			break;

		case "update":
			if (new UserDao().update(user, session)) {

				// msg de sucesso
			}

			res.sendRedirect(URL);
			break;

		case "delete":
			new UserDao().remove(user, session);
				// msg de sucesso
			
			res.sendRedirect(URL);
			break;

		default:
			res.sendRedirect(URL);
			break;
		}
	}
}
