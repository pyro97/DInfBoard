<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.PJO.Studente, model.DAO.*, java.util.ArrayList, model.PJO.Annuncio"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Area - DInfBoard</title>
	<link rel="stylesheet" href="css/userArea.css">
</head>
<body>

<%@include file="header.jsp"%>
<%

Boolean auth = (Boolean) session.getAttribute("auth");
Studente stud = (Studente) session.getAttribute("utente");

if(auth==null || !auth) {
	response.sendRedirect("login.jsp");
}
%>   

	<div id="div-userarea">
	
		Benvenuto nell'area utente di <%=session.getAttribute("username") %>
		<br>
		
		
		<%
		if(stud!=null && stud.isIsAdmin()) {
			%> Accedi all'area riservata agli amministratori da questo link <br>
			<a href="adminArea.jsp">Area Admin</a> <%
		}
		%>
		
		<br>
		
		<a href="modificaProfilo.jsp?username=<%=session.getAttribute("username")%>">Clicca qui per modificare il tuo profilo</a>
		
		<form action = "LogoutServlet" method="post">
			<button id="logout-button">Logout</button>
		</form>
		
		<%
		StudenteDao dao = new StudenteDao();
		String u = (String) session.getAttribute("username");
		Studente s = dao.get(u);
		ArrayList<Annuncio> annunci_organizzati = dao.getOrganizzati(s);
		ArrayList<Annuncio> annunci_partecipati = dao.getPartecipati(s);
		
		dao.close();
		%>
		
		<div id="annunci-organizzati">
		<h2>Annunci Organizzati</h2>
		<%
		if(annunci_organizzati==null || annunci_organizzati.size()==0) {
			%> <h2>Non hai ancora inserito nessun annuncio sulla piattaforma </h2> <%
		}
		
		else {
			for(int i=0;i<annunci_organizzati.size();i++) {
				%> <div class="annuncio">
					
					<%=annunci_organizzati.get(i).getTitolo()%>
					<img src="<%=annunci_organizzati.get(i).getPathImmagine()%>">
					
					<%
					if(!annunci_organizzati.get(i).getIsVisible()) {
						%> <h3>(Archiviato)</h3> <%
					}
					else {
						%> <a href="ArchiviaAnnuncioServlet?ID=<%=annunci_organizzati.get(i).getID()%>">Archivia Annuncio</a> <%
					}
					
					%>
					<a href="EliminaAnnuncioServlet?ID=<%=annunci_organizzati.get(i).getID()%>">Inizia</a>
					
           	        <a href="CancellaAnnuncioServlet?ID=<%=annunci_organizzati.get(i).getID()%>">Cancella Annuncio</a>
					
					</div> <%
			}
		}
		
		%>
		</div>
		
		<div id="annunci-partecipati">
		<h2>Annunci a cui stai partecipando</h2>
		<%
		if(annunci_partecipati==null || annunci_partecipati.size()==0) {
			%> <h2>Non hai ancora partecipato a nessun annuncio sulla piattaforma </h2> <%
		}
		else {
			for(int i=0;i<annunci_partecipati.size();i++) {
				%> <div class="annuncio">
					
					<%=annunci_partecipati.get(i).getTitolo()%>
					<img src="<%=annunci_partecipati.get(i).getPathImmagine()%>">
					
					<a href="annuncio.jsp?ID=<%=annunci_partecipati.get(i).getID()%>">Vai all'annuncio</a>
					<a href="EliminaPartecipazioneServlet?ID=<%=annunci_partecipati.get(i).getID()%>">Elimina la tua partecipazione.</a>
					
					</div> <%
			}
		}
		%>
		
		</div>
		
	</div>

<%@include file="footer.jsp"%>

</body>
</html>