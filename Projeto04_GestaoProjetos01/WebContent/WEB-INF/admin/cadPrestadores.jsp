<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuários</title>

</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="cabecalho.jsp" %>
	<div class="container">
	
		<h2>Cadastro de Prestadores</h2>		
		<div class="row">
			<div class="col-6">
				<form action="cadastro" method="post">
					<input type="hidden" name="opcao" value="p">
					
<!-- 					<div class="form-check">
					  	<input class="form-check-input" type="radio" name="optCpf" id="cpfOption" value="option1" checked>
					  	<label class="form-check-label" for="cpfOption">
					    	CPF
					  	</label>
					</div>
					<div class="form-check">
					  	<input class="form-check-input" type="radio" name="optCnpj" id="cnpjOption" value="option2">
					  	<label class="form-check-label" for="cnpjOption">
					    	CNPJ
						</label>
					</div>	 -->
					
					<div class="btn-group btn-group-toggle" data-toggle="buttons">
					  	<label class="btn btn-secondary">
					    	<input type="radio" name="optionDoc" id="docCpf" checked> CPF
					  	</label>
					  	<label class="btn btn-secondary">
					    	<input type="radio" name="optionDoc" id="docCnpj"> CNPJ
					  	</label>
					</div>																	
					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" name="txtNome">					
					</div>
					<div class="form-group">
						<label>Email:</label>
						<input type="text" class="form-control" name="txtEmail">					
					</div>
					<div class="form-group">
						<label>Telefone:</label>
						<input type="text" class="form-control" name="txtTelefone">					
					</div>
					<div class="form-group">
						<label>Documento:</label>
						<input type="text" class="form-control" name="txtDocumento">					
					</div>
					<div class="form-group">
						<label>Senha:</label>
						<input type="password" class="form-control" name="txtSenha">						
					</div>					
					<button type="submit" class="btn btn-primary">Incluir Prestador</button>
					
				</form>
			</div>
		</div>
		
	</div>	
</body>
</html>