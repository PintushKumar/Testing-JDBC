import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/testing_JDBC";
        String username = "root";
        String password = "Pintush@12345";
        String query = "insert into student(id , name , job_title , salary)  values\n" +
                "(3 , 'Juli','Software Developer' , 15000000),\n" +
                "(4 , 'Neha Soni','Web Developer' , 25000000);";


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
            int row= stmt.executeUpdate(query);
            if(row>0){
                System.out.println();
                System.out.println("Inserted Your Data's  Successfully...");
            }else{
                System.out.println();
                System.out.println("Not Inserted Your Data's...");
            }

            con.close();
            stmt.close();
            System.out.println();
            System.out.println("Closing Successfully all the Connection After Completed work ... ");
            System.out.println();

        }catch (SQLException e){
            System.out.println("Connection not Established Successfully.. "+e.getMessage());
        }
    }
}