<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ include file="api_bootstrap.jsp" %>

</head>
<body>
	<div class="container">
		<h1>Essa página ilustra o uso do bootstrap</h1>
		
		<div class="row">
			<div class="col-6 bg-light">
				<form>
					<div class="form-group">
						<label>Nome:</label>
						<input type="text" class="form-control" name="txtNome">					
					</div>
					<div class="form-group">
						<label>Data Nascimento:</label>
						<input type="date" class="form-control" name="txtDataNasc">						
					</div>
					<div class="form-group">
						<label>Cargo:</label>
						<input type="text" class="form-control" name="txtCargo">						
					</div>
					<div class="form-group">
						<label>Salário:</label>
						<input type="text" class="form-control" name="txtSalario">						
					</div>
					<button type="submit" class="btn btn-primary">Enviar</button>												
				</form>
			</div>
		</div>
	</div>	
</body>
</html>