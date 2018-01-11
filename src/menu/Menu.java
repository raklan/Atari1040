package menu;
import pong.myJoke;
import resources.*;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;

import spacevader.SpaceGame;
import pong.PongTable;

/**
 * By Ryan The Babe
 */

public class Menu extends JFrame{

    static private Random gen = new Random();

    private JLabel title;
    private JLabel sel;
    private JLabel option1;
    private JLabel option2;
    private JLabel option3;
    private JLabel exit;
    private JLabel copyright;
    private JLabel names;

    private int selLocation = 1;

    public Menu() {
        super("Atari Emulator 1040");
        this.setBounds(0, 0, 1500, 1000);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_DOWN: {
                        if (selLocation == 1 || selLocation == 2){
                            sel.setLocation(sel.getX(), sel.getY() + 100);
                            selLocation++;
                        }
                        else if(selLocation==3){
                            sel.setLocation(sel.getX(), sel.getY() + 200);
                            selLocation++;
                        }
                        else{
                            sel.setLocation(425, 375);
                            selLocation = 1;
                        }
                        break;
                    }
                    case KeyEvent.VK_UP: {
                        if (selLocation == 2 || selLocation == 3){
                            sel.setLocation(sel.getX(), sel.getY() - 100);
                            selLocation--;
                        }
                        else if(selLocation==4){
                            sel.setLocation(sel.getX(), sel.getY() - 200);
                            selLocation--;
                        }
                        else{
                            sel.setLocation(425, 775);
                            selLocation = 4;
                        }
                        break;
                    }
                    case KeyEvent.VK_ENTER: {
                        if (selLocation == 1){
                            //Instantiate Space Invaders Object
                            SpaceGame space = new SpaceGame();

                        }
                        else if(selLocation == 2){
                            myJoke joke=new myJoke();
                            //Instantiate Jeff's Quest Object
                        }
                        else if(selLocation == 3){
                            //Instantiate Pong Object
                            PongTable pong=new PongTable();

                        }
                        else if(selLocation == 4){
                            dispose();
                        }
                        break;
                    }
                }
            }
        });

        this.createTitle();
        this.createOptions();
        this.addSel();

        this.createStars();

        this.setVisible(true);

    }

    private void createTitle(){
        title = new JLabel("");
        title.setSize(new Dimension(800,300));
        ImageIcon theImage = new ImageIcon(this.getClass().getResource("/resources/images/LogoResized.png"));
        title.setIcon(theImage);
        title.setLocation(350,0);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVisible(true);
        this.add(title);

        copyright = new JLabel("");
        copyright.setSize(new Dimension(350,100));
        ImageIcon copyrightImage = new ImageIcon(this.getClass().getResource("/resources/images/Copyright Stuff.png"));
        copyright.setIcon(copyrightImage);
        copyright.setLocation(25,875);
        copyright.setHorizontalAlignment(SwingConstants.LEFT);
        copyright.setVisible(true);
        this.add(copyright);

        names = new JLabel("");
        names.setSize(new Dimension(350,100));
        ImageIcon namesImage = new ImageIcon(this.getClass().getResource("/resources/images/Naems.png"));
        names.setIcon(namesImage);
        names.setLocation(1100,875);
        names.setHorizontalAlignment(SwingConstants.LEFT);
        names.setVisible(true);
        this.add(names);
    }
    private void createOptions(){
        option1 = new JLabel("");
        option1.setSize(new Dimension(400,100));
        option1.setIcon(new ImageIcon(this.getClass().getResource("/resources/images/SpaceInvadersLogoWhite.png")));
        option1.setLocation(550,350);
        option1.setHorizontalAlignment(SwingConstants.CENTER);
        option1.setVisible(true);

        option2 = new JLabel("Jeff's Quest");
        option2.setSize(new Dimension(400,100));
        option2.setIcon(new ImageIcon(this.getClass().getResource("/resources/images/JeffLogoWhite.png")));
        option2.setLocation(550,450);
        option2.setHorizontalAlignment(SwingConstants.CENTER);
        option2.setVisible(true);

        option3 = new JLabel("");
        option3.setSize(new Dimension(400,100));
        option3.setIcon(new ImageIcon(this.getClass().getResource("/resources/images/Pong White.png")));
        option3.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        option3.setLocation(550,550);
        option3.setHorizontalAlignment(SwingConstants.CENTER);
        option3.setVisible(true);

        exit = new JLabel("");
        exit.setForeground(Color.WHITE);
        exit.setSize(new Dimension(400,100));
        exit.setIcon(new ImageIcon(this.getClass().getResource("/resources/images/QuitWhiteLogo.png")));
        exit.setLocation(550,750);
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setVisible(true);

        this.add(option1);
        this.add(option2);
        this.add(option3);
        this.add(exit);
    }

    private void addSel(){
        sel = new JLabel("");
        sel.setSize(new Dimension(100,50));
        sel.setIcon(new ImageIcon(this.getClass().getResource("/resources/images/ArrowResizedWhite.png")));
        sel.setLocation(425,375);
        sel.setHorizontalAlignment(SwingConstants.CENTER);
        sel.setVisible(true);
        this.add(sel);
    }

    private void createStars(){
        for(int i = 0; i<=50; i++){
            GameRectangle star = new GameRectangle(gen.nextInt(1400)+50, gen.nextInt(850)+100, 3,3);
            star.setBackground(Color.WHITE);
            star.setVisible(true);
            this.add(star);
        }
    }


}