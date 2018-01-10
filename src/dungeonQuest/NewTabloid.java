package dungeonQuest;

import resources.GameRectangle;
import spacevader.SpaceGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class NewTabloid extends JFrame {

    static private Random gen = new Random();
    
    private JLabel player;
    private Arrow arrow;

    private int shoot;

    private ArrayList<Arrow> arrows = new ArrayList<Arrow>();

    private java.util.Timer t = new Timer();
    private int fps = 40;

    private int arrowLocation = 1;

    public NewTabloid() {
        super("Jeff's Quest");
        this.setBounds(0, 0, 1500, 1000);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);

        t.schedule(new NewTabloid.MyTimerTask(),0,1000/fps);

        this.createPlayer();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_DOWN: player.setLocation(player.getX(),player.getY()+10); break;
                    case KeyEvent.VK_UP: player.setLocation(player.getX(),player.getY()-10); break;
                    case KeyEvent.VK_LEFT: player.setLocation(player.getX()-10,player.getY()); break;
                    case KeyEvent.VK_RIGHT: player.setLocation(player.getX()+10,player.getY()); break;
                    case KeyEvent.VK_SPACE: shoot -= 1; arrows.add(addArrow()); shootArrow(); break;
                }
            }
        });

        this.setVisible(true);

    }

    private void createPlayer(){
        player = new JLabel("");
        player.setSize(new Dimension(100,100));
        ImageIcon theImage = new ImageIcon(this.getClass().getResource("/resources/dungeon/FarmerMan.png"));
        player.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        player.setIcon(theImage);
        player.setLocation(350,0);
        player.setVisible(true);
        this.add(player);
    }

    private Arrow addArrow(){
        arrow = new Arrow(player.getX(), player.getY(), 50,50, "/resources/dungeon/ArrowWithFletching.png");
        arrow.setLocation(player.getX(),player.getY());
        arrow.setHorizontalAlignment(SwingConstants.CENTER);
        arrow.setVisible(true);
        this.add(arrow);

        return arrow;
    }

    private void shootArrow(){
        for(Arrow a : arrows){
            if(a.getCount()>=1000){
                a.setVisible(false);
                this.remove(a);
                arrows.remove(a);
            }
            else {
                while (a.getCount() < 1000) {
                    a.setLocation(a.getX() + 1, a.getY());
                    a.setCount(a.getCount() + 1);
                    this.repaint();

                    //check Collision
                }
            }

        }
    }

    private void act(){
        shootArrow();
    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run(){
            act();
        }
    }

}