<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.PJO.Annuncio"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bacheca.css">
<title>Bacheca - DInfBoard</title>
</head>
<body>

<%@ include file="header.jsp" %>

<div id="bachecaDiv">
Qui si stampa tutta la bacheca di DinfBoard
<%

ArrayList<Annuncio> bacheca = (ArrayList<Annuncio>) application.getAttribute("bacheca");

if(bacheca==null)
	response.sendRedirect("error.jsp");
else if(bacheca.size()==0) {
	%> 
	
	La bacheca di DInfBoard è vuota. Clicca sul pulsante in alto per inserire un annuncio
	
	<%
}

else {
	for(int i=0;i<bacheca.size();i++) {
		
		%> <div class="class_annunci">
		<%=bacheca.get(i).getTitolo() %> -- <%=bacheca.get(i).getDescrizione() %> -- <img src="<%=bacheca.get(i).getPathImmagine()%>">
		<a href="annuncio.jsp?ID=<%=bacheca.get(i).getID()%>">Vai all'annuncio</a>
			</div>
			
			<%
		
	}
}

%>

</div>

<%@ include file="footer.jsp" %>

</body>
</html>