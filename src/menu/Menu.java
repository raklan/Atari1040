package menu;

import javax.swing.*;
import resources.*;
import java.awt.*;
public class Menu extends GameRectangle {

    private GameRectangle title;
    private GameRectangle sel;
    private GameRectangle option1;
    private GameRectangle option2;
    private GameRectangle option3;
    private GameRectangle exit;

    public Menu(){
        super(0,0,1500,1000);
        this.setBackground(Color.BLACK);

        title = new GameRectangle(350,50,800,300);
        title.setBackground(Color.WHITE);

        option1 = new GameRectangle(550,400,400,100);
        option1.setBackground(Color.WHITE);

        option2= new GameRectangle(550,550,400,100);
        option2.setBackground(Color.WHITE);

        option3 = new GameRectangle(550,700,400,100);
        option3.setBackground(Color.WHITE);

        exit = new GameRectangle(550,850,400,100);
        exit.setBackground(Color.WHITE);

        sel = new GameRectangle(400,425,100,50);
        sel.setBackground(Color.WHITE);

        this.add(title);
        this.add(option1);
        this.add(option2);
        this.add(option3);
        this.add(exit);
        this.add(sel);

    }


}