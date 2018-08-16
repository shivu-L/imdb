package restresponse.director;

import java.util.Set;

public class DirectorGenresResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private Set<String> genres;

	public DirectorGenresResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DirectorGenresResponse(Long id, String firstName, String lastName, Set<String> genres) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.genres = genres;
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

	public Set<String> getGenres() {
		return genres;
	}

	public void setGenres(Set<String> genres) {
		this.genres = genres;
	}

}
