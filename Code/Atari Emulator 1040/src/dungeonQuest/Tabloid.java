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
        shoot = 5;
        count = 0;
        fps = 40;
        Random gen = new Random();
        startx = gen.nextInt(200)+1;
        starty = gen.nextInt(200)+1;
        startW = 100;
        startH = 100;
        half = startH/2;
        win =new JFrame("Picture");
        win.setBounds(0,0,1000,1000);
        win.setLayout(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
        //Character not Michael
        jeff = new player(startx, starty, startW,startH, "FarmerMan.png");
        win.add(jeff,0);
        jeff.requestFocusInWindow();
        win.repaint();
        t.schedule(new MyTimerTask(),0,1000/fps);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_DOWN: y+=10;  count +=1; jeff.moved(count); break;
                    case KeyEvent.VK_UP: y-=10; count +=1; jeff.moved(count); break;
                    case KeyEvent.VK_LEFT: x-=10;count +=1; jeff.moved(count); break;
                    case KeyEvent.VK_RIGHT: x+=10;count +=1; jeff.moved(count); break;
                    case KeyEvent.VK_SPACE: shoot -= 1; shot(); System.out.println("Sup"); break;
                }
            }
        });
        x = jeff.getX();
        y = jeff.getY();
        arrow = new Arrow(x + startW,y+half,25,25,"ArrowWithFletching.png");
        arrow.setVisible(true);
        win.add(arrow,0);
        goat1 = new Goat(startx + 200, starty, 100, 100,"DerpyGoat1.png" );
        win.add(goat1,0);
        goat1.setVisible(true);
    }
    public void shot()
    {
        win.add(arrow,0);
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
            jeff.moved(count);
            win.repaint();
        }
    }
    public static void main (String[]args)
    {
        Tabloid jef = new Tabloid();
    }
}
