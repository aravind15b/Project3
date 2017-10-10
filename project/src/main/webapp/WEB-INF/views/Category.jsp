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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Category</title>
</head>
<body>
<c:url var="AddCategory" value="/Category/add" ></c:url>
<form:form action="${AddCategory}" method="POST" commandName="category" >
<table cellspacing="2" align="center" >
	<c:if test="${!empty category.catname}">
	<tr>
	<td colspan="2">Category Id</td>
	<td><form:input  path="catid" readolny="true" disabled="true"/>
	<form:hidden path="catid" />
	</td>
	
	</tr>
	</c:if>
	<tr>
	<td colspan="2">Category Name</td>
	<td><form:input type="text" path="catname" /></td>
	</tr>
	<tr>
	<td colspan="2">Category Description</td>
	<td ><form:input type="text" path="catdesc"/></td>
	</tr>
	<tr> 
			<td colspan="2">
			<c:if test="${!empty category.catname}">
			<input type="submit" value="editCategory" />
			</c:if>
			</td>
		</tr>
			<tr>
			<td colspan="2">
			<c:if test="${empty category.catname}">
			<input type="submit" value="AddCategory" />
			</c:if>
			</td>
		</tr>


</table>
</form:form>
<!-- Displaying the Category data using Table -->
<table cellspacing="2" align="center" border="5" >

	<tr bgcolor="#ff66ff">
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operations</td>
	</tr>
<c:forEach items="${catdetail}" var="category">

<tr >
			<td>${category.catid}</td>
			<td>${category.catname}</td>
			<td>${category.catdesc}</td>
			<td><a href="<c:url value="deleteCategory/${category.catid}"/>">Delete</a>
				<a href="<c:url value="editCategory/${category.catid}"/>">Edit</a>
			</td>
		</tr>
</c:forEach>
</table>

</body>
</html>