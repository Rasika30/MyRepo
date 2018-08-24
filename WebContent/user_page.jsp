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
Search by name<br>
Search by ISBN<br>
Search by author<br>
<a href="showall">Show all books</a><br>
</div>
</body>
</html>