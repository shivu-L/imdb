package pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MoviesGenresId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class MoviesGenresId implements java.io.Serializable {

	// Fields

	private Integer movieId;
	private String genre;

	// Constructors

	/** default constructor */
	public MoviesGenresId() {
	}

	/** full constructor */
	public MoviesGenresId(Integer movieId, String genre) {
		this.movieId = movieId;
		this.genre = genre;
	}

	// Property accessors

	@Column(name = "movie_id")

	public Integer getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	@Column(name = "genre")

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MoviesGenresId))
			return false;
		MoviesGenresId castOther = (MoviesGenresId) other;

		return ((this.getMovieId() == castOther.getMovieId()) || (this.getMovieId() != null
				&& castOther.getMovieId() != null && this.getMovieId().equals(castOther.getMovieId())))
				&& ((this.getGenre() == castOther.getGenre()) || (this.getGenre() != null
						&& castOther.getGenre() != null && this.getGenre().equals(castOther.getGenre())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMovieId() == null ? 0 : this.getMovieId().hashCode());
		result = 37 * result + (getGenre() == null ? 0 : this.getGenre().hashCode());
		return result;
	}

}