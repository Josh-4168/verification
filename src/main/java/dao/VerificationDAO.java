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
        System.out.println("Searching...");
System.out.println("userId = " + userId);
System.out.println("code = " + code);
        ResultSet rs = ps.executeQuery(); 
        if(rs.next()) { System.out.println("MATCH FOUND");
        valid = true;
        String update = "UPDATE verification_codes SET status='USED' WHERE id=?"; 
        PreparedStatement ups = conn.prepareStatement(update);
        ups.setInt(1, rs.getInt("id"));
        int rows =ups.executeUpdate();System.out.println("Updated rows = " + rows); }else{System.out.println("NO MATCH FOUND");} } catch (Exception e) { e.printStackTrace(); }
        return valid; }
public ResultSet getAllVerifications() {

    try {
        Connection conn = DBConnection.getConnection();
System.out.println("NEW QUERY RUNNING");

String sql =
    "SELECT u.id AS user_id, " +
    "u.phone_number, " +
    "v.id AS verification_id, " +
    "v.code, " +
    "v.created_at " +
    "FROM users u " +
    "LEFT JOIN verification_codes v ON u.id = v.user_id " +
    "ORDER BY u.id DESC";

        PreparedStatement ps = conn.prepareStatement(sql);

        return ps.executeQuery();

    } catch(Exception e) {
        e.printStackTrace();
    }

    return null;
}
public int getTotalPhones(){

    int count = 0;

    try{
        Connection conn = DBConnection.getConnection();

        String sql = "SELECT COUNT(*) FROM users";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            count = rs.getInt(1);
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return count;
}
public int getTotalCodes(){

    int count = 0;

    try{
        Connection conn = DBConnection.getConnection();

        String sql = "SELECT COUNT(*) FROM verification_codes";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            count = rs.getInt(1);
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return count;
}
public int getTodayCodes(){

    int count = 0;

    try{
        Connection conn = DBConnection.getConnection();

        String sql =
        "SELECT COUNT(*) FROM verification_codes " +
        "WHERE DATE(created_at)=CURDATE()";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            count = rs.getInt(1);
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return count;
}
public boolean deleteVerification(int userId){

    boolean deleted = false;

    try{
        Connection conn = DBConnection.getConnection();

        String sql1 =
            "DELETE FROM verification_codes WHERE user_id=?";

        PreparedStatement ps1 =
            conn.prepareStatement(sql1);

        ps1.setInt(1, userId);
        ps1.executeUpdate();

        String sql2 =
            "DELETE FROM users WHERE id=?";

        PreparedStatement ps2 =
            conn.prepareStatement(sql2);

        ps2.setInt(1, userId);

        int rows = ps2.executeUpdate();

        if(rows > 0){
            deleted = true;
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return deleted;
}
}