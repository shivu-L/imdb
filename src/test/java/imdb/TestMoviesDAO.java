package imdb;

import dao.MoviesDAO;
import pojo.Movies;

public class TestMoviesDAO {

	public static void main(String[] args) {
		MoviesDAO moviesDAO = new MoviesDAO();
		Movies movies = moviesDAO.findById(47L);
		System.out.println(movies.getName());
	}
}
