package controller;

import dao.VerificationDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "DeleteVerificationServlet", urlPatterns = {"/DeleteVerificationServlet"})
public class DeleteVerificationServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id =
            Integer.parseInt(request.getParameter("id"));

        VerificationDAO dao =
            new VerificationDAO();

        dao.deleteVerification(id);

        response.sendRedirect("admin-dashboard.jsp");
    }
    }
