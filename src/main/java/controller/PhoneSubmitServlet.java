
package controller;
 import dao.UserDAO; 
import model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "PhoneSubmitServlet", urlPatterns = {"/PhoneSubmitServlet"})
public class PhoneSubmitServlet extends HttpServlet {


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
         
         String phone = request.getParameter("phone"); 
         User user = new User(phone); 
         UserDAO dao = new UserDAO();
         boolean status = dao.saveUser(user);
         if(status) { 
             HttpSession session = request.getSession();
             session.setAttribute("phone", phone);
             response.getWriter().write("SUCCESS"); 
         } else { response.getWriter().write("FAILED"); }
    }

    

}
