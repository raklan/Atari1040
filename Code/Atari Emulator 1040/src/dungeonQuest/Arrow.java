public class Arrow extends EzImage{
    protected int x, y;
    public Arrow(int sides, int height, int w, int h, String i)
    {
        super(sides,height,w,h,i);
        x = sides;
        y = height;
}
    public int shoot(int x)
    {
            this.setLocation(x,this.getY());
            x += 10;
            return x;

    }
}