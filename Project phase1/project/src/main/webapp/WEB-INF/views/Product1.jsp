<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="60%" align="center" border="5">
<td rowspan="7"><img src="<c:url value="/resources/images/${prodinfo.proid}.jpg"/>"/></td>
<tr bgcolor="black">
<td colspan="3"><center><b><h4>Product View</h4></b></center></td>
</tr>

<tr>
<td>Product Name</td><td>${prodinfo.prodname}</td>
</tr>

<tr>
<td>Product Desc</td><td>${prodinfo.prodesc}</td>
</tr>
<tr>
<td>Price</td><td>Rs.${prodinfo.price}</td>
</tr>
<h4>hurry this left ${prodinfo.quanity}
<a href="<c:url value="/CheckOut" />">Cheackout</a>

</h4>

<tr>
<td>

<c:if test="${sessionScope.loggedIn}">
<form action="<c:url value="/addToCart/${prodinfo.proid}.jpg"/>" method="get">


<select name="quantity">

    <option hidden="true"><h4>Quantity</h4></option>
    <option name="1">1</option>
    <option name="2" >2</option>
    <option name="3" >3</option>
    <option name="4" >4</option>
    <option name="5" >5</option>
    <option name="6">6</option>
    <option name="7" >7</option>
    <option name="8" >8</option>
    <option name="9" >9</option>
    
    
    
</select>
<input type="submit" value="addToCart" />
<a href ="Checkout"><input type="submit" value="Checkout"></a>
</form>
</c:if>


<c:if test="${!sessionScope.loggedIn}">
<form action="Login" method="get">

</form>
</c:if>

</tr>
</table>
</html>