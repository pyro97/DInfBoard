<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.PJO.Studente"%>

    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Area - DInfBoard</title>
</head>
<body>

<%@include file="header.jsp"%>
<%

if(auth==null || !auth || utente==null ) {
	response.sendRedirect("login.jsp");
}else{
	if(utente.isIsAdmin())		response.sendRedirect("login.jsp");

}
%>   

	<div id="div-userarea">
	
		Benvenuto nell'area utente di <%=session.getAttribute("username") %>
		
		<br>
		
		<form action = "LogoutServlet">
			<button id="logout-button">Logout</button>
		</form>
		
	
	</div>

<%@include file="footer.jsp"%>

</body>
</html>