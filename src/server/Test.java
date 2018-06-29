package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

//import javax.xml.bind.annotation.XmlRootElement;
import server.DataStore;

public class Test {
	
	public static void main(String[] args) throws Exception {
		DataStore dataStore = new DataStore();
		Message email = new Message("Hello");
		Message email1 = new Message("Hello1");
		Date date = new Date();
		
		dataStore.addMessage(email, date);
		Date date1 = new Date();
		dataStore.addMessage(email1, date1);
		date1 = new Date();
		dataStore.addMessage(email1, date1);
		
		
		System.out.println(dataStore.getAllMessages());
		System.out.println(dataStore.getMessage());
	    }
	
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

public static String Zapros(String name) throws Exception {
	String bool = "false";
	MyConnector connector = new MyConnector();
	
	try (Connection conn = connector.getConnection()){	
		String sql = "SELECT id FROM user_info Where name = ?";
		PreparedStatement pS = conn.prepareStatement(sql);
		pS.setString(1, name);
		
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

public static String setNewUser(String name, String password) throws Exception {
	String bool = "false";
	MyConnector connector = new MyConnector();
	
	try (Connection conn = connector.getConnection()){	
		String sql = "INSERT INTO user_info(name, password) VALUES(?, ?)";
		PreparedStatement pS = conn.prepareStatement(sql);
		pS.setString(1, name);
		pS.setString(2, password);
		
		pS.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	return bool;
	}

}
