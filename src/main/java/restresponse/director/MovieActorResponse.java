package restresponse.director;

import java.util.ArrayList;
import java.util.List;

import restresponse.pojo.ActorResponse;
import restresponse.pojo.MovieResponse;

public class MovieActorResponse {
	
	
	private Long id;
	private String name;
	private Long year;
	private Float rank;
	private List<ActorResponse> actors = new ArrayList<>();
	
	public MovieActorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieActorResponse(Long id, String name, Long year, Float rank, List<ActorResponse> actors) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rank = rank;
		this.actors = actors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Float getRank() {
		return rank;
	}

	public void setRank(Float rank) {
		this.rank = rank;
	}

	public List<ActorResponse> getactors() {
		return actors;
	}

	public void setactors(List<ActorResponse> actors) {
		this.actors = actors;
	}
	
	

	
}
