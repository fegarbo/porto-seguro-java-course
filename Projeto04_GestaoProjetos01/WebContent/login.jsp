<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/admin/api_bootstrap.jsp" %>
</head>
<body>	
	<div class="container">
		<div class="row">
			<div class="col-6">
				<form action="login" method="post">				
					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" name="txtNome">					
					</div>
					<div class="form-group">
						<label>Senha:</label>
						<input type="password" class="form-control" name="txtSenha">						
					</div>
					<button type="submit" class="btn btn-primary">Validar Usuário</button>
					
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