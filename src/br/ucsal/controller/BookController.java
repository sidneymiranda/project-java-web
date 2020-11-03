package br.ucsal.controller;

import java.util.List;

import br.ucsal.model.Book;

public class BookController implements IBook {

	@Override
	public boolean insert(Book book, List<Book> listBooks) {
		try {
			listBooks.add(book);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Book> toList() {

		return null;
	}

	@Override
	public boolean update(String isbn, String title, String author, List<Book> listBooks) {
		for (Book book : listBooks) {
			if (book.getIsbn().equals(isbn)) {
				book.setTitle(title);
				book.setauthor(author);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(String isbn, List<Book> listBooks) {
		for (Book obj : listBooks) {
			if (obj.getIsbn().equals(isbn)) {
				listBooks.remove(obj);
				return true;
			}
		}
		return false;
	}

}
