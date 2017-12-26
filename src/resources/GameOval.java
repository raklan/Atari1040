package resources;

import javax.swing.*;
import java.awt.*;

/** resources.GameOval Supplier Class
 * Author: David D. Riley
 * Date: April, 2004
 */
public class GameOval extends JComponent  {

    /** post:   getX() == x  and  getY() == y
     *          and  getWidth() == w  and getHeight() == h
     *          and  getBackground() == Color.black
     */
	public GameOval(int x, int y, int w, int h)  {
        super();
		setBounds(x, y, w, h);
        setBackground(Color.black);
	}

    /** post:   this method draws a filled resources.GameOval
     *          and  the upper left corner of the bounding rectangle is (getX(), getY()) 
     *          and  the oval's dimensions are getWidth() and getHeight()
     *          and  the oval's color is getBackground()
     */
    public void paint(Graphics g)  {
        g.setColor( getBackground() );
        g.fillOval(0, 0, getWidth()-1, getHeight()-1);
        paintChildren(g);
   }

}