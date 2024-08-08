<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Numero Esistente</title>
</head>
<body>
    <h1>Errore: Il numero di telefono è già presente nella rubrica.</h1>
    <p><%= request.getAttribute("message") %></p>
    <button type="button" onclick="window.location.href='getPersona'">Torna alla Lista</button>
</body>
</html>
