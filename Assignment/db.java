import java.sql.*;
class db{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection test = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "th_e_grea_t", "12345Qwert");
            System.out.println("Connection to db established");
            Statement stmt = test.createStatement();
            ResultSet rs = stmt.executeQuery("select * from emp");
            while(rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
            test.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
}