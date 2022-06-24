<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>

<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("funcionarios");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Funcionarios</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="imagens/favicon.png">

</head>
<body>
	<div class="recupera">
	<h1>Cadastro de Funcionarios</h1>
	<a href="novo.html" class="Botao2">Novo</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Telefone</th>
				<th>Email</th>
				<th>    </th>
			</tr>
		</thead>
		<tbody class="tbody">
			<%for (int i = 0; i < lista.size(); i++) {%>
				<tr>
										
					<td><%out.println( lista.get(i).getIdfunc()); %></td>
					<td><%out.println( lista.get(i).getNome()); %></td>
					<td><%out.println( lista.get(i).getCpf()); %></td>
					<td><%out.println( lista.get(i).getTelefone()); %></td>
					<td><%out.println( lista.get(i).getEmail()); %></td>
					
					<td><a href="javascript:confirmarExclusao(<%=lista.get(i).getIdfunc() %>)" class="Botao3">Excluir</a></td>
				
				
				
				</tr>
				
			<%} %>
		
		
		</tbody>
	</table>
</div>
<script src="scripts/validador.js"></script>
</body>
</html>