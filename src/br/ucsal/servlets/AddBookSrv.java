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

import br.ucsal.model.Book;

public class AddBookSrv extends HttpServlet {

	private static final long serialVersionUID = -7000745908562139031L;

	public AddBookSrv() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		List<Book> listBooks = (List<Book>) session.getAttribute("listBooks");
		
		PrintWriter out = res.getWriter();

		listBooks = (listBooks == null) ? new ArrayList<Book>() : listBooks;
		
		String edition = req.getParameter("edition") == null ? " NÃO INFORMADO" : req.getParameter("edition");
		String sinope = req.getParameter("sinope") == null ? " NÃO INFORMADO" : req.getParameter("sinopse");
		String genre = req.getParameter("genre") == null ? " NÃO INFORMADO" : req.getParameter("genre");
		String idioma = req.getParameter("idioma") == null ? " NÃO INFORMADO" : req.getParameter("idioma");
		
		try {
			listBooks.add(new Book(req.getParameter("title").toUpperCase(), 
					req.getParameter("author").toUpperCase(),
					req.getParameter("year"), 
					req.getParameter("isbn").toUpperCase(), 
					edition,
					idioma.toUpperCase(), 
					genre.toUpperCase(),
					sinope.toUpperCase()));

			session.setAttribute("listBooks", listBooks);

			res.sendRedirect("pages/profile/admin/home.jsp");
			out.println("<script>alert('sucesso!');</script>");
			return;			
		} catch (IOException e) {
			res.sendRedirect("pages/profile/admin/register.jsp?user="+session.getAttribute("userLogado"));
			
			out.println("<script>alert('Erro no cadastro, tente novamente!');</script>");
		}		
	}
}
