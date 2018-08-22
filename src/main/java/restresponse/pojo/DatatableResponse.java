package restresponse.pojo;

import java.util.List;

public class DatatableResponse {
	
	private Integer draw;
	private Integer recordsTotal;
	private Integer recordsFiltered;
	private List<Data> data;
	public DatatableResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DatatableResponse(Integer draw, Integer recordsTotal, Integer recordsFiltered, List<Data> data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	
	

}
