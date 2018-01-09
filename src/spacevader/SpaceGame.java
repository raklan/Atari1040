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

    private int alienTime = 5;
    private int alienMove = alienTime;
    private int alienPos = 0; //0-8, controls where aliens move to next

    public SpaceGame()
    {
        super("SpaceInvaders");
        setBounds(0,0,1500, 1000);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        int row = 10; //number of aliens per row
        int s = (getWidth()-row*50)/(row+1); //space between aliens
        int w = 50 + s; //width of aliens + space
        int h = 50 + 30; //vertical spacing
        fleet = new Alien[row][4];
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
        if(b.isUp()) {
            for (Alien[] ar : fleet) {
                for (Alien a : ar) {
                    if (a != null) {
                        arec = new Rectangle(a.getX(), a.getY(), a.getWidth(), a.getHeight());
                        if (arec.intersects(brec)) {
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
                dispose();
            }
        }
    }

    private void moveFleet()
    {
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
                    }else
                    {
                        a.shift(0, (left)? -20 : 20);
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