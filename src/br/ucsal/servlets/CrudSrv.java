package br.ucsal.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.controller.BookController;
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

		String action = req.getParameter("action");

		String author = req.getParameter("name");
		String title = req.getParameter("title");
		String year = req.getParameter("year");
		String isbn = req.getParameter("isbn");
		String edition = req.getParameter("edition") == null ? "NÃO INFORMADO" : req.getParameter("edition");
		String sinope = req.getParameter("sinope") == null ? "NÃO INFORMADO" : req.getParameter("sinopse");
		String genre = req.getParameter("genre") == null ? "NÃO INFORMADO" : req.getParameter("genre");
		String idioma = req.getParameter("idioma") == null ? "NÃO INFORMADO" : req.getParameter("idioma");

		switch (action) {

		case "create":
			if (new BookController().insert(new Book(title.toUpperCase(), author.toUpperCase(), year,
					isbn.toUpperCase(), edition + "ª", idioma.toUpperCase(), genre.toUpperCase(), sinope.toUpperCase()),
					listBooks)) {

				session.setAttribute("listBooks", listBooks);
			};
			res.sendRedirect("pages/profile/admin/home.jsp?user=" + session.getAttribute("userLogado"));
			break;

		case "toList":
			new BookController().toList();

			break;

		case "update":
			new BookController().update(isbn, author, title, listBooks);

			break;

		case "delete":
			if (new BookController().remove(isbn, listBooks)) {
				session.setAttribute("listBooks", listBooks);
				res.sendRedirect("pages/profile/admin/home.jsp");
			}
			break;

		default:
			break;
		}
	}

}
