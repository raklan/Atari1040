import sun.plugin.dom.css.Rect;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class player extends Rectangle{
    protected int x, y, shoot, count;
    public player(int up, int sides, int w, int h){
        super(up,sides,w,h);
        x = up;
        y = sides;
        shoot = 15;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_DOWN: y+=10; move(); count +=1; break;
                    case KeyEvent.VK_UP: y-=10; move();count +=1;break;
                    case KeyEvent.VK_LEFT: x-=10; move();count +=1; break;
                    case KeyEvent.VK_RIGHT: x+=10; move();count +=1; break;
                    case KeyEvent.VK_SPACE: shoot -= 1;count +=1; break;
                }
            }
        }
    }
    public void move(){
        this.setLocation(x,y);

    }
    public static void main(String[]args)
    {
        
    }
}
