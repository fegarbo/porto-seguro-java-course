<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
</head>
<body>
	<div class="container">
		<h1>Lista de Produtos</h1>
		<a href=<c:url value="/"/> class="btn btn-primary">Voltar para o menu</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>DESCRICAO</th>
					<th>UNIDADE</th>
					<th>PREÇO</th>
					<th>IMAGEM</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${produtos}">
					<tr>
						<td>${p.descricao}</td>
						<td>${p.unidade}</td>
						<td><fmt:formatNumber value="${p.preco}" type="currency" /></td>
						<td><img src=<c:url value="/imagem/${p.id}" /> width="75" /></td>						
						<td>
							<a class="btn btn-primary" href=<c:url value="/clientes/alteracao/${c.documento}" />>Alterar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>