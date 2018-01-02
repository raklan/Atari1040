package spacevader;

import java.awt.*;

public class Bullet extends SpaceEntity{

    private boolean isUp;

    public Bullet(int x, int y, boolean u)
    {
        super(x,y);
        setBackground(Color.blue);
        setSize(10,10);
        isUp = u;
        if(u)
            dy = -20;
        else
            dy = 20;
    }
}
