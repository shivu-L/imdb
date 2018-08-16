package apprest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("naveen")
	public Response getMsg(@QueryParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	
	@GET
	@Path("vishal/{id}")
	public Response getVishalMsg(@PathParam("id") String id ,@QueryParam("param") String msg) {
 
		String output = id+" Vishal say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
 
	
	@POST
	@Path("vishal/{id}")
	public Response getPostMsg(@FormParam("abc") String abc,@FormParam("id") Integer id) {
 
		String output = " POST Vishal say : "+abc+" "+id;
 
		return Response.status(200).entity(output).build();
 
	}
	
 
	
	

}