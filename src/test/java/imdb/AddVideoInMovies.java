
package imdb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.MoviesDAO;
import pojo.Movies;
import restresponse.pojo.VideoResponse;
import util.HibernateSessionFactory;

public class AddVideoInMovies {
	private static final Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
	private static final Faker faker = new Faker();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoviesDAO moviesDAO = new MoviesDAO();
		
		Session session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		List<Movies> movies =moviesDAO.findLimitedSkipMovies(500, 700);
		
		for (Movies movie : movies) {
			movie.setVideo(sendGet().getUrl());		
			
		}
		
		session.getTransaction().commit();

		session.close();
		System.out.println("Done");
	}

	
	
	private static VideoResponse sendGet() {

		String url = "http://www.splashbase.co/api/v1/images/random?videos_only=true";
		VideoResponse  videoResponse = null;
		URL obj;
		try {
			obj = new URL(url);
		
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		videoResponse =gson.fromJson(response.toString(), VideoResponse.class);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoResponse;
	}
	
	
	
	
}
