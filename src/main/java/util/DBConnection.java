package util; 
import java.sql.Connection; 
import java.sql.DriverManager; 

public class DBConnection { 
    
    private static final String URL =
    "jdbc:mysql://sql5.freesqldatabase.com:3306/sql5829510?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

private static final String USER = "sql5829510";

private static final String PASSWORD = "cVxMCckjQH";
    public static Connection getConnection() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
            URL,
            USER,
            PASSWORD
        );

    } catch (Exception e) {
        System.out.println("DATABASE CONNECTION FAILED");
        e.printStackTrace();
        return null;
    }
}}