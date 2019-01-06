<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/generic-style.css">
<link rel="stylesheet" href="css/forgottedPassword.css">
<script src="script/jquery.js"></script>
<title>Password Dimenticata - SoundDiscovery</title>
</head>
<body>

<%@include file="header.jsp" %>
<h2 class=title>Recupero Password</h2>

<div id="recupero-box">

Da qui ti sarà possibile recuperare la password del tuo account.

<form id="emailForm" action="EmailSenderServlet" method="post">

<div id="input-box">Inserisci l'email dell'account che vuoi recuperare : 

<input type="email" name="email"></div> <br>

<br>

<p id="output"></p>

</form>


<button id="check">Recupera</button>

</div>


<%
Boolean badEmail=(Boolean) request.getSession().getAttribute("badEmail");
if(badEmail!=null && badEmail) {
	%> <h2>Hai inserito una email non presente nei nostri sistemi, non è possibile recuperare la password</h2> <% 
}
request.getSession().removeAttribute("badEmail");
%>

<%@include file="footer.jsp" %>

<script>

$(document).ready( function() {
	
	$("#check").click( function() {
		var flag=false;
		$("input[type=email]").each( function() {
			var input=$(this).val();
			console.log(input);
			if(!input) {
				$("#output").html("Hai mancato dei campi");
				$(this).css("border-color","red");
				flag=true;
			}
		})
		
		if(!flag) {
			$("#emailForm").submit();
		}
	})
})

</script>

</body>
</html>