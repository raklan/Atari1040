<<<<<<< HEAD
import javax.swing.*;
import java.awt.*;
import menu.Menu;
import resources.GameRectangle;
import spacevader.Game;
=======
import menu.MenuGUI;
import menu.NewMenu;
>>>>>>> refs/remotes/origin/master

import javax.swing.*;

/**
 * Created by Ryan on 12/18/2017.
 */
public class Main {

//    static JFrame frame = new JFrame("Atari Emulator 1040");

    public static void main(String[]args){
//        frame.setVisible(true);
//        frame.setBounds(0,0,1500,1000);
//        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
//        frame.getContentPane().setBackground(Color.BLUE);

        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new MenuGUI().$$$getRootComponent$$$());

        mainMenu();

        //mainMenu();

        Game spacegame = new Game(frame);
        frame.add(spacegame);
        spacegame.requestFocusInWindow();
    }

    public static void mainMenu() {

        //Menu menu = new Menu();
        //NewMenu menu = new NewMenu();



//        for(JLabel l: menu.getList()){
//            frame.add(l);
//            l.setLocation(350,50);
//        }
//        frame.setVisible(true);
//
//        frame.getContentPane().setBackground(Color.BLACK);
    }




}
