package pojo;

public class Searchs {

	private String value;
	private boolean regex;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isRegex() {
		return regex;
	}
	public void setRegex(boolean regex) {
		this.regex = regex;
	}
	public Searchs(String value, boolean regex) {
		super();
		this.value = value;
		this.regex = regex;
	}
	public Searchs() {
		super();
		// TODO Auto-generated constructor stub
	}
}
