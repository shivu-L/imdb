package imdb;

import dao.MoviesGenresDAO;
import pojo.MoviesGenres;
import pojo.MoviesGenresId;

public class TestMoviesGenresDAO {

	public static void main(String[] args) {

		
		MoviesGenresDAO moviesGenresDAO = new MoviesGenresDAO();
		MoviesGenresId moviesGenresId = new MoviesGenresId();
		moviesGenresId.setMovieId(8);
		MoviesGenres moviesGenres = moviesGenresDAO.findById(moviesGenresId);
		System.out.println(moviesGenres.getMovies().getName());
		
	}
}
