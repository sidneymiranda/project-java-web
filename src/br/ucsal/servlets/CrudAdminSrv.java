package br.ucsal.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.controller.UserDao;
import br.ucsal.model.User;

public class CrudAdminSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrudAdminSrv() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<User> listUsers = (List<User>) session.getAttribute("listUsers");

		String register = req.getParameter("register");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String confirmPasswd = req.getParameter("confirmPassword");
		String typeUser = req.getParameter("typeUser");
		
		String action = req.getParameter("action");
		
		switch (action) {
		case "create":
			if(new UserDao()
					.insert(new User(name,register,password,typeUser), listUsers)) {
				session.setAttribute("listUsers", listUsers);
			}
			res.sendRedirect("pages/profile/admin/users.jsp");
			break;
		
		case "read":
			
			res.sendRedirect("pages/profile/admin/users.jsp");
			break;
		
		case "update":
			String passwordOld = req.getParameter("passwordOld");
			String newPassword = req.getParameter("newPassword");
			
			if(new UserDao()
					.update(register, passwordOld, newPassword, listUsers)) {
				session.setAttribute("listUsers", listUsers);
			}
			
			res.sendRedirect("pages/profile/admin/users.jsp");
			break;
		
		case "delete":
			if(new UserDao()
					.remove(register, listUsers)) {
				session.setAttribute("listUsers", listUsers);
			}
			
			res.sendRedirect("pages/profile/admin/users.jsp");
			break;

		default:
			res.sendRedirect("pages/profile/admin/users.jsp");
			break;
		}
	}
}
