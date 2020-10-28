package StudentTabs;

import Database.DegreeDataBase;
import Database.StudentDataBase;
import Domain.Students;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class StudentDegreeTab extends JPanel
{
    
    JTable table;
    String [] header = {"First Name", "Last Name", "Department"};
    String [][] tableArr;
    ArrayList<Students> list;
    ScrollPane sc;
    
    int x;
    
    JLabel subLbl1, subLbl2, subLbl3, subLbl4, subLbl5, subLbl6;
    JTextField subFld1, subFld2, subFld3, subFld4, subFld5, subFld6;
    JButton addBtn;
    
    public StudentDegreeTab(String department) 
    {
//        System.out.println(department);
        
        list = StudentDataBase.getStudents(department);
        setLayout(null);
        showStudentDegreeTab();

    }
    
    public void showStudentDegreeTab() 
    {
        //Initalizing Components
        
        //Table
        
        tableArr = new String [list.size()][3];
        
        for(int i=0; i<tableArr.length; i++)
        {
            tableArr[i][0] = "" + list.get(i).getId();
            tableArr[i][1] = list.get(i).getfName();
            tableArr[i][2] = list.get(i).getlName();
        }
        
        table = new JTable(tableArr, header);
        sc = new ScrollPane();
        sc.add(table);
        sc.setBounds(0, 0, 900,100);
        add(sc);
        
//        Table Configuration, Alignment
        
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int)JLabel.CENTER);
        DefaultTableCellRenderer v = new DefaultTableCellRenderer();
        v.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(v);
        for(int i=0; i<table.getColumnCount(); i++)
        {
            table.getColumnModel().getColumn(i).setCellRenderer(v);
        }
        
//        Table Configuration, Orientation Whether For English Or Arabic
        
        table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
//        Table Event
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt)
            {
                x = table.getSelectedRow();
            }
        });
         
//        Subjects Labels, Fields And Button
        
        subLbl1 = new JLabel("OOP");
        subLbl2 = new JLabel("Data Structure");
        subLbl3 = new JLabel("Data Base");
        subLbl4 = new JLabel("Algorithms");
        subLbl5 = new JLabel("Problem Solving");
        subLbl6 = new JLabel("Android");
        
        subFld1 = new JTextField();
        subFld2 = new JTextField();
        subFld3 = new JTextField();
        subFld4 = new JTextField();
        subFld5 = new JTextField();
        subFld6 = new JTextField();
        
        addBtn = new JButton("Add");
        
//        Setting Labels, Fields And Button Bounds And Event
        
        subLbl1.setBounds(5,130,50,25);
        subFld1.setBounds(110,130,125,25);
        
        subLbl2.setBounds(5,165,100,25);
        subFld2.setBounds(110,165,125,25);
        
        subLbl3.setBounds(5,200,100,25);
        subFld3.setBounds(110,200,125,25);
        
        subLbl4.setBounds(5,235,100,25);
        subFld4.setBounds(110,235,125,25);
        
        subLbl5.setBounds(5,270,125,25);
        subFld5.setBounds(110,270,125,25);
        
        subLbl6.setBounds(5,305,75,25);
        subFld6.setBounds(110,305,125,25);
        
        addBtn.setBounds(5,345,230,25);
        addBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int id = list.get(x).getId();
                DegreeDataBase.insertDegree(id, Integer.parseInt(subFld1.getText()), Integer.parseInt(subFld2.getText()), Integer.parseInt(subFld3.getText()), Integer.parseInt(subFld4.getText()), Integer.parseInt(subFld5.getText()), Integer.parseInt(subFld6.getText()));
                JOptionPane.showMessageDialog(null, "Degree Added", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
        });
        
        //Adding Components
        
        add(subLbl1);
        add(subLbl2);
        add(subLbl3);
        add(subLbl4);
        add(subLbl5);
        add(subLbl6);
        
        add(subFld1);
        add(subFld2);
        add(subFld3);
        add(subFld4);
        add(subFld5);
        add(subFld6);
        
        add(addBtn);
    }
}