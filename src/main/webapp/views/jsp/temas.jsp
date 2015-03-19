<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JEE_ECP</title>
</head>
	<body>
		<h1>Temas</h1>
		<ul>
			<c:forEach var="tema" items="${temas.getTemas()}">
				<li>${tema.name} >> ${tema.question} (<a href="votar?temaid=${tema.id}">Votar</a>)</li>
			</c:forEach>
		</ul>
		<a href="index">Volver</a> |
		<a href="newtema"> + Añadir nuevo Tema</a>
	</body>
	
</html>