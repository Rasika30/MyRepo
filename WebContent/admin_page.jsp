<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("username");
%>
<div align="center">
<marquee><h1>Welcome, <%=name%></h1></marquee><br><br>
<h2>MENU:</h2><br>
<a href="add.jsp">Add Book</a><br>
<a href="update.jsp">Update Book</a><br>
<a href="delete.jsp">Delete Book</a>
</div>
</body>
</html>