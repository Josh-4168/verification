
package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;

@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String oldPassword =
                request.getParameter("oldPassword");

        String newPassword =
                request.getParameter("newPassword");

        HttpSession session =
                request.getSession();

        String username =
                (String) session.getAttribute("admin");
System.out.println("Admin = " + username);
System.out.println("Old Password = " + oldPassword);
System.out.println("New Password = " + newPassword);
        try {

            Connection conn =
                    DBConnection.getConnection();

            String checkSql =
                    "SELECT * FROM admins " +
                    "WHERE username=? AND password_hash=?";

            PreparedStatement checkPs =
                    conn.prepareStatement(checkSql);

            checkPs.setString(1, username);
            checkPs.setString(2, oldPassword);

            ResultSet rs =
                    checkPs.executeQuery();

            if(rs.next()) {

                String updateSql =
                        "UPDATE admins " +
                        "SET password_hash=? " +
                        "WHERE username=?";

                PreparedStatement updatePs =
                        conn.prepareStatement(updateSql);

                updatePs.setString(1, newPassword);
                updatePs.setString(2, username);

                int rows =
                        updatePs.executeUpdate();

                if(rows > 0) {

                    response.sendRedirect(
                        "change-password.jsp?success=1"
                    );

                } else {

                    response.sendRedirect(
                        "change-password.jsp?error=1"
                    );

                }

            } else {

                response.sendRedirect(
                    "change-password.jsp?error=wrongpassword"
                );

            }

        } catch(Exception e) {

            e.printStackTrace();

            response.sendRedirect(
                "change-password.jsp?error=database"
            );
        }
    }
    }
