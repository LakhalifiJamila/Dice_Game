<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<link href="${pageContext.request.contextPath}/style/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/style/signin.css"
	rel="stylesheet">
</head>
<body>
			<h1>Page d'erreur</h1>
			
			<ul>

				<c:forEach items="${requestScope.messages}" var="msg">
				
					   <li style="color: red">${msg.message}</li>

				</c:forEach>
			</ul>

</body>
</html>