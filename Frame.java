import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Frame extends JFrame implements ActionListener, KeyListener{
    //variables
    Car car;
    Cactus cactus;
    Bird bird;
    JLabel label;
    Image floor;
    JPanel panel = new JPanel();
    boolean gameStart;
    Timer timer;

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    //constructor
    public Frame(){
        gameStart =true; 
        
        timer = new Timer(10, this); // Timer with 10 milliseconds interval
        timer.start();

        this.setTitle("Cactus Game");
        this.setSize(580,708);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);
        this.setResizable(false);
        this.addKeyListener(this);
        if(gameStart == true){
            System.out.println("It is true");
            car = new Car();
            cactus = new Cactus();
            this.add(car);
            this.add(cactus);
            //this.add(bird);
        }

        //Floor
        panel.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        floor = new ImageIcon("Floor.png").getImage();
        
        Color color = new Color(25,25,112);
        this.getContentPane().setBackground(color);

        this.setLocationRelativeTo(null);
        if(gameStart == true){
            if(car.y == cactus.y){
                System.out.println("Game over");
            }
        }

        this.setVisible(true);

    }

    //methods
    public void paint(Graphics g){
        super.paint(g); 
        Graphics g2D = (Graphics2D) g;
        g2D.drawImage(floor, 0,400, 1000, 300, null);
    }
    public void checkCollision(){
        if(car!= null && cactus != null && car.getBounds().intersects(cactus.getBounds())){
            System.out.println("Game Over");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            gameStart = true;
            System.out.println("Pressed");
            this.removeKeyListener(this);
        }
    }


    //Ignore These 2 Methods
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}
