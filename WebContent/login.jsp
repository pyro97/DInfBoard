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
	
		<form action="LoginServlet" method=get>
		
			<input type="text" id="username" name="username">
			Inserisci Username
			<input type="password" id="password" name="password">
			Inserisci Password
			<button id="submit">Accedi</button>
			
		</form>
		
	<script>
	function loginHandler()
	{
		var x= cLoginForm();
			if(x)
			{
				console.log("Login ok.");	
			}
	}
	</script>
	<script src="js/controlloForm.js"></script>
	
	
	Non sei ancora registrato?
	Provvedi subito <a href="registrazione.jsp">Registrati!</a>
	
	</div>

<%@include file="footer.jsp"%>

</body>

</html>
