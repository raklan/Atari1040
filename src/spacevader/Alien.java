package spacevader;

import java.awt.*;

public class Alien extends SpaceEntity{

    protected Alien(int x, int y)
    {
        super(x,y);
        setBackground(Color.red);
    }

    protected void shift(int u, int s)
    {
        x+=s;
        y+=u;
        setLocation(x,y);
    }
}
