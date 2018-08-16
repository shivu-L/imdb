package imdb;

import org.hibernate.Session;

import dao.ActorsDAO;
import dao.DirectorsDAO;
import dao.DirectorsGenresDAO;
import dao.MoviesDAO;
import dao.MoviesGenresDAO;
import dao.RolesDAO;
import pojo.Actors;
import pojo.Directors;
import pojo.DirectorsGenres;
import pojo.DirectorsGenresId;
import pojo.Movies;
import pojo.MoviesGenres;
import pojo.MoviesGenresId;
import util.HibernateSessionFactory;

public class TestActorsDAO {

	public static void main(String[] args) {

		ActorsDAO actorsDAO = new ActorsDAO();
		Actors actors = actorsDAO.findById(3l);
		System.out.println(actors.getFirstName());


		
	}
}
