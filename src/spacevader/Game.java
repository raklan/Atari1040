package spacevader;
import resources.GameRectangle;

import javax.swing.*;
import java.awt.*;

public class Game extends GameRectangle{

    Alien[][] fleet;

    public Game(JFrame win)
    {
        super(0,0,win.getWidth(), win.getHeight());
        setBackground(Color.black);

        int s = 20;
        int w = 50 + s;
        int n = (getWidth()-s)/w;
        fleet = new Alien[n][4];
        for(int j = 0; j<fleet[0].length; j++) {
            for (int i = 0; i < n; i++) {
                fleet[i][j] = new Alien(i * w + s, 100+j*w);
                add(fleet[i][j]);
            }
        }
    }

}