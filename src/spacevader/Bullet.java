package spacevader;

import java.awt.*;

public class Bullet extends SpaceEntity{

    private boolean isUp;

    public Bullet(int x, int y, boolean u)
    {
        super(x,y);
        isUp = u;
        setSize(11, 22);
        String i;
        if(u) {
            dy = -20;
            i="src/resources/space/LaserUP.png";
        }
        else {
            dy = 20;
            i = "src/resources/space/LaserDown.png";
        }
        image = new EzImage(-13, -3, 33, 33, i);
        add(image);
    }

    protected boolean isUp()
    {
        return isUp;
    }
}
