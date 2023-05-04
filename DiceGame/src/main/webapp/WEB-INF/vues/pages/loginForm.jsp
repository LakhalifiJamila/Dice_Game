<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.bo.Message"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Dice Game</title>
</head>
<body>
	<div class="container">
		<form method="POST" action="${pageContext.request.contextPath}/LoginServlet">
			<div>
				<a href="${pageContext.request.contextPath}/UserManagementServlet?inscription">Nouveau compte</a>
			</div>
			
			<h2 class="form-signin-heading">Connexion</h2>
			
			<label for="inputName">Login</label><br>
			<input type="text" placeholder="Nom d'utilisateur" required autofocus name="login" id="inputName"><br>
			
			<label for="inputPassword">Mot de passe</label><br> 
			<input type="password" id="inputPassword" placeholder="Password" name="password" required><br>

			<button type="submit">Sign in</button>
			
		</form>
		
		<div>
			<!--boucle en jstl messages -->
			<ul>

				<c:forEach items="${requestScope.messages}" var="msg">
				
					<c:choose>
					  <c:when test="${msg.type == Message.WARN}">
					   <li style="color: orange">${msg.message}</li>
					  </c:when>
					  <c:when test="${msg.type == Message.INFO}">
					   <li style="color: green">${msg.message}</li>
					  </c:when>
					   <c:when test="${msg.type == Message.ERROR}">
					   <li style="color: red">${msg.message}</li>
					  </c:when>
					  <c:otherwise>
					  <li>MESSAGE ${msg.message}</li>
					  </c:otherwise>
					</c:choose>

				</c:forEach>
			</ul>
			
		</div>

	</div>
</body>
</html>


