<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JEE_ECP Temas</title>
</head>
	<body>
		<h1>Temas</h1>
		<ul>
			<c:forEach var="tema" items="${temas.getTemas()}">
				<li>${tema.name} >> ${tema.question}
					<form action="deletetema" method="post" style="display:inline">
						<input type="hidden" name="temaid" value="${tema.id}" />
						(<label for="submit-${tema.id}" style="cursor:pointer">Delete</label>)
						<input id="submit-${tema.id}" type="submit" value="Submit" style="display:none">
					</form>
					(<a href="showvotos?temaid=${tema.id}">Ver votaciones</a>)
					(<a href="votar?temaid=${tema.id}">Votar</a>)
				</li>
			</c:forEach>
		</ul>
		<a href="/JEE_ECP/views/">Volver</a> |
		<a href="newtema"> + Añadir nuevo Tema</a>
	</body>
	
</html>