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

/**
 *  Made By Garrett
 */
public class PongTable extends JFrame {
    private int fps = 50;
    private Timer t = new Timer();
    private Pong ball;
    private Paddle paddle;
    private Paddle paddle2;
    private int counter=0;
    private boolean up;
    private boolean down;
    private boolean s;
    private boolean w;
    private JLabel J;

    private JLabel pongImage;

    public PongTable() {
        super();
        up=false;
        down=false;
        this.getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 200, 700, 700);
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
        paddle2=new Paddle(480,125,10,35);
        paddle2.setBackground(Color.WHITE);
        table.add(paddle2);
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
                    case KeyEvent.VK_W:
                    {
                        w=true;
                        if(!w)
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
                        if(!s)
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
            if(!ball.checkX()) {
                ball.move();
                if (up) {
                    paddle.moveUP();

                }
                if (down) {
                    paddle.moveDown();
                }
                if(w)
                {
                    paddle2.moveUP();
                }
                if(s)
                {
                    paddle2.moveDown();
                }
                collide(paddle.left(), paddle.right(), paddle.bottom(), paddle.top());
                collide(paddle2.left(), paddle2.right(), paddle2.bottom(), paddle2.top());
                J.setText(Integer.toString(counter));
            }
            else {
                paddle2.reset();
                paddle.reset();
                ball.reset();
                counter=0;
            }
        }
    }


    public void collide(int l,int r,int b,int t)
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
            counter++;
        }
    }
}