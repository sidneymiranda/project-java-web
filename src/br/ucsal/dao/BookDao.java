package br.ucsal.dao;

import java.util.List;

import br.ucsal.model.BookModel;

public class BookDao implements IBook {

	@Override
	public boolean insert(BookModel bookModel, List<BookModel> listBooks) {
		try {
			listBooks.add(bookModel);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<BookModel> toList() {

		return null;
	}

	@Override
	public boolean update(String isbn, String author, String edition, String year, List<BookModel> listBooks) {
		for (BookModel bookModel : listBooks) {
			if (bookModel.getIsbn().equals(isbn)) {
				bookModel.setAuthor(author);
				bookModel.setEdition(edition);
				bookModel.setYear(year);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(String isbn, List<BookModel> listBooks) {
		for (BookModel obj : listBooks) {
			if (obj.getIsbn().equals(isbn)) {
				listBooks.remove(obj);
				return true;
			}
		}
		return false;
	}

}
