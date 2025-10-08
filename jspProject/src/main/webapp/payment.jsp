<%@ page session="true" %>
<%
String username = (String) session.getAttribute("username");
if(username==null){ response.sendRedirect("login.jsp"); return; }

String trainNo = request.getParameter("trainNo");
String trainName = request.getParameter("trainName");
String departure = request.getParameter("departure");
String arrival = request.getParameter("arrival");
String seats = request.getParameter("seats");
String quota = request.getParameter("quota");
String source = request.getParameter("source");
String destination = request.getParameter("destination");

if(trainNo==null || seats==null){ response.sendRedirect("dashboard.jsp"); return; }
%>

<form action="PaymentServlet" method="post">
<input type="hidden" name="trainNo" value="<%= trainNo %>">
<input type="hidden" name="trainName" value="<%= trainName %>">
<input type="hidden" name="seats" value="<%= seats %>">
<input type="hidden" name="quota" value="<%= quota %>">
<input type="hidden" name="username" value="<%= username %>">

Payment Method:
<select name="paymentMethod" required>
<option value="UPI">UPI</option>
<option value="Debit Card">Debit Card</option>
<option value="Net Banking">Net Banking</option>
<option value="Wallet">Wallet</option>
</select>

<button type="submit">Pay Now</button>
</form>
