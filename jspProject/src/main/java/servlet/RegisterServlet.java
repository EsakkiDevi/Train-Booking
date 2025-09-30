package servlet;

import dao.Registerdao;
import model.Register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private Registerdao userDAO = new Registerdao();

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

       
        Register user = new Register(fullname, email, phone, password);

        try {
            
            if(userDAO.isUserExist(email, phone)) {
               
                response.sendRedirect("index.jsp?error=exists");
            } else {
              
                boolean success = userDAO.registerUser(user);
                if(success) {
                   
                    response.sendRedirect("login.jsp?success=1");
                } else { // Registration failed → show general error
                    response.sendRedirect("index.jsp?error=1");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=1");
        }
    }

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
