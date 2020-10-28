package Database;

import Domain.Degree;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DegreeDataBase {
    
    public static Connection connect() throws SQLException 
    {
        return DriverManager.getConnection("jdbc:sqlite:Staff.db");
    }
    
    public static void insertDegree(int id, int sub1, int sub2, int sub3, int sub4, int sub5, int sub6)
    {
        try
        {
            Connection con = connect();
            PreparedStatement ps = con.prepareStatement("insert into Degree values(?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, id);
            ps.setInt(2, sub1);
            ps.setInt(3, sub2);
            ps.setInt(4, sub3);
            ps.setInt(5, sub4);
            ps.setInt(6, sub5);
            ps.setInt(7, sub6);
            ps.setInt(8, sub1+sub2+sub3+sub4+sub5+sub6);
            ps.execute();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Degree> getDegree(int id)
    {
        ArrayList<Degree> list = new ArrayList<>();
        try
        (
            Connection c = connect();
            PreparedStatement ps = c.prepareStatement("select * from Degree where id = ?");
        )
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                list.add(new Degree(rs.getString("Sub1"), rs.getString("Sub2"), rs.getString("Sub3"), rs.getString("Sub4"), rs.getString("Sub5"), rs.getString("Sub6")));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public static void updateDegree(int id, String sub1, String sub2, String sub3, String sub4, String sub5, String sub6)
    {
        try
        (
            Connection c = connect();
            PreparedStatement ps = c.prepareStatement("update Degree set Sub1 = ?, Sub2 = ?, Sub3 = ?,  Sub4 = ?, Sub5 = ?, Sub6 = ?, SUM = ? where id = ? ");
        )
        {
            ps.setString(1, sub1);
            ps.setString(2, sub2);
            ps.setString(3, sub3);
            ps.setString(4, sub4);
            ps.setString(5, sub5);
            ps.setString(6, sub6);
            ps.setInt(7, Integer.parseInt(sub1)+Integer.parseInt(sub2)+Integer.parseInt(sub3)+Integer.parseInt(sub4)+Integer.parseInt(sub5)+Integer.parseInt(sub5));
            ps.setInt(8, id);
            
            ps.execute();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
