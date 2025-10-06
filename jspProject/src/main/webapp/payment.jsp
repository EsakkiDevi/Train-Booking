<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if(username == null){ response.sendRedirect("login.jsp"); return; }

    String trainNo = request.getParameter("trainNo");
    String trainName = request.getParameter("trainName");
    String departure = request.getParameter("departure");
    String arrival = request.getParameter("arrival");
    String duration = request.getParameter("duration");
    String source = request.getParameter("source");
    String destination = request.getParameter("destination");
    String seats = request.getParameter("seats");
    String quota = request.getParameter("quota");

    if(trainNo == null || seats == null){ response.sendRedirect("dashboard.jsp"); return; }
%>

<html>
<head>
<title>Payment Page</title>
<style>
body { font-family: 'Segoe UI', sans-serif; background:#f2f2f2; }
.container { width:400px; margin:50px auto; background:white; padding:20px; border-radius:10px; box-shadow:0 0 10px #ccc; }
h2 { text-align:center; color:#333; }
table { width:100%; margin-bottom:15px; }
td { padding:8px; }
button { width:100%; padding:10px; background:#4CAF50; color:white; border:none; border-radius:5px; cursor:pointer; }
button:hover { background:#45a049; }
</style>
</head>
<body>
<div class="container">
<h2>Payment Summary</h2>

<table>
<tr><td>Train No:</td><td><%= trainNo %></td></tr>
<tr><td>Name:</td><td><%= trainName %></td></tr>
<tr><td>From:</td><td><%= source %></td></tr>
<tr><td>To:</td><td><%= destination %></td></tr>
<tr><td>Departure:</td><td><%= departure %></td></tr>
<tr><td>Arrival:</td><td><%= arrival %></td></tr>
<tr><td>Seats:</td><td><%= seats %></td></tr>
<tr><td>Quota:</td><td><%= quota %></td></tr>
</table>

<form action="PaymentServlet" method="post">
    <!-- Pass all details to servlet -->
    <input type="hidden" name="trainNo" value="<%= trainNo %>">
    <input type="hidden" name="seats" value="<%= seats %>">
    <input type="hidden" name="quota" value="<%= quota %>">
    <input type="hidden" name="username" value="<%= username %>">
    <button type="submit">Pay Now</button>
</form>

</div>
</body>
</html>
