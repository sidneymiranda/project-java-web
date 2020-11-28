package br.ucsal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.ucsal.model.BookModel;

public class BookDao implements IBook {
	private static List<BookModel> listBooks;

	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean insert(BookModel bookModel, HttpSession session) {
		boolean response = false;
		try {
			listBooks = (List<BookModel>) session.getAttribute("listBooks") == null 
					? new ArrayList<BookModel>()
					: listBooks;
			listBooks.add(bookModel);

			session.setAttribute("listBooks", listBooks);

			response = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			return response;
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<BookModel> find(String param) {
		ArrayList<BookModel> emptyList = new ArrayList<>();
		
		return listBooks.contains(param) ? listBooks : emptyList;
	}

	@SuppressWarnings("finally")
	public boolean update(BookModel bookModel, HttpSession session) {
		boolean response = false;

		try {

			listBooks.forEach(book -> {
				if (book.getIsbn().equals(bookModel.getIsbn())) {
					book.setAuthor(bookModel.getAuthor());
					book.setEdition(bookModel.getEdition());
					book.setYear(bookModel.getYear());

					session.setAttribute("listBooks", listBooks);

					return;
				}
			});
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			return response;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean remove(BookModel bookModel, HttpSession session) {

		try {
			listBooks.forEach(book -> {
				if (book.getIsbn().equals(bookModel.getIsbn())) {
					listBooks.remove(book);
					session.setAttribute("listBooks", listBooks);

				}
			});

		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			return false;
		}

	}

}
