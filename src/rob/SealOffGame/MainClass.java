package rob.SealOffGame;

import javax.swing.*;

public class MainClass extends JFrame {
    public MainClass() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setTitle("Seal Off");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
