package dao;

import util.DBConnection;
import java.sql.*;

public class AdminDAO {

    public boolean login(String username, String password){

        boolean valid = false;

        try{

            Connection conn = DBConnection.getConnection();

            String sql =
                "SELECT * FROM admins WHERE username=? AND password_hash=?";

            PreparedStatement ps =
                conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                valid = true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return valid;
    }
}
