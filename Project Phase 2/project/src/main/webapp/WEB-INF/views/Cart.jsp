<%@ page language="java" contentType="text/html"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table cellspacing="3" align="center" >

<tr bgcolor="red">
<td><h4><b>Product Name</b></h4></td>
<td><h4><b>Quantity</b></h4></td>
<td><h4><b>SubTotal</b></h4></td>
<td><h4><b>ProductImage</b></h4></td>
<td><h4><b>Operation</b></h4></td>


<form action="<c:url value="/updateCartItem/${cartitem.citemid }" />"/>
<c:forEach items="${cartitems}" var="cartitem">
<tr>

<td>${cartitem.prodname }</td>
<td><input type="text" value="${cartitem.quantity}"name="quantity" required/></td>
<td>Rs.${cartitem.price * cartitem.quantity}</td>
<td><img src="<c:url value="/resources/images/${cartitem.proid}.jpg"/>"style="height:200px; width:60%" alt="Error on loading images"/>
<td>
<input type="submit" value="UPDATE" class="btn-success btn-block"/>
<a href="<c:url value="/deleteCartItem/${cartitem.citemid }" />">DELETE </a>
</td>

</tr>
</c:forEach>
</form>

<tr>

<br>

<td><a href="<c:url value="/CheckOut" />"> <b><h4>CheckOut</h4></b></a></td>
</tr>
</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>