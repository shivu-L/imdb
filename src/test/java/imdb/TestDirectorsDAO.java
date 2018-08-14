package imdb;

import dao.DirectorsDAO;
import pojo.Directors;

public class TestDirectorsDAO {
	public static void main(String[] args) {

		DirectorsDAO directorsDAO = new DirectorsDAO();
		Directors directors = directorsDAO.findById(8L);
		System.out.println(directors.getFirstName());
	}
}
