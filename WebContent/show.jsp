<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.beans.Book" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Showing all the books:
<%
List<Book> list=(ArrayList<Book>)request.getAttribute("list");
%>
<table border="5px">
<tr>
<th>ISBN</th>
<th>Name</th>
</tr>
<%
for(Book book:list){	
%>
<tr>
<td><%= book.getIsbn() %></td>
<td><%= book.getName() %></td>
</tr>
<% 
} 
%>
</table>


</body>
</html>