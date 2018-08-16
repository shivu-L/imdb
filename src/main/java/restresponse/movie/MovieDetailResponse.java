package restresponse.movie;

import java.util.ArrayList;
import java.util.List;

import pojo.Directors;
import restresponse.pojo.ActorResponse;
import restresponse.pojo.DirectorResponse;
import restresponse.pojo.MovieResponse;

public class MovieDetailResponse {
	private MovieResponse movieResponse;
	
	private List<DirectorResponse> directors = new ArrayList<>(); 
	private List<ActorResponse> actors = new ArrayList<>();
	public MovieDetailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieDetailResponse(MovieResponse movieResponse, List<DirectorResponse> directors,
			List<ActorResponse> actors) {
		super();
		this.movieResponse = movieResponse;
		this.directors = directors;
		this.actors = actors;
	}
	public MovieResponse getMovieResponse() {
		return movieResponse;
	}
	public void setMovieResponse(MovieResponse movieResponse) {
		this.movieResponse = movieResponse;
	}
	public List<DirectorResponse> getdirectors() {
		return directors;
	}
	public void setdirectors(List<DirectorResponse> directors) {
		this.directors = directors;
	}
	public List<ActorResponse> getactors() {
		return actors;
	}
	public void setactors(List<ActorResponse> actors) {
		this.actors = actors;
	}

}
