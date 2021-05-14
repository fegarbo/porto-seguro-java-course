<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Lista de Prestadores</h1>
		<a href=<c:url value="/"/> class="btn btn-primary">Voltar para o menu</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>DOCUMENTO</th>
					<th>USUARIO</th>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>TELEFONE</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${listaPrestadores}">
					<tr>
						<td>${p.documento}</td>
						<td>${p.usuario}</td>
						<td>${p.nome}</td>
						<td>${p.email}</td>						
						<td>${p.telefone}</td>
						<td>
							<a href=<c:url value="/pagamentos/lista/${p.documento}" />>Ver Pagamentos</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>