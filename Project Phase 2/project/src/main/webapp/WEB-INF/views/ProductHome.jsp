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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<title>Insert title here</title>
<style>
#ty{
background-image:url("http://medias.tourismebretagne.com/images/n/d/-/A/q/full_Le-Grand-Aquarium-de-Saint-Malo-1.jpg") ;
opacity:1.0;

}
#tt{
background-color:black;

}
#ttu
{
background-color:white;
opacity:;

}
</style>
</head>
<body id="ty">

<div class="container">
<table class="table table-bordered" style="border: 2px solid black;">
<thead>
<tr id="tt">
<th>Product image</th>
<th>Product quantity</th>
<th>Product Price</th>
<th>CheckOut</th>
</tr>
</thead>
<c:forEach items="${proddetail}" var="product">
<tr id="ttu">
<td><a href="Product1/${product.proid }">
<img src="<c:url value="/resources/images/${product.proid }.jpg"/>" style="height:200px; width:60%" alt="Error on loading images"/>
</a>
<a href="ProductDesc">Product Descirtion</a>
</td>
<td>${product.quanity}</td>
<td>${product.price}</td>
<td><a href="<c:url value="/CheckOut"/>">View th products added to cart</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>