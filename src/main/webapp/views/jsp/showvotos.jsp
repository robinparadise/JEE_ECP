<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva Votación</title>
</head>
<body>
	<c:set var="voto" scope="request" value="${showvotos}" />
	<h1>Votación</h1>
	<h2>
		${voto.tema.toString()}
	</h2>
    <p><b>Nota Media: </b>${voto.media}</p>
    <br/>
    <b>Según el nivel de Estudios</b>
    <ul>
		<c:forEach var="estudio" items="${votoView.getNivelesEstudios()}">
			<li>${estudio}</li>
		</c:forEach>
	</ul>
</body>
</html>
