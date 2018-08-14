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
 * DirectorsGenres entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "directors_genres", schema = "public")

public class DirectorsGenres implements java.io.Serializable {

	// Fields

	private DirectorsGenresId id;
	private Directors directors;

	// Constructors

	/** default constructor */
	public DirectorsGenres() {
	}

	/** minimal constructor */
	public DirectorsGenres(DirectorsGenresId id) {
		this.id = id;
	}

	/** full constructor */
	public DirectorsGenres(DirectorsGenresId id, Directors directors) {
		this.id = id;
		this.directors = directors;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "directorId", column = @Column(name = "director_id")),
			@AttributeOverride(name = "genre", column = @Column(name = "genre")),
			@AttributeOverride(name = "prob", column = @Column(name = "prob", precision = 8, scale = 8)) })

	public DirectorsGenresId getId() {
		return this.id;
	}

	public void setId(DirectorsGenresId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "director_id", insertable = false, updatable = false)

	public Directors getDirectors() {
		return this.directors;
	}

	public void setDirectors(Directors directors) {
		this.directors = directors;
	}

}