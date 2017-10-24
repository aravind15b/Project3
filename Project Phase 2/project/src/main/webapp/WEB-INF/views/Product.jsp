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
<title>Product</title>
</head>
<body>
<c:url var="AddProduct" value="/Product/add" ></c:url>
<form:form action="${AddProduct}" method="POST" commandName="product" enctype="Multipart/form-data">
<table cellspacing="2" align="center" >
	<c:if test="${!empty product.prodname}">
	<tr>
	<td colspan="2">Product ID</td>
	<td><form:input  path="proid" readolny="true" disabled="true"/>
	<form:hidden path="proid" />
	</td>
	
	</tr>
	</c:if>
	<tr>
	<td colspan="2">Product Name</td>
	<td><form:input type="text" path="prodname" /></td>
	</tr>
	
	<tr>
				<td><h4><b>Category</b></h4></td>
				<td><form:select path="catid">
						<form:option value="0" label="------Select----" />
						<form:options items="${catdetail}" />
					</form:select>
				</td>
			</tr>		
			<tr>
				<td><h4><b>Supplier</b></h4></td>
				<td><form:select path="supid">
						<form:option value="0" label="------Select----" />
						<form:options items="${supdetail}" />
					</form:select>
				</td>
			</tr>		
			
			
			
			<tr>				
			<tr>
				<td><h4><b>Price</b></h4></td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td><h4><b>Quantity</b></h4></td>
				<td><form:input path="quanity" /></td>
			</tr>
	
	<tr>
		<td><h4><b>Product Image</b></h4></td>
				<td><form:input type="file" path="pimage" /></td>
			</tr>

	<tr>
	
	<td colspan="2">Product Description</td>
	<td ><form:textarea path="prodesc"/></td>
	</tr>
	<tr> 
			<td colspan="2">
			<c:if test="${!empty product.prodname}">
			<input type="submit" value="editproudct" />
			</c:if>
			</td>
		</tr>
			<tr>
			<td colspan="2">
			<c:if test="${empty product.prodname}">
			<input type="submit" value="Addproduct" />
			</c:if>
			</td>
		</tr>


</table>
</form:form>
<!-- Displaying the Category data using Table -->
<table cellspacing="2" align="center" border="5" >

	<tr bgcolor="#ff66ff">
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Product Desc</td>
		<td>Supplier ID </td>
		<td>Quanity</td>
		<td>Price</td>
		
		<td>Operations</td>
			
	</tr>

<c:forEach items="${proddetail}" var="product">
			<tr>
			<td>${product.proid}</td>
			<td>${product.prodname}</td>
			<td>${product.prodesc}</td>

			<td >${product.supid}</td>

			<td>${product.quanity}</td>
			<td>${product.price}</td>	
			<td><a href="<c:url value="deleteProduct/${product.proid}"/>">Delete</a>
				
			<a href="<c:url value="editProduct/${product.proid}"/>">Edit</a>
			</td>
		</tr>
</c:forEach>
</table>
<form action="Product.jsp" method="get">
<input type="text" name="${product.prodname }}">
</form>

</body>
</html>