<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="header.jsp"/>
</head>
<body>
	<div class="container">
	    <jsp:include page="cabecera.jsp"/>
		<h2>Último Pedido</h2>
		<p>Código: <span id="idCodigo"></span></p>
		<p>Mesa: <span id="idMesa"></span></p>
		<p>Hora: <span id="idHora"></span></p>
		<p>Camarero: <span id="idCamarero"></span></p>
		<table class="table" id="idTablaProductos">
			<tr>
				<th>Cantidad</th>
				<th>Producto</th>
			</tr>
			<!-- aquí se generan filas automáticamente -->
		</table>
	</div>
	<script src="${pageContext.request.contextPath}/js/ultimo-pedido.js"></script>
</body>
</html>