package restresponse.director;

import java.util.List;
import java.util.Set;

public class MovieCategoryDirectorResponse {

	private Long id;
	private String name;
	private Long year;
	private Float rank;
	Set<String> genres;
	List<DirectorGenresResponse> directors;

	public MovieCategoryDirectorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieCategoryDirectorResponse(Long id, String name, Long year, Float rank, Set<String> genres,
			List<DirectorGenresResponse> directors) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rank = rank;
		this.genres = genres;
		this.directors = directors;
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

	public Set<String> getGenres() {
		return genres;
	}

	public void setGenres(Set<String> genres) {
		this.genres = genres;
	}

	public List<DirectorGenresResponse> getDirectors() {
		return directors;
	}

	public void setDirectors(List<DirectorGenresResponse> directors) {
		this.directors = directors;
	}

}
