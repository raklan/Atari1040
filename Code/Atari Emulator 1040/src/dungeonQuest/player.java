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
        System.out.println(count);
    }
    public void moved(int count) {
        this.setLocation(x, y);
        tcount += 1;
        if (count == tcount) {
            System.out.println("done");
        }

    }


}
