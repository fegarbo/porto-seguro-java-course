<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<label>Usuário:</label><br/>
		<input type="text" name="txtUsuario"><br/>
		
		<label>Senha:</label><br/>
		<input type="password" name="txtSenha"><br/>
		
		<input type="submit" value="Enviar">
	</form>
</body>
</html>