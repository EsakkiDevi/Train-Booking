package servlet;

import dao.Bookingdao;
import dao.Traindao;
import db.database;
import model.Booking;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("username") == null){
            response.sendRedirect("login.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");
        String trainNo = request.getParameter("trainNo");
        String quota = request.getParameter("quota");
        int seats = Integer.parseInt(request.getParameter("seats"));

        try (Connection con = database.getConnection()) {

            Traindao trainDao = new Traindao(con);
            Bookingdao bookingDao = new Bookingdao(con);

            // Check & update seats
            if(trainDao.updateSeats(trainNo, seats)) {

                // Create booking object
                Booking booking = new Booking();
                booking.setUsername(username);
                booking.setTrainNo(trainNo);
                booking.setSeatsBooked(seats);
                booking.setQuota(quota);
                booking.setPaymentStatus("Paid");

                if(bookingDao.addBooking(booking)) {
                    request.setAttribute("message", "✅ Booking Successful for Train " + trainNo);
                } else {
                    request.setAttribute("message", "❌ Booking failed while saving record!");
                }
            } else {
                request.setAttribute("message", "❌ Not enough seats available!");
            }

        } catch(Exception e){
            e.printStackTrace();
            request.setAttribute("message", "❌ Server error occurred!");
        }

        // Forward to confirmation page
        request.getRequestDispatcher("booking-confirmation.jsp").forward(request, response);
    }
}
