<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.bo.GameState"%>
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/back/ReinitGameServlet">Reinitialiser le jeu</a>
| <a href="${pageContext.request.contextPath}/BestScoreServlet">Consulter le meilleur score des autres joueurs</a>
| <a href="${pageContext.request.contextPath}/DeconnectServlet">Se déconnecter</a><br><br><br>

<h1>Partie terminée !</h1>

| Votre score: 
<c:out value="${sessionScope.gameState.user.actualScore}"/>
| Meilleur score:
<c:out value="${sessionScope.gameState.user.bestScore}"/>
</body>
</html>