package dao; 
import model.VerificationCode; 
import util.DBConnection; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList;
import java.util.List;
import model.VerificationRecord;

public class VerificationDAO {
   public boolean saveCode(VerificationCode vc) {

    String sql =
        "INSERT INTO verification_codes(user_id, code, status) VALUES(?,?,?)";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setInt(1, vc.getUserId());
        ps.setString(2, vc.getCode());
        ps.setString(3, "PENDING");

        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
} 
   public boolean verifyCode(int userId, String code) {

    String sql =
        "SELECT * FROM verification_codes " +
        "WHERE user_id=? AND code=? AND status='PENDING'";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setInt(1, userId);
        ps.setString(2, code);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                String update =
                    "UPDATE verification_codes SET status='USED' WHERE id=?";

                try (PreparedStatement ups =
                         conn.prepareStatement(update)) {

                    ups.setInt(1, rs.getInt("id"));
                    ups.executeUpdate();
                }

                return true;
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
public List<VerificationRecord> getAllVerifications() {

    List<VerificationRecord> list = new ArrayList<>();

    String sql =
        "SELECT u.id AS user_id, " +
        "u.phone_number, " +
        "v.code, " +
        "v.created_at " +
        "FROM users u " +
        "LEFT JOIN verification_codes v ON u.id = v.user_id " +
        "ORDER BY u.id DESC";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()
    ) {

        while (rs.next()) {

            list.add(
                new VerificationRecord(
                    rs.getInt("user_id"),
                    rs.getString("phone_number"),
                    rs.getString("code"),
                    rs.getTimestamp("created_at")
                )
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
public int getTotalPhones() {

    String sql = "SELECT COUNT(*) FROM users";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()
    ) {

        if (rs.next()) {
            return rs.getInt(1);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}
public int getTotalCodes() {

    String sql = "SELECT COUNT(*) FROM verification_codes";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()
    ) {

        if (rs.next()) {
            return rs.getInt(1);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}
public int getTodayCodes() {

    String sql =
        "SELECT COUNT(*) FROM verification_codes " +
        "WHERE DATE(created_at)=CURDATE()";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()
    ) {

        if (rs.next()) {
            return rs.getInt(1);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}
public boolean deleteVerification(int userId) {

    String sql1 =
        "DELETE FROM verification_codes WHERE user_id=?";

    String sql2 =
        "DELETE FROM users WHERE id=?";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        PreparedStatement ps2 = conn.prepareStatement(sql2)
    ) {

        ps1.setInt(1, userId);
        ps1.executeUpdate();

        ps2.setInt(1, userId);

        return ps2.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
}