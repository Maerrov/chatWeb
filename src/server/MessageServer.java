package server;

import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import server.DataStore;

@Path("/message")
public class MessageServer {
	DataStore dataStore = new DataStore();
	
	@POST
	@Path("/send/{date}/{email}")
	@Produces(MediaType.TEXT_PLAIN)
	public String setMessage(@PathParam("date") long date, @PathParam("email") Message email){
		//String res = date + " " + email;
		//return res;
		Date revDate = new Date(date);
		int result = dataStore.addMessage(email, revDate);
		return String.valueOf(result);	
	}
	
	@POST
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(){
		//String res = date + " " + email;
		//return res;
		return dataStore.getMessage();
	}
	
}
