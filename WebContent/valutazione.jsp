<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Valutazione</title>
</head>
<body>
 
 
<%@include file="header.jsp"%>

<%

Boolean auth = (Boolean) session.getAttribute("auth");
Studente s = (Studente) session.getAttribute("utente");

if(auth==null || !auth) {
	response.sendRedirect("login.jsp");
}

String utenteDaValutare=request.getParameter("username");
session.setAttribute("utenteDaValutare",utenteDaValutare);
%>



<div id="div-valuta">
	
		<form action="ValutazioneServlet" method=get>
					<p>Selezione la tua valutazione da 0 a 5 da dare all'utente <%=utenteDaValutare%>.</p>
	
			<input type="radio" name="valutazione" value="0" checked> 0<br>
		  	<input type="radio" name="valutazione" value="1"> 1<br>
		  	<input type="radio" name="valutazione" value="2"> 2<br>
		  	<input type="radio" name="valutazione" value="3"> 3<br>
		  	<input type="radio" name="valutazione" value="4"> 4<br>
		  	<input type="radio" name="valutazione" value="5"> 5<br>
			
			<button id="submitValutazione">Valuta</button>
			
		</form>
	
	
	</div>
 <%@include file="footer.jsp"%>
</body>
</html>
