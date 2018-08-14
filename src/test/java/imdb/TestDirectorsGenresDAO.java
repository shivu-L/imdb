package imdb;

import dao.DirectorsGenresDAO;
import pojo.DirectorsGenres;
import pojo.DirectorsGenresId;

public class TestDirectorsGenresDAO {

	public static void main(String[] args) {

		DirectorsGenresDAO directorsGenresDAO = new DirectorsGenresDAO();
		DirectorsGenresId directorsGenresId = new DirectorsGenresId();
		directorsGenresId.setDirectorId(3L);
		DirectorsGenres directorsGenres = directorsGenresDAO.findById(directorsGenresId);
		System.out.println(directorsGenres.getDirectors().getFirstName());
	}
}
