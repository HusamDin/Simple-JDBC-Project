package StudentTabs;

import Database.StudentDataBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentAddTab extends JPanel implements ActionListener
{
    
    private JLabel fNameLbl, sNameLbl, departLbl,addLbl;
    private JTextField fNameFld, sNameFld, addFld, departFld;
    private JButton addBtn;
    
    public StudentAddTab()
    {
        setLayout(null);
        showStudentAddTab();
        
//      Initiallizing
        
//        fNameLbl = new JLabel("First Name");
//        fNameLbl.setBounds(20, 20, 75, 25);
//        fNameFld = new JTextField();
//        fNameFld.setBounds(105,20,125,25);
//        
//        sNameLbl = new JLabel("Second Name");
//        sNameLbl.setBounds(20, 50, 80,25);
//        sNameFld = new JTextField();
//        sNameFld.setBounds(105, 50, 125,25);
//        
//        addLbl = new JLabel("Address");
//        addLbl.setBounds(20, 80, 75, 25);
//        addFld = new JTextField();
//        addFld.setBounds(105, 80, 125, 25);
//        
//        departLbl = new JLabel("Department");
//        departLbl.setBounds(20, 110, 80, 25);
//        departFld = new JTextField();
//        departFld.setBounds(105, 110, 125, 25);
//        
//        addBtn = new JButton("Add");
//        addBtn.setBounds(105, 140, 75, 25);
//        addBtn.addActionListener(this);
        
//      Adding
        
//        add(fNameLbl);
//        add(fNameFld);
//        
//        add(sNameLbl);
//        add(sNameFld);
//        
//        add(addLbl);
//        add(addFld);
//        
//        add(departLbl);
//        add(departFld);
//        
//        add(addBtn);
    }
    
    public void showStudentAddTab()
    {
//      Initiallizing
        
        fNameLbl = new JLabel("First Name");
        fNameLbl.setBounds(20, 20, 75, 25);
        fNameFld = new JTextField();
        fNameFld.setBounds(105,20,125,25);
        
        sNameLbl = new JLabel("Second Name");
        sNameLbl.setBounds(20, 50, 80,25);
        sNameFld = new JTextField();
        sNameFld.setBounds(105, 50, 125,25);
        
        addLbl = new JLabel("Address");
        addLbl.setBounds(20, 80, 75, 25);
        addFld = new JTextField();
        addFld.setBounds(105, 80, 125, 25);
        
        departLbl = new JLabel("Department");
        departLbl.setBounds(20, 110, 80, 25);
        departFld = new JTextField();
        departFld.setBounds(105, 110, 125, 25);
        
        addBtn = new JButton("Add");
        addBtn.setBounds(105, 140, 75, 25);
        addBtn.addActionListener(this);
        
//      Adding
        
        add(fNameLbl);
        add(fNameFld);
        
        add(sNameLbl);
        add(sNameFld);
        
        add(addLbl);
        add(addFld);
        
        add(departLbl);
        add(departFld);
        
        add(addBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        StudentDataBase.insertStudent(fNameFld.getText(), sNameFld.getText(), addFld.getText(), departFld.getText());
        JOptionPane.showMessageDialog(null, "Student " + " " + fNameFld.getText() + " " + sNameFld.getText() + " Added Successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
