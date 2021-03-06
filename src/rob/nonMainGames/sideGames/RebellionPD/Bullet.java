package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Bullet {
    private Image image;
    private int x, y, dx;

    public Bullet() {
        y = 187;
        x = 95;
        dx = 0;
        ImageIcon ii = new ImageIcon(getClass().getResource("bullet.png"));
        image = ii.getImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void move() {
        x += dx;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_Z) {
            dx = 2;
        }
    }
}
