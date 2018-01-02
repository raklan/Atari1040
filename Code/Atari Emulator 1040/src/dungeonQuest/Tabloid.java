import javax.swing.*;

public class Tabloid {
    protected static player jeff;
    public static void main(String[]args)
    {
        JFrame win=new JFrame("Picture");
        win.setBounds(0,0,1000,1000);
        win.setLayout(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
        //Character
        jeff = new player(startx, starty, 50,50);
        win.add(jeff,0);
    }
}
