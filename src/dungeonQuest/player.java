package dungeonQuest;

import javax.swing.*;

public class player extends JLabel{
    protected int x, y, shoot, count, tcount;
    public player(int x, int y, int w, int h, String i){
        super("");
        setBounds(x,y,w,h);
        setIcon(new ImageIcon(this.getClass().getResource(i)));
        setVisible(true);
        shoot = 15;
        System.out.println(count);
    }
    public void moved(int x, int y, int count) {
        this.setLocation(x, y);
        tcount += 1;
        if (count == tcount) {
            System.out.println("done");
        }

    }


}
