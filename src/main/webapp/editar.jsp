<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Cliente - Editar</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h3>Editar cliente</h3>
	<div class="container">
		<form name="frmCliente" action="update">
			<table>
				<tr>
					<td><input type="text" name="id" id="caixa3" readonly
						value="<%out.print(request.getAttribute("id"));%>"></td>
				</tr>
				<tr>
					<td><input type="text" name="nome" class="Caixa1" required
						value="<%out.print(request.getAttribute("nome"));%>"></td>
				</tr>
				<tr>
					<td><input type="text" name="email" class="Caixa2" required
						value="<%out.print(request.getAttribute("email"));%>"></td>
				</tr>
				<tr>
					<td><input type="text" name="telefone" class="Caixa1" id="fone"
						value="<%out.print(request.getAttribute("telefone"));%>"></td>
				</tr>
			</table>
			<input type="submit" value="Salvar" class="Botao1">
		</form>
		<script src="https://unpkg.com/imask"></script>
		<script>
			var element = document.getElementById('fone');
			var maskOptions = {
				mask : '(00) 00000-0000'
			};
			var mask = IMask(element, maskOptions);
		</script>
	</div>
</body>
</html>