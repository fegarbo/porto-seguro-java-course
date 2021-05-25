<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Produtos</title>
<%@ include file="/WEB-INF/views/api_bootstrap.jsp"%>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Cadastro de Produtos</h1>
				<form:form action="/Projeto06_GestaoVendas/cadproduto" 
					modelAttribute="produto" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<form:label path="descricao">Descrição:</form:label>
						<form:input path="descricao" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<form:label path="unidade">Unidade:</form:label>
						<form:input path="unidade" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<form:label path="preco">Preço:</form:label>
						<form:input path="preco" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<form:label path="categoria">Categoria:</form:label>
						<form:select path="categoria" cssClass="form-control">
							<form:option value="0">--SELECIONE--</form:option>
							<form:options items="${categorias}" itemValue="id" itemLabel="descricao"/>							
						</form:select>						
					</div>
					<!--Imagem -->
					<div class="form-group">
						<label>Imagem:</label>
						<input type="file" name="foto" class="form-control" /> 
					</div>					
					<button type="submit" class="btn btn-primary">Incluir Produto</button>											
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>