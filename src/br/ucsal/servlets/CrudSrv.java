package br.ucsal.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.controller.BookDao;
import br.ucsal.model.Book;

public class CrudSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrudSrv() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		List<Book> listBooks = (List<Book>) session.getAttribute("listBooks");

		listBooks = (listBooks == null) ? new ArrayList<Book>() : listBooks;

		String author = req.getParameter("author");
		String title = req.getParameter("title");
		String year = req.getParameter("year");
		String isbn = req.getParameter("isbn");
		String edition = req.getParameter("edition") == null ? "NÃO INFORMADO" : req.getParameter("edition");
		String sinope = req.getParameter("sinope") == null ? "NÃO INFORMADO" : req.getParameter("sinopse");
		String genre = req.getParameter("genre") == null ? "NÃO INFORMADO" : req.getParameter("genre");
		String idioma = req.getParameter("idioma") == null ? "NÃO INFORMADO" : req.getParameter("idioma");

		String action = req.getParameter("action");
		
		switch (action) {

		case "create":
			if (new BookDao().insert(new Book(title.toUpperCase(), author.toUpperCase(), year,
					isbn.toUpperCase(), edition, idioma.toUpperCase(), genre.toUpperCase(), sinope.toUpperCase()),
					listBooks)) {

				session.setAttribute("listBooks", listBooks);
			};
			res.sendRedirect("pages/profile/employee/home.jsp");
			break;

		case "read":
			new BookDao().toList();

			break;

		case "update":
			if(new BookDao().update(isbn, author,edition, year, listBooks)) {
				session.setAttribute("listBooks", listBooks);
			}
			res.sendRedirect("pages/profile/employee/home.jsp");
			break;

		case "delete":
			if (new BookDao().remove(isbn, listBooks)) {
				session.setAttribute("listBooks", listBooks);
				res.sendRedirect("pages/profile/employee/home.jsp");
			}
			break;

		default:
			break;
		}
	}

}
