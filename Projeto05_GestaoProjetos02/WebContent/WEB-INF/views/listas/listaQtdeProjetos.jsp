<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projetos por Cliente</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Lista de Clientes e Quantidade de Projetos</h1>
		<!-- 	<button class="btn" ><i class="fa fa-home"></i>Home</button> -->
		<a href=<c:url value="/"/> class="btn btn-primary">Voltar para o menu</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>CLIENTE</th>
					<th>TELEFONE</th>
					<th>QTDE. PROJETOS</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${listaQtdeClientes}">
					<tr>
						<td>${c.cliente}</td>
						<td>${c.telefone}</td>
						<td>${c.quantidade}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>