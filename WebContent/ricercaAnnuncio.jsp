<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.PJO.Annuncio"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bacheca.css">
<title>Ricerca - DInfBoard</title>
</head>
<body>

<%@ include file="header.jsp" %>

<div id="bachecaDiv">
Qui si stampa la lista che soddisfa i requisiti della chiave di ricerca.
<%

ArrayList<Annuncio> bacheca = (ArrayList<Annuncio>) application.getAttribute("bacheca");

if(bacheca==null)
	response.sendRedirect("error.jsp");
else if(bacheca.size()==0) {
	%> 
	
	Nessun annuncio soddisfa la chaive di ricerca inserita.
	
	<%
}

else {
	for(int i=0;i<bacheca.size();i++) {
		
		if(bacheca.get(i).getIsVisible() && bacheca.get(i).getTitolo().contains(request.getParameter("ricerca"))) {
			
		%> <div class="class_annunci">
				<%=bacheca.get(i).getTitolo() %> -- <%=bacheca.get(i).getDescrizione() %> <br> 
				<img src="<%=bacheca.get(i).getPathImmagine()%>"> <br> 
				<a href="annuncio.jsp?ID=<%=bacheca.get(i).getID()%>">Vai all'annuncio</a>
			</div>
			
			<% }
		
	}
}

%>

</div>

<%@ include file="footer.jsp" %>

</body>
</html>