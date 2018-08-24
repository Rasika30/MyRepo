<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="add">
<br><br><br><br><br><br><br>
<div align="center">
Enter details of book to be added:<br>
ISBN of book: <input type="text" name="isbn"><br><br>
Name of book: <input type="text" name="name"><br><br>
Publication: <input type="text" name="publication"><br><br>
Author of book: <input type="text" name="author"><br><br>
<input type="submit" value="ADD"><br><br>
<% 
String msg = (String)request.getAttribute("message");
%>
<%= msg %>
</div>
</form>
</body>
</html>