package restresponse.movie;

import java.util.ArrayList;
import java.util.List;

import pojo.Directors;
import restresponse.pojo.ActorResponse;
import restresponse.pojo.DirectorResponse;
import restresponse.pojo.MovieResponse;

public class MovieDetailResponse {
	private Long id;
	private String name;
	private Long year;
	private Float rank;
	private String image;	
	private String video;
	
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	private List<DirectorResponse> directors = new ArrayList<>(); 
	private List<ActorResponse> actors = new ArrayList<>();
	public MovieDetailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieDetailResponse(Long id, String name, Long year, Float rank, List<DirectorResponse> directors,
			List<ActorResponse> actors) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rank = rank;
		this.directors = directors;
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
	public List<DirectorResponse> getDirectors() {
		return directors;
	}
	public void setDirectors(List<DirectorResponse> directors) {
		this.directors = directors;
	}
	public List<ActorResponse> getActors() {
		return actors;
	}
	public void setActors(List<ActorResponse> actors) {
		this.actors = actors;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
