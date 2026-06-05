package util; 
import java.sql.Connection; 
import java.sql.DriverManager; 

public class DBConnection { 
    private static final String URL = "jdbc:mysql://localhost:3306/telegram_auth"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "41689227@dmu"; 
    public static Connection getConnection() { 
        Connection conn = null;
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection( URL, USER, PASSWORD ); 
        } catch (Exception e) { e.printStackTrace(); } 
        return conn; } }