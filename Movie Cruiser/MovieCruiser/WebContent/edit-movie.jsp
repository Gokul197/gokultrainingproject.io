<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="ie-edge">
<link rel="stylesheet" href="styles/style.css">
<title>Edit movie List</title>
<script src="js/script.js"></script>
</head>
<body>

	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movielogo.png"> <a href="ShowMovieListAdmin">Movies</a>
	</div>

	<h1>Edit Movie</h1>

	<div class="body-content-colour">
		<form action="EditMovieList" onsubmit="return validateMovieForm()"
			name="editMovieList" method="get">
			<div class="form-field-spacing">
				<label for="title">Title</label><br> <input type="text"
					class="text-box" name="name" id="name" value="${movieList.title}">

			</div>
			<div class="form-field-spacing">
				<label for="price">Gross($)</label> <input type="text"
					class="text-box" name="price" id="price"
					value="${movieList.boxOffice}"><br>
			</div>
			<div class="form-field-spacing">
				<c:if test="${movieList.active }">
					<input class="radio" type="radio" name="active" value="Yes" checked>Yes
                    <input class="radio" type="radio" name="active"
						value="No">No
                                 </c:if>
				<c:if test="${!movieList.active }">
					<input class="radio" type="radio" name="active" value="Yes" checked>Yes                   
                    <input class="radio" type="radio" name="active"
						value="No" checked>No
                    </c:if>
			</div>
			<div class="form-field-spacing">
				<label for="dateOfLaunch">Date of Launch</label> <input type="text"
					class="text-box" name="dateOfLaunch"
					value="<fmt:formatDate value="${movieList.dateOfLaunch}" type="date" pattern="dd/MM/yyyy" />">
			</div>
			<div class="form-field-spacing">
				<label for="genre"></label>
				<div>
					Category <select name="genre" class="dropdown" id="genre">
						<option value="${movieList.genre}">${movieList.genre}</option>
						<option value="Science Fiction">Science Fiction</option>
						<option value="SuperHero">SuperHero</option>
						<option value="Romance">Romance</option>
						<option value="Adventure">Adventure</option>
					</select>
				</div>
			</div>
			<div class="form-field-spacing">
				<c:if test="${movieList.hasTeaser }">
					<input type="checkbox" name="hasTeaser" checked>
				</c:if>
				<c:if test="${!movieList.hasTeaser }">
					<input type="checkbox" name="hasTeaser">
				</c:if>
				<label for="freeDelivery">Has Teaser</label>
			</div>
			<input type="hidden" name="id" value="${movieList.id}">
			<div>
				<input type="submit" class="button success-button" value="save">
			</div>

			<div class="footer" id="footer">copyright@2019</div>
		</form>
	</div>
</body>
</html>