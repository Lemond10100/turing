<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Rubrica</title>
</head>
<body>
    <h1>Rubrica Telefonica</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Telefono</th>
            <th>Operazioni</th>
        </tr>
        <%-- Inserire qui il codice per iterare sugli oggetti Persona --%>
        <tr>
            <td>1</td>
            <td>Mario</td>
            <td>Rossi</td>
            <td>1234567890</td>
            <td>
                <a href="editor.jsp?id=1">Modifica</a>
                <a href="delete.jsp?id=1">Elimina</a>
            </td>
        </tr>
    </table>
    <button onclick="window.location.href='editor.jsp'">NUOVO</button>
</body>
</html>
