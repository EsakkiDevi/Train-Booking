<%@ page session="true" %>
<%
String username = (String) session.getAttribute("username");
if(username==null){ response.sendRedirect("login.jsp"); return; }

String message = (String) request.getAttribute("message");
if(message==null) message = "No message.";
%>

<h2>Booking Status</h2>
<p><%= message %></p>
<a href="dashboard.jsp">Back to Dashboard</a>
