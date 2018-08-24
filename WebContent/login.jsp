<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login">
<br><br><br><br><br><br><br>
<div align="center">
<% 
String msg = (String)request.getAttribute("message");
%>
<%= msg %>
<br>
Enter name: <input type="text" name="username"><br><br>
Enter password: <input type="password" name="password"><br><br>
<input type="submit" value="submit">
</div>
</form>
</body>
</html>