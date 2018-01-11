package pong;
import resources.GameOval;
import java.util.Random;
/**
 * Write a description of class Ball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pong extends GameOval
{
    private int width2;
    private int width;
    private int height;
    private int height2;
    private int speedY;
    private int speedX;
    public Pong(int w,int h,int w2,int h2)
    {
        super(250,125,w,h);
        width2=w2;
        height2=h2;
        width=w;
        height=h;
        speedY=7;
        speedX=7;
    }
    
    public void move()
    {
        int x=this.getX();
        int y=this.getY();
        this.setLocation(x+speedX,y+speedY);
        if((this.getX()>(width2-width))||(this.getX()<0))
        {
            speedX*=-1;
        }
        if((this.getY()>(height2-height))||(this.getY()<0))
        {
            speedY*=-1;
        }

    }
    public int left() {
        return getX();
    }

    public int right() {
        return getX() + width;
    }

    public int top() {
        return getY();
    }

    public int bottom() {
        return getY() + height;
    }
    public void changeSpeedD(){speedX*=-1;}
    public boolean checkX()
    {
        if((this.getX()<5)||(this.getX()>495)) {
            return true;
        }
        else
            return false;

    }
    public void reset()
    {
        this.setLocation(250,125);
    }
}

