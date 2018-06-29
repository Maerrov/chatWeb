package server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import server.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/restExample")
public class Server {

	@POST
	@Path("/user/{name}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUser(@PathParam("name") String name, @PathParam("password") String password){
		String res = name + " " + password;
		try {
			res = Test.Zapros(name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@POST
	@Path("/user/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUser(@PathParam("name") String name){
		String res = name;
		try {
			res = Test.Zapros(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@POST
	@Path("/registr/{name}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public String newUser(@PathParam("name") String name, @PathParam("password") String password){
		String res = name + " " + password;
		try {
			res = Test.setNewUser(name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

