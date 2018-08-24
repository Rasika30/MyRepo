<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="delete">
<br><br><br><br><br><br><br><br>
<div align="center">
ISBN of book to be deleted: <input type="text" name="isbn"><br><br>
<input type="submit" value="DELETE"><br><br>
<% 
String msg = (String)request.getAttribute("message");
%>
<%= msg %>
</div>
</form>
</body>
</html>