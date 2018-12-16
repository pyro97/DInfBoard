<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Boolean auth = (Boolean) session.getAttribute("auth");
if(auth==null || !auth) {
	response.sendRedirect("login.jsp");
}
%>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User Area - DInfBoard</title>
</head>
<body>

	<div id="div-userarea">
	
		Benvenuto nell'area utente di <%=session.getAttribute("username") %>
	
	</div>

</body>
</html>