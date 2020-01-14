<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="ie-edge">
<link rel="stylesheet" href="styles/style.css">
<title>Edit Menu Item</title>
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a href="ShowCart">Cart</a>
		<a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="page-title">Products</div>
	<c:if test="${addCartStatus}">
		<div class="success-message">Items added to cart Successfully</div>
	</c:if>
	<span id="span" class="span"></span>
	<div>
		<table class="body-content-colour">
			<tr bgcolor="">
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${menuItem}" var="dataItem">
				<tr>
					<td>${dataItem.name}</td>
					<td><c:choose>
							<c:when test="${dataItem.freeDelivery}"> Yes</c:when>
							<c:otherwise> No</c:otherwise>
						</c:choose></td>
					<td>Rs.<fmt:formatNumber value="${dataItem.price}"
							pattern="#,##,##,##,###.00" /></td>
					<td>${dataItem.category}</td>
					<td><a href="AddToCartServlet?menuItemId=${dataItem.id}">Add
							to cart</a></td>
				</tr>
			</c:forEach>

		</table>

		<div class="footer" id="footer">copyright@2019</div>
	</div>

</body>
</html>