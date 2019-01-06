<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.PJO.Studente"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profilo - DInfBoard</title>
	<link rel="stylesheet" href="css/profiloAdmin.css">
</head>

<body>

<%@include file="header.jsp"%>
<%

Boolean auth = (Boolean) session.getAttribute("auth");
Studente s = (Studente) session.getAttribute("utente");

if(!auth || !s.isIsAdmin() || auth==null) {
	response.sendRedirect("restricted.jsp");
}

%>   

<div class="row">
  <div class="left" style="background-color:#ddd;">
    <h2>Area Admin</h2>  
    <ul id="myMenu">
      <li><a href="inserireAdmin.jsp">Inserisci Admin</a></li>
      <li><a href="rimuoviAdmin.jsp">Rimuovi Admin</a></li>
      <li><a href="sospendiUtente.jsp">Sospendi Utente</a></li>
      <li><a href="gestionePreferenze.jsp">Aggiorna Preferenze</a></li>
      <li><a href="LogoutServlet">Logout</a></li>
    </ul>
  </div>
  
  <div class="right" style="background-color:#005999;">
    <h1 class="titolo">Profilo Admin</h1>
 	<h3>Nome: </h3> <p>cognome </p> 
 	<h3>Cognome: </h3> <p>cognome </p> 
 	<h3>E-mail: </h3> <p>cognome </p> 
 	<h3>Username: </h3> <p>cognome </p> 
 	 <h3>Password: </h3> <p>cognome </p> 
 	
 	
 	
 	
  </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>