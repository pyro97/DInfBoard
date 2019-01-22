<%@page import="model.PJO.Studente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.DAO.* , model.PJO.*"%>
    
    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifica Profilo - DInfBoard</title>
	<link rel="stylesheet" href="css/modificaProfilo.css">
</head>
<body>

<%@include file="header.jsp"%>

    <%

    StudenteDao dao = new StudenteDao();
    Studente utente = dao.get(request.getParameter("username")); 

%>   
<div class="row">
  
  
  <div class="right" style="background-color:#005999;">
    <h1 class="titolo">Modifica Profilo</h1>
  
	Modifica Profilo
		<form id="form" action="ModificaProfiloServlet">

			Inserisci Username
			<input type="text" name="username" value="<%=utente.getUsername()%>"><br>
		 	Inserisci Nome
		 	<input type="text" name="nome" value="<%=utente.getNome()%>"><br>
		 	Inserisci Cognome
		 	<input type="text" name="cognome" value="<%=utente.getCognome()%>"><br>
		 	Inserisci Preferenza
		 	<input type="text" name="preferenza" value="<%=utente.getPreferenza()%>"><br>
		 	Inserisci Email
		 	<input type="text" name="email" value="<%=utente.getEmail()%>"><br>
		 	Inserisci Password
		 	<input type="text" name="password" value="<%=utente.getPassword()%>"><br>
		 	
			
			
			<br><br>
			<button id="updateProf">Conferma</button>
			
		</form>
	
    	
    	
        
        
        </div>
    
  </div>

<%@include file="footer.jsp"%>

</body>
</html>