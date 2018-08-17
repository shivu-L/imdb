package restresponse.director;

import java.util.ArrayList;
import java.util.List;

import restresponse.pojo.DirectorResponse;

public class DirectorDetailResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private String director_image;
	private String video;
	
		public String getVideo() {
		return video;
	}


	public void setVideo(String video) {
		this.video = video;
	}


		private List<MovieActorResponse> movies = new ArrayList<>();
	

	public DirectorDetailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public DirectorDetailResponse(Long id, String firstName, String lastName, String director_image, String video,
			List<MovieActorResponse> movies) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.director_image = director_image;
		this.video = video;
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


	public String getDirector_image() {
		return director_image;
	}


	public void setDirector_image(String director_image) {
		this.director_image = director_image;
	}


	public List<MovieActorResponse> getMovies() {
		return movies;
	}


	public void setMovies(List<MovieActorResponse> movies) {
		this.movies = movies;
	}



	
}
