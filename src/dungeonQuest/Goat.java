package dungeonQuest;

import javax.swing.*;
import java.awt.*;

public class Goat extends JLabel{
    public Goat(int x, int y, int w, int h, String i)
    {
        super("");
        setBounds(x, y, w, h);
        setSize(new Dimension(w,h));
        setIcon(new ImageIcon(this.getClass().getResource(i)));
    }
}
