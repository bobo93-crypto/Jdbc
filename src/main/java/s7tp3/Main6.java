package s7tp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main6 {

	public static void main(String[] args) {

		final String driverClass = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String login = "hr";
		final String password = "hr";
		final String req = "insert into PERSONNE values (1, 'N1', '31-05-2000')";
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
			
			 try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			 
			try {
				con.close();
				System.out.println(stmt.isClosed());// false donc il faut closer le stmt en premier 
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	

}
