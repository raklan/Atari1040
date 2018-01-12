package spacevader;

import resources.GameRectangle;

public class SpaceEntity extends GameRectangle{

    protected int x, y;
    protected int dx = 0;
    protected int dy = 0;
    protected EzImage image;

    protected SpaceEntity(int x, int y)
    {
        super(x,y,50,50);
        this.x = x;
        this.y = y;
    }

    protected void move()
    {
        x +=dx;
        y+=dy;
        setLocation(x,y);
    }

    protected Bullet shoot(boolean up)
    {
        Bullet b = new Bullet(getX()+getWidth()/2-5, getY(), up);
        return b;
    }
}
