package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnectionUtil {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "root");
        System.out.println(conn);
 
    }

}
