import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import menu.Menu;
import resources.GameRectangle;


/**
 * Created by Ryan on 12/18/2017.
 */
public class Main {

    static JFrame frame = new JFrame("Atari Emulator 1040");

    public static void main(String[]args)throws MalformedURLException{
        frame.setVisible(true);
        frame.setBounds(0,0,1500,1000);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLUE);

        mainMenu();

    }
    public static void mainMenu()throws MalformedURLException{

        Menu menu = new Menu();

        for(JLabel l: menu.getList()){
            frame.add(l);
            l.setLocation(350,50);
        }
        frame.setVisible(true);

        frame.getContentPane().setBackground(Color.BLACK);
    }



}
