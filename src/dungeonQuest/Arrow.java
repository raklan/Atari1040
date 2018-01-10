package dungeonQuest;

import resources.*;
import javax.swing.*;

public class Arrow extends JLabel{
    protected int x, y;
    public Arrow(int x, int y, int w, int h, String i) {
        super("");
        setBounds(x, y, w, h);
        setIcon(new ImageIcon(this.getClass().getResource(i)));
        setVisible(true);
    }
    public int shoot(int x)
    {
            this.setLocation(x,this.getY());
            x += 10;
            return x;

    }
}