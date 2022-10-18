<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align = "center"> Add Book </h1>
<%if(request.getAttribute("successMsg")!=null){ %>
<%= request.getAttribute("successMsg") %>
<%} %>

<%if(request.getAttribute("errorMsg")!=null){ %>
<%= request.getAttribute("errorMsg") %>
<%} %>

<br> <br> <br> 

<form action="AddBookController" method = "post">
<label> Name Of Book </label>
<input name = "nameOfBook" type = "text">
<br> <br> <br>
<label> Book Pdf Uplode </label>
<input name = "bookPdfUplode" type = "text">
<br> <br> <br>
<label> Book Image</label>
<input name = "bookImage" type = "text">
<br> <br> <br>
<label>Book Price</label>
<input name = "bookPrice" type = "price">
<br> <br> <br>
<label>Book Author</label>
<input name = "bookAuthor" type = "text">
<br> <br> <br>
<input type = "submit">
</form>
</body>
</html>