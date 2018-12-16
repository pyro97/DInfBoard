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
		<a href="account.html"><img src="img/header/userIcon.png"></a>
	</div>

</header>