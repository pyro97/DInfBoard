<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registrazione - DInfBoard</title>
	<link rel="stylesheet" href="css/registrazione.css">
</head>
<body>

<%@include file="header.jsp"%>

	<div id="div-registrazione">
	
	Benvenuto nella pagina di registrazione alla piattaforma DInfBoard
		<form action="RegistrazioneServlet">
		
			Inserisci Username
			<input type="text" placeholder="Inserisci.."><br>
			Inserisci E-mail
			<input type="text" placeholder="Inserisci.."><br>
			Inserisci Password
			<input type="text" placeholder="Inserisci.."><br>
			Inserisci il tuo nome
			<input type="text" placeholder="Inserisci.."><br>
			Inserisci il tuo cognome
			<input type="text" placeholder="Inserisci.."><br>
			
			<br><br>
			<button id="registrazione-button">Registrati</button>
			
		</form>
	
	</div>

<%@include file="footer.jsp"%>

</body>
</html>