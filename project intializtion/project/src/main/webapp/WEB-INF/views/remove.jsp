<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form  commandName="userupdate1" action="updateUser1" method="POST">
<div class="col-lg-12">
<div class="form-group">
<label for="emailid">Email Id</label>
<form:input type="email"  path="emailid" class="form-control" value="${user.emailid }" readonly="true"/>

</div>
</div>
<div class="col-lg-12">
<div class="form-group">
<label for="UserName">UserName</label>
<form:input  type="text"  path="username" class="form-control" value="${user.username }"/>
</div>
</div>
<div class="col-lg-12">
<div class="form-group">
<label for="password">Password</label>
<form:input  type="text"  path="password" class="form-control" value="${user.password }"/>
</div>
</div>
<div class="form-group">
<div class="row">
<div class="col-sm-6 col-sm-offset-3">
<button class="btn btn-lg btn-primary btn-block"
type="submit">Sign up</button>
</div>
</div>
</div>
</form:form>

</body>
</html>