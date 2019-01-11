<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.PJO.Studente, model.DAO.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User - DInfBoard</title>
<link rel="stylesheet" href="css/user.css">
</head>
<body>

<%
Boolean auth = (Boolean) session.getAttribute("auth");
if(auth==null || !auth)
	response.sendRedirect("login.jsp");

StudenteDao dao = new StudenteDao();
String user = (String) request.getParameter("username");
Studente s = dao.get(user);
dao.close();
%>

<%@ include file="header.jsp" %>

<div id="userDiv">

<h2>Valutazione</h2><%=s.getValutazione()%> <br>

<h2>Username</h2> <%=s.getUsername()%> <br>

<h2>Nome</h2> <%=s.getNome() %> <br>

<h2>Cognome</h2> <%=s.getCognome() %> <br>

</div>

<%@ include file="footer.jsp" %>

</body>
</html>