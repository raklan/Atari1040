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
public class PongTable extends JFrame
{
    private int fps=50;
    private Timer t=new Timer();
    private JFrame back;
    private Pong ball;
    public PongTable()
    {
        super();
        setBounds(700,700,700,700);
        GameRectangle table =new GameRectangle(0,50,500,250);
        table.setBackground(Color.BLACK);
        add(table,0);
        ball=new Pong(5,5,500,250);
        ball.setBackground(Color.WHITE);
        Paddle paddle=new Paddle(10,50,10,35);
        paddle.setBackground(Color.WHITE);
        table.add(paddle,0);
        table.add(ball,0);
        setFocusable(true);
        addKeyListener(new KeyAdapter()
            {
                @Override
                public void keyPressed(KeyEvent e)
                {
                    switch(e.getKeyCode())
                    {
                        case KeyEvent.VK_UP:
                        //code for moving paddle up
                        break;

                        case KeyEvent.VK_DOWN:
                        //code for moving paddle down
                        break;
                    }
                }
            });
        t.schedule(new myTimerTask(), 0, 1000/fps);
        setVisible(true);
    }

    public class myTimerTask extends TimerTask
    {
        @Override
        public void run() {
            ball.move();
        }

    }
}
