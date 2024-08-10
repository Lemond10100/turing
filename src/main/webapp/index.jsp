<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Configurazione Database</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 600px;
            padding-top: 50px;
            margin: auto;
        }
        .form-label {
            margin-top: 10px;
        }
        .form-control {
            margin-bottom: 10px; /* Spacing between inputs */
        }
        .btn-primary {
            width: 100%; /* Full width */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mb-4">Impostazioni di Connessione al Database</h1>
        <form action="indexServlet" method="post">
            <div class="mb-3">
                <label for="dbHost" class="form-label">Host del Database:</label>
                <input type="text" id="dbHost" name="dbHost" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="dbPort" class="form-label">Porta del Database:</label>
                <input type="text" id="dbPort" name="dbPort" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="dbUrl" class="form-label">URL del Database:</label>
                <input type="text" id="dbUrl" name="dbUrl" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="dbUser" class="form-label">Username del Database:</label>
                <input type="text" id="dbUser" name="dbUser" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="dbPassword" class="form-label">Password del Database:</label>
                <input type="password" id="dbPassword" name="dbPassword" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary">Procedi</button>
        </form>

        <%-- Display error message if credentials are wrong --%>
        <% if (request.getParameter("error") != null) { %>
            <div class="alert alert-danger" role="alert">
                Credenziali errate, si prega di riprovare.
            </div>
        <% } %>
    </div>
</body>
</html>
