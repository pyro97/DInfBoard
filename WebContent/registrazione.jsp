<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.PJO.Preferenza, model.DAO.implement.ManagerPreferenza"%>
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
	
	Benvenuto nella pagina di registrazione alla piattaforma DInfBoard
		<form id="registrazioneForm" action="RegistrazioneServlet" method=post>
		
			Inserisci Username
			<input type="text" id="username" name="username" placeholder="Inserisci.."><br>
			Inserisci E-mail
			<input type="email" id="email" name="email" placeholder="Inserisci.."><br>
			Inserisci Password
			<input type="password" id="password" name="password" placeholder="Inserisci.."><br>
			Inserisci il tuo nome
			<input type="text" id="nome" name ="nome" placeholder="Inserisci.."><br>
			Inserisci il tuo cognome
			<input type="text" id="cognome" name="cognome" placeholder="Inserisci.."><br>
			Inserisci preferenza 
			
			<%
			ArrayList<Preferenza> elencoPreferenza;
			elencoPreferenza = ManagerPreferenza.getElencoPreferenze();
			%>
			
			<select name="preferenza">
				<%
				for(int i=0;i<elencoPreferenza.size();i++) {
					%> 
					<option value="<%=elencoPreferenza.get(i).getNome()%>"><%=elencoPreferenza.get(i).getNome()%></option>
					<%
				}
				%>
			</select>
			
			<br><br>
			
		</form>
	
	<button onclick="registrazioneHandler()">Registrati</button>
	
	<script>
	
	function registrazioneHandler() {
		//var x = cRegistrazioneForm();
		//if(x) {
			document.getElementById("registrazioneForm").submit(); 
		//	console.log("Sono qui");
		//}
			
	}
	
	</script>
	
	<script src="js/controlloForm.js"></script>
	
	</div>

<%@include file="footer.jsp"%>

</body>
</html>