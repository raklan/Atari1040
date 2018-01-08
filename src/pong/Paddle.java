package pong;
import resources.*;
/**
 * Write a description of class Paddle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Paddle extends GameRectangle{
    private int W;
    private int H;
    private int X;
    private int Y;
    public Paddle(int x, int y, int w, int h) {
        super(x, y, w, h);
        X=x;
        Y=y;
        W = w;
        H = h;
    }

    public void moveUP() {
        this.setLocation(getX(), getY() - 5);
    }

    public void moveDown() {
        this.setLocation(getX(), getY() + 5);
    }

    public int left() {
        return getX();
    }

    public int right() {
        return getX() + W;
    }

    public int top() {
        return getY();
    }

    public int bottom() {
        return getY() + H;
    }
    public void reset()
    {
        this.setLocation(X,Y);
    }
}