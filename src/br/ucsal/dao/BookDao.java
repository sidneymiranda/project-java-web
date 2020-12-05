package br.ucsal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.ucsal.model.Book;

public class BookDao implements IBook {
	private static List<Book> listBooks;
	private static boolean response = false;

	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public boolean insert(Book book, HttpSession session) {
		try {
			listBooks = (List<Book>) session.getAttribute("listBooks") == null 
					? new ArrayList<Book>()
					: listBooks;
			listBooks.add(book);

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
	public List<Book> find(String param) {
		ArrayList<Book> emptyList = new ArrayList<>();
		
		return listBooks.contains(param) ? listBooks : emptyList;
	}

	@SuppressWarnings("finally")
	public boolean update(Book book, HttpSession session) {
		try {

			listBooks.forEach(b -> {
				if (b.getIsbn().equals(book.getIsbn())) {
					b.setAuthor(book.getAuthor());
					b.setEdition(book.getEdition());
					b.setYear(book.getYear());

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
	public boolean remove(Book book, HttpSession session) {
		try {
			listBooks.forEach(b -> {
				if (b.getIsbn().equals(book.getIsbn())) {
					listBooks.remove(b);
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
