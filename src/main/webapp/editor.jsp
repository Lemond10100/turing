<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title><%= request.getParameter("id") == null ? "Nuova Persona" : "Modifica Persona" %></title>
</head>
<body>
    <h1><%= request.getParameter("id") == null ? "Nuova Persona" : "Modifica Persona" %></h1>
    <form action="<%= request.getParameter("id") == null ? "addPersona" : "modificaPersona" %>" method="post">
        <% if (request.getParameter("id") != null) { %>
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>" />
        <% } %>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<%= request.getParameter("nome") != null ? request.getParameter("nome") : "" %>" /><br>
        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" value="<%= request.getParameter("cognome") != null ? request.getParameter("cognome") : "" %>" /><br>
        <label for="telefono">Telefono:</label>
        <input type="text" id="telefono" name="telefono" value="<%= request.getParameter("telefono") != null ? request.getParameter("telefono") : "" %>" /><br>
        <label for="indirizzo">Indirizzo:</label>
        <input type="text" id="indirizzo" name="indirizzo" value="<%= request.getParameter("indirizzo") != null ? request.getParameter("indirizzo") : "" %>" /><br>
        <label for="eta">Età:</label>
        <input type="number" id="eta" name="eta" value="<%= request.getParameter("eta") != null ? request.getParameter("eta") : "" %>" /><br>
        <button type="submit">SALVA</button>
        <button type="button" onclick="window.location.href='getPersona'">ANNULLA</button>

    </form>
</body>
</html>
