<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/registrazione.css">
</head>
<body>

<%@include file="header.jsp"%>

	<div id="div-registrazione">
	
	Benvenuto nella pagina di registrazione alla piattaforma DInfBoard
		<form action="RegistrazioneServlet">
		
			<input type="text">
			Inserisci Username
			<input type="text">
			Inserisci E-mail
			<input type="text">
			Inserisci Password
			<input type="password">
			Inserisci il tuo nome
			<input type="text">
			Inserisci il tuo cognome
			<input type="text">
			
			<input type="submit" text="Registrati">
			
		</form>
	
	</div>

<%@include file="footer.jsp"%>

</body>
</html>