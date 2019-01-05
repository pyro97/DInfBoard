<%@page import="model.DAO.implement.ManagerPreferenza"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.PJO.Preferenza, model.DAO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserisci un nuovo Annuncio - DInfBoard</title>
<link rel="stylesheet" href="css/inserisciAnnuncio.css">
</head>
<body>

<%
Boolean auth = (Boolean) session.getAttribute("auth");
if(auth==null || !auth)
	response.sendRedirect("login.jsp");
%>

<%@ include file = "header.jsp" %>

	<div id="inserisciAnnuncioDiv">
	
		<form action=InserisciAnnuncioServlet method=post enctype="multipart/form-data">
		
			Inserisci Titolo
			<input type="text" id="titolo" name="titolo" placeholder="Inserisci..">
			Inserisci Descrizione
			<input type="textarea" id="descrizione" name="descrizione" placeholder="Inserisci..">
			Inserisci Immagine
			<input type="file" name="immagine">
			
			Scegli la categoria in cui inserire il tuo annuncio : 
			<br>
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
			
			<button type="submit">Inserisci Annuncio</button>
			
		</form>
		
	<script>
	function inserisciAnnuncioHandler()
	{
		var x= cAnnuncioForm();
			if(x)
			{
				console.log("Annuncio ok.");	
			}
	}
	</script>
	<script src="js/controlloForm.js"></script>
	
	
	</div>

<%@ include file = "footer.jsp" %>

</body>
</html>
