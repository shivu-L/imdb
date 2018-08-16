package restresponse.pojo;

public class MovieResponse {

	private Long id;
	private String name;
	private Long year;
	private Float rank;
	public MovieResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieResponse(Long id, String name, Long year, Float rank) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rank = rank;
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
	
	
}
