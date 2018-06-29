package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import javax.xml.bind.annotation.XmlRootElement;


public class Test {
	
/*	public static void main(String[] args) throws Exception {
		//getConnection();
		//createTable();
		String name = "vadims";
		String password = "admin";
		System.out.println(Zapros(name, password));
	    }*/
	
public static String Zapros(String name, String password) throws Exception {
	String bool = "false";
	MyConnector connector = new MyConnector();
	
	try (Connection conn = connector.getConnection()){	
		String sql = "SELECT id FROM user_info Where name = ? and password = ?";
		PreparedStatement pS = conn.prepareStatement(sql);
		pS.setString(1, name);
		pS.setString(2, password);
		
		ResultSet rs = pS.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			bool = "true";
		}	
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	return bool;
	}

}
