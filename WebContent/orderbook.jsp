<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Books</title>
</head>
<body>

<%

User   u = (User) session.getAttribute("logged_in_user");
out.println(u);
%>

<h3>Order Books</h3>
<form action="OrderBookServlet"> 
UserId:<input type="number" name="userId" value="<%=u.getId()%>" required />
<br/>

Select Book:
<select name="bookId" required>
<option value="1">Core Java</option>
<option value="2">MySQL</option>

</select>
<br/>
Quantity:<input type="number" name="quantity" min="1" required />
<br/>
<button type ="submit">Submit</button>

</form>
</body>
</html>