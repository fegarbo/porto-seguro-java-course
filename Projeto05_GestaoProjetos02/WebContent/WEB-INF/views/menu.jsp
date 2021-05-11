<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu de Opções</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="api_bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h1>Menu de Opções</h1>
		<ul>
			<li>
				<a href=<c:url value="/cliente/lista" />>Lista de Clientes</a>
			</li>
		</ul>
	</div>
</body>
</html>