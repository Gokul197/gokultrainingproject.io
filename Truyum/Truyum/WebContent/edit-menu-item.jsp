<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cognizant.truyum.model.MenuItem"%>
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
		<img src="images/truyum-logo-light.png"> <a href="http://localhost:8080/Truyum/menuitemListServlet">Menu</a>
	</div>

	<h1>Edit Menu Item</h1>

	<div class="body-content-colour">
            <form action="EditMenuItem" onSubmit="return validateMenuItemForm()" name="menuItemForm" method="post">
                <div class="form-field-spacing">
                    <label for="title">Name</label>
                    <input type="text" class="text-box" name="name" id="name" value="${menuItem.name }">
                    
                </div>
                <div class="form-field-spacing">
                        <label for="price">Price</label>
                        <input type="text" class="text-box" name="price" id="price" value="${menuItem.price}"><br>
                </div>
                <div class="form-field-spacing">
                        <c:if test="${menuItem.active }">
                    <input class="radio" type="radio" name="active" value="Yes"checked >Yes
                    <input class="radio" type="radio" name="active" value="No" >No
                                 </c:if>
                                 <c:if test="${!menuItem.active }">
                                 <input class="radio" type="radio" name="active" value="Yes" checked>Yes                   
                    <input class="radio" type="radio" name="active" value="No" checked>No
                    </c:if>
                </div>
                
                
                <div class="form-field-spacing">
                        <label for="dateOfLaunch">Date of Launch</label>
                        <input type="text"  class="text-box" name="dateOfLaunch" value="<fmt:formatDate value="${menuItem.dateOfLaunch}" type="date" pattern="dd/MM/yyyy" />">
                         </div>

                <div class="form-field-spacing">
                    <label for="category"></label>
                    <div>
                    Category <select name="category" class="dropdown" id="category">
                    <option value="${menuItem.category }">${menuItem.category }</option>
                    <option value="starters">Starters</option>
                    <option value="maincourse">Main Course</option>
                    <option value="dessert">Dessert</option>
                    <option value="drinks">Drinks</option>
                    </select>
                    </div>
                </div>

                 <div class="form-field-spacing">
                    <c:if test="${menuItem.freeDelivery }">
                    <input type="checkbox" name="freeDelivery" checked>
                    </c:if>  
                    <c:if test="${!menuItem.freeDelivery }">
                    <input type="checkbox" name="freeDelivery">
                    </c:if>                
                    <label for="freeDelivery">Free Delivery</label>
                </div>
                <input type="hidden" name="id" value="${menuItem.id}">
                 <div>
                     <input type="submit"  class="button success-button" value="save" >
                 </div>
                    
                 
                    <div class="footer" id="footer">
                     copyright@2019
                    </div>           
                    </form>    
        </div>
</body>
</html>