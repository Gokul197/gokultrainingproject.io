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
		<div class="home">MovieCruiser</div>
		<img src="images/movielogo.png"> <a href="ShowFavorites">Favorites</a>
		<a href="ShowMovieListCustomer">Movies</a>
	</div>
	<div class="page-title"></div>

	<span id="span" class="span"></span>
	<div>
		<h1>Movies</h1>
		<c:if test="${addCartStatus}">
			<div class="success-message">Movie added to Favorites
				Successfully</div>
		</c:if>
		<table class="body-content-colour">
			<tr bgcolor="">
				<th>Title</th>
				<th>Box Office</th>
				<th>Genre</th>
				<th>HasTeaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${menuItem}" var="movieList">
				<tr>
					<td>${movieList.title}</td>
					<td>$<fmt:formatNumber value="${movieList.boxOffice}"
							pattern="#,##,##,##,###.00" /></td>
					<td>${movieList.genre}</td>
					<td><c:choose>
							<c:when test="${movieList.hasTeaser}"> Yes</c:when>
							<c:otherwise> No</c:otherwise>
						</c:choose></td>
					<td><a href="AddToFavorites?movieListId=${movieList.id}">Add
							to Favorites</a></td>
				</tr>
			</c:forEach>

		</table>

		<div class="footer" id="footer">copyright@2019</div>
	</div>

</body>
</html>