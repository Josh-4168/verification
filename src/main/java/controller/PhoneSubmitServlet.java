
package controller;
 import dao.UserDAO; 
import model.User;
import java.io.IOException;

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
         
         
         String phone = request.getParameter("phone"); 
         
if(!phone.matches("^[97][0-9]{8}$")){
    response.sendRedirect("index.jsp?error=phone");
    return;
}
         String countryCode = request.getParameter("countryCode");
String fullPhone = countryCode + phone;

UserDAO dao = new UserDAO();

if (dao.phoneExists(fullPhone)) {
    request.setAttribute("error", "Phone number already registered.");
    request.getRequestDispatcher("index.jsp").forward(request, response);
    return;
}

User user = new User(fullPhone);
boolean status = dao.saveUser(user);
         if(status) { 
             HttpSession session = request.getSession();
             session.setAttribute("fullPhone", fullPhone);
              response.sendRedirect("verify.jsp");
         } else {  response.getWriter().write("FAILED"); }
    }

    

}
