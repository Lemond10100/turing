<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Persona"%>

<!DOCTYPE html>
<html>
<head>
    <title>Rubrica</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 20px;
            padding-bottom: 20px;
        }
        .container {
            max-width: 1200px;
            margin: auto;
        }
        .table {
            width: 100%;
            margin-bottom: 20px;
        }
        .btn-table {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="d-flex justify-content-between mb-3">
            <h1>Rubrica Telefonica</h1>
            <a href="logout" class="btn btn-secondary">Logout</a> <!-- Bootstrap styled logout link -->
        </div>

        <table class="table table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Indirizzo</th>
                    <th>Telefono</th>
                    <th>Età</th>
                    <th>Operazioni</th>
                </tr>
            </thead>
            <tbody>
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
                        out.println("<a href='editor.jsp?id=" + persona.getId() + "' class='btn btn-primary btn-table'>Modifica</a>");
                        out.println("<form method='POST' action='deletePersona' style='display:inline;'>");
                        out.println("<input type='hidden' name='id' value='" + persona.getId() + "' />");
                        out.println("<button type='submit' class='btn btn-danger'>Elimina</button>");
                        out.println("</form>");
                        out.println("</td>");
                        out.println("</tr>");
                    }
                }
            %>
            </tbody>
        </table>
        <button onclick="window.location.href='editor.jsp'" class="btn btn-success">NUOVO</button>
    </div>
</body>
</html>
