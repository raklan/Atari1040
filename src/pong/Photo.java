package pong;
import javax.swing.*;
import java.awt.*;
public class Photo extends JLabel{
    public Photo(int x, int y, int g, int b,String i){
        super("");
        setVisible(true);
        setSize(new Dimension(g,b));
        setLocation(x,y);
        setIcon(new ImageIcon(this.getClass().getResource(i)));

    }
}
