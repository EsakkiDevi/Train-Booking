<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body {
            margin: 0;
            font-family: 'Poppins', sans-serif;
            background: url('https://images.unsplash.com/photo-1555124618-81b95d0e5892?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDB8fHRyYWlufGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=500') no-repeat center center/cover;
            height: 100vh;
        }
        /* Navbar */
        .navbar {
            background-color: rgba(0, 0, 0, 0.7);
            height: 75px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 50px;
            color: white;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.4);
        }
        .navbar h1 {
            font-size: 22px;
            letter-spacing: 1px;
        }
        .navbar ul {
            list-style: none;
            display: flex;
            gap: 25px;
        }
        .navbar ul li a {
            text-decoration: none;
            color: white;
            font-weight: 500;
            font-size: 16px;
            transition: color 0.3s ease;
        }
        .navbar ul li a:hover {
            color: #00bfff;
        }
        /* Form Container */
        form {
            background: rgba(255, 255, 255, 0.92);
            width: 400px;
            padding: 35px 45px;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.4);
            position: absolute;
            top: 55%;
            right: 8%;
            transform: translateY(-50%);
        }
        form h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #222;
        }
        .input-container {
            position: relative;
            margin-bottom: 20px;
        }
        .input-container label {
            display: block;
            margin-bottom: 6px;
            font-weight: 500;
            color: #333;
        }
        .input-container input {
            width: 80%;
            padding: 10px 40px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-size: 15px;
        }
        .input-container i {
            position: absolute;
            top: 35px;
            left: 12px;
            color: #666;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            background-color: #0078d7;
            border: none;
            color: white;
            font-size: 17px;
            border-radius: 8px;
            cursor: pointer;
            transition: background 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #005fa3;
        }
        a {
            text-decoration: none;
            color: #0078d7;
            display: block;
            text-align: center;
            margin-top: 15px;
        }
        a:hover {
            text-decoration: underline;
        }
        .error {
            color: red;
            font-size: 13px;
            display: block;
            margin-top: 4px;
        }
    </style>
</head>

<body>
<!-- Navbar -->
<div class="navbar">
    <h1>
        <img src="logo.png" alt="IR Logo" style="height:60px; width:70px; vertical-align:middle; margin-right:10px;">
        Zoho Railway Catering and Tourism Corporation 
    </h1>
    <ul>
        <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Home</a></li>
        <li><a href="register.jsp"><i class="fa-solid fa-user-plus"></i> Register</a></li>
        <li><a href="login.jsp"><i class="fa-solid fa-right-to-bracket"></i> Login</a></li>
    </ul>
</div>

<!-- Login Form -->
<form  method="post"  action="LoginServlet">

    <h2><i class="fa-solid fa-right-to-bracket"></i> Login</h2>

    <!-- Email -->
    <div class="input-container">
        <label><i class="fa-solid fa-envelope"></i> Email</label>
        <i class="fa-solid fa-envelope"></i>
        <input type="email" name="email" required>
    </div>

    <!-- Password -->
    <div class="input-container">
        <label><i class="fa-solid fa-lock"></i> Password</label>
        <i class="fa-solid fa-lock"></i>
        <input type="password" name="password" id="password" required>
        <i class="fa-solid fa-eye toggle-eye" id="togglePassword"></i>
    </div>

    <input type="submit" value="Login">
    <a href="index.jsp">Don't have an account? Register here</a>

    <p class="error">${errorMessage}</p>
</form>

<!-- Script for eye icon -->
<script>
document.addEventListener('DOMContentLoaded', function() {
    const passwordInput = document.getElementById("password");
    const togglePassword = document.getElementById('togglePassword');

    togglePassword.addEventListener('click', function() {
        const type = passwordInput.type === 'password' ? 'text' : 'password';
        passwordInput.type = type;
        this.classList.toggle('fa-eye-slash');
    });
});
</script>

</body>
</html>
