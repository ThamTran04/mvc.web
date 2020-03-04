<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Inscription</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/reservation.css">
<link rel="stylesheet" type="text/css" href="styles/inscription.css">
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="inscription">
		<form action="/mvc.web/inscription" method="post">
			<div class="block" onclick="onclick">
				<div class="contact">
					<div class="left">
						<img id="logo" src="/mvc.web/image/logo.png" alt="logo ICS">
						<h1>FORMULAIRE D'INSCRIPTION</h1>
						<div id="sep"></div>
					</div>

					<div class="right">
						<input type="text" name="surname" class="input_block" id="surname"
							placeholder="Nom" alt="surname" required /> <input type="text"
							class="input_block" id="name" name="name" placeholder="Prenom"
							alt="name" required /> <input type="text" class="input_block"
							id="utilisateur" name="utilisateur"
							placeholder="Nom d'utilisateur" alt="nom d'utilisateur" required />
						<input type="email" class="input_block" id="email" name="email"
							placeholder="Email" alt="email" /> <input type="password"
							class="input_block" id="password" name="password"
							placeholder="Mot de passe" alt="password" /> <input type="submit"
							id="envoi" value="S'enregistrer" />

					</div>
				</div>
			</div>
		</form>
	</div>
	<script src="inscription1.js"></script>
</body>
</html>