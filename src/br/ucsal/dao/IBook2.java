package br.ucsal.dao;

import java.util.List;

import br.ucsal.model.Book;

public interface IBook2 {

	public boolean insert(Book book);

	public List<Book> getList();
	
	public boolean update(Book book);
	
	public boolean remove(String isbn);
}
