package pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RolesId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class RolesId implements java.io.Serializable {

	// Fields

	private Integer actorId;
	private Integer movieId;
	private String role;

	// Constructors

	/** default constructor */
	public RolesId() {
	}

	/** full constructor */
	public RolesId(Integer actorId, Integer movieId, String role) {
		this.actorId = actorId;
		this.movieId = movieId;
		this.role = role;
	}

	// Property accessors

	@Column(name = "actor_id")

	public Integer getActorId() {
		return this.actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	@Column(name = "movie_id")

	public Integer getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	@Column(name = "role")

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RolesId))
			return false;
		RolesId castOther = (RolesId) other;

		return ((this.getActorId() == castOther.getActorId()) || (this.getActorId() != null
				&& castOther.getActorId() != null && this.getActorId().equals(castOther.getActorId())))
				&& ((this.getMovieId() == castOther.getMovieId()) || (this.getMovieId() != null
						&& castOther.getMovieId() != null && this.getMovieId().equals(castOther.getMovieId())))
				&& ((this.getRole() == castOther.getRole()) || (this.getRole() != null && castOther.getRole() != null
						&& this.getRole().equals(castOther.getRole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getActorId() == null ? 0 : this.getActorId().hashCode());
		result = 37 * result + (getMovieId() == null ? 0 : this.getMovieId().hashCode());
		result = 37 * result + (getRole() == null ? 0 : this.getRole().hashCode());
		return result;
	}

}