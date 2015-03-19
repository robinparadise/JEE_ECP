<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>AgregarTemaView</title>
</head>
<body>
	<h1>
		Añadir un <b>Tema</b>
	</h1>
	<form action="newtema" method="post">
		<p>
			Nombre: <input name="name" type="text" value="${temaView.tema.name}" />${temaView.errorMsg}</p>
		<p>
			Pregunta: <input name="question" type="text"
				value="${temaView.tema.question}" />${temaView.errorMsg}</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="index">Volver a Home</a>
	</p>
</body>
</html>