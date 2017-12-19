import javax.swing.*;
import java.awt.*;
public class Menu extends Rectangle{

    private Rectangle title;
    private Rectangle sel;
    private Rectangle option1;
    private Rectangle option2;
    private Rectangle option3;

    public Menu(){
        super(0,0,1500,1000);
        this.setBackground(Color.BLACK);

        title = new Rectangle(350,50,800,300);
        title.setBackground(Color.WHITE);

        option1 = new Rectangle(550,400,400,100);
        option1.setBackground(Color.WHITE);

        option2= new Rectangle(550,550,400,100);
        option2.setBackground(Color.WHITE);

        option3 = new Rectangle(550,700,400,100);
        option3.setBackground(Color.WHITE);

        sel = new Rectangle(400,425,100,50);
        sel.setBackground(Color.WHITE);

        this.add(title);
        this.add(option1);
        this.add(option2);
        this.add(option3);
        this.add(sel);

    }


}