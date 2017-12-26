package resources;

import javax.swing.*;
import java.awt.*;

/** resources.GameRectangle Supplier Class
 * Author: David D. Riley
 * Date: April, 2004
 */
public class GameRectangle extends JComponent  {

    /** post:   getX() == x  and  getY() == y
     *          and  getWidth() == w  and getHeight() == h
     *          and  getBackground() == Color.black
     */
	public GameRectangle(int x, int y, int w, int h)  {
        super();
		setBounds(x, y, w, h);
        setBackground(Color.black);
	}

    /** post:   this method draws a filled resources.GameRectangle
     *          and  the upper left corner is (getX(), getY()) 
     *          and  the rectangle's dimensions are getWidth() and getHeight()
     *          and  the rectangle's color is getBackground()
     */
    public void paint(Graphics g)  {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getWidth()-1, getHeight()-1);
        paintChildren(g);
   }

}