package menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import resources.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
/*
not used... look at NewMenu
 */
public class Menu {

    JFrame frame = new JFrame("Atari Emulator 1040");
    private JLabel title;
    private GameRectangle sel;
    private GameRectangle option1;
    private GameRectangle option2;
    private GameRectangle option3;
    private GameRectangle exit;


    ArrayList<JLabel> menuObjects = new ArrayList<>();

    public Menu() {

        //frame.setVisible(true);
        frame.setBounds(0, 0, 1500, 1000);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLUE);
        //frame.pack();
        frame.setLocationByPlatform(true);


        createTitle();

        exit = new GameRectangle(550,850,400,100);
        exit.setBackground(Color.WHITE);

        sel = new GameRectangle(400,425,100,50);
        sel.setBackground(Color.WHITE);

        frame.setVisible(true);

//        option1 = new GameRectangle(550,400,400,100);
//        option1.setBackground(Color.WHITE);
//
//        option2= new GameRectangle(550,550,400,100);
//        option2.setBackground(Color.WHITE);
//
//        option3 = new GameRectangle(550,700,400,100);
//        option3.setBackground(Color.WHITE);
//



    }

    private void createTitle() {
        try {
            BufferedImage bi = ImageIO.read(getClass().getResource("/resources/images/AtariRainbow.gif"));
            //BufferedImage bi = ImageIO.read(new URL("file://./resources/images/AtariRainbow.gif"));
            ImageIcon backgroundImage = new ImageIcon(bi.getScaledInstance(250, 100, Image.SCALE_SMOOTH));
            //title = new JLabel(backgroundImage);
            //title = new JLabel(new ImageIcon(bi));
            title = new JLabel();

            //title.setLocation(500,50);
            title.setIcon(backgroundImage);

            frame.add(title);
            //menuObjects.add(title);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

