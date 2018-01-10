package menu;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

public class NewMenu extends JFrame {

    JPanel contentPane;
    JLabel imageLabel = new JLabel();
    JLabel headerLabel = new JLabel();
    JLabel menuItem1 = new JLabel();
    JLabel menuItem2 = new JLabel();
    JLabel menuItem3 = new JLabel();
    JLabel selector = new JLabel();

    public NewMenu() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            contentPane = (JPanel) getContentPane();
            //contentPane.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentPane.setBackground(Color.black);

            setSize(new Dimension(1500, 900));
            setTitle("Atari Emulator 1040!");

            //SetHeaderText();
            SetTitleImage();
            SetMenuItems();
            //SetSelector();


            // show it
            this.setLocationRelativeTo(null);
            this.setVisible(true);


        } catch (Exception exception)

        {
            exception.printStackTrace();
        }
    }

    private void SetHeaderText() {
        // add the header label

        headerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        headerLabel.setText("Choose the game you wish to play!");
        headerLabel.setForeground(Color.white);
        contentPane.add(headerLabel);
    }

    private void SetTitleImage() throws MalformedURLException {
        //this will resize the image, but it breaks the animation
//            BufferedImage bi = ImageIO.read(getClass().getResource("/Desktop/LogoMovedGif.gif"));
//            ImageIcon titleImage = new ImageIcon(bi.getScaledInstance(250, 100, Image.SCALE_SMOOTH));
        URL url = new URL("/resources/images/LogoSlow.gif");
        Icon titleImage = new ImageIcon(url);
        JLabel label = new JLabel(titleImage);

        JFrame f = new JFrame("Animation");
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        //contentPane.add(imageLabel, SwingConstants.TOP);
        //imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void SetMenuItems(){
        menuItem1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        menuItem1.setText("SpaceGame Option #1");
        menuItem1.setForeground(Color.white);
        menuItem1.setSize(400,100);
        menuItem1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contentPane.add(menuItem1, SwingConstants.CENTER);
        menuItem1.setHorizontalAlignment(SwingConstants.CENTER);
        menuItem1.setVerticalAlignment(SwingConstants.TOP);

        menuItem2.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        menuItem2.setText("SpaceGame Option #2");
        menuItem2.setForeground(Color.white);
        menuItem2.setSize(new Dimension(400,100));
        menuItem2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contentPane.add(menuItem2, SwingConstants.CENTER);
        menuItem2.setHorizontalAlignment(SwingConstants.CENTER);
        menuItem2.setVerticalAlignment(SwingConstants.CENTER);

        menuItem3.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        menuItem3.setText("SpaceGame Option #3");
        menuItem3.setForeground(Color.white);
        contentPane.add(menuItem3, SwingConstants.CENTER);
    }

    private void SetSelector(){
        ImageIcon sel = new ImageIcon(this.getClass().getResource("/resources/images/ArrowWhite.gif"));
        selector.setIcon(sel);

        contentPane.add(selector, SwingConstants.CENTER);
        selector.setHorizontalAlignment(SwingConstants.CENTER);
    }
}

