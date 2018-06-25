package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {
	private  String url;
	private  Properties prop = new Properties();
	private  Connection conn;
	{
		url = "jdbc:mysql://localhost:3306/user_base";
		
		prop.setProperty("user", "root");
		prop.setProperty("password","Lit227v");
		prop.setProperty("create", "true");
	}

	public  Connection getConnection(){
		try {
			conn = DriverManager.getConnection(url, prop);
		} catch (SQLException e) {
			System.err.println("Проблеми із підключенням до " + url);
			e.printStackTrace();
		}
		return conn;
	}

	public  void closeConnection() {
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			System.err.println("Проблеми із закриттям connection до  " + url);
			e.printStackTrace();
		}
	}
}