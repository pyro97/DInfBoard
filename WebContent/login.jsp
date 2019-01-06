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
	
		<form action="LoginServlet" id="loginForm" method="post">
		
			<input type="text" id="username" name="username">
			Inserisci Username
			<input type="password" id="password" name="password">
			Inserisci Password
			
		</form>
		
		<button onclick="loginHandler()">Accedi</button>
	
	
	<script src="js/controlloForm.js"></script>
		
	<script>
	
	function loginHandler()
	{
		var x= cLoginForm();
			if(x)
			{
				document.getElementById("loginForm").submit();
			}
	}
	</script>
	
	
	Non sei ancora registrato?
	Provvedi subito <a href="registrazione.jsp">Registrati!</a>
	<br>
	<br>
	<a href="forgottedPassword.jsp">Hai dimenticato la password?</a>
	
	</div>

<%
Boolean notlogged = (Boolean) session.getAttribute("not-logged");
if(notlogged!=null && notlogged) {
	%> <h2>Hai inserito delle credenziali errate</h2> <%
	session.removeAttribute("not-logged");
}
%>

<%@include file="footer.jsp"%>

</body>

</html>
