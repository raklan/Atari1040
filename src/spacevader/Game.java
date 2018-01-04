package spacevader;
import resources.GameRectangle;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;

public class Game extends JFrame{

    private Alien[][] fleet;
    private Ship ship;
    private ArrayList<Bullet> bullets;
    private Timer t = new Timer();
    private int fps = 40;

    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean spacePressed = false;
    private final int speed = 20;

    public Game()
    {
        super("SpaceInvaders");
        setBounds(0,0,1500, 1000);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        int row = 20; //number of aliens per row
        int s = (getWidth()-row*50)/(row+1); //space between aliens
        int w = 50 + s; //with of aliens + space
        fleet = new Alien[row][4];
        for(int j = 0; j<fleet[0].length; j++) {
            for (int i = 0; i < row; i++) {
                fleet[i][j] = new Alien(i * w + s, 50+j*w);
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

    public void checkCollision(Bullet b) {
        for (Alien[] ar : fleet)
        {
            for (Alien a : ar) {
                Rectangle arec = new Rectangle(a.getX(), a.getY(), a.getWidth(), a.getHeight());
                Rectangle brec = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());
                if (arec.intersects(brec)) {
                    remove(a);
                    Arrays.asList(ar).indexOf(a);
                    remove(b);
                    bullets.remove(b);
                    break;
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