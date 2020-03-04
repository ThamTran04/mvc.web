<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/reservation.css">
<link rel="stylesheet" type="text/css" href="styles/login1.css">
</head>
<body>
	<nav class="navbar navbar-dark bg-primary">
		<img src="image/logo.png"> <a id="lien"
			href="/mvc.web/inscription">S'enregistrer</a>
	</nav>
	<c:choose>
		<c:when test="${param.err == '1'}">
			<h1 style="color: red">Username or Password is not correct</h1>
		</c:when>

		<c:when test="${param.adminerror == '1'}">
			<h1 style="color: red">you are not admin. You have to connecte
				to admin</h1>
		</c:when>

		<c:when test="${param.usererror == '1'}">
			<h1 style="color: red">You have to connecte</h1>
		</c:when>
	</c:choose>

	<div class="login">
		<form action="/mvc.web/login" method="post">
			<div class="block" onclick="onclick">
				<div class="top"></div>

				<div class="center">
					<input type="text" name="username" placeholder="Nom d'utilisateur" />
					<input type="password" name="password" placeholder="Mot de passe" />
					<input type="checkbox" name="chkRemember" value="ON" /> Se
					rappeler de moi<input type="submit" id="seconnecter"
						value="Se connecter" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
