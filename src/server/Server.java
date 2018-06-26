package server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Collection;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import server.MyConnector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/restExample")
public class Server {
	//DataStore dataStore = new DataStore();

	// Отримання переліку студентів у форматі JSON
	@GET
	@Path("/user/{name}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean getUser(@PathParam("name") String name, @PathParam("password") String password) {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		
		boolean res = false;
		
/*		try {
			PreparedStatement pS = null;
			String sql = "SELECT name FROM user_info Where name = ? and password = ?";
			
			pS.setString(1, name);
			pS.setString(2, password);
			
			pS = conn.prepareStatement(sql);
			ResultSet rs = pS.executeQuery(sql);
			res = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}*/
		return res;
	}

/*	// Отримання інформації про студента у форматі XML
	@GET
	@Path("/students/{studentid}")
	// @Produces(MediaType.APPLICATION_XML)
	public Student getStudent(@PathParam("studentid") int id) {
		return dataStore.getStudent(id);
	}

	// Занесення інформації про студента у сховище
	@PUT
	@Path("/students/{studId}/{name}/{ball}")
	@Produces(MediaType.TEXT_PLAIN)
	public String addStudent(@PathParam("studId") int studId, @PathParam("name") String name,
			@PathParam("ball") double ball) {
		int result = dataStore.addStudent(new Student(studId, name, ball));
		return String.valueOf(result);
	}

	// Видаленн інформації про студента із сховища
	@DELETE
	@Path("/students/{studId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeStudent(@PathParam("studId") int studId) {

		int result = dataStore.deleteStudent(studId);
		return String.valueOf(result);
	}

	@POST
	@Path("/students/{studId}/{name}/{ball}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateStudent(@PathParam("studId") int studId, @PathParam("name") String name,
			@PathParam("ball") double ball) {
		int result = dataStore.updateStudent(new Student(studId, name, ball));
		return String.valueOf(result);
	}*/

}

