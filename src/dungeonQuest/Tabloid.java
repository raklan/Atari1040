package dungeonQuest;

import com.sun.codemodel.internal.JOp;
import javafx.embed.swing.JFXPanel;
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

public class Tabloid extends JFrame {

    static private Random gen = new Random();

    private JLabel character;
    private Arrow arrow;
    private Grid grid;

    private int shoot, amount, eAmount, dead, ex1, ex2, ex3, why1, why2, why3;

    private Rectangle arec, grec, prec, crec, rec, herorec;

    private Goat goaty;
    private Pig piggy;
    private Chicken chicky;


    private ArrayList<Arrow> arrows;

    private Timer t;
    private int fps = 40;

    private int arrowLocation = 1;

    public Tabloid() {
        super("Jeff's Quest");
        ex1 = gen.nextInt(900);
        ex2 = gen.nextInt(900);
        ex3 = gen.nextInt(900);
        why1 = gen.nextInt(900);
        why2 = gen.nextInt(900);
        why3 = gen.nextInt(900);
        this.setBounds(0, 0, 1500, 1000);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        arrows = new ArrayList<>();
//        t = new Timer();
//        System.out.println(arrows);
//        t.schedule(new Tabloid.MyTimerTask(),0,1000/fps);
        this.createcharacter();
        this.addGoat(ex1, why1);
        this.addPig(ex2, why2);
        this.addChicken(ex3, why3);
        this.addGrid();
        this.createGoat();
        this.createChicken();
        this.createPig();
        herorec = new Rectangle(character.getX(), character.getY(),100, 100);
        eAmount = 0;
        grec = enemy("Goat");
        prec = enemy("Pig");
        crec = enemy("Chicken");
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_DOWN: amount += 1;  character.setLocation(character.getX(),character.getY()+100); herorec.setLocation(character.getX(),character.getY()+100); ai(amount, eAmount); eAmount += 1; keepInBounds(); checkCollision(); break;
                    case KeyEvent.VK_UP: amount += 1; character.setLocation(character.getX(),character.getY()-100);herorec.setLocation(character.getX(),character.getY()-100); ai(amount, eAmount); eAmount += 1; keepInBounds();  checkCollision(); break;
                    case KeyEvent.VK_LEFT: amount += 1;  character.setLocation(character.getX()-100,character.getY()); herorec.setLocation(character.getX()-100,character.getY()); ai(amount, eAmount); eAmount += 1; keepInBounds(); checkCollision(); break;
                    case KeyEvent.VK_RIGHT: amount += 1; character.setLocation(character.getX()+100,character.getY());herorec.setLocation(character.getX()+100,character.getY()); ai(amount, eAmount); eAmount += 1; keepInBounds(); checkCollision(); break;
//                    case KeyEvent.VK_SPACE: shoot += 1; amount +=1; ai(amount, eAmount); eAmount += 1; addArrow(); arrows.add(arrow); shootArrow(); break;
                }
            }
        });

        this.setVisible(true);

    }
    private void keepInBounds(){
        if(character.getX()<0)
        {
            character.setLocation(50, character.getY());
        }
        if (character.getY()<0)
        {
            character.setLocation(character.getX(), 15);
        }
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
    private void addGoat(int ex, int why){
        if(ex + 100 < character.getX() && ex -100 > character.getX())
        {
            ex += 100;
        }
        if(why + 100 < character.getY() && why - 100 > character.getY())
        {
            why +=100;
        }
        goaty = new Goat(ex, why, 200, 200, "/resources/dungeon/DerpyGoat1.png");
        goaty.setVisible(true);
        this.add(goaty,0);
    }
    private Rectangle createGoat(){
        grec = new Rectangle(goaty.getX(),goaty.getY(),goaty.getWidth(), goaty.getHeight());
        return grec;
    }
    private Pig addPig(int ex, int why) {
        if(ex + 100 < character.getX() && ex -100 > character.getX())
        {
            ex += 100;
        }
        if(why + 100 < character.getY() && why - 100 > character.getY())
        {
            why +=100;
        }
        piggy = new Pig(ex, why, 200, 200, "/resources/dungeon/Pig2.png");
        piggy.setVisible(true);
        this.add(piggy, 0);
        return piggy;
    }
    private Rectangle createPig() {
        prec = new Rectangle(piggy.getX(), piggy.getY(), piggy.getWidth(), piggy.getHeight());
        return prec;
    }
    private Chicken addChicken(int ex, int why) {
        if(ex + 100 < character.getX() && ex -100 > character.getX())
        {
            ex += 100;
        }
        if(why + 100 < character.getY() && why - 100 > character.getY())
        {
            why +=100;
        }
        chicky = new Chicken(ex, why, 150, 150, "/resources/dungeon/Chicken.png");
        chicky.setVisible(true);
        this.add(chicky, 0);
        return chicky;
    }
    private Rectangle createChicken() {
        crec = new Rectangle(chicky.getX(), chicky.getY(), chicky.getWidth(), chicky.getHeight());
        return crec;
    }

    private Rectangle enemy(String i){
        switch (i){
            case "Goat":
                rec = createGoat();
                break;
            case "Pig":
                rec = createPig();
                break;
            case "Chicken":
                rec = createChicken();
                break;
        }
        return rec;
    }
    private void ai(int amount, int eAmount) {
        if (amount != eAmount) {
            if (abs(goaty.getX() - character.getX()) > abs(goaty.getY() - character.getY())) {
                if (character.getX() - goaty.getX() > 0) {
                    goaty.setLocation(goaty.getX() + 100, goaty.getY());
                    grec.setLocation(goaty.getX() + 100, goaty.getY());
                } else if (character.getX() - goaty.getX() < 0) {
                    goaty.setLocation(goaty.getX() - 100, goaty.getY());
                    grec.setLocation(goaty.getX() - 100, goaty.getY());
                } else {
                    System.out.println("Error");
                }
            } else if (abs(goaty.getX() - character.getX()) < abs(goaty.getY() - character.getY())) {
                if (character.getY() - goaty.getY() > 0) {
                    goaty.setLocation(goaty.getX(), goaty.getY() + 100);
                    grec.setLocation(goaty.getX(), goaty.getY() + 100);
                } else if (character.getY() - goaty.getY() < 0) {
                    goaty.setLocation(goaty.getX(), goaty.getY() - 100);
                    grec.setLocation(goaty.getX(), goaty.getY() - 100);
                } else {
                    System.out.println("Error");
                }
            }
            if (abs(piggy.getX() - character.getX()) > abs(piggy.getY() - character.getY())) {
                if (character.getX() - piggy.getX() > 0) {
                    piggy.setLocation(piggy.getX() + 100, piggy.getY());
                    prec.setLocation(piggy.getX() + 100, piggy.getY());
                } else if (character.getX() - piggy.getX() < 0) {
                    piggy.setLocation(piggy.getX() - 100, piggy.getY());
                    prec.setLocation(piggy.getX() - 100, piggy.getY());
                } else {
                    System.out.println("Error");
                }
            } else if (abs(piggy.getX() - character.getX()) < abs(piggy.getY() - character.getY())) {
                if (character.getY() - piggy.getY() > 0) {
                    piggy.setLocation(piggy.getX(), piggy.getY() + 100);
                    prec.setLocation(piggy.getX(), piggy.getY() + 100);
                } else if (character.getY() - piggy.getY() < 0) {
                    piggy.setLocation(piggy.getX(), piggy.getY() - 100);
                    prec.setLocation(piggy.getX(), piggy.getY() - 100);
                }
            }
            if (abs(chicky.getX() - character.getX()) > abs(chicky.getY() - character.getY())) {
                if (character.getX() - chicky.getX() > 0) {
                    chicky.setLocation(chicky.getX() + 100, chicky.getY());
                    crec.setLocation(chicky.getX() + 100, chicky.getY());
                } else if (character.getX() - chicky.getX() < 0) {
                    chicky.setLocation(chicky.getX() - 100, chicky.getY());
                    crec.setLocation(chicky.getX() - 100, chicky.getY());
                } else {
                    System.out.println("Error");
                }
            } else if (abs(chicky.getX() - character.getX()) < abs(chicky.getY() - character.getY())) {
                if (character.getY() - chicky.getY() > 0) {
                    chicky.setLocation(chicky.getX(), chicky.getY() + 100);
                    crec.setLocation(chicky.getX(), chicky.getY() + 100);
                } else if (character.getY() - chicky.getY() < 0) {
                    chicky.setLocation(chicky.getX(), chicky.getY() - 100);
                    crec.setLocation(chicky.getX(), chicky.getY() - 100);
                }
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

    private Grid addGrid(){
        grid = new Grid(0,0,900,900, "/resources/dungeon/GridForBlake.png");
        grid.setVisible(true);
        this.add(grid);

        return grid;
    }
    private void shootArrow() {
        for (Arrow a : arrows) {
            arec = new Rectangle(a.getX(), a.getY(), a.getWidth(), a.getHeight());
            if (a.getCount() >= 1000) {
                a.setVisible(false);
                arrows.remove(a);
            } else {
                while (a.getCount() < 1000) {
                    a.setLocation(a.getX() + 1, a.getY());
                    a.setCount(a.getCount() + 1);
                    arec.setLocation(a.getX(), a.getY());
                    if (arec.intersects(grec)) {
                        remove(goaty);
                        dead += 1;
                    } else if (arec.intersects(prec)) {
                        remove(piggy);
                        dead += 1;
                    } else if (arec.intersects(crec)) {
                        remove(chicky);
                        dead += 1;
                    }
                }
                arrows.remove(a);
                remove(a);
                this.repaint();
            }
        }
    }
    private void checkCollision()
    {

        if(grec.intersects(herorec))
        {
            System.out.println("Hello");
            dispose();
            System.out.println("It took " + amount + " moves for the animals to get you");
            HighScore();
        }
        else if(prec.intersects(herorec))
        {
            dispose();
            System.out.println("It took " + amount + " moves for the animals to get you");
            HighScore();
        }
        else if (crec.intersects(herorec))
        {
            dispose();
            System.out.println("It took " + amount + " moves for the animals to get you");
            HighScore();

        }
    }
    public void HighScore()
    {
        player.highScoreJEFF high = new player.highScoreJEFF();
        boolean newHigh = high.readJEFFHighScore()<=amount;
        if(newHigh)
        {
            high.writeJEFFInvaders(amount);
            JOptionPane.showMessageDialog(null, "New High Score Of: " + amount);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Your Score was " + amount);
        }

    }

    //    public void act(){
//        shootArrow();
//        checkCollision();
//    }
//
//    public class MyTimerTask extends TimerTask {
//        @Override
//        public void run(){
//            act();
//        }
//    }
    public static void main(String[]args){
        new dungeonQuest.Tabloid();
    }

}