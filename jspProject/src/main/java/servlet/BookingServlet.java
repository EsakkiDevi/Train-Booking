package servlet;

import dao.Traindao;
import db.database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/BookTrain")
public class BookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        String trainNo = request.getParameter("trainNo");       // Train number from dashboard
        String dateStr = request.getParameter("date");          // Travel date
        int seats = Integer.parseInt(request.getParameter("seats")); // Number of seats

        // Get logged-in user ID from session
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (trainNo == null || dateStr == null || seats <= 0 || userId == null) {
            response.getWriter().print("Invalid booking request!");
            return;
        }

        try (Connection con = database.getConnection()) {

            // 1️⃣ Reduce seats in DB (optional local tracking)
            new Traindao(con).reduceSeats(trainNo, seats);

            // 2️⃣ Insert booking record
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO booking(user_id, train_no, travel_date, seats_booked) VALUES(?,?,?,?)"
            );
            ps.setInt(1, userId);
            ps.setString(2, trainNo);
            ps.setDate(3, java.sql.Date.valueOf(dateStr));
            ps.setInt(4, seats);
            ps.executeUpdate();
            ps.close();

            response.getWriter().print("Booking successful!");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("Booking failed! Try again.");
        }
    }

    // Optional: handle GET for testing
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("BookingServlet is running. Use POST to book.");
    }
}
