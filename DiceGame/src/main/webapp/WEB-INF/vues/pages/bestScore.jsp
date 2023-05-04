<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Best score</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/back/ReinitGameServlet">Reinitialiser le jeu</a>
| <a href="${pageContext.request.contextPath}/DeconnectServlet">Se déconnecter</a><br><br><br>

<h1>Votre meilleur score:</h1>
<c:out value="${sessionScope.gameState.user.bestScore}"/>

<h1>Le meilleur score des autres joueurs</h1>
<table>

	<c:forEach items="${requestScope.users}" var="user">
		
		<tr>
			<td><h3>${user.login}: </h3></td>
			<td>${user.bestScore}</td>
		</tr>
	
	</c:forEach>
</table>

</body>
</html>