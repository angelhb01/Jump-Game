import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cactus extends JPanel implements ActionListener{
   //class variables
    Image cactus;
    public Timer timer;
    int xVelocity = 4;
    public int x = 900;
    public int y = 471;
    public int pHeight = 105;
    public int pWidth = 90;

   //constructor
    public Cactus(){

        this.setBackground(Color.red);

        cactus = new ImageIcon("Cactus.png").getImage();
        
        //this.setPreferredSize(new Dimension(90, 105));
        this.setBounds(900,y,pWidth,pHeight);

        //timer starts to increase the x velocity
        timer = new Timer(10,this);
        timer.start();

    }

    //methods
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(cactus,-78,-60,250,170,null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = x - xVelocity;
        this.setBounds(x,y,pWidth,pHeight);
        repaint();

    }
}
