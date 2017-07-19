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
import model.Book;


@WebServlet("/AddbooksServlet")
public class AddbooksServlet extends HttpServlet {
       
   
        
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
			out.println("addbookservlet");
			
			

			
			String name = request.getParameter("name");
			String price=request.getParameter("price");
			String author_id=request.getParameter("author_id");
			String pub_date=request.getParameter("pub_date");
		
			out.println("name="+ name);
			out.println("price="+ price);
			out.println("author_id="+ author_id);
			out.println("pub_date="+ pub_date);
			
			
			int Price = Integer.parseInt(price);
			int authorId = Integer.parseInt(author_id);
			LocalDate published_date =LocalDate.parse(pub_date);
	       
			
			Book book = new Book();
			book.setName(name);
			book.setPrice(Price);
			book.setAuthorId(authorId);
			book.setPublishedDate(published_date);
	        out.println(book);
	        
	        
	        BookDAO bookDAO =new BookDAO();
	        
	        try {
				bookDAO.register(book);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        //redirect to listbook jsp
	        response.sendRedirect("listsbooks.jsp");
		
		}

	
	

}
