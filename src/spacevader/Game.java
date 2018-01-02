package spacevader;
import resources.GameRectangle;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{

    Alien[][] fleet;
    Ship ship;

    public Game()
    {
        super("SpaceShooter");
        setBounds(0,0,1500, 1000);
        getContentPane().setBackground(Color.black);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

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