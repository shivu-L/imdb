package apprest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.bytebuddy.asm.Advice.Return;
import pojo.CriteriaPojo;
import pojo.Orders;
import pojo.Column;

import pojo.Searchs;

@Path("criteria")
public class CriteriaRest {

	@GET
	@Path("details")
	public Response getDetails() {

		Faker faker = new Faker();
		Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

		CriteriaPojo criteriapojo = new CriteriaPojo();
		criteriapojo.setDraw(faker.number().randomDigitNotZero());

		ArrayList<Column> columns = new ArrayList<>();
		Column col = new Column();
		for (int i = 0; i < 3; i++) {

		col.setData(faker.number().randomDigitNotZero()+"");
		col.setName(faker.name().name());
		col.setSearchable(true);
		col.setOrderable(false);

		//List<Searchs> search = new ArrayList<>();
		
		Searchs search1 = new Searchs();
		search1.setValue(faker.number().randomDigitNotZero() + "");
		search1.setRegex(true);

		//search.add(search1);
		
		col.setSearch(search1);
		
		columns.add(col);
		}
		criteriapojo.setColumns(columns);

		ArrayList<Orders> orderList = new ArrayList<>();
		Orders order1 = new Orders();
		order1.setColumn(faker.number().randomDigitNotZero());
		order1.setDir("asc");

		orderList.add(order1);
		criteriapojo.setOrder(orderList);

		criteriapojo.setStart(0);
		criteriapojo.setLength(1);

		//List<Searchs> searches1 = new ArrayList<>();

		Searchs searches2 = new Searchs();
		searches2.setValue("");
		searches2.setRegex(true);

		
		criteriapojo.setSearch(searches2);

		return Response.status(200).entity(gson.toJson(criteriapojo)).build();
	}

}
