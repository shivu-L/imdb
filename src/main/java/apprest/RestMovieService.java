package apprest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.MoviesDAO;
import pojo.Actors;
import pojo.Directors;
import pojo.DirectorsGenres;
import pojo.Movies;
import pojo.MoviesGenres;
import pojo.Roles;
import restresponse.director.DirectorGenresResponse;
import restresponse.director.MovieCategoryDirectorResponse;
import restresponse.movie.MovieDetailResponse;
import restresponse.pojo.ActorResponse;
import restresponse.pojo.DirectorResponse;
import restresponse.pojo.MovieResponse;
import restresponse.pojo.VideoResponse;
import util.HibernateSessionFactory;

@Path("/movie")

public class RestMovieService {

	private static final Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
	private static final Faker faker = new Faker();
	@GET
	@Path("{movie_id}")
	public Response getMsg(@PathParam("movie_id") Long movie_id) {

		MoviesDAO moviesDAO = new MoviesDAO();

		Movies movies = moviesDAO.findById(movie_id);

		MovieResponse movieResponse = new MovieResponse(movies.getId(), movies.getName(), movies.getYear(),
				movies.getRank());
		movieResponse.setImage(faker.internet().avatar());
		movieResponse.setVideo(sendGet().getUrl());
		
		return Response.status(200).entity(gson.toJson(movieResponse)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}

	@GET
	@Path("{movie_id}/moviedetail")
	public Response getMovieDetail(@PathParam("movie_id") Long movie_id) {

		MoviesDAO moviesDAO = new MoviesDAO();
		List<DirectorResponse> directorResponses = new ArrayList<>();
		List<ActorResponse> actorResponses = new ArrayList<>();
		Movies movie = moviesDAO.findById(movie_id);
		
		Faker faker = new Faker();


		if (movie == null) {

			return Response.status(200).entity(gson.toJson("Invalid movie id "))
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

		} 
		else {
		MovieResponse movieResponse = new MovieResponse(movie.getId(), movie.getName(), movie.getYear(),
				movie.getRank());

		for (Directors director : movie.getDirectorses()) {
			DirectorResponse dirResponse = new DirectorResponse(director.getId(), director.getFirstName(),
					director.getLastName());
			directorResponses.add(dirResponse);
		}

		for (Roles role : movie.getRoleses()) {
			Actors actor = role.getActors();

			ActorResponse actorResponse = new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(),
					actor.getGender());
			actorResponses.add(actorResponse);
		}

		
		MovieDetailResponse movieDetailResponse = new MovieDetailResponse(movieResponse.getId(),movieResponse.getName(),movieResponse.getYear(),movieResponse.getRank(), directorResponses,
				actorResponses);
		movieDetailResponse.setImage(faker.internet().avatar());
		movieDetailResponse.setVideo(sendGet().getUrl());
		
		
		return Response.status(200).entity(gson.toJson(movieDetailResponse)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}
	}

	@GET
	@Path("getMovies")
	public Response getAllMovies() {

		MoviesDAO moviesDAO = new MoviesDAO();

		List<Movies> movies_list = moviesDAO.findLimitedMovies(20);
		Set<String> movie_genre = null;
		List<DirectorGenresResponse> directors_list = new ArrayList<>();
		DirectorGenresResponse directors = new DirectorGenresResponse();
		Set<String> genres = new HashSet<String>();
		List<MovieCategoryDirectorResponse> movies = new ArrayList<>();
		MovieCategoryDirectorResponse movies_responses = new MovieCategoryDirectorResponse();

		for (Movies movie : movies_list) {
			for (MoviesGenres moviesGenre : movie.getMoviesGenreses()) {
				movie_genre = new HashSet<String>();
				movie_genre.add(moviesGenre.getId().getGenre());
			}
			for (Directors director : movie.getDirectorses()) {
				for (DirectorsGenres direGenre : director.getDirectorsGenreses()) {
					genres.add(direGenre.getId().getGenre());
				}
				directors = new DirectorGenresResponse(director.getId(), director.getFirstName(),
						director.getLastName(), genres);
				directors_list.add(directors);
			}
			
			
			movies_responses = new MovieCategoryDirectorResponse(movie.getId(), movie.getName(), movie.getYear(),
					movie.getRank(), movie_genre, directors_list);
		
			movies.add(movies_responses);
		}

		
		
		return Response.status(200).entity(gson.toJson(movies)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}
	
	
	@GET
	@Path("getallMovies")
	public Response getLimitedMovies() {

		MoviesDAO moviesDAO = new MoviesDAO();

		List<Movies> movies_list = moviesDAO.findLimitedMovies(20);
		Set<String> genres = new HashSet<String>();
		List<MovieResponse> movies = new ArrayList<>();
		MovieResponse movies_responses = new MovieResponse();

		for (Movies movie : movies_list) {
			movies_responses.setImage(faker.internet().avatar());
			
			movies_responses.setVideo(sendGet().getUrl());
			
			movies_responses = new MovieResponse(movie.getId(),movie.getName(),movie.getYear(),movie.getRank());
			movies.add(movies_responses);
		}
		
		
		return Response.status(200).entity(gson.toJson(movies)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();

	}

	@GET
	@Path("top10/{category}")
	public Response getTopMovieDetail(@PathParam("category") String category) {
	
		
		
		return Response.status(200).entity(gson.toJson(null)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").allow("OPTIONS").build();
	}

	
	
	@GET
	@Path("topten/{category}")
	public Response getAllMovies(@PathParam("category") String category) {
		Session session = HibernateSessionFactory.getSession();

		String queryString = "select movie_id,genre from movies_genres GROUP BY movie_id,genre HAVING lower(genre) = lower('"+category+"')";
		SQLQuery queryObject = session.createSQLQuery(queryString);
		System.out.println(queryObject.getQueryString());
		List<Object[]> results = queryObject.list();
		List<Long> movie_id = new ArrayList<>();

		for (Iterator iterator = results.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			movie_id.add(((Integer) objects[0]).longValue());

		}

		Criteria crit1 = session.createCriteria(Movies.class);
		ProjectionList projections = Projections.projectionList()
				.add(Projections.property("id").as("id")).
				//.add(Projections.id().as("id"))
				add(Projections.property("name").as("name")).
				add(Projections.property("year").as("year"))
				.add(Projections.property("rank").as("rank"));
		crit1.setProjection(projections);
		crit1.add(Restrictions.in("id", movie_id));
		crit1.addOrder(Order.desc("rank"));
		crit1.setMaxResults(10)
		.setResultTransformer(Transformers.aliasToBean(MovieResponse.class));

		List<MovieResponse> movieResponses = crit1.list();

		return Response.status(200).entity(gson.toJson(movieResponses)).header("Access-Control-Allow-Origin", "*")
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
