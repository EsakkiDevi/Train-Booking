<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if(username == null){ response.sendRedirect("login.jsp"); return; }

    String trainNo = request.getParameter("trainNo");
    String trainName = request.getParameter("trainName");
    String source = request.getParameter("source");
    String destination = request.getParameter("destination");
    String departure = request.getParameter("departure");
    String arrival = request.getParameter("arrival");
    String seats = request.getParameter("seats");
    String quota = request.getParameter("quota");
    String paymentMethod = request.getParameter("paymentMethod");

    if(trainNo == null){ response.sendRedirect("dashboard.jsp"); return; }
%>

<html>
<head>
<title>Booking Confirmed</title>
<style>
body { font-family: 'Segoe UI', sans-serif; background:#f2f2f2; display:flex; justify-content:center; align-items:center; height:100vh; }
.container { background:white; padding:30px; border-radius:10px; box-shadow:0 0 15px #ccc; width:450px; text-align:center; }
h1 { color:green; }
table { width:100%; margin:20px 0; border-collapse: collapse; }
td { padding:8px; border-bottom:1px solid #ccc; text-align:left; }
button { padding:10px 20px; margin-top:20px; background:#4CAF50; color:white; border:none; border-radius:5px; cursor:pointer; }
button:hover { background:#45a049; }
</style>
</head>
<body>
<div class="container">
    <h1>✅ Booking Confirmed!</h1>
    <p>Thank you, <b><%= username %></b>. Your train ticket has been booked successfully.</p>

    <h2>Ticket Details</h2>
    <table>
        <tr><td>Train No:</td><td><%= trainNo %></td></tr>
        <tr><td>Name:</td><td><%= trainName %></td></tr>
        <tr><td>From:</td><td><%= source %></td></tr>
        <tr><td>To:</td><td><%= destination %></td></tr>
        <tr><td>Departure:</td><td><%= departure %></td></tr>
        <tr><td>Arrival:</td><td><%= arrival %></td></tr>
        <tr><td>Seats Booked:</td><td><%= seats %></td></tr>
        <tr><td>Quota:</td><td><%= quota %></td></tr>
        <tr><td>Payment Method:</td><td><%= paymentMethod %></td></tr>
    </table>

    <button onclick="window.print()">🖨️ Print Ticket</button>
</div>
</body>
</html>
