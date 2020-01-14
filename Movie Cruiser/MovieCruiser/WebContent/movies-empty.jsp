<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width">
<meta http-equiv="X-UA-Compatible" content="ie-edge">
<link rel="stylesheet" href="styles/style.css">
<title>Edit Movies</title>
<script src="js/script.js"></script>

</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images\movielogo.png"> <a href="ShowMovieListCustomer">Movies</a>
		<a href="ShowFavorites">Favorites</a>
	</div>
	<div>
		<p class="para">
			No Movies in the Favorites.Use 'Add to Favorite' option in  <a href="ShowMovieListCustomer"> Movie 
				List.</a>
		</p>
	</div>
	<div class="footer" id="footer"> copyright@2019 </div>

</body>
</html>

