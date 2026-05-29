
package controller;
import dao.UserDAO; 
import dao.VerificationDAO;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "VerifyCodeServlet", urlPatterns = {"/VerifyCodeServlet"})
public class VerifyCodeServlet extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String phone = (String) request.getSession() .getAttribute("phone"); 
        String code = request.getParameter("code"); 
        UserDAO userDAO = new UserDAO(); 
        int userId = userDAO.getUserId(phone);
        VerificationDAO verificationDAO = new VerificationDAO();
        boolean valid = verificationDAO.verifyCode( userId, code ); 
        if(valid) { request.getSession() .setAttribute("authenticated", true);
        response.getWriter().write("VERIFIED");
        } else { response.getWriter().write("INVALID"); }
    }

    

}
