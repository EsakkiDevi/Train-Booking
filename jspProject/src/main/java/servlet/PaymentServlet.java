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
import model.Train;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

       
        System.out.println("---- Received Parameters ----");
        Enumeration<String> paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();
            System.out.println(name + " = " + req.getParameter(name));
        }
        System.out.println("-----------------------------");


        String trainNo = req.getParameter("trainNo");
        String seatStr = req.getParameter("seats");
        String quota = req.getParameter("quota");
        String travelClass = req.getParameter("class");
        String[] names = req.getParameterValues("pname");
        String[] ages = req.getParameterValues("page");
        String[] genders = req.getParameterValues("pgender");
        String[] categories = req.getParameterValues("pcategory");

        if (trainNo == null || seatStr == null || seatStr.trim().isEmpty()) {
            out.println("<h3 style='color:red;'>Error: Missing train number or seats parameter!</h3>");
            return;
        }

        int seats = 0;
        try {
            seats = Integer.parseInt(seatStr);
        } catch (NumberFormatException e) {
            out.println("<h3 style='color:red;'>Error: Invalid number format for seats!</h3>");
            return;
        }

        // 🧩 Get session username
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            out.println("<h3 style='color:red;'>Error: User not logged in!</h3>");
            return;
        }

       
        Booking b = new Booking();
        b.setUsername(username);
        b.setTrainNo(trainNo);
        b.setSeatsBooked(seats);
        b.setQuota(quota);
        b.setPaymentStatus("Pending");

        Bookingdao bdao = new Bookingdao();
        int bookingId = bdao.saveBooking(b);

    
        List<Passenger> plist = new ArrayList<>();
        if (names != null) {
            for (int i = 0; i < names.length; i++) {
                Passenger p = new Passenger();
                p.setBookingId(bookingId);
                p.setName(names[i]);

                int age = 0;
                try {
                    age = Integer.parseInt(ages[i]);
                } catch (Exception e) {
                    age = 0;
                }
                p.setAge(age);

                p.setGender(genders[i]);
                double baseFare = getBaseFare(travelClass);
                double fare = calculateFareByCategory(categories[i], baseFare);
                p.setFare(fare);

                plist.add(p);
            }
        }

       
        Passengerdao pdao = new Passengerdao();
        pdao.savePassengers(plist, bookingId);

        Traindao tdao = new Traindao();
        tdao.updateSeats(trainNo, seats);

     
        b.setPaymentStatus("Success");
        bdao.updatePaymentStatus(bookingId, "Success"); // if method exists

       
        Train train = tdao.getTrainByNo(trainNo); // Implement this in Traindao

       
        req.setAttribute("booking", b);
        req.setAttribute("train", train);
        req.setAttribute("passengers", plist);

      
        RequestDispatcher rd = req.getRequestDispatcher("ticket.jsp");
        rd.forward(req, res);
    }

   
    private double getBaseFare(String travelClass) {
        if (travelClass == null) return 500.0;
        switch (travelClass) {
            case "AC": return 1000.0;
            case "2AC": return 800.0;
            case "Sleeper": return 500.0;
            default: return 500.0;
        }
    }

  
    private double calculateFareByCategory(String category, double baseFare) {
        if (category == null) return baseFare;
        switch (category) {
            case "Child": return baseFare * 0.5;
            case "Senior": return baseFare * 0.7;
            default: return baseFare;
        }
    }
}
