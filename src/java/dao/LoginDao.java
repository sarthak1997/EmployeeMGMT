package dao;

import java.sql.*;
import model.Loginmodel;
import myConnection.MyCon;

public class LoginDao  {
    Connection con=null;
    String sql;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public boolean checkLoginUser(Loginmodel L) throws Exception
    {
        
    con=MyCon.getConnection();
    sql="select * from logindb where username=? and password=?";
    ps=con.prepareStatement(sql);
    ps.setString(1, L.getName());
    ps.setString(2, L.getPassword());
    rs=ps.executeQuery();
    if(rs.next())
        return true;
    return false;
    }
    public boolean checkLoginAdmin(String A,String P) throws Exception
    {
    if(A.equals("Manjan") && P.equals("s123456j"))
        return true;
    return false;
    }
}
