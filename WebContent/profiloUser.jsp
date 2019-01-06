<%@page import="model.PJO.Studente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> Profilo - DInfBoard</title>
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
    <h1 class="titolo">Profilo</h1>
 	
 	<h3>Nome: </h3> <p><%=utente.getNome() %> </p> 
 	<h3>Cognome: </h3> <p><%=utente.getCognome() %> </p> 
 	<h3>E-mail: </h3> <p><%=utente.getEmail() %> </p> 
 	<h3>Username: </h3> <p><%=utente.getUsername() %> </p> 
 	 <h3>Password: </h3> <p><%=utente.getPassword() %> </p> 
 	
        
        <div class="buttons">
        
        
        
        <form action="modificaProfilo.jsp">
			<button  id="updateProf">Modifica</button>
    	
    	</form>
    	
 
    	
        
        
        </div>
    
    	
 	    
 
  </div>
</div>

<%@include file="footer.jsp"%>

</body>
</html>