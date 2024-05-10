import java.awt.*;

import javax.swing.*;

public class Background extends JPanel{
    private Image icon;    

    public Background(){
        //this.setBackground(Color.red);
        icon = new ImageIcon("background.jpg").getImage();
        this.setBounds(0,0,650,600);


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(icon, 0, 0, 650, 600, null);
    }
}
