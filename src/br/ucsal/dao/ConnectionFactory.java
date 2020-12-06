package br.ucsal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/app?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void ddl(Connection con) throws SQLException {
		Statement st = con.createStatement();
		st.addBatch("CREATE SCHEMA IF NOT EXISTS `app` DEFAULT CHARACTER SET utf8;");
		st.addBatch("use app;");
		
	}

	public static void main(String[] args) throws SQLException {
		Connection con = getConnection();

		if (con != null) {
			con.close();
		}
	}
}
