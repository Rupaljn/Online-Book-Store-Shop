<%@page import="com.rakuten.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align = "center"> View Book </h1>
<form action="ViewBookController" method = "post">
<label>Book Name</label>
<input name = "bookName" type = "text">
<input type = "submit" name = "serch">
</form>
<%if(request.getAttribute("msg")!=null){ %>
<%= request.getAttribute("msg") %>
<%} %>
<%if(request.getAttribute("book")!=null){
	Book bk = (Book)request.getAttribute("book");%>


<table>
<tr>
<th>Name Of Book</th>
<td> <%= bk.getNameOfBook() %></td>
</tr>
<br> <br> <br> <br>
<tr>
<th>Book Pdf Uplode </th>
<td> <%= bk.getBookPdfUplode() %></td>
</tr> 
<br> <br> <br> <br>
<tr>
<th> Book Image</th>
<td> <%=bk.getBookImage() %></td>
</tr>
<br> <br> <br>
<tr>
<th> Book Price </th>
<td> <%=bk.getBookPrice() %></td>
</tr>
<tr>
<th> Book Author </th>
<td><%=bk.getBookAuthor() %> </td>
</table>
<%} %>
</body>
</html>