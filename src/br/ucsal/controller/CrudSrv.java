package br.ucsal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.dao.BookDao;
import br.ucsal.model.BookModel;

public class CrudSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrudSrv() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		HttpSession session = req.getSession();

		String author = req.getParameter("author").toUpperCase();
		String title = req.getParameter("title").toUpperCase();
		String year = req.getParameter("year");
		String isbn = req.getParameter("isbn").toUpperCase();
		String edition = req.getParameter("edition") == "" ? "NÃO INFORMADO" : req.getParameter("edition");
		String sinope = req.getParameter("sinope") == "" ? "NÃO INFORMADO" : req.getParameter("sinopse").toUpperCase();
		String genre = req.getParameter("genre") == "" ? "NÃO INFORMADO" : req.getParameter("genre").toUpperCase();
		String idioma = req.getParameter("idioma") == "" ? "NÃO INFORMADO" : req.getParameter("idioma").toUpperCase();

		String action = req.getParameter("action");
		String profile = (String) session.getAttribute("profile");
		
		BookModel newBook = new BookModel(title, author, year, isbn, edition, idioma, genre, sinope);

		switch (action) {

		case "create":
			if (new BookDao().insert(newBook, session)) {

				// setar uma msg de sucesso e emitir um alert na home
			}

			res.sendRedirect("pages/profile/" + profile + "/home.jsp");
			break;

		case "find":
			String query = req.getParameter("query");
			
			new BookDao().find(query);

			break;

		case "update":
			if (new BookDao().update(newBook, session)) {
				// setar uma msg de atualizado com sucesso e emitir um alert na home
			}

			res.sendRedirect("pages/profile/" + profile + "/home.jsp");
			break;

		case "delete":
			if (new BookDao().remove(newBook, session)) {
				// setar uma msg de atualizado com sucesso e emitir um alert na home
			}
			res.sendRedirect("pages/profile/" + profile + "/home.jsp");
			break;

		default:
			break;
		}
	}

}
