package dao; 
import model.VerificationCode; 
import util.DBConnection; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 

public class VerificationDAO {
    public boolean saveCode(VerificationCode vc) {
        boolean status = false;
        try { Connection conn = DBConnection.getConnection(); 
        String sql = "INSERT INTO verification_codes(user_id, code, status) VALUES(?,?,?)"; 
        PreparedStatement ps = conn.prepareStatement(sql); 
        ps.setInt(1, vc.getUserId()); 
        ps.setString(2, vc.getCode());
        ps.setString(3, "PENDING"); 
        int rows = ps.executeUpdate(); 
        if(rows > 0) { status = true; } } 
        catch (Exception e) { e.printStackTrace(); } 
        return status; } 
    public boolean verifyCode(int userId, String code) { 
        boolean valid = false; 
        try { Connection conn = DBConnection.getConnection(); 
        String sql = "SELECT * FROM verification_codes WHERE user_id=? AND code=? AND status='PENDING'"; 
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userId);
        ps.setString(2, code);
        ResultSet rs = ps.executeQuery(); 
        if(rs.next()) { valid = true;
        String update = "UPDATE verification_codes SET status='USED' WHERE id=?"; 
        PreparedStatement ups = conn.prepareStatement(update);
        ups.setInt(1, rs.getInt("id"));
        ups.executeUpdate(); } } catch (Exception e) { e.printStackTrace(); }
        return valid; } }