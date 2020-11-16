package br.ucsal.dao;

import java.util.List;

import br.ucsal.model.BookModel;

public interface IBook {

	public boolean insert(BookModel bookModel, List<BookModel> listBooks);
	
	public List<BookModel> toList();
	
	public boolean update(String isbn, String author, String edition, String year, List<BookModel> listBooks);
	
	public boolean remove(String id, List<BookModel> listBooks);
	
	
}
