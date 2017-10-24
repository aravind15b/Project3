<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css">
.sidenav {
     
      background-color: #f1f1f1;
      height: 100%;
    }

@media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
      
      }
      .row.content {height:auto;} 
    }
</style>

</head>

<body>

<div class="container">
  <h3>Pills With Dropdown Menu</h3>
  <ul class="nav nav-pills nav-stacked col-sm-2 sidenav">
    <li class="active"><a href="#">Home</a></li>
    <li class="dropdown">
      <c:forEach  items="${catdetails}" var="category">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.catname} <span class="caret"></span></a>
      </c:forEach>
      <ul class="dropdown-menu">
        <li><a href="#">Submenu 1-1</a></li>
        <li><a href="#">Submenu 1-2</a></li>
        <li><a href="#">Submenu 1-3</a></li>                        
      </ul>
    </li>
    <li><a href="#">Menu 2</a></li>
    <li><a href="#">Menu 3</a></li>
  </ul>
</div>

</body>
</html>
