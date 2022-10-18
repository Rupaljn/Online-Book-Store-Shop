<%@page import="com.rakuten.dto.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align = "center" > Client Profile </h1>
<form action="ClientProfileController"  method = "post">
<label> Name </label>
<input name = "name" type = "text">
<input name = "serch" type = "submit">
</form>
<%if(request.getAttribute("msg")!=null){%>
<%=request.getAttribute("msg") %>
<%} %>

<%if(request.getAttribute("client")!=null){ 
Client clnt = (Client)request.getAttribute("clnt");%>

<table>
<br> <br> <br>
<tr>
<th>Id</th> 
<td><%= clnt.getId()%></td>
</tr>
<tr>
<th> Email Id</th>
<td><%=clnt.getEmailId()%></td>
</tr>
<tr> 
<th> Role</th>
<td><%=clnt.getRole()%></td>
</tr>
<tr>
<th> Created Date </th>
<td><%=clnt.getCreatedDate()%></td>
</tr>
<tr>
<th> Created By</th>
<td><%=clnt.getCreatedBy() %></td>
</tr>
<tr>
<th> Modifie Date</th>
<td> <%=clnt.getModifieDate() %></td>
</tr>
<tr>
<th>Modifie By</th>
<td> <%=clnt.getModifieBy() %></td>
</tr>
<%} %>
</table>

</body>
</html>