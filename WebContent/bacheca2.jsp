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
		
		if(bacheca.get(i).getIsVisible()) {
			int width=100/bacheca.size();
			width=width-(2*bacheca.size());
		%> <div class="class_annunci" style="width : <%=width%>%">
				<%=bacheca.get(i).getTitolo() %><br> 
				<img src="<%=bacheca.get(i).getPathImmagine()%>"> <br> 
				<a href="annuncio.jsp?ID=<%=bacheca.get(i).getID()%>">Vai all'annuncio</a>
			</div>
			
			<% }
		
		}
	}

	%>

	</div>

</body>

<%@ include file="footer.jsp" %>

</html>