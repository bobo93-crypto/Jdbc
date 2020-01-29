package s7tp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main5 {
	public static void main(String[] args) {

		final String driverClass = OracleUtil.DRIVER_CLASS;
		final String url = OracleUtil.URL;
		final String login = OracleUtil.LOGIN;
		final String password = "hr";
		//final String req = "select employee_id, first_name, last_name from employees";
		final String req = "select * from departments";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, login, password);
			// System.out.println(con!=null);
			stmt = con.createStatement();
			rs = stmt.executeQuery(req);
			java.sql.ResultSetMetaData rsmd=rs.getMetaData();//pour avoir entre autre les noms de colonnes ou l'etat des donnees
			int nbrCols=rsmd.getColumnCount();
			
			for (int i = 1; i <=nbrCols; i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			
			System.out.println();
			
			
			while (rs.next()) {
				for (int i = 1; i <=nbrCols; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
			
			
			
			// con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				con.close();
				System.out.println(stmt.isClosed());// true
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
