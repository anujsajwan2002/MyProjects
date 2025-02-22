import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener,KeyListener{
    int boardWidth = 360;
    int boardLength = 640;


    //Images
    Image backgroundImg;
    Image topPipeImg;
    Image bottomPipeImg;
    Image birdImg;

    //Bird
    int birdX = boardWidth/8;
    int birdY = boardLength/2;
    int birdWitdh = 34;
    int birdheight = 24;

    class Bird{
        int x = birdX;
        int y = birdY;
        int width = birdWitdh;
        int height = birdheight;
        Image img;

        Bird(Image img){
            this.img = img;
        }

    }

    //Game Logic
    Bird bird;
    //int velocityX = -4;
    int velocityY = 0;
    int gravity = 1;

    Timer gameLoop;


    FlappyBird(){
        setPreferredSize(new Dimension(boardWidth,boardLength));
        setFocusable(true);
        addKeyListener(this);
        //setBackground(Color.blue);

        //load Images
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        //bird
        bird = new Bird(birdImg);

        //game timer
        gameLoop = new Timer(1000/60,this); // 1000/60 = 16.6 
        gameLoop.start();
    }

    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        System.out.println("Draw");
        //background

        g.drawImage(backgroundImg, 0, 0, boardWidth,boardLength,null);

        g.drawImage(bird.img, bird.x,bird.y,bird.width,bird.height,null);

    }

    public void move(){
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y,0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }


    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            velocityY = -9;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
}
