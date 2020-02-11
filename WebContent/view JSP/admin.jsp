<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin management</title>
<link rel="stylesheet" type="text/css" href="styles/users.css">
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

	<h4 style="color: red">Wellcom to admin management for all users</h4>
	<form action="/mvc.web/admin" method="post">
	<table>
		<tr><!-- On cree l'entête -->
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>

		<!-- On cherche users a partir de  sessionScope initialise dans doPost (ligne 50)-->
		<c:forEach items="${requestScope.users}" var="user">
			<!-- pour chaque user dans users -->
			<tr>
				<!-- On cree data -->
				<!-- username, email, password: day la nhung variables da duoc khai bao trong class User.java -->
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
			</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>