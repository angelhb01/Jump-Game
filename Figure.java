import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Figure extends JPanel implements KeyListener, ActionListener {
    public Image icon;
    public double yVelocity = 0;
    public double xVelocity = 0;
    public int y = 424; // Initial y position which is the ground
    public int x = 150;
    public int pHeight = 80;
    public int pWidth = 100;
    public Timer timer;
    Rectangle rect1;


    public Figure() {
        rect1 = new Rectangle(x,y,pWidth,pHeight);

        this.setBackground(Color.red);

        icon = new ImageIcon("Astronaut/astronaut1.png").getImage();
        this.setBounds(x, y, pWidth, pHeight);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setOpaque(false);
        timer = new Timer(16, this); // Timer with 10 milliseconds interval
    }

    public void stopTimer(){
        timer.stop();
    }
    public void startTimer(){
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(icon, 0, 0, 100, 80, null);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && y == 424 || e.getKeyCode() == KeyEvent.VK_W && y == 424) {
            yVelocity = -16.5; // Set upward velocity when space is pressed, but only if the car is on the ground (y == 500)
        }
        // (Checpoint) Moving the character.
        if(e.getKeyCode() == KeyEvent.VK_D){
            xVelocity = 7;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            xVelocity = -7;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A){
            xVelocity = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}


    @Override
    public void actionPerformed(ActionEvent e) {
        if (y < 424) {
            yVelocity += 1.1; // Gravity effect, increase downward velocity
        }


        // keeps updating the movement every second.
        y += yVelocity;
        x += xVelocity;

        if (y > 424) {
            y = 424; // Keep the car on the ground
            yVelocity = 0; // Stop downward velocity when the car is on the ground
        }
        if(x > 590){
            x = 590;
        }
        if(x < 0){
            x = 0;
        }


        this.setBounds(x, y, pWidth, pHeight);
        rect1.setBounds(this.getX(),this.getY(),pWidth,pHeight);
        //repaint();
    }

}
