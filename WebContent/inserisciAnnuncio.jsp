<%@page import="model.DAO.implement.ManagerPreferenza"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.PJO.Preferenza, model.DAO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserisci un nuovo Annuncio - DInfBoard</title>
</head>
<body>

<%@ include file = "header.jsp" %>

	<div id="inserisciAnnuncioDiv">
	
		<form action=InserisciAnnuncioServlet method=post>
		
			Inserisci Titolo
			<input type="text" name="titolo" placeholder="Inserisci..">
			Inserisci Descrizione
			<input type="text" name="descrizione" placeholder="Inserisci..">
			Inserisci Immagine
			<input type="image" name="immagine" placeholder="Inserisci..">
			
			<%
			ArrayList<Preferenza> elencoPreferenza = new ArrayList<Preferenza>();
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
			
		</form>
	
	</div>

<%@ include file = "footer.jsp" %>

</body>
</html>