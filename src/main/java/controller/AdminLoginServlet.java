
package controller;
import dao.AdminDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException; 

@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/AdminLoginServlet"})
public class AdminLoginServlet extends HttpServlet {

    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("AdminLoginServlet reached");
          String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");

        AdminDAO dao = new AdminDAO();

        if(dao.login(username, password)){
System.out.println("LOGIN SUCCESS");
            HttpSession session =
                    request.getSession();

            session.setAttribute("admin", username);

            response.sendRedirect("admin-dashboard.jsp");

        }else{
System.out.println("LOGIN FAILED");
            response.sendRedirect(
                    
                    "admin-login.jsp?error=1");
            
        }
    
       
    }
}
   
