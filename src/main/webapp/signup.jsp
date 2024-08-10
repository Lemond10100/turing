<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Signup - Rubrica</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url('https://example.com/path-to-your-background-image.jpg') no-repeat center center fixed;
            background-size: cover;
            height: 100vh; /* Full height */
            overflow: hidden; /* Disable scroll */
        }
        .container {
            max-width: 400px;
            margin: auto;
            background: rgba(255, 255, 255, 0.8); /* Semi-transparent white background */
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            position: relative;
            top: 50%;
            transform: translateY(-50%);
        }
        .form-control:focus {
            box-shadow: 0 0 0 0.25rem rgba(13,110,253,0.25);
        }
        .btn-primary {
            padding: 10px 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mb-4 text-center">Signup</h1>

        <form action="signup" method="post" class="mb-3">
            <div class="mb-3">
                <label for="username" class="form-label">Username:</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Signup</button>
            </div>
        </form>

        <% if (request.getParameter("error") != null && !request.getParameter("error").isEmpty()) { %>
            <p class="text-danger"><%= request.getParameter("error") %></p>
        <% } %>

        <a href="login.jsp" class="d-block mt-3 text-center">Already have an account? Login here.</a>
    </div>
</body>
</html>
