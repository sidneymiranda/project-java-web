package br.ucsal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.dao.UserDao;
import br.ucsal.dao.UserDao2;
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
		case "validar":
			String param = req.getParameter("register");
			String msg = "Matrícula informada já existe no banco de dados!";

			if (new UserDao2().validate(param)) {
				msg = "Usuário liberado para cadastro!";
			}
			
			PrintWriter pr = res.getWriter();
			res.setContentType("text/xml");
			pr.println("<response>");
			pr.println("<result>" + msg + "</result>");
			pr.println("</response>");
			pr.close();
			break;
		
		case "insert":
			String register = req.getParameter("register");
			String name = req.getParameter("name");
			String password = req.getParameter("password");

			User user = new User(name, register, password);
			try {
				new UserDao().insert(user, session);
				res.sendRedirect("pages/login.jsp");
			} catch (IOException e) {
				throw new IOException(e);
			}
			break;
		default:
			break;
		}

	}
}
