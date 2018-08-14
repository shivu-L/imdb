package pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DirectorsGenresId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class DirectorsGenresId implements java.io.Serializable {

	// Fields

	private Long directorId;
	private String genre;
	private Float prob;

	// Constructors

	/** default constructor */
	public DirectorsGenresId() {
	}

	/** full constructor */
	public DirectorsGenresId(Long directorId, String genre, Float prob) {
		this.directorId = directorId;
		this.genre = genre;
		this.prob = prob;
	}

	// Property accessors

	@Column(name = "director_id")

	public Long getDirectorId() {
		return this.directorId;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}

	@Column(name = "genre")

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Column(name = "prob", precision = 8, scale = 8)

	public Float getProb() {
		return this.prob;
	}

	public void setProb(Float prob) {
		this.prob = prob;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DirectorsGenresId))
			return false;
		DirectorsGenresId castOther = (DirectorsGenresId) other;

		return ((this.getDirectorId() == castOther.getDirectorId()) || (this.getDirectorId() != null
				&& castOther.getDirectorId() != null && this.getDirectorId().equals(castOther.getDirectorId())))
				&& ((this.getGenre() == castOther.getGenre()) || (this.getGenre() != null
						&& castOther.getGenre() != null && this.getGenre().equals(castOther.getGenre())))
				&& ((this.getProb() == castOther.getProb()) || (this.getProb() != null && castOther.getProb() != null
						&& this.getProb().equals(castOther.getProb())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDirectorId() == null ? 0 : this.getDirectorId().hashCode());
		result = 37 * result + (getGenre() == null ? 0 : this.getGenre().hashCode());
		result = 37 * result + (getProb() == null ? 0 : this.getProb().hashCode());
		return result;
	}

}