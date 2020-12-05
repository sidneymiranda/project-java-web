package br.ucsal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.dao.BookDao;
import br.ucsal.dao.BookDao2;
import br.ucsal.model.Book;

public class CrudSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrudSrv() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		BookDao2 dao;

		switch (action) {
		case "getList":
			dao = new BookDao2();
			List<Book> listBooks = dao.getList();
			req.setAttribute("list", listBooks);
			break;
		case "remove":
			dao = new BookDao2();
			String msg;
			String isbn = req.getParameter("isbn").toUpperCase();
			msg = (dao.remove(isbn)) ? "<script>alert('Livro excluído com sucesso!')</script>"
					: "<script>Erro ao excluir.</script>";
			req.setAttribute("msg", msg);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String author = req.getParameter("author").toUpperCase();
		String title = req.getParameter("title").toUpperCase();
		String year = req.getParameter("year");
		String isbn = req.getParameter("isbn").toUpperCase();
		String edition = req.getParameter("edition") == "" ? "NÃO INFORMADO" : req.getParameter("edition");
		String sinope = req.getParameter("sinope") == "" ? "NÃO INFORMADO" : req.getParameter("sinopse").toUpperCase();
		String genre = req.getParameter("genre") == "" ? "NÃO INFORMADO" : req.getParameter("genre").toUpperCase();
		String idioma = req.getParameter("idioma") == "" ? "NÃO INFORMADO" : req.getParameter("idioma").toUpperCase();

		Book newBook = new Book(title, author, year, isbn, edition, idioma, genre, sinope);

//		String action = req.getParameter("action");
//		String profile = (String) session.getAttribute("profile");

//		no mysql
		String msg;
		BookDao2 dao = new BookDao2();
		if (req.getParameter("id") == null) {
			msg = (dao.insert(newBook)) ? "<script>alert('Livro cadastrado com sucesso!')</script>"
					: "<script>Erro ao cadastrar o livro.</script>";
		} else {
			msg = (dao.update(newBook)) ? "<script>alert('Livro atualizado com sucesso!')</script>"
					: "<script>Erro ao atualizar o livro.</script>";
		}
		req.setAttribute("msg", msg);
		RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
		dispatcher.forward(req, res);

//		na sessão
//		switch (action) {
//
//		case "create":
//			if (new BookDao().insert(newBook, session)) {
//
//				// setar uma msg de sucesso e emitir um alert na home
//			}
//
//			res.sendRedirect("pages/profile/" + profile + "/home.jsp");
//			break;
//
//		case "find":
//			String query = req.getParameter("query");
//
//			new BookDao().find(query);
//
//			break;
//
//		case "update":
//			if (new BookDao().update(newBook, session)) {
//				// setar uma msg de atualizado com sucesso e emitir um alert na home
//			}
//
//			res.sendRedirect("pages/profile/" + profile + "/home.jsp");
//			break;
//
//		case "delete":
//			if (new BookDao().remove(newBook, session)) {
//				// setar uma msg de atualizado com sucesso e emitir um alert na home
//			}
//			res.sendRedirect("pages/profile/" + profile + "/home.jsp");
//			break;
//
//		default:
//			break;
//		}
	}

}
