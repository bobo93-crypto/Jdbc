package s7tp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {

	public static void main(String[] args)  {
		Connection con;
    try {
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdJdbc", "root", "root");
		//System.out.println(con!=null);
		 Statement stmt=con.createStatement();
		 stmt.executeUpdate("insert into PERSONNE VALUES(1,'N1','2000-05-19')");
		con.close();
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
