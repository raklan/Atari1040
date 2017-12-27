package menu;

import javax.swing.*;
import resources.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Menu {

    private JLabel title;
    private GameRectangle sel;
    private GameRectangle option1;
    private GameRectangle option2;
    private GameRectangle option3;
    private GameRectangle exit;

    ArrayList<JLabel> objects = new ArrayList<JLabel>();

    public Menu(){

        try {
            URL url = new URL("file://localhost/Users/Ryan/Documents/GitHub/Atari1040/src/AtariRainbow.gif");
            Icon icon = new ImageIcon(url);
            title = new JLabel(icon);
        }catch(Exception e){
            e.printStackTrace();
        }

        title.setLocation(350,50);

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

        objects.add(title);

    }

    public JLabel makeGif(){
        try {
            Icon icon = new ImageIcon(new URL("file://localhost/Users/Ryan/Documents/GitHub/Atari1040/src/AtariRainbow.gif"));
            JLabel label = new JLabel(icon);
            return label;
        }catch(MalformedURLException e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<JLabel> getList(){
        return objects;
    }

}