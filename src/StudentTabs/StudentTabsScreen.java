package StudentTabs;

import Database.UserDataBase;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import jdbc.pkgfinal.project.Staff;

public class StudentTabsScreen extends JFrame{
    
    String department;
    
    private static JTabbedPane tabs;
    
    public StudentTabsScreen(String department) 
    {
        this.department = department;
        
//        System.out.println(department);

    }
    
    public void showStudentTabsScreen()
    {
        StudentAddTab sat = new StudentAddTab();
        StudentDegreeTab sdt = new StudentDegreeTab(department);
        StudentShowTab sst = new StudentShowTab(department);
        StudentUpdateTab sut = new StudentUpdateTab();
        DegreeUpdateTab dut = new DegreeUpdateTab();
        
        
        tabs = new JTabbedPane();
        tabs.addTab("Add A Student", sat);
        tabs.addTab("Add Degree For A Student", sdt);
        tabs.addTab("Show Students With Degree", sst);
        tabs.addTab("Update Student", sut);
        tabs.addTab("Update Degree", dut);
        
        add(tabs);
        
        setTitle("Tabs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,500);
        setResizable(false);
        setVisible(true);
    }
}
