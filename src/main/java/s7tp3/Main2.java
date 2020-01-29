package s7tp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {

	public static void main(String[] args) {

		final String driverClass = "com.mysql.jdbc.Driver";
		final String url = "jdbc:mysql://localhost:3306/bdJdbc";
		final String login = "root";
		final String password = "root";
		final String req = "insert into PERSONNE values (2, 'N2', '2000-05-31')";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, login, password);
			// System.out.println(con!=null);
			stmt = con.createStatement();
			stmt.executeUpdate(req);
			// con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			 * try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			 */
			try {
				con.close();
				System.out.println(stmt.isClosed());// true
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
