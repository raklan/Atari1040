package dungeonQuest;

import resources.*;
import javax.swing.*;
import java.awt.*;

public class Arrow extends JLabel{

    private int count;

    private JLabel a;

    public Arrow(int x, int y, int w, int h, String i){
        super("");
        count = 0;
        setBounds(x, y, w, h);
        setSize(new Dimension(w,h));
        setIcon(new ImageIcon(this.getClass().getResource(i)));
        setVisible(true);
    }

    public int getCount(){
        return count;
    }
    public void setCount(int x){
        count = x;
    }

    //public int shoot(int x)
    //{
    //        this.setLocation(x,this.getY());
    //        x += 10;
    //        return x;

    //}
}