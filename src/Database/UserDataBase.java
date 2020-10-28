package Database;

import Domain.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDataBase
{
    public static Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:sqlite:Staff.db");
    }
    
    public static void insertUser(String userName, String pass, String depart)
    {
        try
        (
            Connection con = connect();
            PreparedStatement ps = con.prepareStatement("insert into Users values(?,?,?)");
        )
        {
        ps.setString(1, userName);
        ps.setString(2, pass);
        ps.setString(3, depart);    //This Order Must Be The Same Of The Table. If I Don't Remember Then I Will Make The Insert Queery More Specific Like This insert into Users(user_name,Password,Department) values(?,?,?)
        
        ps.execute();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
//     Without Closing The DB, The Method Will Bring A Lot Of Errors.
    
    public static ArrayList<Users> getUsers()
    {
        ArrayList<Users> list = new ArrayList<>();

        try
        (
            Connection con = connect();
            PreparedStatement ps = con.prepareStatement("select * from Users");
            ResultSet rs = ps.executeQuery();
        )
        
        {
            while(rs.next())
            {
                list.add(new Users(rs.getString("user_name"), rs.getString("Password"), rs.getString("Department")));
            }
        }       
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
    public static int checkUser(String userName, String pass)
    {
        int x = 0;
        
            ArrayList<Users> list = getUsers();
            
            for(int i=0; i<list.size(); i++)
            {
                if(list.get(i).getUserName().equalsIgnoreCase(userName))
                {
                    if(list.get(i).getPass().equalsIgnoreCase(pass))
                    {
                        x = 1;
                        break;
                    }
                    else
                    {
                        x = 2;
                        break;
                    }
                }
                else
                {
                    x = 0;
                }
            }
        return x;
    }
    
    public static String getUserDepart(String userNameFld)
    {
        try
        (
            Connection con = connect();
            PreparedStatement ps = con.prepareStatement("select Department from Users where user_name = ? ");
        )
        {
            ps.setString(1, userNameFld);
            ResultSet rs = ps.executeQuery();
            return rs.getString("Department");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
