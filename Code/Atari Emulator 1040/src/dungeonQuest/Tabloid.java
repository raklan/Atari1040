import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Rectangle;
public class Tabloid extends JFrame{
    protected  player jeff;
    protected Arrow arro;
    protected  int startx, starty, startW, startH, fps, x, y, shoot, count, half;
    protected  Timer t = new Timer();
    protected  JFrame win;
    protected Goat goat1;
    protected boolean dead= false;
    protected Arrow arrow;
    public Tabloid()
    {
        super("Picture");
        shoot = 5;
        count = 0;
        fps = 40;
        Random gen = new Random();
        startx = gen.nextInt(200)+1;
        starty = gen.nextInt(200)+1;
        startW = 100;
        startH = 100;
        half = startH/2;
        this.setBounds(0,0,1000,1000);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //Character not Michael
        jeff = new player(startx, starty, startW,startH, "FarmerMan.png");
        this.add(jeff,0);
        jeff.requestFocusInWindow();
        this.repaint();
        t.schedule(new MyTimerTask(),0,1000/fps);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_DOWN: y+=10;  count +=1; jeff.moved(x, y, count); break;
                    case KeyEvent.VK_UP: y-=10; count +=1; jeff.moved(x,y, count); break;
                    case KeyEvent.VK_LEFT: x-=10;count +=1; jeff.moved(x,y,count); break;
                    case KeyEvent.VK_RIGHT: x+=10;count +=1; jeff.moved(x,y,count); break;
                    case KeyEvent.VK_SPACE: shoot -= 1; shot(); break;
                }
            }
        });
        x = jeff.getX();
        y = jeff.getY();
        arrow = new Arrow(x + startW,y+half,25,25,"ArrowWithFletching.png");
        arrow.setVisible(true);
        this.add(arrow,0);
        goat1 = new Goat(startx + 200, starty, 100, 100,"DerpyGoat1.png" );
        this.add(goat1,0);
        goat1.setVisible(true);
    }
    public void shot()
    {
        this.add(arrow,0);
        arrow.shoot();
        Rectangle arro = new Rectangle(arrow.getX(),arrow.getY(),arrow.getWidth(),arrow.getHeight());
        Rectangle goatio = new Rectangle(goat1.getX(),goat1.getY(),goat1.getWidth(),goat1.getHeight());
        if(arro.intersects(goatio))
        {
            remove(goat1);
            dead = true;
        }
        if(dead = true)
        {
            remove(arrow);
            dead = false;
        }
    }
    public class MyTimerTask extends TimerTask{
        @Override
        public void run(){
            jeff.moved(x,y,count);
        }
    }
    public static void main (String[]args)
    {
        Tabloid jef = new Tabloid();
    }
}
