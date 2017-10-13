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
<script type="text/javascript">
function showAlert(){
alert("U have registered successful");	
}


</script>
</head>
<body>
<%@include file="header.jsp" %>
<div class="contianer">

<h1>Customer details</h1>
<div class="col-lg-12">
<div class="row">
<form:form id="saveRegister"  commandName="Userobj" action="saveRegister" method="POST" role ="form">
<div class="col-lg-12">
<div class="form-group">
<label for="emailid">Email Id</label>
<form:input type="email"  path="emailid" class="form-control" placeholder="Enter the Email id..." pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Eg:jackkk@xxx.yyy"/>
<form:errors path="emailid"> </form:errors>
</div>
</div>
<div class="col-lg-12">
<div class="form-group">
<label for="username">UserName</label>
<form:input  type="text"  path="username" class="form-control" placeholder="Enter the UserName..."/>
</div>
</div>
<div class="col-lg-12">
<div class="form-group">
<label for="password">Password</label>
<form:input  type="password"  path="password" class="form-control" placeholder="Enter the password..." minlength="6" maxlength="16"  title="Six or more characters"/>
</div>
</div>
<div class="col-lg-12">
<div class="form-group">
<label for="mobile">Mobile</label>
<form:input  type="text"  path="mobile" class="form-control" placeholder="Enter the MobileNumber..." pattern="[789][0-9]{9}" title="Should be 10 digits starting from 7,8 or 9" />
</div>
</div>
<div class="col-lg-12">
<div class="form-group">
<label for="userid">UserId</label>
<form:input  type="text"  path="userid" class="form-control" placeholder="Enter the UserId..." />
</div>
</div>
<div class="col-lg-12">
<div class="form-group">
<label for="Address">Address</label>
<form:input  type="text"  path="address" class="form-control" placeholder="Enter the address..." />
</div>
</div>
<div class="col-lg-12">
<div class="form-group">
<label for="country">Country</label>
<form:input  type="text"  path="country" class="form-control" placeholder="Enter the Country..." />
</div>
</div>
<div class="form-group">
<div class="row">
<div class="col-sm-6 col-sm-offset-3">
<button class="btn btn-lg btn-primary btn-block"
type="submit" onclick="showAlert()">Sign up</button>
</div>
</div>
</div>
</form:form>
</div>
</div>
</div>
</body>
</html>