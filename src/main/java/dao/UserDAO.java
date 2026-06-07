package dao; 
import model.User; 
import util.DBConnection; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 

public class UserDAO { 
   public boolean saveUser(User user) {

    String sql = "INSERT INTO users(phone_number) VALUES(?)";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setString(1, user.getPhoneNumber());

        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}public int getUserId(String phoneNumber) {

    String sql = "SELECT id FROM users WHERE phone_number=?";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setString(1, phoneNumber);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("id");
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}
public boolean phoneExists(String phoneNumber) {

    String sql = "SELECT id FROM users WHERE phone_number=?";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setString(1, phoneNumber);

        try (ResultSet rs = ps.executeQuery()) {
            return rs.next();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
}