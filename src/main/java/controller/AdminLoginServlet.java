
package controller;
import util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException; 
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/AdminLoginServlet"})
public class AdminLoginServlet extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       try { Connection conn = DBConnection.getConnection();
       String sql = "SELECT * FROM admins WHERE username=? AND password_hash=?";
       PreparedStatement ps = conn.prepareStatement(sql); 
       ps.setString(1, username);
       ps.setString(2, password);
       ResultSet rs = ps.executeQuery(); 
       if(rs.next()) { 
           HttpSession session = request.getSession();
           session.setAttribute( "admin", username ); 
           response.sendRedirect( "admin-dashboard.jsp" );
       } else { response.getWriter() .write("INVALID LOGIN"); } }
       catch (Exception e) { e.printStackTrace(); }
    }

   
}
