package imdb;

import java.util.List;

import org.hibernate.Session;

import com.github.javafaker.Faker;

import dao.MoviesDAO;
import pojo.Movies;
import util.HibernateSessionFactory;

public class AddImageInMovies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoviesDAO moviesDAO = new MoviesDAO();
		Faker faker = new Faker();
		Session session = HibernateSessionFactory.getSession();
		session.getTransaction().begin();
		List<Movies> movies = moviesDAO.findAll();

		for (Movies movie : movies) {
			movie.setImage(faker.internet().avatar());

		}

		session.getTransaction().commit();

		session.close();
		System.out.println("Done");
	}

}
