package br.ucsal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.dao.BookDao;
import br.ucsal.model.Book;

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
		Book newBook = null;
		String query = null;
		String profile = (String) session.getAttribute("profile");
		String action = req.getParameter("action");
		
		if(action.equals("find")) {
			query = req.getParameter("query").toUpperCase();
		} else {
			String author = req.getParameter("author").toUpperCase();
			String title = req.getParameter("title").toUpperCase();
			String year = req.getParameter("year");
			String isbn = req.getParameter("isbn").toUpperCase();
			String edition = req.getParameter("edition") == "" ? "NÃO INFORMADO" : req.getParameter("edition");
			String sinope = req.getParameter("sinope") == "" ? "NÃO INFORMADO" : req.getParameter("sinopse").toUpperCase();
			String publishingCompany = req.getParameter("publishingCompany") == "" ? "NÃO INFORMADO" : req.getParameter("publishingCompany").toUpperCase();
			String idioma = req.getParameter("idioma") == "" ? "NÃO INFORMADO" : req.getParameter("idioma").toUpperCase();
			newBook = new Book(title, author, year, isbn, edition, idioma, publishingCompany, sinope);
		}

		switch (action) {
		case "create":
			new BookDao().insert(newBook, session);
			res.sendRedirect("pages/profile/" + profile + "/home.jsp");
			break;

		case "find":
			new BookDao().find(query, session);
			res.sendRedirect("pages/profile/" + profile + "/home.jsp");
			break;

		case "update":
			new BookDao().update(newBook, session); 
			res.sendRedirect("pages/profile/" + profile + "/home.jsp");
			break;

		case "delete":
			new BookDao().remove(newBook, session);
				
			res.sendRedirect("pages/profile/" + profile + "/home.jsp");
			break;
		}
	}

}
