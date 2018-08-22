package pojo;

public class Orders {

	private Integer column;
	private String dir;
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public Orders(Integer column, String dir) {
		super();
		this.column = column;
		this.dir = dir;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
}
