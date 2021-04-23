<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Dados do Funcionário</h1>
	
	<form action="employee" method="post">
		<label>Nome:</label><br/>
		<input type="text" name="txtNome"><br/>
		
		<label>Data de Nasc:</label><br/>
		<input type="date" name="txtDataNasc"><br/>
		
		<label>Cargo:</label><br/>
		<input type="text" name="txtCargo"><br/>
		
		<label>Salário:</label><br/>
		<input type="text" name="txtSalario"><br/>				
		
		<input type="submit" value="Enviar">
	</form>
</body>
</html>