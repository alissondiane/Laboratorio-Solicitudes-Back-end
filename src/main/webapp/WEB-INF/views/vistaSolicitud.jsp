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
		<h1>Input Form</h1>
		<form:form action="${empty solicitud.id?'agregarSolicitud':'modificarSolicitud'}" method="post" modelAttribute="solicitud">
			<form:hidden path="id"/>
			<table>
				<tr>
					<td>Institucion</td>
					<td>
						<form:input path="institucionNombre" /> <br />
						<form:errors path="institucionNombre" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Nombre Solicitantes</td>
					<td>
						<form:input path="solicitanteNombre" /> <br />
						<form:errors path="solicitanteNombre" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Estado</td>
					<td>
						<form:input path="estadoNombre" /> <br />
						<form:errors path="estadoNombre" cssClass="error" />
					</td>
				</tr>				
				<tr>
					<td colspan="2"><button type="submit">Submit</button></td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>