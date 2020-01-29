package s7tp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main4 {
	public static void main(String[] args) {

		final String driverClass = OracleUtil.DRIVER_CLASS;
		final String url = OracleUtil.URL;
		final String login = OracleUtil.LOGIN;
		final String password = "hr";
		final String req = "select employee_id, first_name, last_name from employees";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, login, password);
			// System.out.println(con!=null);
			stmt = con.createStatement();
			rs = stmt.executeQuery(req);
			System.out.println("EMP_ID\tFIRST_NAME\tLAST_NAME");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString("first_name") + "\t" + rs.getString(3));
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
