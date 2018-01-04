package spacevader;

import java.awt.*;

public class TEMPCLASS {


    public void checkCollision()
    {
        Bullets:
        for(int i = 0; i<bullets.size(); i++)
        {
            Bullet b = bullets.get(i);
            for(Alien a : fleet)
            {
                Rectangle arec = new Rectangle(a.getX(), a.getY(), a.getWidth(), a.getHeight());
                Rectangle brec = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());
                if(arec.intersects(brec))
                {
                    remove(a);
                    a = null;
                    remove(b);
                    bullets.remove(b);
                    i--;
                    continue Bullets;
                }
            }
        }
    }

    private int alienWait = 500;
    private int shiftpos = 0;
    public void move() {
        alienWait--;
        if(alienWait == 0)
        {
            alienWait = 500;
            boolean right;
            switch (shiftpos)
            {
                case 0:
                    right = true;
                    break;
                case 1:
                    right = false;
                    break;
                case 2:
                    right = false;
                    break;
                case 3:
                    right = true;
                    break;
            }
            for(Alien a : fleet)
            {
                
            }
        }
    }
}
