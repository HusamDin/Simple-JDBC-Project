package StudentTabs;

import Database.StudentDataBase;
import Domain.Students;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableCellRenderer;

public class StudentShowTab extends JPanel{
    
    JTable table;
    String[] header = {"ID", "First Name", "Last Name", "Department", "Degree"};
    String [][] data;
    JScrollPane sc;
    ArrayList<Students> list;
    int x;
    
    JButton print;
    
    public StudentShowTab(String department)
    {
        list = StudentDataBase.getStudentsDegree(department);
        setLayout(null);
        showStudentShowTab();

    }
    
    public void showStudentShowTab()
    {
        
        data = new String[list.size()][5];
        
        for(int i=0; i<data.length; i++)
        {
            data[i][0] = "" + list.get(i).getId();
            data[i][1] = list.get(i).getfName();
            data[i][2] = list.get(i).getlName();
            data[i][3] = list.get(i).getDepartment();
            data[i][4] = list.get(i).getAddress();
        }
        
        table = new JTable(data, header);
        sc = new JScrollPane(table);
        sc.setBounds(0,0,900,300);
        add(sc);
        
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int)JLabel.CENTER);
        DefaultTableCellRenderer v = new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for(int i=0; i<table.getColumnCount(); i++)
        {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
        table.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {   
                x = table.getSelectedRow();
                    System.out.println("Student " + list.get(x).getfName() + "'s Degree");
            }
        });
        
        print = new JButton("Print");
        print.setBounds(377,330,125,25);
        print.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                MessageFormat h = new MessageFormat("Student " + list.get(x).getfName() + "'s Degree");
                MessageFormat f = new MessageFormat("Page 1");
                
                try {
                    table.print(PrintMode.NORMAL,h,f);
                } catch (PrinterException ex) {
                    Logger.getLogger(StudentShowTab.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }

            
        });
        add(print);
    }
}