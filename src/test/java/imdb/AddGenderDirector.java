package imdb;

import java.util.List;

import org.hibernate.Session;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.DirectorsDAO;

import pojo.Directors;
import util.HibernateSessionFactory;

public class AddGenderDirector {
	private static final Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
	private static final Faker faker = new Faker();
	
	public static void main(String args[]){
		
	DirectorsDAO directorsDAO = new DirectorsDAO();
	Session session = HibernateSessionFactory.getSession();
	session.getTransaction().begin();
	List<Directors> directors = directorsDAO.findAll();
	for (Directors directors2 : directors) {
		
		directors2.setGender("M");
	}

	session.getTransaction().commit();
	session.close();
	
	}
}
