package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import dao.OrderDAO;
import model.Book;
import model.Order;


@WebServlet("/OrderBookServlet")
public class OrderBookServlet extends HttpServlet {
	
       
    
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("orderbookservlet");

		
		String userid =request.getParameter("userId");
		String bookid =request.getParameter("bookId");
		String quantity =request.getParameter("quantity");
		
		out.println("User_id="+ userid);
		out.println("Book_id="+ bookid);
		out.println("quantity="+ quantity);
		
		int userid1 = Integer.parseInt(userid);
		int bookid1 = Integer.parseInt(bookid);
		int quantity1 = Integer.parseInt(quantity);
		
		  OrderDAO orderDAO =new OrderDAO();
			
			Order order = new Order();
			order.setUserid(userid1);
			order.setBookid(bookid1);
			order.setQuantity(quantity1);
	        out.println(order);
        
	        
	        try {
				orderDAO.register(order);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	        
	        
	        
	        response.sendRedirect("listorder.jsp");
	    
	        
	        
	        
	
	}

}
