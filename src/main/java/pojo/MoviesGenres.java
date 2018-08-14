package pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * MoviesGenres entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "movies_genres", schema = "public")

public class MoviesGenres implements java.io.Serializable {

	// Fields

	private MoviesGenresId id;
	private Movies movies;

	// Constructors

	/** default constructor */
	public MoviesGenres() {
	}

	/** minimal constructor */
	public MoviesGenres(MoviesGenresId id) {
		this.id = id;
	}

	/** full constructor */
	public MoviesGenres(MoviesGenresId id, Movies movies) {
		this.id = id;
		this.movies = movies;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "movieId", column = @Column(name = "movie_id")),
			@AttributeOverride(name = "genre", column = @Column(name = "genre")) })

	public MoviesGenresId getId() {
		return this.id;
	}

	public void setId(MoviesGenresId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id", insertable = false, updatable = false)

	public Movies getMovies() {
		return this.movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

}