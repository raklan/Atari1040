package spacevader;

import resources.GameRectangle;

public class SpaceEntity extends GameRectangle{

    private int x, y;

    protected SpaceEntity(int x, int y)
    {
        super(x,y,50,50);
        this.x = x;
        this.y = y;
    }

    protected void moveX(int x)
    {
        this.x+=x;
        setLocation(x,y);
    }

    protected void moveY(int y)
    {
        this.y+=y;
        setLocation(x,y);
    }
}
