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
		
			<input type="text">
			Inserisci Username/E-mail
			<input type="password">
			Inserisci Password
			<button id="submit">Accedi</button>
			
		</form>
	
	Non sei ancora registrato?
	Provvedi subito <a href="registrazione.jsp">Registrati!</a>
	
	</div>

<%@include file="footer.jsp"%>

</body>

</html>