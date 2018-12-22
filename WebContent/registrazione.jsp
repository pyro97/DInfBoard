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
			<input type="text" name="username" placeholder="Inserisci.."><br>
			Inserisci E-mail
			<input type="text" name="email" placeholder="Inserisci.."><br>
			Inserisci Password
			<input type="password" name="password" placeholder="Inserisci.."><br>
			Inserisci il tuo nome
			<input type="text" name ="nome" placeholder="Inserisci.."><br>
			Inserisci il tuo cognome
			<input type="text" name="cognome" placeholder="Inserisci.."><br>
			Inserisci preferenza ( Inserire '0' per andare avanti)
			<input type="text" name="preferenza" placeholder="Inserisci.."><br>
			
			<br><br>
			<button id="registrazione-button">Registrati</button>
			
		</form>
	
	</div>

<%@include file="footer.jsp"%>

</body>
</html>