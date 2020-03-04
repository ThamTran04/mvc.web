<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Réservation</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/reservation.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>

function onRadioButtonClick(el) {
	var name = el.name;
	var id = el.id.toString();
	if (name == "formationgroupradios")
		document.getElementById("formation").value = id;
	if (name == "roomgroupradios"){
		var room = document.getElementById("room");
		room.value = id;	
		room.dispatchEvent(new Event('change'));
	}
};

$(document).ready(function(){

	$("#room").change(function(){
		  
		var room = document.getElementById("room").value;
		// alert("room is " + room);
		$.ajax({
			url : 'reservation2',
			type : 'GET',
			data : 'room=' + room,
			dataType : 'html',
			
			success : function(code_html, statut){
				$("#date").html("<option>Select a date</option>"); 
				$(code_html).appendTo("#date");
				
				$("#start-time").html("<option>Select a start time</option>"); 
				$("#end-time").html("<option>Select an end time</option>")
				
			},

			error : function(resultat, statut, erreur){
				console.log("Something really bad happened " + textStatus);
			}
		});		
	});
	
	$("#date").change(function(e){
		 
		var date = document.getElementById("date").value;
		 
		$.ajax({
			url : 'reservation2',
			type : 'GET',
			data : 'date=' + date,
			dataType : 'html',
			
			success : function(code_html, statut){
			           				
				// clear content
				$("#start-time").html("<option>Select a start time</option>");
				$(code_html).appendTo("#start-time")
								
				$("#end-time").html("<option>Select an end time</option>");
				$(code_html).appendTo("#end-time")
			},

			error : function(resultat, statut, erreur){
				console.log("Something really bad happened " + textStatus);
			}
		});		
	});
	


});
	
</script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="vide"></div>

	<div id="conteneur">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Occupant</h5>
				<div class="container">
					<div class="row d-flex justify-content-around">
						<div class="col-sm">
							<div class="card" style="width: 10rem;">
								<img src="image/promo.jpg" class="card-img-top" alt="Dev Web">
								<div class="card-body">
									<div class="form-check">
										<input type="radio" checked="checked" class="form-check-input"
											id="web" name="formationgroupradios"
											onclick="onRadioButtonClick(this)"> <label
											class="form-check-label">Dev Web</label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm">
							<div class="card" style="width: 10rem;">
								<img src="image/promo.jpg" class="card-img-top" alt="Java">
								<div class="card-body">
									<div class="form-check">
										<input type="radio" class="form-check-input" id="java"
											name="formationgroupradios"
											onclick="onRadioButtonClick(this)"> <label
											class="form-check-label" for="materialGroupJava">Java</label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm">
							<div class="card" style="width: 10rem;">
								<img src="image/promo.jpg" class="card-img-top" alt="TAI">
								<div class="card-body">
									<div class="form-check">
										<input type="radio" class="form-check-input" id="tai"
											name="formationgroupradios"
											onclick="onRadioButtonClick(this)"> <label
											class="form-check-label">TAI</label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm">
							<div class="card" style="width: 10rem;">
								<img src="image/promo.jpg" class="card-img-top" alt="CDA">
								<div class="card-body">
									<div class="form-check">
										<input type="radio" class="form-check-input" id="cda"
											name="formationgroupradios"
											onclick="onRadioButtonClick(this)"> <label
											class="form-check-label">CDA</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="vide"></div>

		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Salle</h5>
				<div class="container">
					<div class="row d-flex justify-content-around">
						<div class="col-sm">
							<div class="card" style="width: 10rem;">
								<img src="image/salle.jpg" class="card-img-top" alt="Open space">
								<div class="card-body">
									<p class="card-text">60 places</p>
									<div class="form-check">
										<input type="radio" class="form-check-input" checked="checked"
											id="openspace" name="roomgroupradios"
											onclick="onRadioButtonClick(this)"> <label
											class="form-check-label">Open space</label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm">
							<div class="card" style="width: 10rem;">
								<img src="image/salle.jpg" class="card-img-top" alt="Theo">
								<div class="card-body">
									<p class="card-text">20 places</p>
									<div class="form-check">
										<input type="radio" class="form-check-input" id="theo"
											name="roomgroupradios" onclick="onRadioButtonClick(this)">
										<label class="form-check-label">Theo</label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm">
							<div class="card" style="width: 10rem;">
								<img src="image/salle.jpg" class="card-img-top" alt="buro">
								<div class="card-body">
									<p class="card-text">10 places</p>
									<div class="form-check">
										<input type="radio" class="form-check-input" id="buro"
											name="roomgroupradios" onclick="onRadioButtonClick(this)">
										<label class="form-check-label">Buro</label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm">
							<div class="card" style="width: 10rem;">
								<img src="image/salle.jpg" class="card-img-top" alt="plato">
								<div class="card-body">
									<p class="card-text">15 places</p>
									<div class="form-check">
										<input type="radio" class="form-check-input" id="plato"
											name="roomgroupradios" onclick="onRadioButtonClick(this)">
										<label class="form-check-label">Plato</label>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="card">			
		  <div class="card-body">
			<h5 class="card-title">Date time</h5>
				
			<div id="datetime">
				<select id="date"> 
					<option>Select a date</option>
					<option>lundi</option>
					<option>mardi</option>
					<option>mecredi</option>
				</select>			
				<select id="start-time">
					<option>Select a start time</option>
				</select>
				<select id="end-time" >
					<option>Select a end time</option>
				</select>				
			</div>
		  </div>
		</div>
		
	</div>


	<form action="/mvc.web/calendar">
		<!--  ${pageContext.request.contextPath} = /mvc.web/ -->
		<input type="hidden" name="formation" id="formation" value="promos" />
		<input type="hidden" name="room" id="room" value="room" />
		<center>
			<input type="submit" class="btn btn-primary" value="Réserver" />
		</center>
	</form>
	
</body>
</html>