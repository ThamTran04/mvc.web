<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Calendar</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<link rel="stylesheet" href="styles/reservation.css">
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Formation: <c:out value="${param.formation}"/></th>
				<th scope="col">Salle: <c:out value="${param.room}" /></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
	</table>
</body>
</html>