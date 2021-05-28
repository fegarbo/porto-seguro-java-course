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
				<hr/>
				
				<div class="alert alert-primary">
					<strong>PAGAR ESTE PEDIDO:</strong>
					<div>						
						<div class="form-group">
							<label>Num. Cartão:</label>
							<input type="text" class="form-control" name="cartao" id="cartao">					
						</div>
						<input type="hidden" name="pedido" id="pedido" value="${pedidosVM.pedido}" />
						<input type="hidden" name="valor" id="totalPedido" value="${valorTotal}" />
						
						<button type="button" id="efetuarPagamento">Efetuar Pagamento</button>						
					</div>
					<div id="resposta"></div>
				</div>
						
			</div>
			<div class="col-6">
				<h4>Itens do Pedido</h4>
				<c:forEach var="i" items="${itensPedido}">
					<div class="alert alert-success" style="marin-top:10px;">
						<div style="float:right;">
							<a href=<c:url value="/itens/remover/${i.idItem}"/>>[X]</a>
						</div>
						<strong>DESCRIÇÃO: </strong>${i.nomeProduto}<br/>
						<strong>QTDE: </strong>${i.quantidade}<br/>
						<strong>VALOR: </strong>${i.valorTotal}
					</div>
				</c:forEach>
				<p class="text-right" >Total: ${valorTotal}</p>
			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
	<script>
		$(document).ready(function(){
			$('#efetuarPagamento').click(function(){
				$.ajax({
					dataType: 'json',
					contentType: 'application/json',
					url: 'http://localhost:8080/Projeto07_ApiPagamentos/api/pagamentos',
					method: 'POST',
					data: JSON.stringify({
						numeroPedido: $('#pedido').val(),
						numeroCartao: $('#cartao').val(),
						valor: $('#totalPedido').val(),
						status: 1
					}),
				
					success: function(resposta) {
						$('#resposta').html('Pagamento efetuado com sucesso');
					},
					error: function(erro) {
						alert('Erro: ' + erro.responseText);
					}
				});
			});
		});
	
	
	</script>
	
	
	
	
	
</body>
</html>







