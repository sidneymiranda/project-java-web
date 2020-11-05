package br.ucsal.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.model.User;

public class CreateUserSrv extends HttpServlet {
	private static final long serialVersionUID = -3470928178875222284L;

	public CreateUserSrv() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		List<User> listUsers = (List<User>) session.getAttribute("listUsers");

		listUsers = (listUsers == null) ? new ArrayList<User>() : listUsers;

		String register = req.getParameter("register");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String confirmPasswd = req.getParameter("confirmPassword");
		String typeUser = req.getParameter("typeUser") == null ? "default" : req.getParameter("typeUser");

		try {
			if (listUsers.isEmpty()) {
				session.setAttribute("listUsers", listUsers.add(new User("admin", "0000", "admin", "admin")));
			}

			if (typeUser != null && name != null && register != null && password != null) {
				if (password.equals(confirmPasswd)) {
					listUsers.add(new User(name, register, password, typeUser));

					session.setAttribute("listUsers", listUsers);

					// IMPLEMENTAR UMA MSG DE SUCESSO NA CRIAÇÃO DO USUÁRIO ANTES DE REDIRECIONAR
					if (typeUser.equals("admin")) {
						res.sendRedirect("/ProjectJavaWebJSP/pages/profile/admin/users.jsp");
					}
					res.sendRedirect("/ProjectJavaWebJSP/pages/login.jsp");
					return;
				}
			}

			res.sendRedirect("/ProjectJavaWebJSP/pages/registerUser/newUser.jsp");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
