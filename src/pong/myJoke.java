package pong;
import resources.GameRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class myJoke extends JFrame {
    public myJoke() {
        super();
        super.setBounds(350, 250, 500, 500);
        GameRectangle rec = new GameRectangle(0, 0, 300, 300);
        rec.setBackground(Color.BLACK);
        JLabel J = new JLabel("<html>For this game, use your imagination,<BR> pull out your phone and play a game, <BR>or press escape to quit </html>");
        J.setFont(new Font("Impact", Font.BOLD, 24));
        J.setLocation(100, 100);
        J.setForeground(Color.WHITE);
        J.setBounds(0, 0, 500, 150);
        rec.add(J);
        add(rec);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE: {
                        dispose();
                    }
                }
            }
        });
        setVisible(true);
    }
}