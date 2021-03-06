package restresponse.pojo;

public class ActorResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String image;
    private String video;
    
    public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public ActorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActorResponse(Long id, String firstName, String lastName, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
