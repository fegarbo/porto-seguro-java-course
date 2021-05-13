<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Lista de Projetos</h1>
		<h3>Cliente: ${nomeCliente}</h3>
		
		<a href=<c:url value="/" />class="btn btn-primary">Voltar para o menu</a> |
		<a href=<c:url value="/clientes/lista" />class="btn btn-primary">Voltar para a lista de clientes</a>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>DESCRIÇÃO</th>
					<th>DURAÇÃO</th>
					<th>VALOR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${listaProjetos}">
					<tr>
						<td>${p.id}</td>
						<td>${p.descricao}</td>
						<td>${p.duracao}</td>
						<td>${p.valor}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>