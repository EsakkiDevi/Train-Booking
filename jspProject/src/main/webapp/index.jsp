<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Train Ticket Registration</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>
        body {
            margin: 0;
            font-family: 'Poppins', sans-serif;
            /* Working direct image URL from Unsplash */
            background: url('https://images.unsplash.com/photo-1572803090936-72796aef96a2?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxjb2xsZWN0aW9uLXBhZ2V8MTV8ZktuVlhjbEplalF8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=60&w=500') no-repeat center center;
            background-size: cover;
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
            width: 450px;
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

        .input-container .toggle-eye {
            right: 12px;
            left: auto;
            cursor: pointer;
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
    <h1> <img src="logo.png" alt="IR Logo" style="height:60px ;width:70px; vertical-align:middle; margin-right:10px;"> Zoho Railway Catering and Tourism Corporation </h1>
    <ul>
        <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Home</a></li>
        <li><a href="register.jsp"><i class="fa-solid fa-user-plus"></i> Register</a></li>
        <li><a href="login.jsp"><i class="fa-solid fa-right-to-bracket"></i> Login</a></li>
    </ul>
</div>

<!-- Registration Form -->
<form method="post" action="register" autocomplete="off">
    <h2><i class="fa-solid fa-train"></i> Register for Train Booking</h2>

    <% if("exists".equals(request.getParameter("error"))) { %>
        <p style="color:red;">User already registered with this email or phone!</p>
    <% } %>

    <% if("1".equals(request.getParameter("success"))) { %>
        <p style="color:green;">Registration successful! Please login.</p>
    <% } %>

    <!-- Full Name -->
    <div class="input-container">
        <label><i class="fa-solid fa-id-card"></i> Full Name</label>
        <input type="text" name="fullname" required>
    </div>

    <!-- Email -->
    <div class="input-container">
        <label><i class="fa-solid fa-envelope"></i> Email</label>
        <input type="email" name="email" id="email" required>
        <span class="error" id="emailError"></span>
    </div>

    <!-- Phone -->
    <div class="input-container">
        <label><i class="fa-solid fa-phone"></i> Phone</label>
        <input type="text" name="phone" id="phone" required>
        <span class="error" id="phoneError"></span>
    </div>

    <!-- Password -->
    <div class="input-container">
        <label><i class="fa-solid fa-lock"></i> Password</label>
        <input type="password" name="password" id="password" required>
        <i class="fa-solid fa-eye toggle-eye" id="togglePassword"></i>
        <span class="error" id="passwordError"></span>
    </div>

    <!-- Confirm Password -->
    <div class="input-container">
        <label><i class="fa-solid fa-lock"></i> Confirm Password</label>
        <input type="password" id="confirmPassword" required>
        <i class="fa-solid fa-eye toggle-eye" id="toggleConfirmPassword"></i>
        <span class="error" id="confirmPasswordError"></span>
    </div>

    <input type="submit" value="Register">
    <a href="login.jsp">Already a user? Login here</a>
</form>

<!-- Validation Script -->
<script>
document.addEventListener('DOMContentLoaded', function() {
  const emailInput = document.getElementById("email");
  const phoneInput = document.getElementById("phone");
  const passwordInput = document.getElementById("password");
  const confirmPasswordInput = document.getElementById("confirmPassword");

  const emailError = document.getElementById("emailError");
  const phoneError = document.getElementById("phoneError");
  const passwordError = document.getElementById("passwordError");
  const confirmPasswordError = document.getElementById("confirmPasswordError");

  const togglePassword = document.getElementById('togglePassword');
  const toggleConfirmPassword = document.getElementById('toggleConfirmPassword');

  // Email Validation
  emailInput.addEventListener("input", function() {
    const pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    emailError.textContent = pattern.test(emailInput.value) ? "" : "Example: abcd@gmail.com";
  });

  // Phone Validation
  phoneInput.addEventListener("input", function() {
    const pattern = /^\d{10}$/;
    phoneError.textContent = pattern.test(phoneInput.value) ? "" : "Phone Number must be 10 digits";
  });

  // Password Validation
  passwordInput.addEventListener("input", function() {
    const pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;
    passwordError.textContent = pattern.test(passwordInput.value) ? "" : "Password must have uppercase, lowercase, digit, special character (8–12 chars)";

    if (confirmPasswordInput.value !== "") {
      confirmPasswordError.textContent = confirmPasswordInput.value !== passwordInput.value ? "Passwords do not match!" : "";
    }
  });

  confirmPasswordInput.addEventListener("input", function() {
    confirmPasswordError.textContent = confirmPasswordInput.value !== passwordInput.value ? "Passwords do not match!" : "";
  });

  // Toggle Password Visibility
  togglePassword.addEventListener('click', function() {
    passwordInput.type = passwordInput.type === 'password' ? 'text' : 'password';
    this.classList.toggle('fa-eye-slash');
  });

  toggleConfirmPassword.addEventListener('click', function() {
    confirmPasswordInput.type = confirmPasswordInput.type === 'password' ? 'text' : 'password';
    this.classList.toggle('fa-eye-slash');
  });

});
</script>

</body>
</html>
