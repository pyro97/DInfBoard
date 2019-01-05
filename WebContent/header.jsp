<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.PJO.Studente"%>
     <%
Boolean auth = (Boolean) session.getAttribute("auth");
Studente utente= (Studente) session.getAttribute("utente");

%> 
<head>
<link rel="stylesheet" type="text/css" media="screen" href="css/header.css"/>
</head>

<header>
	<div id="logo">
		<a href="index.jsp"><img src="img/header/logo6.png"></a>
	</div>

	<div id="header_central">

		<form action="BachecaServlet">
			<button id="bachecaButton">Bacheca</button>
		</form>
		
		<form action="inserisciAnnuncio.jsp">
			<button id="inserisciAnnuncio">Inserisci Annuncio</button>
		</form>
	</div>

	<div id="header_right">
		<%if(auth==null || !auth || utente==null) {%>
		
		<a href="login.jsp"><img src="img/header/user5.png"></a>
		<%}else{ 
			if(utente.isIsAdmin()){%>
			<a href="adminArea.jsp"><img src="img/header/user5.png"></a>
				
			
			<% }else{%>
			<a href="userArea.jsp"><img src="img/header/user5.png"></a>
				
				
			<%}
		}
		%>
		
	</div>

</header>