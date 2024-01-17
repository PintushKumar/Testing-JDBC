import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/testing_JDBC";
        String username = "root";
        String password = "Pintush@12345";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully ...... ");
        }catch (ClassNotFoundException e){
            System.out.println("Drivers not Loaded Successfully ... "+e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url , username , password);
            System.out.println("Connection Established Successfully.. ");
        }catch (SQLException e){
            System.out.println("Connection not Established Successfully.. "+e.getMessage());
        }
    }
}