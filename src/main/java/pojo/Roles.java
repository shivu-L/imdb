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
 * Roles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roles", schema = "public")

public class Roles implements java.io.Serializable {

	// Fields

	private RolesId id;
	private Actors actors;
	private Movies movies;

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** minimal constructor */
	public Roles(RolesId id) {
		this.id = id;
	}

	/** full constructor */
	public Roles(RolesId id, Actors actors, Movies movies) {
		this.id = id;
		this.actors = actors;
		this.movies = movies;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "actorId", column = @Column(name = "actor_id")),
			@AttributeOverride(name = "movieId", column = @Column(name = "movie_id")),
			@AttributeOverride(name = "role", column = @Column(name = "role")) })

	public RolesId getId() {
		return this.id;
	}

	public void setId(RolesId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "actor_id", insertable = false, updatable = false)

	public Actors getActors() {
		return this.actors;
	}

	public void setActors(Actors actors) {
		this.actors = actors;
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