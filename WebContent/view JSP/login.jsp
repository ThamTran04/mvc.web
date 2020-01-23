<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dialogue Login</title>
<link rel="stylesheet" type="text/css" href="styles/login.css">
</head>
<body>
<h1>Login to ...</h1>

	<c:choose>
		<c:when test="${param.err == '1'}">
			<h4 style="color: red">Username or Password is not correct</h4>
		</c:when>
		
		<c:when test="${param.adminerror == '1'}"> 
			<h4 style="color: red">you are not admin. You have to connecte to admin</h4>
		</c:when>
	</c:choose>

	<form action="/NomProjet/login" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="chkRemember" value="ON">Remember
				to me</td>
			</tr>
			<tr>
				<td><input type="submit" value="Connection"></td>
			</tr>
		</table>
	</form>
</body>
</html>