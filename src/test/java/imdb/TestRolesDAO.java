package imdb;

import dao.RolesDAO;
import pojo.Roles;
import pojo.RolesId;

public class TestRolesDAO {
	public static void main(String[] args) {

		RolesDAO rolesDAO = new RolesDAO();
		RolesId rolesId = new RolesId();
		rolesId.setActorId(22);
		Roles roles = rolesDAO.findById(rolesId);
		System.out.println(roles.getActors().getFirstName());
	}
}
