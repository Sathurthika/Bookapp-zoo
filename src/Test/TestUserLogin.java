package Test;

import dao.UserDAO;
import model.User;

public class TestUserLogin {

	public static void main(String[] args) throws Exception {

        UserDAO userDAO = new UserDAO();
        String email = "sathurthi0216@gmail.com";
		String password = "pass123";
		User user = userDAO.login(email, password);
 System.out.println(user);
	

	}

}
