package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.Bookingdao;
import dao.Traindao;
import model.Booking;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String username = (String) session.getAttribute("username");
        int trainNo = Integer.parseInt(req.getParameter("trainNo"));
        String trainName = req.getParameter("trainName");
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        String departure = req.getParameter("departure");
        String arrival = req.getParameter("arrival");
        int seats = Integer.parseInt(req.getParameter("seats"));
        String quota = req.getParameter("quota");
        double fare = Double.parseDouble(req.getParameter("fare"));
        double totalFare = fare * seats;

        Booking b = new Booking(username, trainNo, trainName, source, destination, departure, arrival, seats, quota, totalFare);

        Bookingdao dao = new Bookingdao();
        if (dao.saveBooking(b)) {
            // update available seats
            try { new Traindao().updateSeats(trainNo, seats); } catch (Exception e) { e.printStackTrace(); }
            resp.sendRedirect("payment.jsp");
        } else {
            resp.getWriter().println("Booking failed!");
        }
    }
}
