package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;

@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
		response.sendRedirect("myorders.jsp");

	}

}
