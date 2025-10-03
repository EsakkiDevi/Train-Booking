<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Train Ticket Registration</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<form method="post" action="register" autocomplete="off">
<h2>Register for Train Booking</h2>

<!-- Success / Error Messages -->
<% if("exists".equals(request.getParameter("error"))) { %>
    <p style="color:red;">User already registered with this email or phone!</p>
<% } %>

<% if("1".equals(request.getParameter("success"))) { %>
    <p style="color:green;">Registration successful! Please login.</p>
<% } %>

<label>Full Name:</label>
<input type="text" name="fullname" required><br><br>

<label>Email:</label>
<input type="email" name="email" id="email" required><br>
<span class="error" id="emailError"></span><br>

<label>Phone:</label>
<input type="text" name="phone" id="phone" required><br>
<span class="error" id="phoneError"></span><br>

<label>Password:</label>
<input type="password" name="password" id="password" required><br>
<span class="error" id="passwordError"></span><br>

<input type="submit" value="Register">
<a href="login.jsp">Already a user </a>
</form>

<script src="script.js"></script> 
</body>
</html>
