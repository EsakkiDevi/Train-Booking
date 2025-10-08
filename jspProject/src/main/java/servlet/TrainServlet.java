package servlet;

import dao.Traindao;
import model.Train;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchTrain")
public class TrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");

        Traindao dao = new Traindao();
        List<Train> trains = dao.searchTrains(from, to);

        request.setAttribute("trainList", trains);
        RequestDispatcher rd = request.getRequestDispatcher("trainlist.jsp");
        rd.forward(request, response);
    }
}
