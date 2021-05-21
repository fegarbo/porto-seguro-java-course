<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Pedidos</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Cadastro de Pedidos por Cliente</h1>
		
		<a href=<c:url value="/"/>>Voltar para o menu</a>
		
		<div class="row">
			<div class="col-6">
				<form action=<c:url value="/cadpedido" /> method="post">	
					<div class="form-group">
						<label>Número do pedido:</label>
						<input type="text" class="form-control" name="numeroPedido">					
					</div>				
					<div class="form-group">
						<label>Cliente:</label>
						<select class="form-control" name="documentoCliente">
							<c:forEach var="c" items="${clientes}">
								<option value="${c.documento}">${c.nome}</option>								
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Incluir Pedido</button>
					
					<c:if test="${resultado ne null}">					
						<div class="alert alert-success" role="alert" style="margin-top:10px;">
						  ${resultado}
						</div>
					</c:if>
				</form>
			</div>
		</div>
	</div>
</body>
</html>