<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Signup</title>
</head>
<body>
    <h1>Signup</h1>
    <form action="signup" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <input type="submit" value="Signup">
    </form>
    <a href="login.jsp">Already have an account? Login here</a>
</body>
</html>
