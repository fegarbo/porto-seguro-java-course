<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<c:set var="nome_pessoa" value="${param.nome}"></c:set>
	
	<c:choose>
		<c:when test="${nome_pessoa ne null}">
			<h1><c:out value="Exemplos de JSTL"></c:out></h1><br/>
			<h2><c:out value="${nome_pessoa}" /></h2>
		</c:when>
		<c:otherwise>
			<h2><c:out value="Nenhum valor informado para o nome" /></h2>
		</c:otherwise>
	</c:choose>
	
<%-- 	<c:if test="${nome_pessoa ne null}">  <!--ne = not equals / eq = equals  --> --%>
<%-- 		<h1><c:out value="Exemplos de JSTL"></c:out></h1><br/> --%>
<%-- 		<h2><c:out value="${nome_pessoa}" /></h2> --%>
<%-- 	</c:if> --%>
</body>
</html>