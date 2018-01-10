package pong;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.awt.*;
import resources.*;

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
    private int counter=0;
private boolean up;
private boolean down;
private JLabel J;

private JLabel pongImage;

    public PongTable() {
        super();
        up=false;
        down=false;
        this.getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(700, 700, 700, 700);
        GameRectangle table = new GameRectangle(100, 100, 500, 250);
        GameRectangle rec=new GameRectangle(0,0,700,700);
        rec.setBackground(Color.BLACK);
        this.add(rec,0);
        table.setBackground(Color.BLUE);
        J=new JLabel(Integer.toString(counter));
        J.setFont(new Font("Impact", Font.BOLD,16));
        J.setLocation(450,450);
        J.setForeground(Color.WHITE);
        J.setBounds(450,450,50,50);
        rec.add(J);
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
        table.add(paddle, 0);
        table.add(ball, 0);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
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

                    case KeyEvent.VK_DOWN:
                        down=true;
                        if(!down) {
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
                J.setText(Integer.toString(counter));
            }
            else {
                paddle.reset();
                ball.reset();
                counter=0;
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
            counter++;
        }
    }

    public static void main(String[] args) {
        PongTable thing=new PongTable();
    }

}
