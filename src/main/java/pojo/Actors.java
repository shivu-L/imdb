package pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Actors entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "actors", schema = "public")

public class Actors implements java.io.Serializable {

	// Fields

	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private Set<Roles> roleses = new HashSet<Roles>(0);

	// Constructors

	/** default constructor */
	public Actors() {
	}

	/** minimal constructor */
	public Actors(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Actors(Long id, String firstName, String lastName, String gender, Set<Roles> roleses) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.roleses = roleses;
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

	@Column(name = "gender")

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "actors")

	public Set<Roles> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Roles> roleses) {
		this.roleses = roleses;
	}

}