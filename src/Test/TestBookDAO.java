package Test;

import java.time.LocalDate;

import dao.BookDAO;
import model.Book;

public class TestBookDAO {	
	
	
	public static void main(String[] args) throws Exception {
	Book user = new Book();
    user.setName("radha");
    user.setPrice(134);
    user.setAuthorId(1);
    user.setPublishedDate(LocalDate.now());

    BookDAO userDAO = new BookDAO();
    userDAO.register(user);


}
}
