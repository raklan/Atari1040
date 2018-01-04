package pong;
import resources.*;
/**
 * Write a description of class Paddle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Paddle extends GameRectangle
{
    
    public Paddle(int x,int y, int w, int h)
    {
        super(x,y,w,h);
    }
    public void moveUP() {
        this.setLocation(getX(),getY()-5);
    }

    public void moveDown() {
        this.setLocation(getX(),getY()+5);
    }
}
