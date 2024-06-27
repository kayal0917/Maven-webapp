<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
 <%
    String name=request.getParameter("name");
%> 
<h2>Update </h2>
<form action="/update" method="get">
	<label for="name">Name:
	<input type="text" id="name" name="name" placeholder="name" value="<%=name %>" readonly></label><br><br>
	<label for="grade">grade:
	<input type="number" name="grade" id="grade"
		placeholder="grade" required></label><br><br>
	
	<button>update</button>
	</form>
</body>
</html>