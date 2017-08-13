
package myConnection;
import java.sql.*;
public class MyCon {
    static Connection con=null;
    public static Connection getConnection() throws Exception
    {
        try{
    Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Driver loaded");

    }
        catch(ClassNotFoundException e)
        {
        System.out.println(e);
                
        }
        try{
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
                //System.out.println("db connected");

        }
        catch(SQLException e)
        {
                System.out.println(e);

        }
        return con;
    }
}
