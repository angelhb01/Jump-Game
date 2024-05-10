
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Enemy3 extends JPanel implements ActionListener{

    //class variables
    Image image;
    public Timer timer;
    int xVelocity = 10;
    int yVelocity = 10;
    public int x = 330;
    public int y = -70;
    public int pHeight = 63;
    public int pWidth = 97;

    public int rWidth = 50;
    public int rHeight = 50;

    Rectangle rect;

    boolean movingR = false;
    boolean movingL = true;

    //constructor
    public Enemy3(){
        this.setBackground(Color.blue);
        rect = new Rectangle(50,50,rWidth,rHeight);

        image = new ImageIcon("Enemies/enemy3.png").getImage();
        
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

        g2D.drawImage(image,-3,-3,100,80,null);

        g.setColor(Color.GREEN);
        g.drawRect(rect.x,rect.y,rect.width,rect.height);
        g.fillRect(rect.x,rect.y,rect.width,rect.height);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 1
        if(y < 170){
            y = y + yVelocity;
        }

        // 2
        if(x > 40 && y == 170 && movingR == false && movingL == true){
            x = x - xVelocity;
        }

        // 3
        if(x == 40 && movingL == true && movingR == false){
            movingL = false;
            movingR = true;
        }

        // 4
        if(x < 500 && y == 170 && movingL == false && movingR == true){
            x = x + xVelocity;
        }

        // 5
        if(x == 500){
            movingR = false;
            movingL = true;
        }

        this.setBounds(x,y,pWidth,pHeight);
        rect.setBounds(this.getX(),this.getY(),pWidth,pHeight);


        //repaint();
    }
}
