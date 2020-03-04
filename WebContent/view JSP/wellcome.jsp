<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>wellcome</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/reservation.css">
</head>
<body>
	<h1 style="color: red">
		Hello
		<c:out value="${requestScope.nom}" />
	</h1>
	<h1 style="color: red">You are wellcome to ICS Nice !!!</h1>
	<jsp:include page="menuLogin.jsp"></jsp:include>
	<img src="image/ICS.png">
</body>
</html>