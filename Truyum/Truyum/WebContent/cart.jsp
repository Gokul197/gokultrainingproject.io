<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<title>Insert title here</title>
</head>
<body>
     <div class="topnav">
          <div class="home">truYum</div>
          <a href="ShowMenuItemListCustomer">Menu</a>
          <a href="ShowCart">Cart</a> <img
              src="images/truyum-logo-light.png">

     </div>
     <c:if test="${message}">
          <div class="success-message">Item removed from Cart successfully</div>
     </c:if>
     <h1>products</h1>
     <table>
          <tr>
              <th>Name</th>
              <th>Free Delivery</th>
              <th>Price</th>
              
              <th>Action</th>

          </tr>

          <c:forEach items="${cart.menuItemList}" var="menuItem">
              <tr>
                   <td>${menuItem.name}</td>
                   <td><c:choose>
                             <c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
                             <c:otherwise>No</c:otherwise>
                        </c:choose></td>
                   <td><fmt:setLocale value="en_IN" /> <fmt:formatNumber
                             value="${menuItem.price}" type="currency"
                             pattern="#,##,##,##,###.00" /></td>
                   
                   <td><a href="RemoveCart?id=${menuItem.id}">Delete</a></td>
              </tr>
          </c:forEach>
          <tr>
            <td></td>
            <td><h4>Total</h4></td>
            <td>${cart.total}</td>
             <td></td>
        </tr>
          

     </table>
     <div class="footer">
          <h3>Copyright @ 2019</h3>
     </div>


</body>
</html>
