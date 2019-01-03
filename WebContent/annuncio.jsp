<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.PJO.Annuncio, model.DAO.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Annuncio - DInfBoard</title>
<link rel="stylesheet" href="css/annuncio.css">
</head>
<body>

<%
Boolean auth = (Boolean) session.getAttribute("auth");
if(auth==null || !auth)
	response.sendRedirect("login.jsp");

int id = Integer.parseInt(request.getParameter("ID"));
AnnuncioDao dao = new AnnuncioDao();
Annuncio a = dao.get(id);
dao.close();

%>

<%@include file="header.jsp" %>

	<div id="annuncioDiv">
		
		<img src="<%=a.getPathImmagine()%>"><br>
		
		<h2>Titolo</h2> <%=a.getTitolo()%> <br>
		<h2>Descrizione</h2> <%=a.getDescrizione()%> <br>
		<h2>Numero Partecipanti</h2> <%=a.getPartecipanti()%> <br>
		<h2>Categoria</h2> <%=a.getPreferenza() %>
		<h2>Organizzatore</h2> <a href="user.jsp?username=<%=a.getUsernameOrganizzatore() %>"><%=a.getUsernameOrganizzatore()%></a>
		
	</div>

<%@include file="footer.jsp" %>

</body>
</html>