import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Car extends JPanel implements KeyListener{
   //class variables
    Image icon;
    //int yVelocity = 4;
    //int y;
    //Timer timer;

   //constructor
    public Car(){
        this.setBackground(Color.red);

        //this.setPreferredSize(new Dimension(10,10));
        icon = new ImageIcon("car.png").getImage();
        this.setBounds(135,601,100,75);
        this.addKeyListener(this);
        this.setFocusable(true);
        

    }



    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        //g2D.setPaint(Color.red);
        //g2D.drawRect(10,30,100,100);

        g2D.drawImage(icon, -76, -103, 250, 180,null);
     
    }


    @Override
    public void keyPressed(KeyEvent e) {
        
        //System.out.println("KeyCode: "+ e.getKeyCode());

        if(e.getKeyCode() == 32){
            //y = y - yVelocity; 
            this.setBounds(135,465,100,75); //y:465
            repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("KeyCode released: "+ e.getKeyCode()); 

        if(e.getKeyCode() == 32){
            this.setBounds(135,601,100,75);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }




    //methods

}
