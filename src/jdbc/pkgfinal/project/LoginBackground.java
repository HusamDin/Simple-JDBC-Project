package jdbc.pkgfinal.project;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LoginBackground extends JPanel{
    
    private ImageIcon i ;
    
    public LoginBackground()
    {
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        i = new ImageIcon(getClass().getResource("Images\\Image.jpg"));
        i.paintIcon(this, g, 0, 0);
    }
}
