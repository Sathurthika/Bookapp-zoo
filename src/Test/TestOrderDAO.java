package Test;

import java.time.LocalDate;

import dao.OrderDAO;
import model.Order;

public class TestOrderDAO {
	public static void main(String[] args) throws Exception {

	Order user = new Order();
	user.setUserid(1);
    user.setBookid(2);
    user.setOrderDate(LocalDate.now());
	user.setStatus("deliverd");
    

   OrderDAO userDAO = new OrderDAO();
    userDAO.register(user);

	}
}	