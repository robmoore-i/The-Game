package rob.SealOffGame;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    public int x;
    private int dx;
    private int rage;
    public int health, baseDamage, defense, direction;
    public boolean isHitting, isBlocking;
    private ImageIcon leftStand, leftBlock, leftPunch;
    private ImageIcon rightStand, rightBlock, rightPunch;
    private int LEFT, RIGHT;

    public Enemy() {
        LEFT = 1;
        RIGHT = 3;
        health = 200;
        rage = 0;
        baseDamage = 0;
        defense = 0;
        isHitting = false;
        isBlocking = false;
        //imageIcons START
        leftStand = new ImageIcon(getClass().getResource("leftStand.png"));
        leftPunch = new ImageIcon(getClass().getResource("leftPunch.png"));
        leftBlock = new ImageIcon(getClass().getResource("leftBlock.png"));
        rightStand = new ImageIcon(getClass().getResource("rightStand.png"));
        rightPunch = new ImageIcon(getClass().getResource("rightPunch.png"));
        rightBlock = new ImageIcon(getClass().getResource("rightBlock.png"));
        //imageIcons END
        direction = 1;
        //left = 1, right = 3;
    }

    public int getX() {
        return x;
    }

    public Image getImage() {
        Image returnThing;
        if (direction == LEFT) {
            if (isHitting && !isBlocking) {
                returnThing = leftPunch.getImage();
            } else if (isBlocking && !isHitting) {
                returnThing = leftBlock.getImage();
            } else {
                returnThing = leftStand.getImage();
            }
        } else if (direction == RIGHT) {
            if (isHitting && !isBlocking) {
                returnThing = rightPunch.getImage();
            } else if (isBlocking && !isHitting) {
                returnThing = rightBlock.getImage();
            } else {
                returnThing = rightStand.getImage();
            }
        } else {
            returnThing = rightStand.getImage();
        }
        return returnThing;
    }

    public void move() {
        decideMove();
        x += dx;
        basicBounds();
    }


    private void basicBounds() {
        if (x <= 0) {
            x = 0;
        } else if (x >= 251) {
            x = 251;
        }
    }

    public void decideMove() {
        if (x + 149 <= Player.x) {
            dx = 1;
            direction = RIGHT;
        } else if (x >= Player.x + 149) {
            dx = -1;
            direction = LEFT;
        }
    }
}