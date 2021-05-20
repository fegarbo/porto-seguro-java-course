<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Clientes</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Lista de Clientes</h1>
		<a href=<c:url value="/"/> class="btn btn-primary">Voltar para o menu</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>DOCUMENTO</th>
					<th>NOME</th>
					<th>EMAIL</th>
					<th>TELEFONE</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${clientes}">
					<tr>
						<td>${c.documento}</td>
						<td>${c.nome}</td>
						<td>${c.email}</td>
						<td>${c.telefone}</td>						
						<td>
							<a class="btn btn-primary" href=<c:url value="/clientes/alteracao/${c.documento}" />>Alterar</a>
							<button type="button" class="btn btn-danger remove"
								 data-id ="${c.documento}"
								 data-toggle="modal"
								 data-target="#modal">Remover</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Confirmar exclusão</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">

	        </button>
	      </div>
	      <div class="modal-body">
	        <h4>Confirma a exclusão do cliente abaixo?</h4>
	        <div id="conteudo"></div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">
	        	Não
	        </button>
	        <button type="button" id="btnRemover" class="btn btn-danger" data-dismiss="modal">
	        	Confirmar
	        </button>
	      </div>
	    </div>
	  </div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var id;
			$('.remove').click(function(){
				id = $(this).attr('data-id');
				var texto = "CPF: " + id;
				$('#conteudo').html(texto);
			});
			
			$('#btnRemover').click(function(){
				var url = "http://localhost:8080/Projeto06_GestaoVendas/clientes/remocao/" + id;
				$(location).attr('href', url);
			})
		});
		
	</script>
</body>
</html>