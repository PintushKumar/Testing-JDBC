import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/testing_JDBC";
        String username = "root";
        String password = "Pintush@12345";
        String query = "select * from student;";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println();
            System.out.println("Drivers Loaded Successfully ...... ");
        }catch (ClassNotFoundException e){
            System.out.println("Drivers not Loaded Successfully ... "+e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url , username , password);
            System.out.println();
            System.out.println("Connection Established Successfully.. ");
            System.out.println();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                String salary = rs.getString("salary");
                System.out.println("========================+============================");
                System.out.println();
                System.out.println("\tid : "+id+"\tname : "+name+"\tjob-title : "+job_title+"\tsalary : "+salary);
                System.out.println("========================+============================");
            }

            con.close();
            stmt.close();
            rs.close();
            System.out.println();
            System.out.println("Closing Successfully all the Connection After Completed work ... ");
            System.out.println();

        }catch (SQLException e){
            System.out.println("Connection not Established Successfully.. "+e.getMessage());
        }
    }
}