<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Clientes</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Lista de Clientes</h1>
		<a href=<c:url value="/"/> class="btn btn-primary">Voltar para o menu</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>DOCUMENTO</th>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>TELEFONE</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${clientes}">
					<tr>
						<td>${c.documento}</td>
						<td>${c.nome}</td>
						<td>${c.telefone}</td>
						<td>${c.email}</td>
						<td>
							<a href=<c:url value="/clientes/alteracao/${c.documento}" />class="btn btn-primary">Alterar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>