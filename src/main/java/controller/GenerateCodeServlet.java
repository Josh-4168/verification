
package controller;
import dao.UserDAO;
import dao.VerificationDAO; 
import model.VerificationCode;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "GenerateCodeServlet", urlPatterns = {"/GenerateCodeServlet"})
public class GenerateCodeServlet extends HttpServlet {

    
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String phone = request.getParameter("phone"); 
       String code = request.getParameter("code"); 
       UserDAO userDAO = new UserDAO(); 
       int userId = userDAO.getUserId(phone); 
       VerificationCode vc = new VerificationCode( userId, code );
       VerificationDAO dao = new VerificationDAO();
       boolean status = dao.saveCode(vc); 
       if(status) { response.getWriter() .write("CODE GENERATED");
       } else { response.getWriter() .write("FAILED"); }
    }

}
