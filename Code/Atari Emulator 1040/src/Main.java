import javax.swing.*;
import java.awt.*;

/**
 * Created by Ryan on 12/18/2017.
 */
public class Main {

    public static void main(String[]args){
        JFrame frame = new JFrame("Atari Emulator 1040");
        frame.setVisible(true);
        frame.setBounds(0,0,1500,1000);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLUE);

        Menu mainMenu = new Menu();

        frame.add(mainMenu);

    }

}
