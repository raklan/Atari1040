package spacevader;
import player.highScoreSpaceInvaders;
import resources.GameRectangle;
import menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.Timer;

/**
 * Created By Sean
 */

public class SpaceGame extends JFrame{

    private Alien[][] fleet;
    private Ship ship;
    private ArrayList<Bullet> bullets;
    private Timer t = new Timer();
    private int fps = 40;

    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean spacePressed = false;
    private final int speed = 20;

    private int row = 10;//number per row
    private int column = 4;//number of rows
    private int aliensLeft;
    private int alienTime = 5;
    private int alienMove = alienTime;
    private int alienPos = 0; //0-8, controls where aliens move to next

    private int score=0;
    private JLabel scoreBoard;

    public SpaceGame()
    {
        super("SpaceInvaders");
        setBounds(0,0,1500, 1000);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        fleet = new Alien[row][column];
        makeAliens();

        ship = new Ship(getWidth()/2+107/2, getHeight()-30-107-30);
        add(ship);

        bullets = new ArrayList<>();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if(!leftPressed) {
                            leftPressed = true;
                            ship.dx += -speed;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(!rightPressed) {
                            rightPressed = true;
                            ship.dx += speed;
                        }
                        break;
                    case KeyEvent.VK_SPACE:
                        if(!spacePressed) {
                            spacePressed = true;
                            Bullet b = ship.shoot(true);
                            bullets.add(b);
                            add(b);
                            score-=100;
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        leftPressed = false;
                        ship.dx -= -speed;
                        break;
                    case KeyEvent.VK_RIGHT:
                        rightPressed = false;
                        ship.dx -= speed;
                        break;
                    case KeyEvent.VK_SPACE:
                        spacePressed = false;
                        break;
                }
            }
        });

        scoreBoard = new JLabel();
        scoreBoard.setBounds(15,15,500, 25);
        scoreBoard.setText(""+score);
        scoreBoard.setForeground(Color.WHITE);
        scoreBoard.setFont(new Font("Magneto", Font.ITALIC, 30));
        add(scoreBoard, 0);

        t.schedule(new MyTimerTask(), 0, 1000/fps);
        setVisible(true);
    }

    private void checkCollision(Bullet b) {
        Rectangle brec = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());
        Rectangle arec;
        AlienCollision:
        if(b.isUp()) {
            for (Alien[] ar : fleet) {
                for (Alien a : ar) {
                    if (a != null) {
                        arec = new Rectangle(a.getX(), a.getY(), a.getWidth(), a.getHeight());
                        if (arec.intersects(brec)) {
                            score+=500;
                            aliensLeft--;
                            remove(a);
                            ar[Arrays.asList(ar).indexOf(a)] = null;
                            remove(b);
                            bullets.remove(b);
                            break;
                        }
                    }
                }
            }
        }else
        {
            arec = new Rectangle(ship.getX(), ship.getY(), ship.getWidth(), ship.getHeight());
            if (arec.intersects(brec)) {
                gameOver();
                break AlienCollision;
            }
        }
        //checks to see if any aliens are left
        if(aliensLeft==0)
            newRound();
    }

    private void moveFleet()
    {
        score++;
        boolean left;
        switch (alienPos) {
            case 0:
                left = false;
                break;
            case 1:
                left = false;
                break;
            case 2:
                left = true;
                break;
            case 3:
                left = true;
                break;
            case 4:
                left = true;
                break;
            case 5:
                left = true;
                break;
            case 6:
                left = false;
                break;
            case 7:
                left = false;
                break;
            default:
                left = false;
                break;
        }
        alienPos++;
        alienPos%=9;
        for (Alien[] ar : fleet)
        {
            for (Alien a : ar) {
                if(a!=null) {
                    if(alienPos==0) {
                        a.shift(20, 0);
                        if((a.getY()+50)>ship.getY())//checks if aliens are too close
                        {
                            gameOver();
                        }
                    }else
                    {
                        a.shift(0, (left)? -25 : 25);
                    }

                    //also here's the code for the aliens to shoot
                    java.util.Random gen = new Random();
                    if(gen.nextInt(100)==0) {
                        Bullet b = a.shoot(false);
                        bullets.add(b);
                        add(b);
                    }
                }
            }
        }
    }

    private void makeAliens()
    {
        int a;//space of alien
        int s; //space between aliens
        int w;//space between aliens plus space of aliens
        int h = 50 + 35; //vertical spacing
        for(int j = 0; j<fleet[0].length; j++) {
            switch (j)
            {
                case 0:
                    a = 29;
                    break;
                case 1:
                    a = 50;
                    break;
                case 2:
                    a = 40;
                    break;
                case 3:
                    a = 50;
                    break;
                default:
                    a = 0;
                    break;
            }
            s = (getWidth()-row*a)/(row+1);
            w = s + a;
            for (int i = 0; i < row; i++) {
                fleet[i][j] = new Alien(i * w  + s, 50+j*h, j);
                add(fleet[i][j]);
            }
        }
        aliensLeft = row*column;
    }

    private void newRound()
    {
        score+=5000;
        t.cancel();
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        makeAliens();
        for(Bullet b : bullets)
            remove(b);
        bullets.clear();
        repaint();
        alienTime--;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t = new Timer();
        t.schedule(new MyTimerTask(), 0, 1000/fps);
    }

    private void gameOver()
    {
        t.cancel();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        highScoreSpaceInvaders high = new highScoreSpaceInvaders();
        boolean newHigh = high.readSpaceInvadersHighScore()<=score;
        if(newHigh)
        {
            high.writeHighScoreSpaceInvaders(score);
        }
        int pane = JOptionPane.showConfirmDialog(null,

                "Game Over!\nScore: "+score+ "\n" + ((newHigh)? "New high score!" : ("High score: "+ high.readSpaceInvadersHighScore())) +"\nWould you like to try again?", "Game Over", JOptionPane.YES_NO_OPTION);
        if(pane==0)//if try again
        {
            for (Alien[] ar : fleet)//get rid of aliens
            {
                for (Alien a : ar) {
                    if(a!=null) {
                        remove(a);
                        ar[Arrays.asList(ar).indexOf(a)] = null;
                    }
                }
            }
            makeAliens();//add new aliens
            for(Bullet b : bullets)//remove bullets
            {
                remove(b);
            }
            bullets.clear();
            alienTime=5;
            score=0;
            t = new Timer();
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.schedule(new MyTimerTask(), 0, 1000/fps);
        }else
        {
            new Menu();
            dispose();
        }
    }

    private void act()
    {
        ship.move();
        for(int i = 0; i<bullets.size(); i++) {
            Bullet b = bullets.get(i);
            b.move();
            if(b.getY()>getHeight()||b.getY()<0)
            {
                remove(b);
                bullets.remove(b);
                i--;
            }
            checkCollision(b);
        }
        alienMove--;
        if(alienMove==0)
        {
            alienMove = alienTime;
            moveFleet();
        }
        scoreBoard.setText(""+score);
        repaint();
    }

    public class MyTimerTask extends TimerTask
    {
        @Override
        public void run()
        {
            act();
        }
    }
}