package pong;
import resources.*;

import java.util.Random;

/**
 * Paddle class for Pong
 *
 * Garrett
 * @version (a version number or a date)
 */
public class Paddle extends GameRectangle{
    private int W;
    private int H;
    private int X;
    private int Y;
    private int value;
    public Paddle(int x, int y, int w, int h) {
        super(x, y, w, h);
        X=x;
        Y=y;
        W = w;
        H = h;
        setDefaultValue();
    }
    //makes basic computer bot
    public boolean computer()
    {
        boolean ting=true;
        Random gen=new Random();
        int temp=gen.nextInt(100)+1;
        if(value>temp){
            ting=false;
        }
        return ting;
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
    //reset computer difficulty
    public void setDefaultValue()
    {
        value=50;
    }
    //make computer get more difficult
    public void changeValue()
    {
        if(value>1) {
            value -= 2;
        }
        else
        {
            value=1;
        }
    }

    public int bottom() {
        return getY() + H;
    }
    //resets paddles
    public void reset()
    {
        this.setLocation(X,Y);
    }
    //was used for bug fixing
    public int ReturnValue()
    {
        return value;
    }
}