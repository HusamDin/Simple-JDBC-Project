package StudentTabs;

import static Database.StudentDataBase.updateStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentUpdateTab extends JPanel implements ActionListener{
    
   private JLabel fNameLbl, sNameLbl, addLbl,  departLbl, idLbl;
   private JTextField fNameFld, sNameFld, addFld, departFld, idFld;
   private JButton updateBtn;
   
   public StudentUpdateTab()
   {
       setLayout(null);
       showStudentUpdateTab();
   }
   
   public void showStudentUpdateTab()
   {
        idLbl = new JLabel("ID");
        idLbl.setBounds(20, 10, 75, 25);
        idFld = new JTextField();
        idFld.setBounds(105, 10, 125, 25);
        
        fNameLbl = new JLabel("First Name");
        fNameLbl.setBounds(20, 40, 75, 25);
        fNameFld = new JTextField();
        fNameFld.setBounds(105,40,125,25);
        
        sNameLbl = new JLabel("Last Name");
        sNameLbl.setBounds(20, 70, 80,25);
        sNameFld = new JTextField();
        sNameFld.setBounds(105, 70, 125,25);
        
        addLbl = new JLabel("Address");
        addLbl.setBounds(20, 100, 75, 25);
        addFld = new JTextField();
        addFld.setBounds(105, 100, 125, 25);
        
        departLbl = new JLabel("Department");
        departLbl.setBounds(20, 130, 80, 25);
        departFld = new JTextField();
        departFld.setBounds(105, 130, 125, 25);
        
        updateBtn = new JButton("Update");
        updateBtn.setBounds(105, 160, 75, 25);
        updateBtn.addActionListener(this);
        
        
        
//      Adding
        
        add(idLbl);
        add(idFld);
        
        add(fNameLbl);
        add(fNameFld);
        
        add(sNameLbl);
        add(sNameFld);
        
        add(addLbl);
        add(addFld);
        
        add(departLbl);
        add(departFld);
        
        add(updateBtn);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        updateStudent(Integer.parseInt(idFld.getText()), fNameFld.getText(), sNameFld.getText(), addFld.getText(), departFld.getText());
        JOptionPane.showMessageDialog(null, "Student Updated", "Updated", JOptionPane.PLAIN_MESSAGE);
    }
}