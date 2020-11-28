package br.ucsal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.dao.UserDao;
import br.ucsal.model.UserModel;

public class NewUserSrv extends HttpServlet {
	private static final long serialVersionUID = -3470928178875222284L;

	public NewUserSrv() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		HttpSession session = req.getSession();

		String register = req.getParameter("register");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String typeUser = "user";

		UserModel user = new UserModel(name, register, password, typeUser);

		try {
			new UserDao().insert(user, session);

			res.sendRedirect("pages/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
