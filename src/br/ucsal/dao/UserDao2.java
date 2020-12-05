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
		String insert = "INSERT INTO user (name, register, password, typeUser, created_at) VALUES (?,?,?,?,?)";
		PreparedStatement pstm = null;
		Connection conn = null;

		try {
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(insert);

			pstm.setString(1, user.getName());
			pstm.setString(2, user.getRegister());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getTypeUser());
			pstm.setString(5, user.getCreated_at());

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
			List<User> users = new ArrayList<>();
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(select);
			ResultSet rs = pstm.executeQuery(select);

			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setRegister(rs.getString("register"));
				user.setTypeUser(rs.getString("typeUser"));
				user.setCreated_at(rs.getString("created_at"));
				users.add(user);
			}
			rs.close();
			pstm.close();
			return users;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

//	VERIFICAR EXISTENCIA DA MATRICULA NO BANCO
	public boolean validate(String register) {
		String select = "SELECT 1 FROM user WHERE register = ?";
		PreparedStatement pstm = null;
		Connection conn = null;
		boolean response;
		try {
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(select);
			pstm.setString(1, register);

			int rs = pstm.executeUpdate(select);
			response = (rs == 1) ? true : false;
			pstm.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public boolean login(String register, String password) {
		String select = "SELECT * FROM user WHERE register = ? AND password = ?";
		PreparedStatement pstm = null;
		Connection conn = null;
		boolean response;
		try {
			conn = ConnectionFactory.getConnection();
			pstm = conn.prepareStatement(select);
			pstm.setString(1, register);
			pstm.setString(2, password);

			response = pstm.execute(select);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
