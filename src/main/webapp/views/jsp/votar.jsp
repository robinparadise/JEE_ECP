<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Votaciones</title>
</head>
<body>
	<c:set var="votoView" scope="request" value="${votar}"/>
	
	<form action="votar" method="post">
		<p>${votoView.getTema().toString()}</p>
		
		<input type="hidden" name="temaid" value="${votoView.tema.getId()}"/>
		<p>Nivel de estudios:
			<select name="nivel_estudios">
				<option disabled selected>--- Elige ---</option>
				<c:forEach var="estudio" items="${votoView.getNivelesEstudios()}">
					<option>${estudio}</option>
				</c:forEach>
			</select>
		</p>
		<p>Puntuación:
			<input type="number" min="0" max="9" step="1" placeholder="0-9" name="valoracion"/>
		</p>
		<input type="submit" value="Votar" />
	</form>
	<a href="index">Volver</a>
</body>
</html>