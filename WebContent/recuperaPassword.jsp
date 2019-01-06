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
	
		<form action=RecuperaPasswordServlet>
		<% String risultato=(String)request.getAttribute("res");
		if(risultato==null)	risultato="";	
		
		%>
			Inserisci Username
			<input type="text" name="usernameRecupera" placeholder="Inserisci.."><br>
			
			<br><br>
			<button id="recupera-button">Recupera</button>
			<%if(risultato!=null && !risultato.isEmpty()){ %>
			<p id="risultatoPassRecupero"><%=risultato %> </p>
			<%} %>
		</form>
	
	</div>

<%@include file="footer.jsp"%>

</body>
</html>