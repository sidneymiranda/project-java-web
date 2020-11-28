package br.ucsal.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import br.ucsal.model.BookModel;

public interface IBook {

	public boolean insert(BookModel bookModel, HttpSession session);
	
	public List<BookModel> find(String parametro);
	
	public boolean update(BookModel bookModel, HttpSession session);
	
	public boolean remove(BookModel bookModel, HttpSession session);
	
	
}
