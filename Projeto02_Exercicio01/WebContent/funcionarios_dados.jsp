<%@page import="br.com.portoseguro.classes.Funcionario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getMethod().equals("GET")){
	%>

	<h1>Dados do Funcionário - JSP</h1>
	
	<form action="" method="post">
		<label>Nome:</label><br/>
		<input type="text" name="txtNome"><br/>
		
		<label>Data de Nasc:</label><br/>
		<input type="date" name="txtDataNasc"><br/>
		
		<label>Cargo:</label><br/>
		<input type="text" name="txtCargo"><br/>
		
		<label>Salário:</label><br/>
		<input type="text" name="txtSalario"><br/>				
		
		<input type="submit" value="Enviar">
	</form>
	
	<% }else{
			String nome = request.getParameter("txtNome");
			String data = request.getParameter("txtDataNasc");
			
			Date dataNasc = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			String cargo = request.getParameter("txtCargo");
			double salario = Double.parseDouble(request.getParameter("txtSalario"));
			
			Funcionario f = new Funcionario(nome, dataNasc, cargo, salario);
			//Apresentando os dados do funcionario
			out.print("<h1>Dados do funcionário - JSP</h1>");
	 %>	 
	 		<ul>
	 			<li><strong>Nome:</strong><%= nome %></li>
	 			<li><strong>Data Nasc:</strong><%= dataNasc %></li>
	 			<li><strong>Cargo:</strong><%= cargo %></li>
	 			<li><strong>Salário:</strong><%= salario %></li>
	 			<li><strong>IRPF:</strong><%= f.getIrpf() %></li>
	 			<li><strong>Salário Líquido:</strong><%= f.getSalarioLiquido() %></li>	 		
	 		</ul>	 
	<% } %>
</body>
</html>