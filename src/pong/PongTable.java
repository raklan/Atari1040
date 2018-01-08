package pong;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.awt.*;
import resources.GameRectangle;

/**
 * 
 * 
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PongTable extends JFrame {
    private int fps = 50;
    private Timer t = new Timer();
    private Pong ball;
    private Paddle paddle;
private boolean up;
private boolean down;
    public PongTable() {
        super();
        up=false;
        down=false;
        this.getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(700, 700, 700, 700);
        GameRectangle table = new GameRectangle(0, 50, 500, 250);
        table.setBackground(Color.BLACK);
        this.add(table, 0);
        ball = new Pong(5, 5, 500, 250);
        ball.setBackground(Color.WHITE);
        paddle = new Paddle(10, 125, 10, 35);
        paddle.setBackground(Color.WHITE);
        table.add(paddle, 0);
        table.add(ball, 0);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        up=true;
                        if (up != false
                                ) {


                            paddle.moveUP();
                            //code for moving paddle up
                        }
                            break;

                    case KeyEvent.VK_DOWN:
                        down=true;
                        if(down!=false) {
                            paddle.moveDown();
                        }
                        //code for moving paddle down
                        break;
                }
            }
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
                }
            }
        });
        t.schedule(new myTimerTask(), 0, 1000 / fps);
        setVisible(true);
    }

    public class myTimerTask extends TimerTask {
        @Override
        public void run() {
            if(!ball.checkX()) {
                ball.move();
                if (up) {
                    paddle.moveUP();

                }
                if (down) {
                    paddle.moveDown();
                }
                collide();
            }
            else {
                paddle.reset();
                ball.reset();
                }
            }
        }


    public void collide()
    {
        int right=ball.right();
        int bottom=ball.bottom();
        int left=ball.left();
        int top=ball.top();
        int L2=paddle.left();
        int R2=paddle.right();
        int B2=paddle.bottom();
        int T2=paddle.top();
        if((right>L2)&&(right<R2)&&(bottom>T2)&&(bottom<B2)||
                (right>L2)&&(right<R2)&&(top>T2)&&(top<B2)||
                (left>L2)&&(left<R2)&&(bottom>T2)&&(bottom<B2)||
                (left>L2)&&(left<R2)&&(top>T2)&&(top<B2)) {
            ball.changeSpeedD();
        }
    }

    public static void main(String[] args) {
        PongTable thing=new PongTable();
    }

}
