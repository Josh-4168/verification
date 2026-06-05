
package controller;
import dao.UserDAO; 
import dao.VerificationDAO;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VerificationCode;

@WebServlet(name = "VerifyCodeServlet", urlPatterns = {"/VerifyCodeServlet"})
public class VerifyCodeServlet extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String phone = (String) request.getSession() .getAttribute("fullPhone"); 
        String code = request.getParameter("code"); 
        System.out.println("Phone = " + phone);
        System.out.println("Entered code: " + code);

 if(code != null && code.matches("^[0-9]{5,6}$")) {

        UserDAO userDAO = new UserDAO();
        int userId = userDAO.getUserId(phone);

        VerificationCode vc = new VerificationCode();
        vc.setUserId(userId);
        vc.setCode(code);

        VerificationDAO verificationDAO = new VerificationDAO();
        verificationDAO.saveCode(vc);

        response.sendRedirect("success.jsp");

    } else {

        response.sendRedirect("verify.jsp?error=1");

    }
    }

    

    }
