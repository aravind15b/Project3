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
<title>Login</title>
</head>
<body>

<section id="promo" class="promo section offset-header">
        <div class="container text-center">
        <br>
            <h2 class="title">FANTEZY ADMIN<span class="highlight"></span></h2>
            <strong><center><h2>Welcome&nbsp;${sessionScope.username}</h2></center></strong>
            <br><br>
        </div><!--//container-->
    </section>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>





<a href="saveRegister">Take to saveregister</a><br>
<a href="Category">Take to Category</a>
<a href="Supplier">Take to Supplier</a>
<a href="Product">Take to Product</a>
</body>
</html>