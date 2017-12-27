import javax.swing.*;
import java.awt.*;
import menu.Menu;
import resources.GameRectangle;


/**
 * Created by Ryan on 12/18/2017.
 */
public class Main {

    static JFrame frame = new JFrame("Atari Emulator 1040");

    public static void main(String[]args){
        frame.setVisible(true);
        frame.setBounds(0,0,1500,1000);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLUE);

    }
    public static void mainMenu(){
        frame.getContentPane().setBackground(Color.BLACK);
        Menu menu = new Menu();
        for(JLabel l: menu.getList())
            frame.add(l);
    }



}
