package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import com.google.gson.Gson;
import model.Train;
import service.TrainAPIService;

@WebServlet("/LiveUpdateServlet")
public class LiveUpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String date = request.getParameter("date");

        TrainAPIService apiService = new TrainAPIService();
        List<Train> trains = apiService.getTrains(from, to, date);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(trains));
        out.flush();
    }
}
