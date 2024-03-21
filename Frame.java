import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener{
    //variables
    int score;
    Timer timer2;
    JLabel scoreLabel = new JLabel();

    Figure car;
    Enemy1 enemy1;
    Enemy2 enemy2;
    Enemy3 enemy3;
    Background background;
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    JPanel panel = new JPanel();
    boolean gameStart = false;
    Timer timer;
    JButton startButton;
    JButton restart;

    JLayeredPane layer1;
    JLayeredPane layer2;
    JLayeredPane layer3;

    //constructor
    public Frame(){
        scoreLabel.setBounds(300,50,250,100);
        scoreLabel.setFont(new Font("MV Boli",Font.PLAIN, 50));
        scoreLabel.setText(""+score);
        scoreLabel.setForeground(Color.white);
        scoreLabel.setVisible(false);

        // creating objects
        background = new Background();
        enemy1 = new Enemy1();
        enemy2 = new Enemy2();
        enemy3 = new Enemy3();
        car = new Figure();
        car.stopTimer();
        enemy1.stopTimer();
        enemy2.stopTimer();
        enemy3.stopTimer();

        // label for start button
        label.setBounds(200,65,250,100);
        label.setText("Press Play");

        label.setFont(new Font("MV Boli",Font.PLAIN,50));
        label.setForeground(Color.white);

        // label for restart button
        label2.setBounds(180,65,300,100);
        label2.setText("Game Over!");
        label2.setFont(new Font("MV Boli",Font.PLAIN,50));
        label2.setForeground(Color.white);
        label2.setVisible(false);

        // image width and height
        int width = 50;
        int height = 50;

        // adjusting size of start button
        ImageIcon startIcon1 = new ImageIcon("play.png"); 
        Image startIcon2 = startIcon1.getImage();

        Image startIcon3 = startIcon2.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon startIconF = new ImageIcon(startIcon3);

        // adjusting size of restart button
        ImageIcon restartIcon1 = new ImageIcon("restart.png"); 
        Image restartIcon2 = restartIcon1.getImage();

        Image restartIcon3 = restartIcon2.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon restartIconF = new ImageIcon(restartIcon3);

        // button
        startButton = new JButton();
        startButton.setBounds(255,185,120,80);
        startButton.setFocusable(false);
        startButton.setIcon(startIconF);
        startButton.setBackground(Color.lightGray);
        startButton.setBorder(BorderFactory.createEtchedBorder());

        restart = new JButton();        
        restart.setBounds(255,185,120,80);
        restart.setFocusable(false);
        restart.setIcon(restartIconF);
        restart.setBackground(Color.lightGray);
        restart.setBorder(BorderFactory.createEtchedBorder());
        restart.setVisible(false);

        timer = new Timer(16, this); // every 10ms the frame(this) will update. 

        // second timer to track the score
        timer2 = new Timer(2000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                score += 10;
                scoreLabel.setText(""+score);
                //System.out.println(score);
            }
        });

        this.setTitle("Astro");
        this.setSize(665,635);
        this.setIconImage(new ImageIcon("Astronaut/astronaut1.png").getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);
        this.setResizable(false);

        startButton.addActionListener(this);
        restart.addActionListener(this);
 

        // add objects to the frame
        this.add(label);
        this.add(label2);
        this.add(startButton);
        this.add(restart);
        this.add(scoreLabel);
        this.setLocationRelativeTo(null);

        this.add(enemy2);
        this.add(enemy1);
        this.add(enemy3);
        this.add(car);
        this.add(background);
        this.setVisible(true);
    }


    //methods

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton){
            //System.out.println("Clicked!");
            gameStart = true;
            startButton.setVisible(false);
            label.setVisible(false);
            car.startTimer();
            enemy1.startTimer();
            timer.start();

            scoreLabel.setVisible(true);
            timer2.start();

        }
        
        if(gameStart == true && score > 50){
            enemy2.startTimer();
        }
        if(gameStart == true && score > 100){
            enemy3.startTimer();
        }

        if(car.rect1.intersects(enemy1.rect) || car.rect1.intersects(enemy2.rect)){
            //System.out.println("Collides");
            gameStart = false;
            label2.setVisible(true);
            restart.setVisible(true);
            timer.stop();
            timer2.stop(); 
            car.stopTimer();
            enemy1.stopTimer();
            enemy2.stopTimer();
            enemy3.stopTimer();
            scoreLabel.setBounds(300,10,250,100);

        }
        if(e.getSource()==restart){
            //System.out.println("Clicked!");
            gameStart = true;

            scoreLabel.setBounds(300,50,250,100);
            score = 0;
            restart.setVisible(false);
            label2.setVisible(false);

            // adjust coordinates
            enemy1.x = 900;
            enemy2.x = -800;            
            enemy3.x = 330;
            enemy3.y = -70;
            car.x = 100;

            // start times
            car.startTimer();
            enemy1.startTimer();

            // set both panel and rectangle to its initial positions.
            enemy2.setBounds(enemy2.x,enemy2.y,enemy2.pWidth,enemy2.pHeight);
            enemy2.rect.setBounds(enemy2.getX(),enemy2.getY(),enemy2.pWidth,enemy2.pHeight);

            enemy3.setBounds(enemy3.x,enemy3.y,enemy3.pWidth,enemy3.pHeight);
            enemy3.rect.setBounds(enemy3.getX(),enemy3.getY(),enemy3.pWidth,enemy3.pHeight);


            timer2.start();
            timer.start();
            scoreLabel.setText(""+score);

        }

    
        // methods for updating difficulty depending on the score.
    }
}
