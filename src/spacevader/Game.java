package spacevader;
import resources.GameRectangle;

import javax.swing.*;
import java.awt.*;

public class Game extends GameRectangle{

    Alien[][] fleet;
    Ship ship;

    public Game(JFrame win)
    {
        super(0,0,win.getWidth()-15, win.getHeight()-35);
        setBackground(Color.black);

        int row = 20; //number of aliens per row
        int s = (getWidth()-row*50)/(row+1); //space between aliens
        int w = 50 + s; //with of aliens + space
        fleet = new Alien[row][4];
        for(int j = 0; j<fleet[0].length; j++) {
            for (int i = 0; i < row; i++) {
                fleet[i][j] = new Alien(i * w + s, 50+j*w);
                add(fleet[i][j]);
            }
        }

        ship = new Ship(getWidth()/2+25, getHeight()-s-50-30);
        add(ship);


    }

}