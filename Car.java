import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Car extends JPanel implements KeyListener, ActionListener {
    public Image icon;
    public int yVelocity = 0;
    public int y = 471; // Initial y position which is the ground
    public int x = 100;
    public int pHeight = 105;
    public int pWidth = 90;
    private Timer timer;

    public Car() {
        this.setBackground(Color.red);
        icon = new ImageIcon("car.png").getImage();
        this.setBounds(100, y, pWidth, pHeight);
        this.addKeyListener(this);
        this.setFocusable(true);
        timer = new Timer(10, this); // Timer with 10 milliseconds interval
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(icon, -76, -103, 250, 180, null);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && y == 471) {
            yVelocity = -20; // Set upward velocity when space is pressed, but only if the car is on the ground (y == 500)
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (y < 471) {
            yVelocity += 1; // Gravity effect, increase downward velocity
        }

        y += yVelocity;

        if (y > 471) {
            y = 471; // Keep the car on the ground
            yVelocity = 0; // Stop downward velocity when the car is on the ground
        }

        this.setBounds(x, y, pWidth, pHeight);
        repaint();
    }


    //Ignore these 2 methods
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}
