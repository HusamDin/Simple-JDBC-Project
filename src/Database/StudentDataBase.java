package Database;

import Domain.Students;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDataBase {
   
    public static Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:sqlite:Staff.db");
    }
    
    public static ArrayList<Students> getStudents(String department)
    {
        ArrayList<Students> list = new ArrayList<>();
        try
        (
            Connection con = connect();
            PreparedStatement ps = con.prepareStatement("select * from Students where department = ? ");
        )
        {
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                list.add(new Students(rs.getInt("ID"), rs.getString("fName"), rs.getString("lName"), rs.getString("Address"), rs.getString("Department")));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public static void insertStudent(String fName, String lName, String address, String department)
    {
        try
        (
            Connection con = connect();
            PreparedStatement ps = con.prepareStatement("insert into Students (fName, lName, Address, Department) values(?,?,?,?)");
        )
        {
            ps.setString(1,fName);
            ps.setString(2,lName);
            ps.setString(3,address);
            ps.setString(4,department);
            ps.execute();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Students> getStudentsDegree(String department)
    {
        ArrayList<Students> list = new ArrayList<>();
        
        try
        (
            Connection c = connect();
            PreparedStatement ps = c.prepareStatement("select * from Students,Degree where Students.id=Degree.id AND department = ? ");
        )
        {
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                list.add(new Students(rs.getInt("ID"), rs.getString("fName"), rs.getString("lName"), rs.getString("SUM")+"", rs.getString("Department")));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
        public static void updateStudent(int id, String fName, String sName, String address, String depart)
        {
            try
            (
                Connection c = connect();
                PreparedStatement ps = c.prepareStatement("update Students set fName = ?, lName = ?, Address = ?, Department = ? where id = ?");
            )
            {
                ps.setString(1, fName);
                ps.setString(2, sName);
                ps.setString(3, address);
                ps.setString(4, depart);
                ps.setInt(5, id);
                ps.execute();
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
}