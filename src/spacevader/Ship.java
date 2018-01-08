package spacevader;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ship extends SpaceEntity{



    public Ship(int x, int y)
    {
        super(x,y);
        setBackground(Color.GREEN);
    }

    protected void setDX(int x)
    {
        dx+=x;
    }

    protected void setDY(int y)
    {
        dy+=y;
    }
}
