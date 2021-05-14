<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Cadastro de Pagamentos por Prestador</h1>
		<div class="row">
			<div class="col-6">
				<form action=<c:url value="/cadpagamento" /> method="post">
					<input type="hidden" name="opcao" value="c">
				
<!-- 					<div class="form-group"> -->
<!-- 						<label>Tipo:</label> -->
<!-- 						<input type="text" class="form-control" name="tipo">					 -->
<!-- 					</div> -->
					
					<div class="form-group">
						<label>Tipo:</label>
						<select class="form-control" name="tipo">
							<c:forEach var="t" items="${enumTipo}">
								<option value="${t.valor}">${t}</option>								
							</c:forEach>
						</select>
					</div>					
					
					
															
					<div class="form-group">
						<label>Valor:</label>
						<input type="number" class="form-control" name="valor">						
					</div>
					<div class="form-group">
						<label>Imposto:</label>
						<input type="text" class="form-control" name="imposto">						
					</div>					
					<div class="form-group">
						<label>Prestador:</label>
						<select class="form-control" name="documentoPrest">
							<c:forEach var="p" items="${listaPrestadores}">
								<option value="${p.documento}">${p.nome}</option>								
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Incluir Pagamento</button>
					
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