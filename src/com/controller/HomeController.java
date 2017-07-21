package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.BookDAO;
import dao.OrderDAO;
import dao.UserDAO;
import model.Book;
import model.Order;
import model.User;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		System.out.println("index");
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		System.out.println("Home");
		modelMap.addAttribute("MESSAGE", "Success");
		return "home";
	}

	@GetMapping("/AddbooksServlet")
	public String addBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("addbookservlet");

		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String author_id = request.getParameter("author_id");
		String pub_date = request.getParameter("pub_date");

		out.println("name=" + name);
		out.println("price=" + price);
		out.println("author_id=" + author_id);
		out.println("pub_date=" + pub_date);

		int Price = Integer.parseInt(price);
		int authorId = Integer.parseInt(author_id);
		LocalDate published_date = LocalDate.parse(pub_date);

		Book book = new Book();
		book.setName(name);
		book.setPrice(Price);
		book.setAuthorId(authorId);
		book.setPublishedDate(published_date);
		out.println(book);

		BookDAO bookDAO = new BookDAO();

		try {
			bookDAO.register(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// redirect to listbook jsp
		return "redirect:listsbooks";

	}

	@GetMapping("/LoginServlet")
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("LoginServlet");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		out.println("email=" + email);
		out.println("password=" + password);

		UserDAO userDAO = new UserDAO();
		User user = null;
		try {
			user = userDAO.login(email, password);
		} catch (Exception e) {

			e.printStackTrace();
		}
		out.println("loggin user=" + user);
		if (user == null) {
			// response.sendRedirect("Login.html");
			return "redirect:Login.html";

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("logged_in_user", user);
			// response.sendRedirect("listsbooks.jsp");
			return "listsbooks";

		}
	}

	@GetMapping("/LogoutServlet")
	public String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LogoutServlet");
		HttpSession session = request.getSession();
		session.invalidate();
		// response.sendRedirect("Login.html");
		return "redirect:Login.html";

	}

	@GetMapping("/OrderBookServlet")
	public String order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("orderbookservlet");

		String userid = request.getParameter("userId");
		String bookid = request.getParameter("bookId");
		String quantity = request.getParameter("quantity");

		out.println("User_id=" + userid);
		out.println("Book_id=" + bookid);
		out.println("quantity=" + quantity);

		int userid1 = Integer.parseInt(userid);
		int bookid1 = Integer.parseInt(bookid);
		int quantity1 = Integer.parseInt(quantity);

		OrderDAO orderDAO = new OrderDAO();

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

		// response.sendRedirect("listorder.jsp");

		return "redirect:listorder.jsp";

	}

	@GetMapping("/RegisterUserServlet")

	public String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("RegisterUserServlet");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		out.println("Name=" + name);
		out.println("email=" + email);
		out.println("password=" + password);

		UserDAO userDAO = new UserDAO();
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		out.println("user=" + user);
		try {
			userDAO.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// response.sendRedirect("login.html");
		return "redirect:Login.html";

	}

	@GetMapping("/UpdateOrderServlet")
	public String update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("UpdateOrderServlet");

		String id = request.getParameter("id");
		String status = request.getParameter("status");

		int orderId = Integer.parseInt(id);

		OrderDAO dao = new OrderDAO();
		try {
			dao.updateStatus(orderId, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// redirect to listbook jsp
		// response.sendRedirect("myorders.jsp");
		return "redirect:myorders.jsp";

	}

}
