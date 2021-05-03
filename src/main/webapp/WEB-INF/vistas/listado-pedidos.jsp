<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="header.jsp"/>
</head>
<body>
	<div class="container">
	    <jsp:include page="cabecera.jsp"/>
		<h2>Listado de Pedidos</h2>
		<table class="table">
			<tr>
				<th>Código</th>
				<th>Fecha</th>
				<th>Hora</th>
				<th>Mesa</th>
				<th>Camarero</th>
			</tr>
			<c:forEach var="pedido" items="${pedidos}">
			<tr>
				<td>${pedido.id}</td>
				<td><fmt:formatDate value="${pedido.fecha}" pattern="dd/MM/yyyy" /></td>
				<td><fmt:formatDate value="${pedido.fecha}" pattern="HH:mm" /></td> 
				<td>${pedido.mesa}</td>
				<td>${pedido.camarero.nombre}</td>
			</tr>
			</c:forEach>
		</table>
	</div>	
</body>
</html>