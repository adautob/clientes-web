<%@page import="dao.Banco"%>
<%@ page import="dao.ClienteDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Cliente"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<br>
	<div class="container">
		<div class="row">
			<div class="cold-md-7">
				<hr>
				<h3>Clientes Cadastrados</h3>
				<hr>
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Nome</th>
							<th>CPF</th>
							<th>Telefone</th>

						</tr>
					</thead>
					<tbody>
						<%
						for (Cliente cliente : Banco.clientes) {
						%>

						<tr>
							<td><%=cliente.getId()%></td>
							<td><%=cliente.getNome()%></td>
							<td><%=cliente.getEmail()%></td>
							<td><%=cliente.getTelefone()%></td>

							<td><a href="select?id=<%=cliente.getId()%>">Atualizar</a>
								| <a href="javascript: confirmar(<%=cliente.getId()%>)">Apagar</a>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<h5>
					<a href="novo.html">Adicionar Cliente</a>
				</h5>
			</div>
		</div>
	</div>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="scripts/confirmador.js"></script>
</body>
</html>