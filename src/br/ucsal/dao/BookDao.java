package br.ucsal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.ucsal.model.Book;

public class BookDao implements IBook {
	private static List<Book> listBooks;
	private static boolean response = false;

	@SuppressWarnings("unchecked")
	private List<Book> getList(HttpSession session){
		listBooks = (List<Book>) session.getAttribute("listBooks") == null ? new ArrayList<Book>() : (ArrayList<Book>) session.getAttribute("listBooks");
		return listBooks;
	}
	
	
	@Override
	@SuppressWarnings("finally")
//	MÉTODO RESPONSÁVEL POR ADICIONAR UM LIVRO À LISTA, RETORNANDO UM BOOLEANO COMO RESULTADO
	public boolean insert(Book book, HttpSession session) {
		try {
			listBooks = getList(session);
			listBooks.add(book);
			session.setAttribute("listBooks", listBooks);
			response = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			return response;
		}
	}

	@Override
//	MÉTODO QUE RETORNA O RESULTADO DAS BUSCAS POR LIVROS
	public void find(String param, HttpSession session) {
		listBooks = getList(session);
		ArrayList<Book> resultList = new ArrayList<>();
		if (listBooks != null && !listBooks.isEmpty()) {
			for (Book b : listBooks) {
				param.toUpperCase();
				if (b.getAuthor().toUpperCase().contains(param) || b.getTitle().toUpperCase().contains(param) || b.getIsbn().toUpperCase().contains(param) || b.getYear().toUpperCase().contains(param)) {
					resultList.add(b);
				}
			}
		}
		session.setAttribute("resultList", resultList);
	}

//	MÉTODO RESPONSÁVEL POR ATUALIZAR OS DADOS DE UM LIVRO
	@SuppressWarnings("finally")
	public boolean update(Book book, HttpSession session) {
		try {
			listBooks = getList(session);
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
//	MÉTODO RESPONSÁVEL POR REMOVER UM LIVRO DA LISTA DE CADASTRO
	public boolean remove(Book book, HttpSession session) {
		try {
			listBooks = getList(session);
			listBooks.forEach(b -> {
				if (b.getIsbn().equals(book.getIsbn())) {
					listBooks.remove(b);
					session.setAttribute("listBooks", listBooks);
					return;
				}
			});
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			return false;
		}
	}
}
