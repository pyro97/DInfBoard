<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recupero Password - SoundDiscovery</title>
<link rel="stylesheet" href="css/generic-style.css">
<link rel="stylesheet" href="css/recuperoPassword.css">
<script src="script/jquery.js"></script>
</head>
<body>

<%@include file="header.jsp" %>
<%
Boolean auth = (Boolean) session.getAttribute("auth");
if(auth!=null && auth) {
	response.sendRedirect("userArea.jsp");
}
%>

<%
String unique=request.getParameter("ID");
if(unique!=null) {
	session.setAttribute("ID", unique);
}
else {
	unique=(String) session.getAttribute("ID");
}
String Id_recupero_pass = (String) session.getAttribute("ID_recupero_Pass");
boolean flag = Id_recupero_pass.equals(unique);

if(!flag) {
	response.sendRedirect("error.jsp");
}

%>

<div id="recupero-box">

	<form id="changePasswordForm" action="ChangePasswordServlet" method="post">
	
	<div id="input-box">Inserisci nuova password : <input type="password" name="password1" id="password1" placeholder="Inserisci Password"></div><br>
	
	<div id="input-box">Conferma password : <input type="password" name="password2" id="password2" placeholder="Inserisci Password"></div><br>
	
	</form>
	
	<button id="check">Imposta nuova password</button>

	<p id="output"></p>

</div>

<% 
Boolean flag2 =(Boolean) session.getAttribute("missmatch");
if(flag2!=null && flag2) {
	%> <h2>Hai inserito delle password che non corrispondono.Riprova.</h2> <% 
}
session.removeAttribute("missmatch");
%>

<script>
$(document).ready( function() {
	$("#check").click( function() {
		
		var password1=$("#password1").val();
		var password2=$("#password2").val();
		if(!password1 || !password2) {
			$("#output").html("Hai lasciato dei campi vuoti");
		}
		else {
			$("#changePasswordForm").submit();
		}
		
	})
})
</script>

<%@include file="footer.jsp" %>

</body>
</html>