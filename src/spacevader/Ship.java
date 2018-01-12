package spacevader;

public class Ship extends SpaceEntity{



    public Ship(int x, int y)
    {
        super(x,y);
        setSize(69,100);
        image = new EzImage(-21,-2, 107, 107, "src/resources/space/MilleniumFalconResized.png");
        add(image);
    }
}
