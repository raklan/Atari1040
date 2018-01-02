package menu;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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
        headerLabel.setText("Choose the game you wsh to play!");
        headerLabel.setForeground(Color.white);
        contentPane.add(headerLabel);
    }

    private void SetTitleImage() {
        //this will resize the image, but it breaks the animation
//            BufferedImage bi = ImageIO.read(getClass().getResource("/resources/images/AtariRainbow.gif"));
//            ImageIcon titleImage = new ImageIcon(bi.getScaledInstance(250, 100, Image.SCALE_SMOOTH));
        ImageIcon titleImage = new ImageIcon(this.getClass().getResource("/resources/images/AtariRainbowResized.gif"));
        imageLabel.setIcon(titleImage);

        contentPane.add(imageLabel, SwingConstants.TOP);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void SetMenuItems(){
        menuItem1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        menuItem1.setText("Game Option #1");
        menuItem1.setForeground(Color.white);
        menuItem1.setSize(400,100);
        menuItem1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contentPane.add(menuItem1, SwingConstants.CENTER);
        menuItem1.setHorizontalAlignment(SwingConstants.CENTER);
        menuItem1.setVerticalAlignment(SwingConstants.TOP);

        menuItem2.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        menuItem2.setText("Game Option #2");
        menuItem2.setForeground(Color.white);
        menuItem2.setSize(new Dimension(400,100));
        menuItem2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contentPane.add(menuItem2, SwingConstants.CENTER);
        menuItem2.setHorizontalAlignment(SwingConstants.CENTER);
        menuItem2.setVerticalAlignment(SwingConstants.CENTER);

        menuItem3.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        menuItem3.setText("Game Option #3");
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

