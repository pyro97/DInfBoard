<%@page import="model.PJO.Studente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
Boolean auth2 = (Boolean) session.getAttribute("auth");
    Studente s=(Studente) session.getAttribute("studente");

if(auth2==null || !auth2 || s==null) {
	response.sendRedirect("login.jsp");
}

%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifica Profilo - DInfBoard</title>
	<link rel="stylesheet" href="css/registrazione.css">
</head>
<body>

<%@include file="header.jsp"%>

	<div id="div-registrazione">
	<%if(s!=null){ %>
	Modifica Profilo
		<form action="ModificaProfiloServlet">
		
			Inserisci Username
			<input type="text" name="username" placeholder="Inserisci.."><%=s.getUsername() %><br>
			Inserisci E-mail
			<input type="text" name="email" placeholder="Inserisci.."><%=s.getEmail() %><br>
			Inserisci Password
			<input type="password" name="password" placeholder="Inserisci.."><%=s.getPassword() %><br>
			Inserisci il tuo nome
			<input type="text" name ="nome" placeholder="Inserisci.."><%=s.getNome() %><br>
			Inserisci il tuo cognome
			<input type="text" name="cognome" placeholder="Inserisci.."><%=s.getCognome() %><br>
			Inserisci preferenza ( Inserire '0' per andare avanti)
			<input type="text" name="preferenza" placeholder="Inserisci.."><%=s.getPreferenza() %><br>
			
			<br><br>
			<button id="conferma-button">Conferma</button>
			
		</form>
	<%} %>
	</div>

<%@include file="footer.jsp"%>

</body>
</html>