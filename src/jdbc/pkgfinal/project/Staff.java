package jdbc.pkgfinal.project;

import Database.UserDataBase;
import StudentTabs.StudentTabsScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Staff extends JFrame implements ActionListener{
    
    LoginBackground lb = new LoginBackground();
    
    JLabel userNameLbl, passLbl;
    JTextField userNameFld;
    JPasswordField  passFld;
    JButton signInBtn, signUpBtn;
    
    public Staff()
    {
        //        We Can't Set Layout null Here Since This Frame Contains The Panel And The Panel Contains The Image.


        //Initiallizing Components
        
//        userNameLbl = new JLabel("Username");
//        userNameLbl.setBounds(15,5,75,25);
//        
//        userNameFld = new JTextField();
//        userNameFld.setBounds(95,5,200,25);
//        
//        passLbl = new JLabel("Password");
//        passLbl.setBounds(600,5,75,25);
//        
//        passFld = new JPasswordField();
//        passFld.setBounds(680,5,200,25);
//        
//        signUpBtn = new JButton("Sign Up");
//        signUpBtn.setBounds(95,45,80,25);
//        signUpBtn.addActionListener(this);
//        
//        signInBtn = new JButton("Sign In");
//        signInBtn.setBounds(680,45,75,25);
//        signInBtn.addActionListener(this);
        
        //Adding Components To The Panel
        
//        lb.add(userNameLbl);
//        lb.add(userNameFld);
//        
//        lb.add(passLbl);
//        lb.add(passFld);
//        
//        lb.add(signInBtn);
//        lb.add(signUpBtn);
//        
//        add(lb);
        
    }
    
    
    
    public void showSignInScreen()
    {
//        We Can't Set Layout null Here Since This Frame Contains The Panel And The Panel Contains The Image.
         
        //Initiallizing Components
        
        userNameLbl = new JLabel("Username");
        userNameLbl.setBounds(15,5,75,25);
        
        userNameFld = new JTextField();
        userNameFld.setBounds(95,5,200,25);
        
        passLbl = new JLabel("Password");
        passLbl.setBounds(600,5,75,25);
        
        passFld = new JPasswordField();
        passFld.setBounds(680,5,200,25);
        
        signUpBtn = new JButton("Sign Up");
        signUpBtn.setBounds(95,45,80,25);
        signUpBtn.addActionListener(this);
        
        signInBtn = new JButton("Sign In");
        signInBtn.setBounds(680,45,75,25);
        signInBtn.addActionListener(this);

        
//        //Adding Components To The Panel
        
        lb.add(userNameLbl);
        lb.add(userNameFld);
        
        lb.add(passLbl);
        lb.add(passFld);
        
        lb.add(signInBtn);
        lb.add(signUpBtn);
        
//      Setting Up The Main Form.
        
        setTitle("Trying");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(900,500);
        setVisible(true);    
        
//      Adding The Background Panel To This Frame.
        
        add(lb);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==signUpBtn)
        {
            this.dispose();
            new SignUpScreen().showSignUpScreen();
        }
        if(e.getSource() == signInBtn)
        {
            int i = UserDataBase.checkUser(userNameFld.getText(), passFld.getText());
            switch(i)
            {
                case 1:
                    JOptionPane.showMessageDialog(null, "Signed In Successfully Doctor , " + userNameFld.getText(), "Successful", JOptionPane.INFORMATION_MESSAGE);
//                        System.out.println(UserDataBase.getUserDepart(userNameFld.getText()));
                    this.dispose();
                    new StudentTabsScreen(UserDataBase.getUserDepart(userNameFld.getText())).showStudentTabsScreen();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Wrong Password", "Warning", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Username Dooesn't Exist", "Warning", JOptionPane.WARNING_MESSAGE);
                    break;
                    
            }
        }
    }
}
