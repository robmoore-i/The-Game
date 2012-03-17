package pierce.Liberation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public static int souls;
    public static int score;
    public static int health;
    public static int bullets;
    private int dy;
    public int x;
    public int y;
    private int canjump;
    private int step;
    private int frame;

    public Player() {
        souls = 0;
        health = 5;
        score = 0;
        bullets = 15;
        canjump = 1;
        x = 58*2;
        y = (58*4)+16;
        step = 0;
        frame = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getFrame() {
        return frame*23;
    }

    public void move() {
        if ((y+dy)<(58*4)+16) {y += dy;}else{y=58*4+16;}
        if (step==0){
            if ((canjump==0)&&(dy!=4)&&(y!=(58*4)+16)) {dy++;}
            if (y >= (58*4)+16) {y = (58*4)+16; dy = 0; canjump = 1;}
        }
        if (step<16){step++;}else{step=0; if (frame<1){frame++;}else{frame=0;}}
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_UP)&&(canjump==1)&&(dy==0)&&(y==(58*4)+16)) {
            dy = -4; canjump = 0;
        }
/*        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }*/
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            //dy = 0;
        }
    }
}