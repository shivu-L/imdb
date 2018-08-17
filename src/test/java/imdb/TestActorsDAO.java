package imdb;

import dao.ActorsDAO;
import pojo.Actors;

public class TestActorsDAO {

	public static void main(String[] args) {

		ActorsDAO actorsDAO = new ActorsDAO();
		Actors actors = actorsDAO.findById(3l);
		System.out.println(actors.getFirstName());

	}
}
