public class player extends EzImage{
    protected int x, y, shoot, count, tcount;
    public player(int up, int sides, int w, int h, String i){
        super(up,sides,w,h,i);
        shoot = 15;
        System.out.println(count);
    }
    public void moved(int x, int y, int count) {
        this.setLocation(x, y);
        tcount += 1;
        if (count == tcount) {
            System.out.println("done");
        }

    }


}
