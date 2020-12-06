package br.ucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.model.Book;

public class BookDao2 implements IBook2 {

	@Override
	public boolean insert(Book book) {
		String insert = "INSERT INTO book (title, author, year, isbn, edition, idioma, genre, sinopse) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		Connection conn = null;
		boolean ok = false;
		try {
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(insert);

			pstm.setString(1, book.getTitle());
			pstm.setString(2, book.getAuthor());
			pstm.setString(3, book.getYear());
			pstm.setString(4, book.getIsbn());
			pstm.setString(5, book.getEdition());
			pstm.setString(6, book.getIdioma());
			pstm.setString(7, book.getGenre());
			pstm.setString(8, book.getSinopse());

			conn.setAutoCommit(false);
			int resp = pstm.executeUpdate();
			conn.commit();
			if (resp == 1) {
				ok = true;
			}
		} catch (Exception e) {
			rollbackAndClose(conn, pstm);
		}
		return ok;
	}

	@Override
	public List<Book> getList() {
		String select = "SELECT * FROM book";
		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			List<Book> books = new ArrayList<>();

			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(select);

			ResultSet rs = pstm.executeQuery(select);

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getLong("id"));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setYear(rs.getString("year"));
				book.setEdition(rs.getString("edition"));
				book.setIdioma(rs.getString("idioma"));
				book.setGenre(rs.getString("genre"));
				book.setSinopse(rs.getString("sinopse"));
				book.setIsbn(rs.getString("isbn"));

				books.add(book);
			}
			rs.close();
			pstm.close();
			return books;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(Book book) {
		boolean ok = false;

		String update = "UPDATE book SET author = ?, year = ?, edition = ? WHERE id = ?";
		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);

			pstm = conn.prepareStatement(update);

			pstm.setString(1, book.getAuthor());
			pstm.setString(2, book.getYear());
			pstm.setString(3, book.getEdition());
			pstm.setLong(4, book.getId());
			int resp = pstm.executeUpdate();
			conn.commit();
			if (resp == 1) {
				ok = true;
			}
		} catch (SQLException e) {
			rollbackAndClose(conn, pstm);
			e.printStackTrace();
		}
		return ok;
	}

//	@Override
//	public void remove(BookModel bookModel) {
//		if (bookModel == null || bookModel.getId() == null) {
//			return;
//		}
//		String delete = "DELETE from book WHERE id = ?";
//		PreparedStatement pstm = null;
//		Connection conn = null;
//
//		try {
//			conn = ConnectionFactory.getConnection();
//			pstm = conn.prepareStatement(delete);
//
//			pstm.setLong(1, bookModel.getId());
//			conn.setAutoCommit(false);
//
//			pstm.execute(delete);
//			conn.commit();
//		} catch (Exception e) {
//			rollbackAndClose(conn, pstm);
//		}
//	}

	public boolean remove(String isbn) {
		boolean ok = false;
		if (isbn != null) {
			String delete = "DELETE from book WHERE isbn = ?";
			PreparedStatement pstm = null;
			Connection conn = null;
			try {
				conn = ConnectionFactory.getConnection();
				pstm = conn.prepareStatement(delete);

				pstm.setString(1, isbn);
				conn.setAutoCommit(false);
				int resp = pstm.executeUpdate(delete);
				conn.commit();
				if (resp == 1) {
					ok = true;
				}
			} catch (SQLException e) {
				rollbackAndClose(conn, pstm);
				throw new RuntimeException(e);
			}
		}
		return ok;
	}

	public void rollbackAndClose(Connection conn, PreparedStatement pstm) {
		try {
			conn.rollback();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception err) {
				err.printStackTrace();
			}
		}
	}
}
