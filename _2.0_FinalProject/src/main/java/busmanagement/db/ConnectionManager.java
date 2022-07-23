package busmanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static Connection con;
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/busmanagement";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";

	public static Connection getConnection() {
		try {
			try {
				//1. Load driver
				Class.forName(DB_DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//2. Create connection
			con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD); //(database name,db username,db password)
			System.out.println("Database connected");
		}catch(SQLException e) {
			System.out.println(e);
		}
		return con;
	}
}
