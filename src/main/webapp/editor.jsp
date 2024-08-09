<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Persona" %>
<%@ page import="javax.validation.ConstraintViolation" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
    <title><%= request.getParameter("id") == null ? "Nuova Persona" : "Modifica Persona" %></title>
</head>
<body>
    <h1><%= request.getParameter("id") == null ? "Nuova Persona" : "Modifica Persona" %></h1>
    <form action="<%= request.getParameter("id") == null ? "addPersona" : "modificaPersona" %>" method="post">
        <% if (request.getAttribute("errors") != null) { %>
            <div style="color: red;">
                <% for (ConstraintViolation<?> violation : (Set<ConstraintViolation<?>>) request.getAttribute("errors")) { %>
                    <p><%= violation.getMessage() %></p>
                <% } %>
            </div>
        <% } %>
        <% if (request.getParameter("id") != null) { %>
            <input type="hidden" name="id" value="<%= request.getParameter("id") %>" />
        <% } %>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<%= request.getAttribute("persona") != null ? ((Persona)request.getAttribute("persona")).getNome() : "" %>" /><br>
        <label for="cognome">Cognome:</label>
        <input type="text" id="cognome" name="cognome" value="<%= request.getAttribute("persona") != null ? ((Persona)request.getAttribute("persona")).getCognome() : "" %>" /><br>
        <label for="telefono">Telefono:</label>
        <input type="text" id="telefono" name="telefono" value="<%= request.getAttribute("persona") != null ? ((Persona)request.getAttribute("persona")).getTelefono() : "" %>" /><br>
        <label for="indirizzo">Indirizzo:</label>
        <input type="text" id="indirizzo" name="indirizzo" value="<%= request.getAttribute("persona") != null ? ((Persona)request.getAttribute("persona")).getIndirizzo() : "" %>" /><br>
        <label for="eta">Età:</label>
        <input type="number" id="eta" name="eta" value="<%= request.getAttribute("persona") != null ? ((Persona)request.getAttribute("persona")).getEta() : "" %>" /><br>
        <button type="submit">SALVA</button>
        <button type="button" onclick="window.location.href='getPersona'">ANNULLA</button>
    </form>
</body>
</html>
