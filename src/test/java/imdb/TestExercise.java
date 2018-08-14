package imdb;

import org.hibernate.Session;

import dao.ActorsDAO;
import pojo.Actors;
import util.HibernateSessionFactory;

public class TestExercise {

	public static void main(String[] args) {

		ActorsDAO actorsDAO = new ActorsDAO();
		Actors actors =actorsDAO.findById(3l);
		System.out.println(actors.getFirstName());
	}
}
