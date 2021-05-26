<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Itens</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
</head>
<body>
	<div class="container">
		<a href=<c:url value="/"/>>Voltar para o menu</a>
		<div class="row">
<!-- 		Dados do cliente -->
			<div class="col-6">
				<h2>Gestão de Itens de Produtos</h2>
				<div class="alert alert-primary">
					<strong>CPF: </strong>${pedidosVM.documento}<br/>
					<strong>Cliente: </strong>${pedidosVM.cliente}<br/>
					<strong>Nº Pedido: </strong>${pedidosVM.pedido}
				</div>
<!-- 			inclusao de itens -->				
				<form action=<c:url value="/caditem"/> method="post">
					<input type="hidden" name="idPedido" value="${pedidosVM.idPedido}" />
					<div class="form-group">
						<label>Selecione o produto:</label>
						<select class="form-control" name="idProduto">
							<c:forEach var="p" items="${produtos}">
								<option value="${p.id}">${p.descricao}</option>													
							</c:forEach>						
						</select>					
					</div>
					<div class="form-group">
						<label>Quantidade:</label>
						<input type="text" class="form-control" name="quantidade">					
					</div>
					<button type="submit" class="btn btn-primary">Incluir Item</button>							
				</form>				
			</div>
			<div class="col-6">
				<h4>Itens do Pedido</h4>
				<c:forEach var="i" items="${itensPedido}">
					<div class="alert alert-success">
						<strong>DESCRIÇÃO: </strong>${i.nomeProduto}<br/>
						<strong>QTDE: </strong>${i.quantidade}<br/>
						<strong>VALOR: </strong>${i.valorTotal}
					</div>
				</c:forEach>
				<p class="text-right" >Total: ${valorTotal}</p>
				
				
				
<!-- 				<table class="table table-striped"> -->
<!-- 					<thead> -->
<!-- 						<tr> -->
<!-- 							<th>DESCRIÇÃO</th> -->
<!-- 							<th>QTDE</th> -->
<!-- 							<th>VALOR</th> -->
<!-- 						</tr> -->
<!-- 					</thead> -->
<!-- 					<tbody> -->
<%-- 						<c:forEach var="i" items="${itensPedido}"> --%>
<!-- 							<tr> -->
<%-- 								<td>${i.nomeProduto}</td> --%>
<%-- 								<td>${i.quantidade}</td>								 --%>
<%-- 								<td>${i.valorTotal}</td> --%>
<!-- 							</tr> -->
<%-- 						</c:forEach> --%>
<!-- 					</tbody> -->
<!-- 					<tfoot align="right"> -->
<!-- 						<tr> -->
<!-- 							<td>TOTAL: </td> -->
<!-- 							<td>R$ 100</td> -->
<!-- 						</tr> -->
<!-- 					</tfoot>					 -->
<!-- 				</table> -->
			</div>
		</div>
	</div>
</body>
</html>







