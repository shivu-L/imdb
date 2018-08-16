package restresponse.director;

import java.util.ArrayList;
import java.util.List;

import restresponse.pojo.DirectorResponse;

public class DirectorDetailResponse {

	private Long id;
	private String firstName;
	private String lastName;
	
	private List<MovieActorResponse> movies = new ArrayList<>();
	

	public DirectorDetailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DirectorDetailResponse(Long id, String firstName, String lastName, List<MovieActorResponse> movies) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.movies = movies;
	}



	public List<MovieActorResponse> getmovies() {
		return movies;
	}


	public void setmovies(List<MovieActorResponse> movies) {
		this.movies = movies;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	

	
	
	
	
}
