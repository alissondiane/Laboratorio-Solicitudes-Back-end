<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring5 MVC  Demo</title>
		<style type="text/css">
			.error {
				color: red;
			}
			table {
				width: 50%;
				border-collapse: collapse;
				border-spacing: 0px;
			}
			table td {
				border: 1px solid #565454;
				padding: 20px;
			}
		</style>
	</head>
	<body>
		<h2>Lista de Solicitudes</h2>
		<a href="vistaSolicitud"> Agregar</a>
		<table>
			<tr>
				<td><strong>Id</strong></td>
				<td><strong>Institución</strong></td>
				<td><strong>Solicitante</strong></td>
				<td><strong>Estado</strong></td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach items="${solicitudes}" var="solicitud">
				<tr>
					<td>${solicitud.id}</td>
					<td>${solicitud.institucionNombre}</td>
					<td>${solicitud.solicitanteNombre}</td>
					<td>${solicitud.estadoNombre}</td>
					<td><a href="vistaSolicitud?id=${solicitud.id}"> Editar</a></td>
					<td><a href="eliminarSolicitud/${solicitud.id}"> Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>