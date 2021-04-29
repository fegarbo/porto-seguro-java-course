<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Clientes</title>

</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="cabecalho.jsp" %>
	<div class="container">
	
		<h2>Cadastro de Clientes</h2>
		<div class="row">
			<div class="col-6">
				<form action="cadastro" method="post">
					<input type="hidden" name="opcao" value="c">
				
					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" name="txtNome">					
					</div>
					<div class="form-group">
						<label>Email:</label>
						<input type="email" class="form-control" name="txtEmail">						
					</div>
					<div class="form-group">
						<label>Telefone:</label>
						<input type="text" class="form-control" name="txtTelefone">						
					</div>					
					<div class="form-group">
						<label>Usuário:</label>
						<select class="form-control" name="cmbUsuario">
							<c:forEach var="usuario" items="${usuarios}">
								<option value="">${usuario.nome} (${usuario.nivel})</option>								
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Incluir Cliente</button>
					
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