<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Pedidos</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
						<select class="form-control" name="documentoCliente" id="documento">
							<option value="0">--- Selecione o Cliente ---</option>
							<c:forEach var="c" items="${clientes}">
								<c:choose>
									<c:when test="${ndoc eq c.documento }">
										<option value="${c.documento}" selected>${c.nome}</option>
									</c:when>
									<c:otherwise>
										<option value="${c.documento}">${c.nome}</option>
									</c:otherwise>
								</c:choose>
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
		<div style="margin-top:20px;">
			<c:choose>
				<c:when test="${pedidos eq null}">
					<div class="alert alert-warning text-center">
						${mensagem}
					</div>
				</c:when>
				<c:otherwise>
					<h3>Pedidos deste cliente</h3>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>PEDIDO</th>
								<th>DATA</th>
								<th>CLIENTE</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${pedidos}">
								<tr>
									<td>${p.pedido}</td>
									<td><fmt:formatDate value="${p.data}" pattern="dd/MM/yyyy"/></td>
									<td>${p.cliente}</td>
									<td><a href=<c:url value="/itens/gestao?idpedido=${p.idPedido}" />>Gestão de Itens</a></td>
								</tr>
							</c:forEach>			
						</tbody>				
					</table>					
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
	<script>
		$(document).ready(function(){
			$('#documento').change(function(){
				let doc = $(this).val();
				let url ='http://localhost:8080/Projeto06_GestaoVendas/pedidos/cadastro';
				
				if(doc != '0'){
					url += '?doc=' + doc;					
				}
				$(location).attr('href',  url);
			});
		});
		
	</script>
</body>
</html>







