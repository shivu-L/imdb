package apprest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.DirectorsDAO;
import pojo.Actors;
import pojo.Directors;
import pojo.Movies;
import pojo.Roles;
import restresponse.director.DirectorDetailResponse;
import restresponse.director.MovieActorResponse;
import restresponse.pojo.ActorResponse;
import restresponse.pojo.DirectorResponse;
import restresponse.pojo.MovieResponse;

@Path("/director")
public class RestDirectorService {
	private static final Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

	@GET
	@Path("{director_id}")
	public Response getMsg(@PathParam("director_id") Long id) {

		DirectorsDAO directorsDAO = new DirectorsDAO();
		Directors director = directorsDAO.findById(id);

		if (director == null) {
			return Response.status(200).entity(gson.toJson("Invalid director id "))
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

		} else {
			// setting director response here
			DirectorResponse dirResponse = new DirectorResponse(director.getId(), director.getFirstName(),
					director.getLastName());

			return Response.status(200).entity(gson.toJson(dirResponse)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

		}

	}

	@GET
	@Path("{director_id}/director_details")
	public Response getDirectorMsg(@PathParam("director_id") Long id) {

		DirectorsDAO directorsDAO = new DirectorsDAO();
		Directors director = directorsDAO.findById(id);

		if (director == null) {

			return Response.status(200).entity(gson.toJson("Invalid director id "))
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

		} else {
			// setting director response here
			List<MovieActorResponse> movieActorResponses = new ArrayList<>();
			List<MovieResponse> movies = new ArrayList<>();
			DirectorDetailResponse detailResponse = new DirectorDetailResponse();
			

			for (Movies movie : director.getMovieses()) {
				MovieResponse movieDetail = new MovieResponse(movie.getId(), movie.getName(), movie.getYear(),
						movie.getRank());

				movies.add(movieDetail);
				List<ActorResponse> actors = new ArrayList<>();

				for (Roles role : movie.getRoleses()) {
					Actors actor = role.getActors();
					ActorResponse actorResponse = new ActorResponse(actor.getId(), actor.getFirstName(),
							actor.getLastName(), actor.getGender());
					actors.add(actorResponse);
				}

				MovieActorResponse movieActorResponse = new MovieActorResponse(movie.getId(), movie.getName(),
						movie.getYear(), movie.getRank(), actors);
				movieActorResponses.add(movieActorResponse);
			}

			detailResponse = new DirectorDetailResponse(director.getId(), director.getFirstName(),
					director.getLastName(), movieActorResponses);

			return Response.status(200).entity(gson.toJson(detailResponse)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

		}

	}
}
