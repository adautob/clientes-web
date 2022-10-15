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
	rel="stylesheet">
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
							<th>Email</th>
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

							<td><a class="btn btn-outline-primary btn-sm" href="select?id=<%=cliente.getId()%>">Atualizar</a>
								<a class="btn btn-outline-secondary btn-sm" href="javascript: confirmar(<%=cliente.getId()%>)">Apagar</a>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<h5>
					<a class="btn btn-primary btn-sm" href="novo.html">Adicionar Cliente</a>
				</h5>
			</div>
		</div>
	</div>
	<!-- JavaScript Bundle with Popper -->
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="scripts/confirmador.js"></script>
</body>
</html>