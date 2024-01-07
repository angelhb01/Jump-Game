import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Bird extends JPanel implements ActionListener{
    Image bird;    
    Timer timer;
    int x = 900;
    int xVelocity = 4;
    
    public Bird(){
        bird = new ImageIcon("bird.png").getImage();
        this.setBounds(900,500,100,50);
        this.setBackground(Color.red);

        timer = new Timer(20,this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(bird,-78,-60,250,170,null);


    }
    
    
    public void actionPerformed(ActionEvent e){
        x = x - xVelocity;
        this.setBounds(x,500,100,50);
        repaint();

    }


}
