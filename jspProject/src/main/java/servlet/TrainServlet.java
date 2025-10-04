package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.Traindao;
import model.Train;

@WebServlet("/TrainServlet")
public class TrainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String from = request.getParameter("from");
        String to = request.getParameter("to");

        Traindao tdao = new Traindao();
        List<Train> trains = tdao.getTrains(from, to);

        request.setAttribute("trains", trains);
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
