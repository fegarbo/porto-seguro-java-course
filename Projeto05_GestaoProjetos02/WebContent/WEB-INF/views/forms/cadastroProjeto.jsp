<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Cadastro de Projetos por Cliente</h1>
		<div class="row">
			<div class="col-6">
				<form action=<c:url value="/cadprojeto" /> method="post">
					<input type="hidden" name="opcao" value="c">
				
					<div class="form-group">
						<label>Descrição:</label>
						<input type="text" class="form-control" name="descricao">					
					</div>
					<div class="form-group">
						<label>Duração:</label>
						<input type="number" class="form-control" name="duracao">						
					</div>
					<div class="form-group">
						<label>Valor:</label>
						<input type="text" class="form-control" name="valor">						
					</div>					
					<div class="form-group">
						<label>Cliente:</label>
						<select class="form-control" name="idcliente">
							<c:forEach var="c" items="${listaClientes}">
								<option value="${c.id}">${c.nome}</option>								
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Incluir Projeto</button>
					
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