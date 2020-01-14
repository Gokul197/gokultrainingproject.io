<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<title>Favorites Movie</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<a href="ShowMovieListCustomer">Movies</a> <a href="ShowFavorites">Favorites</a>
		<img src="images/movielogo.png">

	</div>

	<h1>Favorites</h1>
	<c:if test="${message}">
		<div class="success-message">Movie removed from Favorites
			successfully</div>
	</c:if>
	<table>
		<tr>
			<th>Name</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${cart.movieList}" var="movieList">
			<tr>
				<td>${movieList.title}</td>
				<td>$<fmt:setLocale value="en_IN" /> <fmt:formatNumber
						value="${movieList.boxOffice}" type="currency"
						pattern="#,##,##,##,###.00" /></td>
				<td>${movieList.genre}</td>
				<td><a href="RemoveMovie?id=${movieList.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td><h4>No.of.Favourites:</h4></td>
			<td>${cart.favourites}</td>
			<td></td>
		</tr>

	</table>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>


</body>
</html>
