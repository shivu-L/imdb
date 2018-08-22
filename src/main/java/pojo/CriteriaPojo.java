package pojo;
import java.util.ArrayList;




	public class CriteriaPojo {

		private Integer draw;
		private ArrayList<Column> columns = new ArrayList<>();
		private ArrayList<Orders> order = new ArrayList<>();
		private Integer start;
		private Integer length;
		private Searchs search;
		public CriteriaPojo() {
			super();
			// TODO Auto-generated constructor stub
		}
		public CriteriaPojo(Integer draw, ArrayList<Column> columns, ArrayList<Orders> order, Integer start,
				Integer length, Searchs search) {
			super();
			this.draw = draw;
			this.columns = columns;
			this.order = order;
			this.start = start;
			this.length = length;
			this.search = search;
		}
		

		public Integer getDraw() {
			return draw;
		}
		public void setDraw(Integer draw) {
			this.draw = draw;
		}
		public ArrayList<Column> getColumns() {
			return columns;
		}
		public void setColumns(ArrayList<Column> columns) {
			this.columns = columns;
		}
		public ArrayList<Orders> getOrder() {
			return order;
		}
		public void setOrder(ArrayList<Orders> order) {
			this.order = order;
		}
		public Integer getStart() {
			return start;
		}
		public void setStart(Integer start) {
			this.start = start;
		}
		public Integer getLength() {
			return length;
		}
		public void setLength(Integer length) {
			this.length = length;
		}
		public Searchs getSearch() {
			return search;
		}
		public void setSearch(Searchs search) {
			this.search = search;
		}
		
		
}
