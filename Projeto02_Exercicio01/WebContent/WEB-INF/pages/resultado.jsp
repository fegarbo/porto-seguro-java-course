<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funcionário</title>
</head>
<body>
	<h1>Dados do Funcionário</h1><br/>
	<h2>${func.nome}</h2>
	<h2>${func.dataNascimento}</h2>
	<h2>${func.cargo}</h2>
	<h2>${func.salario}</h2>
	<h2>${func.irpf}</h2>
	<h2>${func.salarioLiquido}</h2>
	<a href="employee">Voltar</a>			
</body>
</html>