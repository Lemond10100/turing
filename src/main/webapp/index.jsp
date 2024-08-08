<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Configurazione Database</title>
</head>
<body>
    <h1>Impostazioni di Connessione al Database</h1>
    <form action="indexServlet" method="post">
        <label for="dbHost">Host del Database:</label>
        <input type="text" id="dbHost" name="dbHost" required><br>

        <label for="dbPort">Porta del Database:</label>
        <input type="text" id="dbPort" name="dbPort" required><br>

        <label for="dbUrl">URL del Database:</label>
        <input type="text" id="dbUrl" name="dbUrl" required><br>

        <label for="dbUser">Username del Database:</label>
        <input type="text" id="dbUser" name="dbUser" required><br>

        <label for="dbPassword">Password del Database:</label>
        <input type="password" id="dbPassword" name="dbPassword" required><br>

        <input type="submit" value="Procedi">
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p style="color: red;">Credenziali errate, si prega di riprovare.</p>
    <% } %>
</body>
</html>
