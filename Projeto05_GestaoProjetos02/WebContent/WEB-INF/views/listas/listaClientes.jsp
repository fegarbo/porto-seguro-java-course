<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Lista de Clientes</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>TELEFONE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${listaClientes}">
					<tr>
						<td>${c.id}</td>
						<td>${c.nome}</td>
						<td>${c.telefone}</td>
						<td>${c.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>