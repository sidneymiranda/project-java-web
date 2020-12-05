package br.ucsal.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.ucsal.model.Book;

public interface IBook {

	public boolean insert(Book book, HttpSession session);
	
	public List<Book> find(String parametro);
	
	public boolean update(Book book, HttpSession session);
	
	public boolean remove(Book book, HttpSession session);
	
	
}
