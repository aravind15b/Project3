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

              <div class="col-xs-6">
                <a href="#" class="active" id="login-form-link">Login</a>
              </div>
        <form role="form" action="perform_login" method="POST">     
        
        <div class="col-lg-12">
<div class="form-group">
<label for="username">UserName</label>
<input  type="text"  name="username" class="form-control" placeholder="Enter the UserName..."/>
</div>
</div>
<div class="col-lg-12">
<div class="form-group">
<label for="password">Password</label>
<input  type="password"  name="password" class="form-control" placeholder="Enter the password..." minlength="6" maxlength="16"  title="Six or more characters"/>
</div>
</div>
    <div class="form-group text-center">
                    <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                    <label for="remember"> Remember Me</label>
                  </div>
                  
                  <div class="form-group">
                    <div class="row">
                      <div class="col-sm-6 col-sm-offset-3">
                       <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign in</button>
                        </div>
                    </div>
                  </div>
     
     
     
     
         </form>
              
              
              
              
              
</body>
</html>