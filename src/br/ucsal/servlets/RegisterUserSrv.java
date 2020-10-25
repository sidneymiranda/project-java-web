package br.ucsal.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.model.User;

public class RegisterUserSrv extends HttpServlet {
	private static final long serialVersionUID = -3470928178875222284L;

	public RegisterUserSrv() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		List<User> listUsers = (List<User>) session.getAttribute("listUsers");

		PrintWriter out = res.getWriter();

		listUsers = (listUsers == null) ? new ArrayList<User>() : listUsers;

		String register = req.getParameter("register");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String typeUser = req.getParameter("typeUser");

		try {
			if (register != null && name != null && password != null && typeUser != null) {
				listUsers.add(new User(name, register, password, typeUser));

				session.setAttribute("listUsers", listUsers);

				// IMPLEMENTAR UMA MSG DE SUCESSO NA CRIAÇÃO DO USUÁRIO ANTES DE REDIRECIONAR
				res.sendRedirect("/ProjectJavaWebJSP/pages/login/login.jsp");
				return;
			}

			req.getRequestDispatcher("newUser.jsp").forward(req, res);

		} catch (IOException e) {
			out.println("<script>alert('Erro no cadastro!');</script>");
			e.printStackTrace();
		}
	}
}
