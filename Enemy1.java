import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Enemy1 extends JPanel implements ActionListener{
    //class variables
    Image image;
    public Timer timer;
    int xVelocity = 10;
    public int x = 900;
    public int y = 425;
    public int pHeight = 63;
    public int pWidth = 143;
    Rectangle rect;

    //constructor
    public Enemy1(){
        rect = new Rectangle(x,y,pWidth,pHeight);
        this.setBackground(Color.blue);

        image = new ImageIcon("Enemies/enemy1.png").getImage();
        
        //this.setPreferredSize(new Dimension(90, 105));
        this.setBounds(x,y,pWidth,pHeight);
        this.setOpaque(false);

        //timer starts to increase the x velocity
        timer = new Timer(16,this);

    }

    //methods
    public void stopTimer(){
        timer.stop();
    }
    public void startTimer(){
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(image,-5,-83,160,165,null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = x - xVelocity;
        this.setBounds(x,y,pWidth,pHeight);
        rect.setBounds(this.getX(),this.getY(),pWidth,pHeight);
        if(x < -800){
            x = 900;
        }
        //repaint();
    }
}
