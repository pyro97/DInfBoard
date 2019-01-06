<%@page import="model.PJO.Studente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modifica Profilo - DInfBoard</title>
	<link rel="stylesheet" href="css/profiloUser.css">
</head>
<body>

<%@include file="header.jsp"%>

    <%
/*

if(auth==null || !auth || utente==null) {
	response.sendRedirect("login.jsp");
}
*/
%>   
<div class="row">
  
  
  <div class="right" style="background-color:#005999;">
    <h1 class="titolo">Modifica Profilo</h1>
    
    
  
	Modifica Profilo
		<form id="form" action="ModificaProfiloServlet">
		Inserisci Username
			<input type="text" name="username"  value="ciao"><br>
			Inserisci Username
			<input type="text" name="username" ><br>
		 	Inserisci Username
			<input type="text" name="username" value="<%=utente.getUsername() %>" <br>
			Inserisci E-mail
			<input type="text" name="email" value="<%=utente.getEmail() %"><br>
			Inserisci Password
			<input type="password" name="password" value="<%=utente.getPassword() %>"<br>
			Inserisci il tuo nome
			<input type="text" name ="nome" value="<%=utente.getNome() %>"<br>
			Inserisci il tuo cognome
			<input type="text" name="cognome" value="<%=utente.getCognome() %>"<br>
			Inserisci preferenza
			<input type="text" name="preferenza" value="<%=utente.getPreferenza() %>"<br>
			
			<br><br>
			<button id="updateProf">Conferma</button>
			
		</form>
	
    	
    	
        
        
        </div>
    
    	
 	    
 	<%-- 
 	<h3>Nome: </h3> <p><%=utente.getNome() %> </p> 
 	<h3>Cognome: </h3> <p><%=utente.getCognome() %> </p> 
 	<h3>E-mail: </h3> <p><%=utente.getEmail() %> </p> 
 	<h3>Username: </h3> <p><%=utente.getUsername() %> </p> 
 	 <h3>Password: </h3> <p><%=utente.getPassword() %> </p> 
 	--%>
  </div>
</div>
	<div id="div-registrazione">
	<%if(utente!=null){ %>
	Modifica Profilo
		<form action="ModificaProfiloServlet">
		
			Inserisci Username
			<input type="text" name="username" placeholder="Inserisci.."><%=utente.getUsername() %><br>
			Inserisci E-mail
			<input type="text" name="email" placeholder="Inserisci.."><%=utente.getEmail() %><br>
			Inserisci Password
			<input type="password" name="password" placeholder="Inserisci.."><%=utente.getPassword() %><br>
			Inserisci il tuo nome
			<input type="text" name ="nome" placeholder="Inserisci.."><%=utente.getNome() %><br>
			Inserisci il tuo cognome
			<input type="text" name="cognome" placeholder="Inserisci.."><%=utente.getCognome() %><br>
			Inserisci preferenza ( Inserire '0' per andare avanti)
			<input type="text" name="preferenza" placeholder="Inserisci.."><%=utente.getPreferenza() %><br>
			
			<br><br>
			<button id="conferma-button">Conferma</button>
			
		</form>
	<%} %>
	</div>

<%@include file="footer.jsp"%>

</body>
</html>