import javax.swing.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Rectangle;
public class Tabloid extends JFrame{
    protected  player jeff;
    protected Arrow arro;
    protected  int startx, starty, fps, x, y;
    protected  Timer t = new Timer();
    protected  JFrame win;
    protected Goat goat1;
    protected boolean dead= false;
    protected Arrow arrow;
    public Tabloid()
    {
        fps = 40;
        Random gen = new Random();
        startx = gen.nextInt(200)+1;
        starty = gen.nextInt(200)+1;
        win =new JFrame("Picture");
        win.setBounds(0,0,1000,1000);
        win.setLayout(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
        //Character not Michael
        jeff = new player(startx, starty, 100,100, "FarmerMan.png");
        win.add(jeff,0);
        jeff.requestFocusInWindow();
        win.repaint();
        t.schedule(new MyTimerTask(),0,1000/fps);
        x = jeff.getX();
        y = jeff.getY();
        arrow = new Arrow(x,y,25,25,"ArrowWithFlethcing.png")
        goat1 = new Goat(startx + 200, starty, 100, 100,"DerpyGoat1.png" )
    }
    public void shot()
    {

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
            jeff.moved();
            win.repaint();
        }
    }
    public static void main (String[]args)
    {
        Tabloid jef = new Tabloid();
    }
}
