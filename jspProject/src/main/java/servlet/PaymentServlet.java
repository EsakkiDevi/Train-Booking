package servlet;

import db.database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/paymentServlet")
public class PaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        String method = request.getParameter("paymentMethod");

        try(Connection con = database.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE bookings SET payment_status='Paid' WHERE booking_id=?")){
            ps.setInt(1, bookingId);
            ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace(); }

        HttpSession session = request.getSession();
        session.setAttribute("bookingId", bookingId);
        response.sendRedirect("confirmTicket.jsp");
    }
}
