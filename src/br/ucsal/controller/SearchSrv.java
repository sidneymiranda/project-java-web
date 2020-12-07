package br.ucsal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.dao.BookDao;

public class SearchSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchSrv() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String query = request.getParameter("query").toUpperCase();
		
		new BookDao().find(query, session);
		
		response.sendRedirect("pages/profile/user/home.jsp");
	}

}
