package spacevader;
import resources.GameRectangle;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

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

    private final int row = 10;
    private final int column = 4;
    private int alienTime = 6;
    private int alienMove = alienTime;
    private int alienPos = 0; //0-8, controls where aliens move to next
    private int aliensLeft;

    private int score = 0;

    public SpaceGame()
    {
        super("SpaceInvaders");
        setBounds(0,0,1500, 1000);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        int s = (getWidth()-row*50)/(row+1); //space between aliens
        int w = 50 + s; //width of aliens + space
        int h = 50 + 30; //vertical spacing
        fleet = new Alien[row][column];
        aliensLeft = row*column;
        for(int j = 0; j<fleet[0].length; j++) {
            for (int i = 0; i < row; i++) {
                fleet[i][j] = new Alien(i * w + s, 50+j*h);
                add(fleet[i][j]);
            }
        }

        ship = new Ship(getWidth()/2+25, getHeight()-s-50-30);
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

        t.schedule(new MyTimerTask(), 0, 1000/fps);
        setVisible(true);
    }

    private void checkCollision(Bullet b) {
        Rectangle brec = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());
        Rectangle arec;
        if(b.isUp()) {//collision for bullet v alien
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
                            //checks if any aliens are left, and if not, rewards score
                            if(aliensLeft==0)
                            {
                                score+=5000;
                                t.cancel();
                                repaint();
                                newRound();
                            }
                            break;
                        }
                    }
                }
            }
        }else
        {//collision for bullet v player
            arec = new Rectangle(ship.getX(), ship.getY(), ship.getWidth(), ship.getHeight());
            if (arec.intersects(brec)) {
                gameOver();
            }
        }
    }

    private void moveFleet()
    {
        int dir;//0=down, 1=left, 2=right
        switch (alienPos) {
            case 0:
                dir = 2;
                break;
            case 1:
                dir = 2;
                break;
            case 2:
                dir = 2;
                break;
            case 3:
                dir = 0;
                break;
            case 4:
                dir = 1;
                break;
            case 5:
                dir = 1;
                break;
            case 6:
                dir = 1;
                break;
            case 7:
                dir = 1;
                break;
            case 8:
                dir = 1;
                break;
            case 9:
                dir = 0;
                break;
            case 10:
                dir = 2;
                break;
            case 11:
                dir = 2;
                break;
            default:
                dir = 0;
                break;
        }
        alienPos++;
        alienPos%=12 ;
        alienFlight:
        for (Alien[] ar : fleet)
        {
            for (Alien a : ar) {
                if(a!=null) {
                    if(dir==0) {
                        a.shift(20, 0);
                        if((a.getY()+50)>=ship.getY())//checks if aliens got too far down
                        {
                            gameOver();
                            break alienFlight;
                        }
                    }else
                    {
                        a.shift(0, (dir==1)? -20 : 20);
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

    private void newRound()
    {
        try {//pause
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //refill aliens
        int s = (getWidth()-row*50)/(row+1); //space between aliens
        int w = 50 + s; //width of aliens + space
        int h = 50 + 30; //vertical spacing
        for(int j = 0; j<fleet[0].length; j++) {
            for (int i = 0; i < row; i++) {
                fleet[i][j] = new Alien(i * w + s, 50+j*h);
                add(fleet[i][j]);
            }
        }
        aliensLeft=row*column;
        repaint();
        //shorten time for aliens to shift
        if(alienTime!=1)
            alienTime--;
        //pause
        try {//pause
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
        System.out.print(score);
        dispose();
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
            score++;
            alienMove = alienTime;
            moveFleet();
        }
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