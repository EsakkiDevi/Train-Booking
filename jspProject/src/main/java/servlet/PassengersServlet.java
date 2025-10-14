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
    	 // Read train & booking info from BookTrain.jsp
        String trainNo = req.getParameter("trainNo");
        String seats = req.getParameter("seats");
        String quota = req.getParameter("quota");
        String classType = req.getParameter("class");

        // Read passenger arrays from BookTrain.jsp
        String[] names = req.getParameterValues("pname");
        String[] ages = req.getParameterValues("page");
        String[] genders = req.getParameterValues("pgender");
        String[] categories = req.getParameterValues("pcategory");

        // Store all data as request attributes to forward to Payment.jsp
        req.setAttribute("trainNo", trainNo);
        req.setAttribute("seats", seats);
        req.setAttribute("quota", quota);
        req.setAttribute("class", classType);

        req.setAttribute("pname", names);
        req.setAttribute("page", ages);
        req.setAttribute("pgender", genders);
        req.setAttribute("pcategory", categories);

        // Forward to Payment.jsp
        RequestDispatcher rd = req.getRequestDispatcher("payment.jsp");
        rd.forward(req, resp);
    }
}
