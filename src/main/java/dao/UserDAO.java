package dao; 
import model.User; 
import util.DBConnection; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 

public class UserDAO { 
    public boolean saveUser(User user) {
        boolean status = false;
        try { 
            Connection conn = DBConnection.getConnection(); 
            String sql = "INSERT INTO users(phone_number) VALUES(?)"; 
            PreparedStatement ps = conn.prepareStatement(sql); 
            ps.setString(1, user.getPhoneNumber()); 
            int rows = ps.executeUpdate(); 
            if(rows > 0) { 
                status = true; } }
        catch (Exception e) { e.printStackTrace(); } 
        return status; } 
    public int getUserId(String phoneNumber) { 
        int id = 0; try { 
            Connection conn = DBConnection.getConnection(); 
            String sql = "SELECT id FROM users WHERE phone_number=?"; 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phoneNumber); 
            ResultSet rs = ps.executeQuery(); 
            if(rs.next()) { 
                id = rs.getInt("id"); } }
        catch (Exception e) { e.printStackTrace(); }
        return id; } }