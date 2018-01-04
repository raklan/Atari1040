import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class player extends EzImage{
    protected int x, y, shoot, count, tcount;
    public player(int up, int sides, int w, int h, String i){
        super(up,sides,w,h,i);
        x = up;
        y = sides;
        shoot = 15;
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_DOWN: y+=10;  count +=1; moved(); break;
                    case KeyEvent.VK_UP: y-=10; count +=1; moved(); break;
                    case KeyEvent.VK_LEFT: x-=10;count +=1; moved(); break;
                    case KeyEvent.VK_RIGHT: x+=10;count +=1; moved(); break;
                    case KeyEvent.VK_SPACE: shoot -= 1;count +=1; shot(); break;
                }

            }
        });
        System.out.println(count);
    }
    public int moved() {
        this.setLocation(x, y);
        tcount += 1;
        if (count == tcount) {
            count += 1;
        }
        return count;
    }


}
