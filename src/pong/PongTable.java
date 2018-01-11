package pong;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.awt.*;
import resources.*;
import menu.Menu;
import player.highScorePong;


/**
 * Pong game board
 *  Made By Garrett
 */
public class PongTable extends JFrame {
    private int score=0;
    private int fps = 50;
    private Timer t = new Timer();
    private GameRectangle rec;
    private Pong ball;
    private Paddle paddle;
    private Paddle paddle2;
    private int counter=0;
    private int counter2=0;
    private int high;
    private boolean up;
    private boolean down;
    private boolean s;
    private boolean w;
    private boolean decision;
    private boolean aim;
    private JLabel J;
    private JLabel J2;
    private JLabel test;
    private JLabel test2;
    private JLabel test3;
    private highScorePong whatever;

    private JLabel pongImage;

    public PongTable() {
        super();
        up=false;
        down=false;
        this.getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 200, 700, 700);
        GameRectangle table = new GameRectangle(100, 100, 500, 250);
        rec=new GameRectangle(0,0,700,700);
        rec.setBackground(Color.BLACK);
        this.add(rec,0);
        table.setBackground(Color.BLUE);
        //allows single or local multiplayer
        int ting=JOptionPane.showConfirmDialog(null,"Are You playing with another human?(Local)","No is playing a computer",JOptionPane.YES_NO_OPTION);
        if(ting==0) {
            decision=true;
        }
        J=new JLabel(Integer.toString(counter));
        J.setFont(new Font("Impact", Font.BOLD,16));
        J.setForeground(Color.WHITE);
        J.setBounds(250,450,50,50);
        J2=new JLabel(Integer.toString(counter));
        J2.setFont(new Font("Impact", Font.BOLD,16));
        J2.setForeground(Color.WHITE);
        J2.setBounds(450,450,50,50);
        test=new JLabel("Press ESC to quit");
        test.setFont(new Font("Impact", Font.BOLD,16));
        test.setForeground(Color.WHITE);
        test.setBounds(350,550,200,50);
        rec.add(test);
        if(!decision) {
            whatever=new highScorePong();
            test2 = new JLabel(Integer.toString(score));
            test2.setFont(new Font("Impact", Font.BOLD, 16));
            test2.setForeground(Color.WHITE);
            test2.setBounds(300, 400, 50, 50);
            rec.add(test2);
            test3 = new JLabel("HIGHSCORE  "+Integer.toString(high=whatever.readPongHighScore()));
            test3.setFont(new Font("Impact", Font.BOLD, 16));
            test3.setForeground(Color.WHITE);
            test3.setBounds(100, 400, 150, 50);
            rec.add(test3);

        }
        rec.add(J);
        rec.add(J2);
        pongImage = new JLabel("");
        pongImage.setSize(new Dimension(400,100));
        pongImage.setIcon(new ImageIcon(this.getClass().getResource("/resources/images/Pong White.png")));
        pongImage.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        pongImage.setLocation(100,0);
        pongImage.setHorizontalAlignment(SwingConstants.CENTER);
        pongImage.setVisible(true);


        rec.add(pongImage);


        rec.add(table, 0);
        ball = new Pong(5, 5, 500, 250);
        ball.setBackground(Color.WHITE);
        paddle = new Paddle(10, 125, 10, 35);
        paddle.setBackground(Color.WHITE);
        paddle2=new Paddle(480,125,10,35);
        paddle2.setBackground(Color.WHITE);
        table.add(paddle2);
        table.add(paddle, 0);
        table.add(ball, 0);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            //code for when a key is pressed
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        up=true;
                        if (!up
                                ) {


                            paddle.moveUP();
                            //code for moving paddle up
                        }
                        break;
                    case KeyEvent.VK_W:
                    {
                        w=true;
                        if((!w)&&(decision))
                        {
                            paddle2.moveUP();
                        }
                        break;
                    }

                    case KeyEvent.VK_DOWN:
                        down=true;
                        if(!down) {
                            paddle.moveDown();
                        }
                        //code for moving paddle down
                        break;
                    case KeyEvent.VK_S:
                    {
                        s=true;
                        if((!s)&&(decision))
                        {
                            paddle2.moveDown();
                        }
                        break;
                    }

                    case KeyEvent.VK_ESCAPE:
                    {
                        new Menu();
                        dispose();
                    }
                }
            }
            //code for when key is lifted
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        up=false;
                        //code for moving paddle up
                        break;

                    case KeyEvent.VK_DOWN:
                        down=false;
                        //code for moving paddle down
                        break;
                    case KeyEvent.VK_W:
                        w=false;
                        break;
                    case KeyEvent.VK_S:
                        s=false;
                        break;
                }
            }
        });
        t.schedule(new myTimerTask(), 0, 1000 / fps);
        setVisible(true);
    }

    public class myTimerTask extends TimerTask {
        @Override
        public void run() {

            if(!decision) {
                test2.setText(Integer.toString(score));

            }
            //allows gameplay if ball is not out of bounds
            if((!ball.checkX1())&&(!ball.checkX2())) {
                ball.move();
                if (up) {
                    paddle.moveUP();

                }
                if (down) {
                    paddle.moveDown();
                }
                if((w)&&(decision))
                {
                    paddle2.moveUP();
                }
                if((s)&&(decision))
                {
                    paddle2.moveDown();
                }

                if(!decision) {
                    if(aim){
                        paddle2.setLocation(paddle2.getX(),ball.getY());

                }
                else
                    {
                        paddle2.setLocation(paddle2.getX(),ball.getY()+10);

                    }
                }
                if(collide(paddle.left(), paddle.right(), paddle.bottom(), paddle.top())) {
                    counter++;
                    if(counter%3==0)
                    {
                        ball.changeSpeed();
                    }
                    aim=paddle2.computer();


                }
                if(collide(paddle2.left(), paddle2.right(), paddle2.bottom(), paddle2.top())) {
                    counter2++;
                }


                J.setText(Integer.toString(counter));
                J2.setText(Integer.toString(counter2));
            }
            else {
                if(!ball.checkX2()) {
                    counter=0;
                    score=0;
                }
                if(!ball.checkX1()) {
                    counter2=0;
                    if(!decision) {
                        paddle2.changeValue();
                        score++;
                    }
                }
                //makes new highscore
                if(!decision)
                    if(high<score) {
                        whatever.writePongInvaders(score);
                    }
                    //resets the bored
                aim=paddle2.computer();
                ball.reset();
                paddle2.reset();
                paddle.reset();


            }
        }
    }

//checks for paddle ball collision
    public boolean collide(int l,int r,int b,int t)
    {
        int right=ball.right();
        int bottom=ball.bottom();
        int left=ball.left();
        int top=ball.top();
        int L2=l;
        int R2=r;
        int B2=b;
        int T2=t;
        if((right>L2)&&(right<R2)&&(bottom>T2)&&(bottom<B2)||
                (right>L2)&&(right<R2)&&(top>T2)&&(top<B2)||
                (left>L2)&&(left<R2)&&(bottom>T2)&&(bottom<B2)||
                (left>L2)&&(left<R2)&&(top>T2)&&(top<B2)) {
            ball.changeSpeedD();
            return true;
        }
        else
        {
            return false; }
    }

}