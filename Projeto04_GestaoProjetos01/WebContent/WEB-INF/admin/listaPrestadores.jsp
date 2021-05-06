<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Prestadores</title>

</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="cabecalho.jsp" %>
	<div class="container">
		<h2>Lista de Prestadores</h2>
		<div style="margin: 5px;">
			<a class="btn btn-primary" href="cadastro?opcao=p">
				Novo Prestador
			</a>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>DOCUMENTO</th>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>TELEFONE</th>
				</tr>			
			</thead>
			<tbody>
				<c:forEach var="cliente" items="${listaPrestadores}">
					<tr>
						<td>${prestador.documento}</td>
						<td>${prestador.nome}</td>
						<td>${cliente.email}</td>
						<td>${cliente.telefone}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	</div>	
</body>
</html>