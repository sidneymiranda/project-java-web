package br.ucsal.dao;

import javax.servlet.http.HttpSession;

import br.ucsal.model.Book;

public interface IBook {

	public boolean insert(Book book, HttpSession session);
	
	public void find(String parametro, HttpSession session);
	
	public boolean update(Book book, HttpSession session);
	
	public boolean remove(Book book, HttpSession session);
	
	
}
