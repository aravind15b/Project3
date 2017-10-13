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
<c:url var="AddSupplier" value="/Supplier/add" ></c:url>
<form:form action="${AddSupplier}" method="POST" commandName="supplier" >
<table cellspacing="2" align="center" >
	<c:if test="${!empty supplier.supname}">
	<tr>
	<td colspan="2">Supplier Id</td>
	<td><form:input  path="supid" readolny="true" disabled="true"/>
	<form:hidden path="supid" />
	</td>
	
	</tr>
	</c:if>
	<tr>
	<td colspan="2">Supplier Name</td>
	<td><form:input type="text" path="supname" /></td>
	</tr>
	<tr>
	<td colspan="2">Supplier Address</td>
	<td ><form:input type="text" path="supaddress"/></td>
	</tr>
	<tr> 
			<td colspan="2">
			<c:if test="${!empty supplier.supname}">
			<input type="submit" value="editSupplier" />
			</c:if>
			</td>
		</tr>
			<tr>
			<td colspan="2">
			<c:if test="${empty supplier.supname}">
			<input type="submit" value="AddSupplier" />
			</c:if>
			</td>
		</tr>


</table>
</form:form>
<!-- Displaying the Category data using Table -->
<table cellspacing="2" align="center" border="5" >

	<tr bgcolor="#ff66ff">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Desc</td>
		<td>Operations</td>
	</tr>
<c:forEach items="${supdetail}" var="supplier">

<tr >
			<td>${supplier.supid}</td>
			<td>${supplier.supname}</td>
			<td>${supplier.supaddress}</td>
			<td><a href="<c:url value="deleteSupplier/${supplier.supid}"/>">Delete</a>
				<a href="<c:url value="editSupplier/${supplier.supid}"/>">Edit</a>
			</td>
		</tr>
</c:forEach>
</table>

</body>
</html>