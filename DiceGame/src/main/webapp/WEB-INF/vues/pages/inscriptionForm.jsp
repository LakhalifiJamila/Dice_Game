<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Dice Game</title>
</head>
<body>

	<div>
		<form method="post" action="${pageContext.request.contextPath}/UserManagementServlet">
			<fieldset>
				<legend>Inscription Formula</legend>
				<p>Entrer vos informations:</p>


				<label for="nom">nom<span>*</span></label> 
				<input type="text" id="nom" name="nom" value="" size="20" maxlength="60" /><br />

				<label for="prenom">prénom<span>*</span></label> 
				<input type="text" id="prenom" name="prenom" value="" size="20" maxlength="60" required/> <br /> 
				<label for="motdepasse">Mot de passe <span >*</span></label>
				<input type="password" id="motdepasse" name="password" value="" size="20" maxlength="20" required/><br /> 
				<label for="nom">Login<span>*</span></label> 
				<input type="text" id="nom" name=login value="" size="20" maxlength="20" required/> <br />
				<input type="submit" value="Inscription" class="btn-primary" /> <br />

			</fieldset>
		</form>
	</div>
</body>

</html>