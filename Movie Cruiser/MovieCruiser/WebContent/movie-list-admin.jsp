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
<title>Edit Movie List</title>
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movielogo.png"> <a href="ShowMovieListAdmin">Movies</a>
	</div>
	<div class="page-title">Movies</div>
	<div>
		<table class="body-content-colour">
			<tr bgcolor="">
				<th>Title</th>
				<th>Box Office</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${movieList}" var="movieList">
				<tr>
					<td>${movieList.title}</td>
					<td>$<fmt:formatNumber value="${movieList.boxOffice}"
							pattern="#,##,##,##,###.00" /></td>
					<td><c:choose>
							<c:when test="${movieList.active}"> Yes</c:when>
							<c:otherwise> No</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate value="${movieList.dateOfLaunch}"
							type="date" pattern="dd/MM/yyyy" /></td>
					<td>${movieList.genre}</td>
					<td><c:choose>
							<c:when test="${movieList.hasTeaser}"> Yes</c:when>
							<c:otherwise> No</c:otherwise>
						</c:choose></td>
					<td><a href="ShowEditMovieList?id=${movieList.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="footer" id="footer">copyright@2019</div>
	</div>
</body>
</html>