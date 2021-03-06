package rob.nonMainGames.sideGames.SealOffGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Enemy {
    public static int health, x;
    private int dx, direction, width;
    private boolean isHitting;
    public static boolean isBlocking;
    private boolean whileHitting;
    private ImageIcon leftStand, leftBlock, leftPunch;
    private ImageIcon rightStand, rightBlock, rightPunch;

    public Enemy() {
        x = 0;
        whileHitting = false;
        health = 2000;
        width = 45;
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
        direction = 3;
        //left = 1, right = 3;
    }

    public int getX() {
        return x;
    }

    public Image getImage() {
        Image returnThing;
        if (direction == 1) {
            if (isHitting && !isBlocking) {
                if (!whileHitting) {
                    returnThing = leftPunch.getImage();
                    if (((x <= Player.x && direction == 3) || (x > Player.x && direction == 1)) && ((Panel.isAdjacent(x, Player.x, width + 10) && direction == 1) || (Panel.isAdjacent(x, Player.x, width + 10) && direction == 3))) {
                        if (!Player.isBlocking) {
                            Player.health -= 2;
                        } else {
                            Player.health--;
                        }
                    }
                } else {
                    returnThing = leftStand.getImage();
                }
            } else if (isBlocking && !isHitting) {
                returnThing = leftBlock.getImage();
            } else {
                returnThing = leftStand.getImage();
            }
        } else if (direction == 3) {
            if (isHitting && !isBlocking) {
                if (!whileHitting) {
                    returnThing = rightPunch.getImage();
                    if (((x <= Player.x && direction == 3) || (x > Player.x && direction == 1)) && ((Panel.isAdjacent(x, Player.x, width + 10) && direction == 1) || (Panel.isAdjacent(x, Player.x, width + 10) && direction == 3))) {
                        if (!Player.isBlocking) {
                            Player.health -= 2;
                        } else {
                            Player.health--;
                        }
                    }
                } else {
                    returnThing = rightStand.getImage();
                }
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
        x += dx;
        if (dx < 0) {
            direction = 1;
        } else if (dx > 0) {
            direction = 3;
        }
        basicBounds();
    }


    private void basicBounds() {
        if (x <= 0) {
            x = 0;
        } else if (x >= 400 - width) {
            x = 400 - width;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D && !isHitting && !isBlocking) {
            dx = 1;
        } else if (key == KeyEvent.VK_A && !isHitting && !isBlocking) {
            dx = -1;
        } else if (key == KeyEvent.VK_Z) {
            isHitting = true;
        } else if (key == KeyEvent.VK_X) {
            isBlocking = true;
        } else if (key == KeyEvent.VK_ENTER) {
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            dx = 0;
        } else if (key == KeyEvent.VK_A) {
            dx = 0;
        } else if (key == KeyEvent.VK_Z) {
            isHitting = false;
            whileHitting = false;
        } else if (key == KeyEvent.VK_X) {
            isBlocking = false;
        } else if (key == KeyEvent.VK_ENTER) {
            isHitting = false;
        }
    }
}