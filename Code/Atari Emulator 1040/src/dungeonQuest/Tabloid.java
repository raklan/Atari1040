import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Rectangle;
public class Tabloid extends JFrame{
    protected  player jeff;
    protected  int startx, starty, startW, startH, fps, x, y, shoot, count, half, arrowStart;
    protected  Timer t = new Timer();
    protected  JFrame win;
    protected Goat goat1;
    protected boolean collision, dead = false;
    protected Arrow arrow;
    protected Rectangle arrRec, goatRec;
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
        this.setBounds(0,0,2000,2000);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //Character not Michael
        jeff = new player(startx, starty, startW,startH, "FarmerMan.png");
        this.add(jeff,0);
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
                    case KeyEvent.VK_SPACE: shoot -= 1; shot(jeff.getX()); break;
                }
            }
        });
        goat1 = new Goat(startx + 200, starty, 100, 100,"DerpyGoat1.png" );
        this.add(goat1,0);
        goat1.setVisible(true);

    }
    private void shot(int x) {
        arrowStart = jeff.getX();
        arrow = new Arrow(arrowStart, jeff.getY(),jeff.getWidth(), jeff.getHeight(), "ArrowWithFletching.png");
        win.add(arrow,0);
        arrRec = new Rectangle(arrow.getX(), arrow.getY(), arrow.getWidth(), arrow.getHeight());
        goatRec = new Rectangle(goat1.getX(),goat1.getY(), goat1.getWidth(),goat1.getHeight());
        do {
            x = arrow.shoot(x);
            if (arrRec.intersects(goatRec)) {
                remove(goat1);
                collision = true;
            }
            if (arrRec.getX() >= 2000)
            {
                remove(arrow);
                collision = true;
             }
        }while(collision != true);
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
