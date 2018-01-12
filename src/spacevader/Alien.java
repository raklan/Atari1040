package spacevader;

import java.awt.Color;


public class Alien extends SpaceEntity{

    protected Alien(int x, int y, int r)
    {
        super(x,y);
        String i;
        switch(r)
        {
            case 0:
                setSize(29,50);
                image = new EzImage(-10,0, 50, 50, "src/resources/space/FIREBALLResized.png");
                break;
            case 1:
                setSize(50,47);
                image = new EzImage(0,0, 50, 47, "src/resources/space/SPACESHIPResized.png");
                break;
            case 2:
                setSize(40,50);
                image = new EzImage(0,0, 40, 50, "src/resources/space/XWINGResized.png");
                break;
            case 3:
                setSize(50,42);
                image = new EzImage(0,0, 50, 42, "src/resources/space/BUGGYBUGResized.png");
                break;
            default:
                i = "";
                break;
        }

        add(image);

    }

    protected void shift(int u, int s)
    {
        x+=s;
        y+=u;
        setLocation(x,y);
    }
}
