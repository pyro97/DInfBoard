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

if(auth==null || !auth || utente==null ) {
	response.sendRedirect("login.jsp");
}else{
	if(!utente.isIsAdmin())		response.sendRedirect("login.jsp");

}

String pref=(String) session.getAttribute("pref");

%>   

<div class="row">
  <div class="left" style="background-color:#ddd;">
    <h2>Area Admin</h2>  
    <ul id="myMenu">
     <li><a href="inserireAdmin.jsp">Inserisci Admin</a></li>
      <li><a href="rimuoviadmin.jsp">Rimuovi Admin</a></li>
      <li><a href="sospendiUtente.jsp">Sospendi Utente</a></li>
      <li><a href="gestionePreferenze.jsp">Aggiorna Preferenze</a></li>
      <li><a href="LogoutServlet">Logout</a></li>
    </ul>
  </div>
  
  <div class="right" style="background-color:#005999;">
        <h1 class="titolo">Aggiorna Preferenze</h1>
    
	
		<div id="div-pref">
	
		<form action="GestionePreferenzeServlet" method=get>
					<p>ID Preferenza</p>
		
			<input type="text" name="id">
			
			<p>Nome Preferenza</p>
		
			<input type="text" name="nome">
			
			
			<button onclick="gestisciPref(this.id)" id="deletePref">Elimina</button>
			<button onclick="gestisciPref(this.id)" id="addPref">Inserisci</button>
			<button onclick="gestisciPref(this.id)" id="updatePref">Aggiorna</button>
			
			
			
		</form>
		<script>
	
	function registrazioneHandler(cliccato) {
		if(cliccato=="deletePref"){
			<%session.setAttribute("pref","elimina");%>
		}else if(cliccato=="addPref"){
			<%session.setAttribute("pref","aggiungi");%>

		}else if(cliccato=="updatePref"){
			<%session.setAttribute("pref","modifica");%>
		}
	}
	
	</script>
	
	</div>
 	
  </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>