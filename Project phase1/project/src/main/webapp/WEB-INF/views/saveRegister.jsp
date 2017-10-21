<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty retrive}">
	<div class="container">
	<table class="table table-bordered">
	<thead>
	<tr>
		<th width="80">Email ID</th>
		<th width="120">UserName</th>
		<th width="120">Password</th>
		<th width="120">Mobile</th>
		<th width="120">UserId</th>
		<th width="120">Address</th>
		<th width="120">Country</th>
		<th width="120">role</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	</thead>
	<c:forEach items="${retrive}" var="user">
		<tbody>
		<tr>
			<td>${user.emailid}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.mobile}</td>
			<td>${user.address}</td>
			<td>${user.country}</td>
			<td>${user.role}</td>
			<td><a href="<c:url value="/edit?eid=${user.emailid}" />">Edit</a></td>
			<td><a href="<c:url value="/remove?eid=${user.emailid}" />" >Delete</a></td>
		</tr>
	</tbody>
	</c:forEach>
	</table>
</div>
</c:if>
</body>
</html>