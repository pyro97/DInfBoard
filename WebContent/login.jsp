<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login - DInfBoard</title>
	<link rel="stylesheet" href="css/login.css">
</head>

<body>

<%@include file="header.jsp"%>

	<div id="div-login">
	
		<form action="LoginServlet">
		
			<input type="text" name="username">
			Inserisci Username/E-mail
			<input type="password" name="password">
			Inserisci Password
			<button id="submit">Accedi</button>
			
		</form>
	
	Non sei ancora registrato?
	Provvedi subito <a href="registrazione.jsp">Registrati!</a> </br>
		Hai dimenticato la password? <a href="recuperaPassword.jsp"> Clicca qui</a>
	
	
	</div>

<%@include file="footer.jsp"%>

</body>

</html>