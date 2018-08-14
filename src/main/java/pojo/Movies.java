package pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Movies entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "movies", schema = "public")

public class Movies implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Long year;
	private Float rank;
	private Set<Roles> roleses = new HashSet<Roles>(0);
	private Set<MoviesGenres> moviesGenreses = new HashSet<MoviesGenres>(0);
	private Set<Directors> directorses = new HashSet<Directors>(0);

	// Constructors

	/** default constructor */
	public Movies() {
	}

	/** minimal constructor */
	public Movies(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Movies(Long id, String name, Long year, Float rank, Set<Roles> roleses, Set<MoviesGenres> moviesGenreses,
			Set<Directors> directorses) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.rank = rank;
		this.roleses = roleses;
		this.moviesGenreses = moviesGenreses;
		this.directorses = directorses;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false)

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "year")

	public Long getYear() {
		return this.year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	@Column(name = "rank", precision = 8, scale = 8)

	public Float getRank() {
		return this.rank;
	}

	public void setRank(Float rank) {
		this.rank = rank;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movies")

	public Set<Roles> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Roles> roleses) {
		this.roleses = roleses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movies")

	public Set<MoviesGenres> getMoviesGenreses() {
		return this.moviesGenreses;
	}

	public void setMoviesGenreses(Set<MoviesGenres> moviesGenreses) {
		this.moviesGenreses = moviesGenreses;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "movies_directors", schema = "public", joinColumns = {
			@JoinColumn(name = "movie_id", updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "director_id", updatable = false) })

	public Set<Directors> getDirectorses() {
		return this.directorses;
	}

	public void setDirectorses(Set<Directors> directorses) {
		this.directorses = directorses;
	}

}