package menu;

import javax.swing.*;
import javax.swing.border.Border;

import resources.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
not used... look at NewMenu
 */
public class Menu extends JFrame{

    private JPanel panel;
    private JLabel title;
    private JLabel sel;
    private JLabel option1;
    private JLabel option2;
    private JLabel option3;
    private JLabel exit;
    private int selLocation = 1;

    public Menu() {
        super("Atari Emulator 1040");
        this.setBounds(0, 0, 1500, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
                        if (selLocation == 1){}
                        else if(selLocation == 2){}
                        else if(selLocation == 3){}
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

        this.setVisible(true);

    }

    private void createTitle(){
        title = new JLabel("ATARI EMULATOR 1040");
        title.setForeground(Color.WHITE);
        title.setSize(new Dimension(800,300));
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 64));
        title.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        title.setLocation(350,0);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVisible(true);
        this.add(title);
    }
    private void createOptions(){
        option1 = new JLabel("Space Invaders");
        option1.setForeground(Color.WHITE);
        option1.setSize(new Dimension(400,100));
        option1.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        option1.setLocation(550,350);
        option1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        option1.setHorizontalAlignment(SwingConstants.CENTER);
        option1.setVisible(true);

        option2 = new JLabel("Jeff's Quest");
        option2.setForeground(Color.WHITE);
        option2.setSize(new Dimension(400,100));
        option2.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        option2.setLocation(550,450);
        option2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        option2.setHorizontalAlignment(SwingConstants.CENTER);
        option2.setVisible(true);

        option3 = new JLabel("Pong");
        option3.setForeground(Color.WHITE);
        option3.setSize(new Dimension(400,100));
        option3.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        option3.setLocation(550,550);
        option3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        option3.setHorizontalAlignment(SwingConstants.CENTER);
        option3.setVisible(true);

        exit = new JLabel("Quit");
        exit.setForeground(Color.WHITE);
        exit.setSize(new Dimension(400,100));
        exit.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        exit.setLocation(550,750);
        exit.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setVisible(true);

        this.add(option1);
        this.add(option2);
        this.add(option3);
        this.add(exit);
    }

    private void addSel(){
        sel = new JLabel("-->");
        sel.setForeground(Color.WHITE);
        sel.setSize(new Dimension(100,50));
        sel.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        sel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        sel.setLocation(425,375);
        sel.setHorizontalAlignment(SwingConstants.CENTER);
        sel.setVisible(true);
        this.add(sel);
    }


}

