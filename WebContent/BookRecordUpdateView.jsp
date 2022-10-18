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
<h1 align = "center"> Book record Update</h1>
<%if(request.getAttribute("msg")!=null){ %>
<%= request.getAttribute("msg") %>
<%} %>
<%if(request.getAttribute("book")!=null){ %>
<% Book bk = (Book)request.getAttribute("book"); %>
<form action="BookRecordUpdateController" method = "post">

<label>Name Of Book</label>
<input name = "nameOfBook" type = "text" value="<%= bk.getNameOfBook()%>">
<br> <br> <br>
<label>Book Pdf Uplode</label>
<input name = "bookPdfUplode" type = "text" value = "<%=bk.getBookPdfUplode()%>">
<br> <br> <br>
<label>Book Image</label>
<input name = "bookImage" type = "text" value = "<%=bk.getBookImage()%>">
<br> <br> <br>
<label>Book Price</label>
<input name = "bookPrice" type = "text" value = "<%=bk.getBookPrice()%>">
<br> <br> <br>
<label> Book Author</label>
<input name = "bookAuthor" type = "text"  value = "<%=bk.getBookAuthor()%>">
<br> <br> <br>
<input type = "submit">
</form>
<%} %>

</body>
</html>