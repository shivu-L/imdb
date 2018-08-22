package pojo;


public class Column {
	private String data;
	private String name;
	private boolean searchable;
	private boolean orderable;
	private Searchs search ;
	public Column() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Column(String data, String name, boolean searchable, boolean orderable, Searchs search) {
		super();
		this.data = data;
		this.name = name;
		this.searchable = searchable;
		this.orderable = orderable;
		this.search = search;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSearchable() {
		return searchable;
	}
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}
	public boolean isOrderable() {
		return orderable;
	}
	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}
	public Searchs getSearch() {
		return search;
	}
	public void setSearch(Searchs search) {
		this.search = search;
	}
	
	

}
