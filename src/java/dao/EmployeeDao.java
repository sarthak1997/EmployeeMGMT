
package dao;
import model.Employee;
import java.sql.*;
import java.util.*;
import java.util.List;
import myConnection.MyCon;
public class EmployeeDao {
    
    String sql;
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public boolean insertEmployee(Employee S) throws Exception
    {
    con=MyCon.getConnection();
    sql="insert into employeedb values(?,?,?,?)";
    ps=con.prepareStatement(sql);
    ps.setInt(1,S.getEid());
    ps.setString(2, S.getEname());
    ps.setString(3,S.getEdept());
    ps.setLong(4, S.getEsalary());
        return ps.executeUpdate()>0;
    }
    public boolean deleteEmployee (int eid) throws Exception
    {
    sql="delete from employeedb where eID=?";
    con=MyCon.getConnection();
    ps=con.prepareStatement(sql);
    ps.setInt(1,eid);
    return ps.executeUpdate()>0;
    
    }
    public Employee searchEmployee(int eid)throws Exception
    {
    sql="select * from employeedb where eID=?";
    con=MyCon.getConnection();
    ps=con.prepareStatement(sql);
    ps.setInt(1,eid);
    rs=ps.executeQuery();
    Employee S=new Employee();
    if(rs.next())
    {
        S.setEid(rs.getInt(1));
    S.setEname(rs.getString(2));
    S.setEdept(rs.getString(3));
    S.setEsalary(rs.getLong(4));
    return S;
    }
    else
        return null;
    }
    public List<Employee> showAll()throws Exception
    {
       
    sql="select * from employeedb";
    con=MyCon.getConnection();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    List<Employee> mylist=new ArrayList();
    
    while(rs.next())
    {
        Employee S = new Employee(); 
        S.setEid(rs.getInt(1));
        S.setEname(rs.getString(2));
        S.setEdept(rs.getString(3));
        S.setEsalary(rs.getLong(4));
        mylist.add(S);     
    }
    return mylist;
    
        
    }
    public boolean update (Employee S)throws Exception
    {
    sql="update employeedb set ename=? ,edept=?, esalary=? where eID=?";
    con=MyCon.getConnection();
    ps=con.prepareStatement(sql);
    ps.setString(1, S.getEname());
    ps.setString(2, S.getEdept());
    ps.setLong(3, S.getEsalary());
    ps.setInt(4, S.getEid());

    return ps.executeUpdate()>0;
    }
    
}
