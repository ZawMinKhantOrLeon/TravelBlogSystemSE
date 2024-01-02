package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection getConnection() {
		
		Connection connection= null;
		String url = "jdbc:mysql://localhost:3306/travelblog?useSSL=false";
		try {
			connection= DriverManager.getConnection(url, "root", "1234");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
}
