package jdbc.pkgfinal.project;

import Database.UserDataBase;
import Domain.Users;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class SignUpScreen extends JFrame implements ActionListener{
    
    LoginBackground lb = new LoginBackground();
    
    JLabel userNameLbl, passLbl, depart, note, lbl, lbl2;
    JTextField userNameFld, passFld, departFld;
    JButton signUp, back;
    
    public void showSignUpScreen()
    {
//      Initializing Components
        
        userNameLbl = new JLabel("Username");
        userNameLbl.setBounds(325, 150, 75, 25);
        
        userNameFld = new JTextField();
        userNameFld.setBounds(405, 150, 200, 25);
        
        passLbl = new JLabel("Password");
        passLbl.setBounds(325, 200, 75, 25);
        
        passFld = new JTextField();
        passFld.setBounds(405, 200, 200, 25);
        
        depart = new JLabel("Department");
        depart.setBounds(325,250,75,25);
        
        departFld = new JTextField();
        departFld.setBounds(405,250,200,25);
        
        note = new JLabel("Please Choose IT / CS / IS ");
        note.setBounds(610,250,285,25);
        
        signUp = new JButton("Sign Up");
        signUp.setBounds(325,300,80,25);
        signUp.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(0,0,75,25);
        back.addActionListener(this);
        
        lbl = new JLabel();
        lbl.setBounds(610,150,250,25);
        lbl.setForeground(Color.red);
        
        lbl2 = new JLabel();
        lbl2.setBounds(325,273,300,25);
        lbl2.setForeground(Color.red);

        
//      Adding Components
        
        lb.add(userNameLbl);
        lb.add(userNameFld);
        
        lb.add(passLbl);
        lb.add(passFld);
        
        lb.add(depart);
        lb.add(departFld);
        
        lb.add(note);
        lb.add(lbl);
        lb.add(lbl2);
        
        lb.add(signUp);
        lb.add(back);

        
//      Setting Up The Main Form.
        
        setTitle("Trying");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(900,500);
        setVisible(true);  
        
        add(lb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     
        if(e.getSource() == back)
        {
            this.dispose();
            new Staff().showSignInScreen();
        }
        if(e.getSource() == signUp)
        {
//            ArrayList<Users> list = UserDataBase.getUsers();
            int i = UserDataBase.checkUser(userNameFld.getText(), passFld.getText());
            if(i==0)
            {
                if(departFld.getText().equalsIgnoreCase("IT") || departFld.getText().equalsIgnoreCase("CS") || departFld.getText().equalsIgnoreCase("IS"))
                {
                    UserDataBase.insertUser(userNameFld.getText(), passFld.getText(), departFld.getText());
                    JOptionPane.showMessageDialog(null, "Signed Up Successfully Doctor , " + userNameFld.getText() + " Now Sign In", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new Staff().showSignInScreen();
                }
                else
                    lbl2.setText("Please Enter One Of The Available Departments");
//                        JOptionPane,showMessageDialog(null, "Username Already Exists", "Press Ok", JOptionPane.WARNING_MESSAGE);
            }
            
            else
                lbl.setText("Username Already Exists");
        }
        
    }
}
