<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Numero Esistente</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 50px;
            background-color: #f4f4f4;
        }
        .container {
            width: 600px;
            padding: 20px;
            margin: auto;
            background-color: #fff;
            border: 1px solid #e3e3e3;
            border-radius: 5px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.23);
        }
        h1 {
            color: #d9534f; /* Bootstrap danger color for error messages */
        }
    </style>
</head>
<body>
    <div class="container text-center">
        <h1 class="mb-4">Errore: Il numero di telefono è già presente nella rubrica.</h1>
        <p><%= request.getAttribute("message") != null ? request.getAttribute("message") : "Si è verificato un errore." %></p>
        <button type="button" class="btn btn-primary" onclick="window.location.href='getPersona'">Torna alla Lista</button>
    </div>
</body>
</html>
