package Test;

import dao.UserDAO;
import model.User;

public class TestUserDAO {

	public static void main(String[] args) throws Exception {
		User user = new User();
        user.setName("radha");
        user.setEmail("rad@gmail.com");
        user.setPassword("r123");
 
        UserDAO userDAO = new UserDAO();
        userDAO.register(user);
 
	

	}

}
