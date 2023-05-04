<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.bo.GameState"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="${pageContext.request.contextPath}/style/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/style/signin.css"
	rel="stylesheet">
</head>

<body>
		<h1>Bonjour 
		<c:out value="${sessionScope.gameState.user.firstName}"/></h1><br>
		
		<a href="${pageContext.request.contextPath}/BestScoreServlet">Consulter le meilleur score des autres joueurs</a>
		| <a href="${pageContext.request.contextPath}/back/ReinitGameServlet">Reinitialiser le jeu</a>
		| <a href="${pageContext.request.contextPath}/DeconnectServlet">Se deconnecter</a><br><br><br>
		
		<h6>Entrer le numéro du dé à lancer puis cliquer sur le bouton</h6>
		<form method="post" action="${pageContext.request.contextPath}/back/GameServlet">
			<label for="numDe">Numéro du dé</label> 
			<input type="number" id="numDe" name="numDe" placeHolder="1,2,3"><br>
			
			<input type="submit" value="Lancer le dé">
		</form>
		
		<%
			GameState gameState = (GameState) request.getSession().getAttribute("gameState");
			if(gameState!=null){
					out.println(gameState);
			}
		%>
		
</body>
</html>