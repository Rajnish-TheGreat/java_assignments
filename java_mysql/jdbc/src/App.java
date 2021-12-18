import java.sql.*;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "12345Qwert");
            System.out.println("Connection to db established");
            Statement stmt1 = con.createStatement();
            stmt1.executeUpdate("insert into emp(emp_name,emp_salary) " + "values('Python',850000)");
            System.out.println("One record is inserted");
            Statement stmt2 = con.createStatement(); 
            ResultSet rs = stmt2.executeQuery("select * from emp");
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
            }
            con.close();
        } 
        catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
}