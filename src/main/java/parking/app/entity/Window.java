package parking.app.entity;

import javax.swing.*;

public class Window extends JFrame {

    public static JFrame frame = new JFrame();
    public Window() {
        frame.setSize(800, 900);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //ImageIcon icon = new ImageIcon("src/main/resources/img/iconoPoke.png");
        //frame.setIconImage(icon.getImage());
    }
}