package apprest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.ActorsDAO;
import pojo.Actors;
import restresponse.pojo.ActorResponse;
import restresponse.pojo.RestErrorMessage;

@Path("/actor")

public class RestActorService {

	private static final Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
	
	private static final Faker faker = new Faker();

	@GET
	@Path("{actorid}")
	public Response getVishalMsg(@PathParam("actorid") Long id ) {
 
		 ActorsDAO actorsDAO = new ActorsDAO();
		 Actors actor= actorsDAO.findById(id);
		 
		 if(actor == null) {
			 
			 RestErrorMessage restErrorMessage = new RestErrorMessage(UserExceptionMessages.ACTORNOTFOUND);
			 
		     return Response.status(200).entity(gson.toJson(restErrorMessage)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

		 }else {
			 
			
			 
			  ActorResponse actorResponse= new ActorResponse(actor.getId(), actor.getFirstName(),actor.getLastName(), actor.getGender()); 
				actorResponse.setImage(faker.internet().avatar());
			  return Response.status(200).entity(gson.toJson(actorResponse)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
		  
		 }
	   
	}
	
	
	
	
	
 
 
}
