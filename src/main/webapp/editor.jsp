<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Persona" %>
<%@ page import="javax.validation.ConstraintViolation" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
    <title><%= request.getParameter("id") == null ? "Nuova Persona" : "Modifica Persona" %></title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mb-4"><%= request.getParameter("id") == null ? "Nuova Persona" : "Modifica Persona" %></h1>
        <form action="<%= request.getParameter("id") == null ? "addPersona" : "modificaPersona" %>" method="post" class="mb-4">
            <% if (request.getAttribute("errors") != null) { %>
                <div class="alert alert-danger">
                    <% for (ConstraintViolation<?> violation : (Set<ConstraintViolation<?>>) request.getAttribute("errors")) { %>
                        <p><%= violation.getMessage() %></p>
                    <% } %>
                </div>
            <% } %>
            <% if (request.getParameter("id") != null) { %>
                <input type="hidden" name="id" value="<%= request.getParameter("id") %>" />
            <% } %>
            <div class="mb-3">
                <label for="nome" class="form-label">Nome:</label>
                <input type="text" id="nome" name="nome" class="form-control" value="<%= request.getAttribute("persona") != null ? ((Persona)request.getAttribute("persona")).getNome() : "" %>" required>
            </div>
            <div class="mb-3">
                <label for="cognome" class="form-label">Cognome:</label>
                <input type="text" id="cognome" name="cognome" class="form-control" value="<%= request.getAttribute("persona") != null ? ((Persona)request.getAttribute("persona")).getCognome() : "" %>" required>
            </div>
            <div class="mb-3">
                <label for="telefono" class="form-label">Telefono:</label>
                <input type="text" id="telefono" name="telefono" class="form-control" value="<%= request.getAttribute("persona") != null ? ((Persona)request.getAttribute("persona")).getTelefono() : "" %>" required>
            </div>
            <div class="mb-3">
                <label for="indirizzo" class="form-label">Indirizzo:</label>
                <input type="text" id="indirizzo" name="indirizzo" class="form-control" value="<%= request.getAttribute("persona") != null ? ((Persona)request.getAttribute("persona")).getIndirizzo() : "" %>" required>
            </div>
            <div class="mb-3">
                <label for="eta" class="form-label">Età:</label>
                <input type="number" id="eta" name="eta" class="form-control" value="<%= request.getAttribute("persona") != null ? ((Persona)request.getAttribute("persona")).getEta() : "" %>" required>
            </div>
            <button type="submit" class="btn btn-primary">SALVA</button>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='getPersona'">ANNULLA</button>
        </form>
    </div>
</body>
</html>
