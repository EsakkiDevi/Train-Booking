<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Train Booking Login</h2>

    <!-- form action matches servlet URL pattern -->
    <form action="LoginServlet" method="post"> 
        <label>Username:</label>
        <input type="text" name="username" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>

    <p style="color:red;">
        ${errorMessage} <!-- shows error from servlet if login fails -->
    </p>
</body>
</html>