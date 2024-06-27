<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.mavendemo.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>All User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: green;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: black;
        }
        button {
            padding: 5px 10px;
            cursor: pointer;
        }
    </style>
</head>
<body>
   <form action="search.jsp" method="GET">
        <label for="searchTerm">Search by Name:</label>
        <input type="text" id="searchTerm" name="searchTerm" placeholder="Enter name...">
        <button type="submit">Search</button>
    </form>
    <h1>User Details</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Grade</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <% List<Student> users = (ArrayList<Student>) request.getAttribute("users");
               for (Student user : users) {
            %>
            <tr>
                <td><%= user.getName() %></td>
                <td><%= user.getGrade() %></td>
                <td>
                    <form action="update.jsp">
                        <input type="hidden" name="name" value="<%= user.getName() %>">
                        <button>Edit</button>
                    </form>
                </td> 
                <td>
                    <form action="/delete">
                        <input type="hidden" name="name" value="<%= user.getName() %>">
                        <button>Delete</button>
                    </form>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
