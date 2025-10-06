package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.Connection;

import dao.Traindao;
import dao.Bookingdao;
import model.Booking;
import db.database;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String trainNo = request.getParameter("trainNo");
        int seats = Integer.parseInt(request.getParameter("seats"));
        String quota = request.getParameter("quota");

        try (Connection con = database.getConnection()) {
            Traindao tdao = new Traindao(con);
            Bookingdao bdao = new Bookingdao(con);

            // 1️⃣ Update available seats
            if(tdao.updateSeats(trainNo, seats)) {
                // 2️⃣ Save booking
                Booking booking = new Booking(username, trainNo, seats, quota, "Paid");
                boolean success = bdao.addBooking(booking);

                request.setAttribute("message", success ? 
                    "✅ Booking & Payment Successful!" : 
                    "❌ Booking failed while saving record!");
            } else {
                request.setAttribute("message", "❌ Not enough seats available!");
            }

            // 3️⃣ Forward to confirmation page
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);

        } catch(Exception e){
            e.printStackTrace();
            request.setAttribute("message", "❌ Server error!");
            request.getRequestDispatcher("confirmation.jsp").forward(request, response);
        }
    }
}
