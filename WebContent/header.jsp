<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
		<a href="userArea.jsp"><img src="img/header/user4.svg"></a>
		<%
		Boolean authForName=(Boolean) session.getAttribute("auth");
		if(authForName!=null && authForName) {
			session.getAttribute("username");
		}
		%>
	</div>

</header>