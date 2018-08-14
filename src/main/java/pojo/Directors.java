package pojo;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Directors entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "directors", schema = "public")

public class Directors implements java.io.Serializable {

	// Fields

	private Long id;
	private String firstName;
	private String lastName;
	private Set<DirectorsGenres> directorsGenreses = new HashSet<DirectorsGenres>(0);
	private Set<Movies> movieses = new HashSet<Movies>(0);

	// Constructors

	/** default constructor */
	public Directors() {
	}

	/** minimal constructor */
	public Directors(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Directors(Long id, String firstName, String lastName, Set<DirectorsGenres> directorsGenreses,
			Set<Movies> movieses) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.directorsGenreses = directorsGenreses;
		this.movieses = movieses;
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

	@Column(name = "first_name")

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "directors")

	public Set<DirectorsGenres> getDirectorsGenreses() {
		return this.directorsGenreses;
	}

	public void setDirectorsGenreses(Set<DirectorsGenres> directorsGenreses) {
		this.directorsGenreses = directorsGenreses;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "directorses")

	public Set<Movies> getMovieses() {
		return this.movieses;
	}

	public void setMovieses(Set<Movies> movieses) {
		this.movieses = movieses;
	}

}