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



<%@ include file="header.jsp" %>

<%


if(auth==null || !auth || utente==null ) {
	response.sendRedirect("login.jsp");
}else{
	if(utente.isIsAdmin())		response.sendRedirect("login.jsp");

}
  

StudenteDao dao = new StudenteDao();
String user = (String) request.getParameter("username");
Studente s = dao.get(user);
dao.close();
%>
<div id="userDiv">

<h2>Valutazione</h2><%=s.getValutazione()%> <br>

<h2>Username</h2> <%=s.getUsername()%> <br>

<h2>Nome</h2> <%=s.getNome() %> <br>

<h2>Cognome</h2> <%=s.getCognome() %> <br>

</div>

<%@ include file="footer.jsp" %>

</body>
</html>