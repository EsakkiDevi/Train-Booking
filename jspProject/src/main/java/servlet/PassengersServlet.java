package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/PassengerServlet")
public class PassengersServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Read form parameters
        String username = req.getParameter("username");
        String trainNoStr = req.getParameter("trainNo");
        String quota = req.getParameter("quota");
        String seatsStr = req.getParameter("seats");
        String passengerName = req.getParameter("passengerName");
        String ageStr = req.getParameter("age");
        String gender = req.getParameter("gender");

        // Convert numeric values safely
        int trainNo = trainNoStr != null ? Integer.parseInt(trainNoStr) : 0;
        int seats = seatsStr != null ? Integer.parseInt(seatsStr) : 0;
        int age = ageStr != null ? Integer.parseInt(ageStr) : 0;

        // Save details in session for next step (Payment)
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        session.setAttribute("trainNo", trainNo);
        session.setAttribute("seats", seats);
        session.setAttribute("quota", quota);
        session.setAttribute("passengerName", passengerName);
        session.setAttribute("age", age);
        session.setAttribute("gender", gender);

        // Forward to payment page
        req.getRequestDispatcher("payment.jsp").forward(req, resp);
    }
}
