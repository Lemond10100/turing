<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Persona"%>

<!DOCTYPE html>
<html>
<head>
    <title>Rubrica</title>
</head>
<body>
    <a href="logout">Logout</a> <!-- Link di Logout -->
    <h1>Rubrica Telefonica</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Indirizzo</th>
            <th>Telefono</th>
            <th>Eta</th>
            <th>Operazioni</th>
        </tr>
        <%
            List<Persona> lista = (List<Persona>) request.getAttribute("personas");
            if (lista != null) {
                for (Persona persona : lista) {
                    out.println("<tr>");
                    out.println("<td>" + persona.getId() + "</td>");
                    out.println("<td>" + persona.getNome() + "</td>");
                    out.println("<td>" + persona.getCognome() + "</td>");
                    out.println("<td>" + persona.getIndirizzo() + "</td>");
                    out.println("<td>" + persona.getTelefono() + "</td>");
                    out.println("<td>" + persona.getEta() + "</td>");
                    out.println("<td>");
                    out.println("<a href='editor.jsp?id=" + persona.getId() + "'>Modifica</a> ");
                    out.println("<form method='POST' action='deletePersona' style='display:inline;'>");
                    out.println("<input type='hidden' name='id' value='" + persona.getId() + "' />");
                    out.println("<input type='submit' value='Elimina' />");
                    out.println("</form>");
                    out.println("</td>");
                    out.println("</tr>");
                }
            }
        %>
    </table>
    <button onclick="window.location.href='editor.jsp'">NUOVO</button>
</body>
</html>
