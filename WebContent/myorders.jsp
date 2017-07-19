<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="model.Order"%>
<%@page import="dao.OrderDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Orders</title>
</head>
<body>
<%

User   u = (User) session.getAttribute("logged_in_user");
out.println(u);
%>

<h3>my orders </h3>
<table border="1">
	<tbody>
		<%
			OrderDAO orderDAO = new OrderDAO();
			List<Order> orderList = orderDAO.listorder(u.getId());
		%><table border="1">
			<thead>
				<tr>
					<th>id</th>
					<th>user_name</th>
					<th>book_name</th>
					<th>quantity</th>
					<th>status</th>
					<th>Ordered_date</th>


				</tr>
			</thead>
			<tbody>
				<%
					for (Order b : orderList) {
						out.println("<tr>");
						out.println("<td>" + b.getId() + "</td>");
						out.println("<td>" + b.getUsername() + "</td>");
						out.println("<td>" + b.getBookname() + "</td>");
						out.println("<td>" + b.getQuantity() + "</td>");
						out.println("<td>" + b.getStatus() + "</td>");
						out.println("<td>" + b.getOrderDate() + "</td>");
						String cancelParameters = "id=" + b.getId() + "&status=CANCELLED";
						
						String cancelLink = "<a href='UpdateOrderServlet?" + cancelParameters +"'>Cancel</a>";
						
						out.println("<td>" + cancelLink  +"</td>");
						
						out.println("</tr>");
					}
				
				%>
			</tbody>
		</table>


	</tbody>


</body>
</html>