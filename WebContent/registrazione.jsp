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
		<form action="RegistrazioneServlet" method=post>
		
			Inserisci Username
			<input type="text" id="username" name="username" placeholder="Inserisci.."><br>
			Inserisci E-mail
			<input type="email" id="email" name="email" placeholder="Inserisci.."><br>
			Inserisci Password
			<input type="password" id="password" name="password" placeholder="Inserisci.."><br>
			Inserisci il tuo nome
			<input type="text" id="nome" name="nome" placeholder="Inserisci.."><br>
			Inserisci il tuo cognome
			<input type="text" id="cognome" name="cognome" placeholder="Inserisci.."><br>
			Inserisci preferenza ( Inserire '0' per andare avanti)
			<input type="text" name="preferenza" placeholder="Inserisci.."><br>
			
			<br><br>
			<button id="registrazione-button">Registrati</button>
			
		</form>
	
	<script>
	function registrazioneHandler()
	{
		var x= cRegistrazioneForm();
			if(x)
			{
				console.log("Registrazione ok.");	
			}
	}
	</script>
	<script src="js/controlloForm.js"></script>
	
	</div>

<%@include file="footer.jsp"%>

</body>
</html>
