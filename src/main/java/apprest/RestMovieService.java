package apprest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.MoviesDAO;
import pojo.Actors;
import pojo.Directors;
import pojo.Movies;
import pojo.Roles;
import restresponse.movie.MovieDetailResponse;
import restresponse.pojo.ActorResponse;
import restresponse.pojo.DirectorResponse;
import restresponse.pojo.MovieResponse;

@Path("/movie")

public class RestMovieService {
	
	private static final Gson gson = new GsonBuilder()
			   .setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
	@GET
	@Path("{movie_id}")
	public Response getMsg(@PathParam("movie_id") Long movie_id) {
 
		MoviesDAO moviesDAO = new MoviesDAO();
		
		Movies movies = moviesDAO.findById(movie_id);
		
		MovieResponse movieResponse = new MovieResponse(movies.getId(), movies.getName(), movies.getYear(), movies.getRank());
		
		return Response.status(200).entity
				(gson.toJson(movieResponse)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
 
	}

	
	
	@GET
	@Path("{movie_id}/moviedetail")
	public Response getMovieDetail(@PathParam("movie_id") Long movie_id) {
 
		MoviesDAO moviesDAO = new MoviesDAO();
		List<DirectorResponse> directorResponses = new ArrayList<>();
		List<ActorResponse> actorResponses = new ArrayList<>();
		Movies movie = moviesDAO.findById(movie_id);
		
		MovieResponse movieResponse = new MovieResponse(movie.getId(), movie.getName(), movie.getYear(), movie.getRank());
		
		for (Directors director : movie.getDirectorses()) {
			DirectorResponse dirResponse = new DirectorResponse(director.getId(), director.getFirstName(), director.getLastName());
			directorResponses.add(dirResponse);
		}
		
		for(Roles role : movie.getRoleses()) {
			Actors actor = role.getActors();
			
			  ActorResponse actorResponse= new ActorResponse(actor.getId(), actor.getFirstName(),actor.getLastName(), actor.getGender()); 
			  actorResponses.add(actorResponse);
		}
		
		MovieDetailResponse movieDetailResponse = new MovieDetailResponse(movieResponse, directorResponses, actorResponses);
		
		return Response.status(200).entity
				(gson.toJson(movieDetailResponse)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
 
	}
	
	
	@GET
	@Path("getMovies")
	public Response getAllMovies() {
 
		MoviesDAO moviesDAO = new MoviesDAO();
		
		List<Movies> movies_list = moviesDAO.findLimitedMovies(40);
		List<MovieResponse> movieResponses = new ArrayList<>();
		for(Movies movies : movies_list) {
			MovieResponse movieResponse = new MovieResponse(movies.getId(), movies.getName(), movies.getYear(), movies.getRank());
			movieResponses.add(movieResponse);
		}
		
		return Response.status(200).entity
				(gson.toJson(movieResponses)).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
 
	}
	
	
}
