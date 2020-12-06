package br.ucsal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.model.User;

public class UserDao2 implements IUser2 {

	@Override
	public void insert(User user) {
		String insert = "INSERT INTO user (name, register, password, typeUser) VALUES (?,?,?,?)";
		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(insert);

			pstm.setString(1, user.getName());
			pstm.setString(2, user.getRegister());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getTypeUser());

			conn.setAutoCommit(false);
			pstm.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			rollbackAndClose(conn, pstm);
		}
	}

	@Override
	public List<User> getList() {
		String select = "SELECT * FROM user";
		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			List<User> listUsers = new ArrayList<>();
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(select);
			ResultSet rs = pstm.executeQuery(select);

			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setRegister(rs.getString("register"));
				user.setTypeUser(rs.getString("typeUser"));
				listUsers.add(user);
			}
			rs.close();
			pstm.close();
			return listUsers;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

//	VERIFICAR EXISTENCIA DA MATRICULA NO BANCO
	public Boolean validate(String name) {
		String select = "SELECT name FROM user WHERE name = ?";
		PreparedStatement pstm = null;
		Connection conn = null;
		boolean response = false;
		try {
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(select);

			pstm.setString(1, name);
			conn.setAutoCommit(false);
			ResultSet rs = pstm.executeQuery(select);
			while (rs.next()) {
				response = true;
			}
		} catch (Exception e) {
			rollbackAndClose(conn, pstm);
			throw new RuntimeException(e);
		}
		return response;
	}

	public static boolean login(User user) {
		String select = "SELECT * FROM user WHERE register = '?' AND password = '?'";
		PreparedStatement pstm = null;
		Connection conn = null;
		boolean response = false;
		try {
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(select);
			pstm.setString(1, user.getRegister());
			pstm.setString(2, user.getPassword());

			conn.setAutoCommit(false);
			ResultSet rs = pstm.executeQuery(select);
			while (rs.next()) {
				response = true;
			}
		} catch (SQLException e) {
			rollbackAndClose(conn, pstm);
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public void update(User user) {
		if (user == null || user.getId() == null) {
			return;
		}
		String update = "UPDATE book SET name = ?, password = ?, typeUser = ? WHERE id = ?";
		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);

			pstm = conn.prepareStatement(update);

			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getTypeUser());
			pstm.setLong(4, user.getId());

			pstm.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			rollbackAndClose(conn, pstm);
			e.printStackTrace();
		}

	}

	public int remove(Long id) {
		int ok = 0;
		if (id != null) {
			String delete = "DELETE from user WHERE id = ?";
			PreparedStatement pstm = null;
			Connection conn = null;
			try {
				conn = ConnectionFactory.getConnection();
				pstm = conn.prepareStatement(delete);

				pstm.setLong(1, id);

				conn.setAutoCommit(false);
				pstm.executeUpdate(delete);
				conn.commit();
				ok = 1;
			} catch (SQLException e) {
				rollbackAndClose(conn, pstm);
				throw new RuntimeException(e);
			}
		}
		return ok;
	}

	private static void rollbackAndClose(Connection conn, PreparedStatement pstm) {
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
