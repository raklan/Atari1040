package dungeonQuest;

import resources.GameRectangle;
import spacevader.SpaceGame;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Math.abs;

public class NewTabloid extends JFrame {

    static private Random gen = new Random();
    
    private JLabel character;
    private Arrow arrow;

    private int shoot, amount, eAmount;

    private Rectangle arec, grec;

    private Goat goaty;

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
        this.addGoat();
        this.createcharacter();

        eAmount = 0;

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_DOWN: amount += 1; ai(amount, eAmount); eAmount += 1; character.setLocation(character.getX(),character.getY()+100); break;
                    case KeyEvent.VK_UP: amount += 1; ai(amount, eAmount); eAmount += 1; character.setLocation(character.getX(),character.getY()-100); break;
                    case KeyEvent.VK_LEFT: amount += 1; ai(amount, eAmount); eAmount += 1; character.setLocation(character.getX()-100,character.getY()); break;
                    case KeyEvent.VK_RIGHT: amount += 1; ai(amount, eAmount); eAmount += 1; character.setLocation(character.getX()+100,character.getY()); break;
                    case KeyEvent.VK_SPACE: shoot += 1; ai(amount, eAmount); eAmount += 1; arrows.add(addArrow()); shootArrow(); break;
                }
            }
        });

        this.setVisible(true);

    }

    private void createcharacter(){
        character = new JLabel("");
        character.setSize(new Dimension(100,100));
        ImageIcon theImage = new ImageIcon(this.getClass().getResource("/resources/dungeon/FarmerMan.png"));
        character.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        character.setIcon(theImage);
        character.setLocation(350,0);
        character.setVisible(true);
        this.add(character);
    }
    private Goat addGoat(){
        goaty = new Goat(1500, character.getY(), 200, 200, "/resources/dungeon/DerpyGoat1.png");
        goaty.setVisible(true);
        this.add(goaty,0);
        return goaty;
    }
//    private Rectangle enemy(){
//
//    }
    private void ai(int amount, int eAmount){
        if(amount != eAmount){
            if(abs(goaty.getX() - character.getX()) > abs(goaty.getY() - character.getY()))
            {
                if (character.getX() - goaty.getX() > 0){
                    goaty.setLocation(goaty.getX() + 100, goaty.getY() );
                }
                else if(character.getX() - goaty.getX() < 0){
                    goaty.setLocation(goaty.getX() - 100, goaty.getY());
                }
                else{
                    System.out.println("Error");
                }
            }
            else if(abs(goaty.getX() - character.getX()) < abs(goaty.getY() - character.getY())){
                if (character.getY() - goaty.getY() > 0){
                    goaty.setLocation(goaty.getX(), goaty.getY() + 100);
                }
                else if(character.getY() - goaty.getY() < 0){
                    goaty.setLocation(goaty.getX(), goaty.getY()- 100);
                }
                else{
                    System.out.println("Error");
                }
            }
            else{
                System.out.println("Error");
            }
        }
    }
    private Arrow addArrow(){
        arrow = new Arrow(character.getX(), character.getY(), 50,50, "/resources/dungeon/ArrowWithFletching.png");
        arrow.setLocation(character.getX(),character.getY());
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
                arec = new Rectangle(a.getX(), a.getY(), a.getWidth(), a.getHeight());
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