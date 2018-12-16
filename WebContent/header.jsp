<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
<link rel="stylesheet" type="text/css" media="screen" href="css/header.css"/>
</head>

<header>
	<div id="logo">
		<img src="img/header/logo6.png">
	</div>

	<div id="header_central">

		<form action="BachecaServlet">
			<button id="bachecaButton" text="Bacheca">Bacheca</button>
		</form>
		
		<button id="inserisciAnnuncioButton"><a href="inserisciAnnuncio.jsp">Inserisci Annuncio</a></button>
	</div>

	<div id="header_right">
		<a href="userArea.jsp"><img src="img/header/userIcon.png"></a>
		<%
		Boolean authForName=(Boolean) session.getAttribute("auth");
		if(authForName!=null && authForName) {
			session.getAttribute("username");
		}
		%>
	</div>

</header>