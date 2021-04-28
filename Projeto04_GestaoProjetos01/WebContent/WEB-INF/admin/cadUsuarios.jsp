<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ include file="cabecalho.jsp" %>
	<div class="container">
	
		<h2>Cadastro de Usuários</h2>
		<div class="row">
			<div class="col-6">
				<form action="cadastro" method="post">
					<input type="hidden" name="opcao" value="u">
				
					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" name="txtNome">					
					</div>
					<div class="form-group">
						<label>Senha:</label>
						<input type="password" class="form-control" name="txtSenha">						
					</div>
					<div class="form-group">
						<label>Nível:</label>
						<select class="form-control" name="cmbNivel">
							<option value="ADM">Administrador</option>
							<option value="CLIENTE">Cliente</option>
							<option value="PREST">Prestador</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Incluir Usuário</button>
					
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