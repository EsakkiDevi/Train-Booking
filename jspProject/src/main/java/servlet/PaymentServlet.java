package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import dao.Bookingdao;
import dao.Passengerdao;
import dao.Traindao;
import model.Booking;
import model.Passenger;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String trainNo = req.getParameter("trainNo");
        int seats = Integer.parseInt(req.getParameter("seats"));
        String quota = req.getParameter("quota");
        String travelClass = req.getParameter("class");
        String[] names = req.getParameterValues("pname");
        String[] ages = req.getParameterValues("page");
        String[] genders = req.getParameterValues("pgender");
        String[] categories = req.getParameterValues("pcategory");

        Booking b = new Booking();
        b.setUsername("user1");
        b.setTrainNo(trainNo);
        b.setSeatsBooked(seats);
        b.setQuota(quota);
        b.setPaymentStatus("Pending");

        Bookingdao bdao = new Bookingdao();
        int bookingId = bdao.saveBooking(b);

        List<Passenger> plist = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Passenger p = new Passenger();
            p.setBookingId(bookingId);
            p.setName(names[i]);
            int age = Integer.parseInt(ages[i]);
            p.setAge(age);
            p.setGender(genders[i]);
            double baseFare = getBaseFare(travelClass);
            double fare = calculateFareByCategory(categories[i], baseFare);
            p.setFare(fare);
            plist.add(p);
        }

        Passengerdao pdao = new Passengerdao();
        pdao.savePassengers(plist, bookingId);

        Traindao tdao = new Traindao();
        tdao.updateSeats(trainNo, seats);

        // ✅ Update payment status to SUCCESS after successful booking
 //bdao.updatePaymentStatus(bookingId, "Success");---------------------->main

        req.setAttribute("bookingId", bookingId);
        req.setAttribute("trainNo", trainNo);
        req.setAttribute("seats", seats);
        req.setAttribute("passengers", plist);
        req.setAttribute("paymentStatus", "Success");

        RequestDispatcher rd = req.getRequestDispatcher("ticket.jsp");
        rd.forward(req, res);
    }

    private double getBaseFare(String travelClass) {
        switch (travelClass) {
            case "AC": return 1000.0;
            case "2AC": return 800.0;
            case "Sleeper": return 500.0;
            default: return 500.0;
        }
    }

    private double calculateFareByCategory(String category, double baseFare) {
        switch (category) {
            case "Child": return baseFare * 0.5;
            case "Senior": return baseFare * 0.7;
            default: return baseFare;
        }
    }
}