package StudentTabs;

import Database.DegreeDataBase;
import static Database.DegreeDataBase.updateDegree;
import Domain.Degree;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DegreeUpdateTab extends JPanel implements ActionListener{
    
    private JLabel subLbl1, subLbl2, subLbl3, subLbl4, subLbl5, subLbl6, idLbl;
    private JTextField subFld1, subFld2, subFld3, subFld4, subFld5, subFld6, idFld;
    private JButton updateBtn, searchBtn;;
    
    public DegreeUpdateTab()
    {
        setLayout(null);
        showDegreeUpdateTab();
    }
    
    public void showDegreeUpdateTab()
    {
        //        Subjects Labels, Fields And Button
        
        idLbl = new JLabel("ID");

        subLbl1 = new JLabel("OOP");
        subLbl2 = new JLabel("Data Structure");
        subLbl3 = new JLabel("Data Base");
        subLbl4 = new JLabel("Algorithms");
        subLbl5 = new JLabel("Problem Solving");
        subLbl6 = new JLabel("Android");
        
        idFld = new JTextField();

        subFld1 = new JTextField();
        subFld2 = new JTextField();
        subFld3 = new JTextField();
        subFld4 = new JTextField();
        subFld5 = new JTextField();
        subFld6 = new JTextField();
        
        updateBtn = new JButton("Update");
        searchBtn = new JButton("Search");

        updateBtn.addActionListener(this);
        searchBtn.addActionListener(this);

//        Setting Labels, Fields And Button Bounds And Event
        
        idLbl.setBounds(5, 95, 75, 25);
        idFld.setBounds(110, 95, 75, 25);

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
        
        updateBtn.setBounds(5,345,230,25);
        searchBtn.setBounds(200, 95, 85, 25);
        
        add(idLbl);
        
        add(subLbl1);
        add(subLbl2);
        add(subLbl3);
        add(subLbl4);
        add(subLbl5);
        add(subLbl6);
        
        add(idFld);
        
        add(subFld1);
        add(subFld2);
        add(subFld3);
        add(subFld4);
        add(subFld5);
        add(subFld6);
        
        add(updateBtn);
        add(searchBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==updateBtn)
        {
            updateDegree(Integer.parseInt(idFld.getText()), subFld1.getText(), subFld2.getText(), subFld3.getText(), subFld4.getText(), subFld5.getText(), subFld6.getText());
            JOptionPane.showMessageDialog(null, "Degree Updated", "Updated", JOptionPane.PLAIN_MESSAGE);
        }
        
        if(e.getSource()==searchBtn)
        {
            ArrayList<Degree> list = DegreeDataBase.getDegree(Integer.parseInt(idFld.getText()));
            
                subFld1.setText(list.get(0).getSub1());
                subFld2.setText(list.get(0).getSub2());
                subFld3.setText(list.get(0).getSub3());
                subFld4.setText(list.get(0).getSub4());
                subFld5.setText(list.get(0).getSub5());
                subFld6.setText(list.get(0).getSub6());
        }

    }
}
