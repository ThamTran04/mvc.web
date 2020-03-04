<%@ page import="java.util.List,bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/reservation.css">
<title>Vehicule Magasin</title>
</head>
<body>
<!--  	onload="document.getElementById('VoitureFields').style.visibility =
	'visible';document.getElementById('MotoFields').style.visibility =
	'hidden';">-->

	<jsp:include page="menu.jsp"></jsp:include>
	<br>
	<h1 style="color: red">
		<c:out value="${requestScope.message}" />
	</h1>

	<form action="/mvc.web/vehicule" method="post">
		<fieldset>
			<legend>Type de V&eacute;hicule</legend>
			<span> <input type="radio" id="voiture" name="typeVehicule"
				value="Voiture"
				onclick="document.getElementById('VoitureFields').style.visibility = 'visible';document.getElementById('MotoFields').style.visibility = 'hidden';"
				checked> <label for="voiture">Voiture</label>
			</span> <span> <input type="radio" id="moto" name="typeVehicule"
				value="Moto"
				onclick="document.getElementById('VoitureFields').style.visibility = 'hidden';document.getElementById('MotoFields').style.visibility = 'visible';">
				<label for="moto">Moto</label>
			</span>
		</fieldset>
		<br />
		<fieldset id="common">
			<legend>Attributs V&eacute;hicule</legend>
			<table id="commontable">
				<tr>
					<td>Immatriculation</td>
					<td><input type="text" name="immatriculation"></td>
				</tr>
				<tr>
					<td>Marque</td>
					<td><input type="text" name="marque"></td>
				</tr>
				<tr>
					<td>Modele</td>
					<td><input type="text" name="modele"></td>
				</tr>
			</table>

		</fieldset>
		<br />
		<fieldset id="MotoFields">
			<legend>Attribut Moto</legend>
			<table>
				<tr>
					<td>Puissance</td>
					<td><input type="text" name="puissance"></td>
				</tr>
			</table>

		</fieldset>
		<br />
		<fieldset id="VoitureFields">
			<legend>Attributs Voiture</legend>
			<table>
				<tr>
					<td>Couleur</td>
					<td><input type="text" name="couleur"></td>
				</tr>
				<tr>
					<td>Annee</td>
					<td><input type="text" name="annee"></td>
				</tr>
			</table>

		</fieldset>
		<div class="button">
			<button type="submit">Ajouter v&eacute;hicule</button>
		</div>
	</form>
	<br />
	<br />
	<br />

	<table>
		<thead>
			<tr>
				<th>Immatriculation</th>
				<th>Marque</th>
				<th>Modèle</th>
				<th>Nombre de roues</th>
				<th>Couleur</th>
				<th>Puissance</th>
				<th>Année</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.vehicules}" var="vehicule">
				<tr>
					<td><c:out value="${vehicule.immatriculation}" /></td>
					<td><c:out value="${vehicule.modele}" /></td>
					<td><c:out value="${vehicule.nombreRoues}" /></td>
					<td><c:out value="${vehicule.marque}" /></td>
					<c:choose>
						<c:when test="${vehicule.typeVehicule == 'Voiture'}">
							<td><c:out value="${vehicule.couleur}" /></td>
							<td></td>
							<td><c:out value="${vehicule.annee}" /></td>
						</c:when>
						<c:when test="${vehicule.typeVehicule =='Moto'}">
							<td></td>
							<td><c:out value="${vehicule.puissance}" /></td>
							<td></td>
						</c:when>
					</c:choose>
				<tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>
		<a href="/mvc.web/vehicule"> Retour Formulaire </a>
	</h2>

</body>
</html>