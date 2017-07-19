<!DOCTYPE html>
<%@page import="model.User"%>
<%@page import="model.Book"%>
<%@page import="java.util.List"%>
<%@page import="dao.BookDAO"%>
<html>
<head>
<title>List books</title>
</head>
<body>

<%

User   u = (User) session.getAttribute("logged_in_user");
//out.println(u);
%>

Welcome <%=u.getName() %> !!!  ( <a href="LogoutServlet"> Logout </a>)


	<h3>List Books</h3>
	<!-- <table border="1">
		<thread>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Published Date</th>
			<th>Author Name</th>
		</thread>
		<tbody>
			<tr>
				<td>1</td>
				<td>Core Java</td>
				<td>Rs.200</td>
				<td>2017-04-04</td>
				<td>Suresh</td>
			</tr>
			<tr>
				<td>2</td>
				<td>MySQL</td>
				<td>Rs.300</td>
				<td>2017-03-04</td>
				<td>Naresh</td>
			</tr>
			<tr>
				<td>3</td>
				<td>.NET</td>
				<td>Rs.600</td>
				<td>2017-05-03</td>
				<td>Ramesh</td>
			</tr>
			<tr>
				<td>4</td>
				<td>C++</td>
				<td>Rs.100</td>
				<td>2017-01-09</td>
				<td>Rajesh</td>
			</tr>
			<tr>
				<td>5</td>
				<td>OOPS</td>
				<td>Rs.500</td>
				<td>2017-06-07</td>
				<td>Kamesh</td>
			</tr>
		</tbody>
	</table>
	 -->

  <%
    BookDAO bookDAO=new BookDAO();
    List<Book> bookList=bookDAO.listbook();
    //out.println("Books:"+bookList);
  %>
  
  <table border="1">
		<thread>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Published Date</th>
			<th>Author Name</th>
		</thread>
		<tbody>
  <%
  for(Book b:bookList){ %>
	  
	  <tr>
		<td><%=b.getId() %></td>
		<td><%=b.getName() %></td>
		<td><%=b.getPrice() %></td>
		<td><%=b.getPublishedDate() %></td>
		<td><%=b.getAuthorId() %></td>
	</tr>  
  <%}%>
  <a href="orderbook.jsp">Add Orders</a>
  <a href="listorders.jsp">List books</a>
    <a href="myorders.jsp">My Orders </a>
  
  
  </body>
</html>