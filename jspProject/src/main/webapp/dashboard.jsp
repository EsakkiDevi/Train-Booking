<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    // Ensure user is logged in
    String userEmail = (String) session.getAttribute("userEmail");
    String fullName = (String) session.getAttribute("userName");

    if (userEmail == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Determine which page content to include
    String selectedPage = request.getParameter("page");
    if (selectedPage == null) selectedPage = "home";

    String contentJSP = "home.jsp"; // default
    switch (selectedPage) {
        case "profile": contentJSP = "profile.jsp"; break;
        case "booking": contentJSP = "booking.jsp"; break;
        case "myBookings": contentJSP = "myBookings.jsp"; break;
        case "cancelBooking": contentJSP = "cancelBooking.jsp"; break;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Ticket Booking Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        body { margin:0; font-family:'Poppins', sans-serif; }
        .navbar {
            background-color: #0078d7;
            color: white;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .sidebar {
            width: 220px;
            height: 100vh;
            background-color: #f1f1f1;
            position: fixed;
            top: 60px;
            left: 0;
            padding-top: 20px;
        }
        .sidebar a {
            display: block;
            padding: 12px 20px;
            text-decoration: none;
            color: #333;
            font-weight: 500;
            margin-bottom: 5px;
            border-left: 4px solid transparent;
            transition: all 0.3s;
        }
        .sidebar a:hover, .sidebar a.active {
            background-color: #0078d7;
            color: white;
            border-left: 4px solid #004a8f;
        }
        .main-content {
            margin-left: 220px;
            padding: 30px;
            min-height: 100vh;
            background: #f0f2f5;
        }
    </style>
</head>
<body>

<div class="navbar">
    <h2><i class="fa-solid fa-train"></i> Ticket Booking Dashboard</h2>
    <div>
        Welcome, <b><%= fullName %></b> &nbsp;&nbsp;|&nbsp;&nbsp;
        <a href="logout.jsp" style="color:white;text-decoration:none;">Logout</a>
    </div>
</div>

<div class="sidebar">
    <a href="dashboard.jsp?page=profile" class="<%= "profile".equals(selectedPage) ? "active" : "" %>">
        <i class="fa-solid fa-user"></i> Profile
    </a>
    <a href="dashboard.jsp?page=booking" class="<%= "booking".equals(selectedPage) ? "active" : "" %>">
        <i class="fa-solid fa-ticket"></i> Book Ticket
    </a>
    <a href="dashboard.jsp?page=myBookings" class="<%= "myBookings".equals(selectedPage) ? "active" : "" %>">
        <i class="fa-solid fa-list"></i> My Bookings
    </a>
    <a href="dashboard.jsp?page=cancelBooking" class="<%= "cancelBooking".equals(selectedPage) ? "active" : "" %>">
        <i class="fa-solid fa-trash"></i> Cancel Booking
    </a>
</div>

<div class="main-content">
    <%-- Include the selected JSP dynamically --%>
    <jsp:include page="<%= contentJSP %>" />
</div>

</body>
</html>
