import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame{
    //variables
    Car car;
    Cactus cactus;
    Bird bird;
    JLabel label;
    Image floor;
    JPanel panel = new JPanel();


    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    //constructor
    public Frame(){
        bird = new Bird();
        car = new Car();
        cactus = new Cactus();

        this.setTitle("Cactus Game");
        this.setSize(1000,800);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);

        //Floor
        panel.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        floor = new ImageIcon("Floor.png").getImage();
        
        Color color = new Color(25,25,112);
        this.getContentPane().setBackground(color);
        this.add(cactus);
        this.add(car);
        this.add(bird);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //methods
    public void paint(Graphics g){
        super.paint(g); 
        Graphics g2D = (Graphics2D) g;
        g2D.drawImage(floor, 0,500, 1000, 300, null);
    }

}