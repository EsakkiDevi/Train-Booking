<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Register" %>
<%@ page session="true" %>
<%
    Register user = (Register) request.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>My Profile</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body { font-family:'Poppins', sans-serif; background:#f0f2f5; display:flex; justify-content:center; align-items:center; height:100vh; margin:0; }
        .profile-container { background:#fff; padding:30px 40px; border-radius:12px; width:400px; box-shadow:0 5px 20px rgba(0,0,0,0.3); }
        h2 { text-align:center; margin-bottom:20px; }
        .input-group { margin-bottom:15px; }
        .input-group label { display:block; font-weight:500; margin-bottom:5px; }
        .input-group input { width:100%; padding:10px; border-radius:6px; border:1px solid #ccc; }
        .btn { width:100%; padding:12px; background:#0078d7; color:#fff; border:none; border-radius:6px; cursor:pointer; font-size:16px; }
        .btn:hover { background:#005fa3; }
        .msg { text-align:center; margin-bottom:15px; font-weight:bold; color:green; }
        a { text-decoration:none; color:#0078d7; display:block; text-align:center; margin-top:10px; }
    </style>
</head>
<body>
    <div class="profile-container">
        <h2><i class="fa-solid fa-user"></i> My Profile</h2>

        <% if(request.getAttribute("msg") != null){ %>
            <div class="msg"><%= request.getAttribute("msg") %></div>
        <% } %>

        <form method="post" action="ProfileServlet">
            <div class="input-group">
                <label>Full Name</label>
                <input type="text" name="fullname" value="<%= user.getFullname() %>" required>
            </div>

            <div class="input-group">
                <label>Email (cannot change)</label>
                <input type="email" name="email" value="<%= user.getEmail() %>" disabled>
            </div>

            <div class="input-group">
                <label>Phone</label>
                <input type="text" name="phone" value="<%= user.getPhone() %>" required>
            </div>

            <div class="input-group">
                <label>Password</label>
                <input type="password" name="password" value="<%= user.getPassword() %>" required>
            </div>

            <button type="submit" class="btn">Update Profile</button>
        </form>
        <a href="dashboard.jsp"><i class="fa-solid fa-arrow-left"></i> Back to Dashboard</a>
    </div>
</body>
</html>
