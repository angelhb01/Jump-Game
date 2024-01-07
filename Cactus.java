import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cactus extends JPanel implements ActionListener{
   //class variables
    Image cactus;
    Timer timer;
    int xVelocity = 4;
    int x = 900;

   //constructor
    public Cactus(){

        this.setBackground(Color.red);

        cactus = new ImageIcon("Cactus.png").getImage();
        
        //this.setPreferredSize(new Dimension(90, 105));
        this.setBounds(900,571,90,105);

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
        this.setBounds(x,571,90,105);
        repaint();



    }
}
