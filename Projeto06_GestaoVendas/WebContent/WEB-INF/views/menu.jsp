<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu de Op��es</title>
<%@ include file="api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Menu de Op��es</h1>
		<ul>
			<li>
				<a href=<c:url value="/clientes/cadastro" />>Cadastro de Clientes</a>
			</li>
			<li>
				<a href=<c:url value="/clientes/lista" />>Lista de Clientes</a>
			</li>							
		</ul>
	</div>
</body>
</html>