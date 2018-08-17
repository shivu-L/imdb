package apprest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
import restresponse.pojo.VideoResponse;

@Path("/actor")

public class RestActorService {

	private static final Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
	
	private static final Faker faker = new Faker();

	@GET
	@Path("/{actorid}")
	public Response getVishalMsg(@PathParam("actorid") Long id ) {
 
		 ActorsDAO actorsDAO = new ActorsDAO();
		 Actors actor= actorsDAO.findById(id);
		 
		 if(actor == null) {
			 
			 RestErrorMessage restErrorMessage = new RestErrorMessage(UserExceptionMessages.ACTORNOTFOUND);
			 
		     return Response.status(200).entity(gson.toJson(restErrorMessage)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

		 }else {
			 
			
			 
			  ActorResponse actorResponse= new ActorResponse(actor.getId(), actor.getFirstName(),actor.getLastName(), actor.getGender()); 
				actorResponse.setImage(faker.internet().avatar());
				actorResponse.setVideo(sendGet().getUrl());
				
			  return Response.status(200).entity(gson.toJson(actorResponse)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
		  
		 }
	   
	}

	
	
	
	
	@GET
	@Path("top10/{category}")
	public Response getTopMovieDetail(@PathParam("category") String category) {
	
		
		
		return Response.status(200).entity(gson.toJson(null)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

	
	private static VideoResponse sendGet() {

		String url = "http://www.splashbase.co/api/v1/images/random?videos_only=true";
		VideoResponse  videoResponse = null;
		URL obj;
		try {
			obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		videoResponse =gson.fromJson(response.toString(), VideoResponse.class);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoResponse;
	}
	
	
	
	
 
 
}
