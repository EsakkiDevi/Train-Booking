<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if(username == null){ response.sendRedirect("login.jsp"); return; }

    String message = (String) request.getAttribute("message");
    if(message == null) message = "No message.";
%>

<html>
<head>
<title>Booking Confirmation</title>
<style>
body { font-family: 'Segoe UI', sans-serif; background:#f2f2f2; }
.container { width:400px; margin:50px auto; background:white; padding:20px; border-radius:10px; box-shadow:0 0 10px #ccc; text-align:center; }
.message { padding:15px; margin:20px 0; border-radius:5px; background:#e7f3fe; color:#31708f; }
a.button { display:inline-block; padding:10px 15px; background:#4CAF50; color:white; text-decoration:none; border-radius:5px; }
a.button:hover { background:#45a049; }
</style>
</head>
<body>
<div class="container">
<h2>Booking Status</h2>
<div class="message"><%= message %></
