package Controller;
import java.sql.*;


public class database {
    Connection conn1 = null;
    
    public Connection connection(){
        try {
            String url1 = "jdbc:mysql://localhost:3306/personal";
            String user = "root";
            String password = "";

            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database test1");
            }

        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return conn1;
    }


    public void close(){
        if (conn1 != null) {
            try {
                conn1.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
