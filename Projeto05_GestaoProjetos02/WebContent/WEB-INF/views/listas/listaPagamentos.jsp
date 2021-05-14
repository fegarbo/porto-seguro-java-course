<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
</head>
<body>
	<div class="container">
		<h1>Lista de Pagamentos</h1>
		<h3>Prestador: ${nomePrestador}</h3>
		
		<a href=<c:url value="/"/>class="btn btn-primary">Voltar para o menu</a> |
		<a href=<c:url value="/prestadores/lista" />class="btn btn-primary">Voltar para a lista de prestadores</a>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>TIPO</th>
					<th>VALOR</th>
					<th>IMPOSTO</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${listaPagamentos}">
					<tr>
						<td>${p.id}</td>
						<td>${p.tipo}</td>
						<td><fmt:formatNumber value="${p.valor}" type="currency"/></td>
						<td><fmt:formatNumber value="${p.imposto}" type="currency"/></td>						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>