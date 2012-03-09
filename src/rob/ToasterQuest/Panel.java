package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Level level;

    public Panel() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        level = new Level();
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(level.getImage(), level.getX(), level.getY(), this);
        g2d.drawImage(level.getPImage(), 200 + 4, 150 - 20, (200 + 4 + (level.getPWidth() * 2)), (150 + (level.getPHeight() * 2) - 20), level.getSprFrame(), level.getSprDir(), (level.getSprFrame() + level.getPWidth()), (level.getSprDir() + level.getPHeight()), this);
        g2d.drawString("Height = " + level.getY(), 100, 100);
        g2d.drawString("Distance = " + level.getX(), 100, 150);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        if (level.up) {
            level.y++;
            if (level.y > level.jumpHeight) {
                level.up = false;
                level.y += 3;
                level.canJump = false;
            }
        } else {
            level.y -= 3;
        }
        level.canJump = true;
        level.move();
        repaint();
    }

    private class adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            level.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            level.keyReleased(e);
        }
    }
}
