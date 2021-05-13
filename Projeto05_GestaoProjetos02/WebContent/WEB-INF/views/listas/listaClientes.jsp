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
		<!-- 	<button class="btn" ><i class="fa fa-home"></i>Home</button> -->
		<a href=<c:url value="/" /> class="btn btn-primary">Voltar para o menu</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>TELEFONE</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${listaClientes}">
					<tr>
						<td>${c.id}</td>
						<td>${c.nome}</td>
						<td>${c.telefone}</td>
						<td>${c.email}</td>
						<td>
							<a href=<c:url value="/projetos/lista/${c.id}" />>Ver Projetos</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>