package gamePanel;

import gameController.GameController;
import gameEngine.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;


public class PlayPanel extends JPanel {
    private static final int STICK_WIDTH = 3;
    private static final int RECT_HEIGHT = 220;
    private static final int RECT_START = 50;


    private GameEngine engine;
    private GameController controller;

    private int backgroundMoveValue = 0;

    private int firstWidth;
    private int secondWidth;
    private int secondRectPos;
    private int moveValue;

    private int rotateDegree;
    private int rotateSpeed;

    private int dest;
    private int heroA;
    private int heroB;
    private int imageCycle;
    private int cycleCnt;

    private boolean isCherryTaken;

    public PlayPanel(GameEngine engine, GameController controller) {
        this.engine = engine;
        this.controller = controller;
        init();
    }

    public void init() {
        backgroundMoveValue++;
        moveValue = 0;
        secondRectPos = 600;

        rotateDegree = 0;
        rotateSpeed = 1;

        firstWidth = engine.getFirstRect().getWidth();
        secondWidth = engine.getSecondRect().getWidth();

        heroA = RECT_START + firstWidth - 5 - Images.HERO_WIDTH;
        heroB = Images.BACKGROUND_HEIGHT - RECT_HEIGHT - Images.HERO_HEIGHT;

        imageCycle = 0;
        cycleCnt = 0;
        dest = 0;

        isCherryTaken = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        moveBackground(g2d);

        g2d.setColor(Color.black);

        AffineTransform def = g2d.getTransform();

        calcRectMove();
        drawRects(g2d);

        //Draw Stick
        calcDegree();
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotateDegree), RECT_START + firstWidth - STICK_WIDTH - 2,
                Images.BACKGROUND_HEIGHT - RECT_HEIGHT);
        g2d.fillRect(RECT_START + firstWidth - STICK_WIDTH - 2, Images.BACKGROUND_HEIGHT - RECT_HEIGHT - engine.getStickLength(),
                STICK_WIDTH, engine.getStickLength());
        g2d.setTransform(old);

        calcDest();
        moveHero();
        drawHero(g2d);

        checkForCherryTaken();
        drawCherry(g2d);

        g2d.setTransform(def);

        checkForGameOver();


        drawScore(g2d);
    }

    private void calcRectMove() {
        if (moveValue >= engine.getDistance() + firstWidth ) {
            controller.nextRect(isCherryTaken);
            init();
        }

        if (rotateDegree == 90 && heroA == dest && !engine.isGameOver()) {
            moveValue += 4;
        }
    }

    private void moveBackground(Graphics2D g2d) {
        if (rotateDegree == 90 && heroB == dest && backgroundMoveValue % 20 != 0 && !engine.isGameOver())
            backgroundMoveValue++;

        AffineTransform old = g2d.getTransform();
        g2d.translate(-backgroundMoveValue, 0);
        g2d.drawImage(Images.background, 0, 0, null);
        g2d.setTransform(old);
    }

    private void drawRects(Graphics2D g2d) {
        g2d.translate(-moveValue, 0);
        g2d.fillRect(RECT_START, Images.BACKGROUND_HEIGHT - RECT_HEIGHT, firstWidth, RECT_HEIGHT);

        if (!engine.isMoving() && rotateDegree == 0 && secondRectPos != RECT_START + firstWidth + engine.getDistance() )
            secondRectPos -= 20;
        if (secondRectPos < RECT_START + firstWidth + engine.getDistance())
            secondRectPos = RECT_START + firstWidth + engine.getDistance();

        g2d.fillRect(secondRectPos,
                Images.BACKGROUND_HEIGHT - RECT_HEIGHT, secondWidth, RECT_HEIGHT);
    }

    private void calcDegree() {
        if (!engine.isMoving())
            return;

        if (rotateDegree < 90) {
            rotateDegree += rotateSpeed / 5;
            rotateSpeed ++;
        } else {
            rotateDegree = 90;
        }
    }




    private void drawHero(Graphics2D g2d) {
        if (heroA <= RECT_START + firstWidth)
            controller.upsideDown = false;
        AffineTransform old = g2d.getTransform();
        g2d.translate(heroA, heroB + Images.HERO_HEIGHT);
        if (engine.isMoving() && controller.isUpsideDown()) {
            g2d.scale(1, -1);
        }
        if (rotateDegree == 90 && heroB < dest) {
            switch (imageCycle) {
                case 0:
                    g2d.drawImage(Images.walk1, 0, -Images.HERO_HEIGHT, null);
                    break;
                case 1:
                    g2d.drawImage(Images.walk2, 0, -Images.HERO_HEIGHT, null);
                    break;
                case 2:
                    g2d.drawImage(Images.walk3, 0, -Images.HERO_HEIGHT, null);
                    break;
                case 3:
                    g2d.drawImage(Images.walk4, 0, -Images.HERO_HEIGHT, null);
                    break;
            }

            cycleCnt++;
            cycleCnt %= 8;
            if (cycleCnt % 8 == 0) {
                imageCycle++;
                imageCycle %= 4;
            }

        } else {
            g2d.drawImage(Images.stand, 0, -Images.HERO_HEIGHT, null);
        }

        g2d.setTransform(old);
    }





    private void calcDest() {
        if (engine.isGameOver() && controller.isUpsideDown())
            return;

        if (engine.isGameOver()) {
            dest = RECT_START + firstWidth - Images.HERO_WIDTH + engine.getStickLength();
        } else {
            dest = RECT_START + firstWidth + engine.getDistance() + secondWidth - 5 - Images.HERO_WIDTH;
        }
    }




    private void moveHero() {
        if (rotateDegree == 90 && heroA < dest)
            heroA += 2;

        if (heroA > dest)
            heroA = dest;

        if (heroA == dest && engine.isGameOver())
            heroB += 20;

        if (heroB > Images.BACKGROUND_HEIGHT)
            controller.gameOver();
    }


    private void drawCherry(Graphics2D g2d) {
        if (!isCherryTaken) {
            g2d.drawImage(Images.cherry, RECT_START + firstWidth + engine.getCherryPos(),
                    Images.BACKGROUND_HEIGHT - RECT_HEIGHT + 5, null);
        }
    }

    private void checkForCherryTaken() {
        if (controller.isUpsideDown() && heroA+ Images.HERO_WIDTH >= RECT_START + firstWidth + engine.getCherryPos()
                            && heroA <= RECT_START + firstWidth + engine.getCherryPos() + 25)
            isCherryTaken = true;
    }


    private void checkForGameOver() {
        if (controller.isUpsideDown() && heroA + Images.HERO_WIDTH >= RECT_START + firstWidth + engine.getDistance() ) {
            engine.setGameOver(true);
            dest = heroA;
        }
    }





    private void drawScore(Graphics2D g2d) {
        g2d.setFont(new Font("Garamond", Font.PLAIN, 40));
        g2d.setColor(Color.pink);
        g2d.drawString("Score : " + engine.getScore(), 20, 40);
        g2d.drawString("Cherries : " + engine.getCherryNum(), 250, 40);
    }
}

//CODE EXPLANATION
//This PlayPanel class represents the interactive gameplay screen within the game. It oversees the rendering of various game components and their dynamic movements. Let's delve deeper into its functionalities:
//
//        Initialization:
//
//        init(): Sets initial values and variables for the game elements, such as rectangles, hero positions, rotation degrees, and more.
//        Drawing Components:
//
//        paintComponent(Graphics g): Handles the graphical rendering of all game elements.
//        moveBackground(Graphics2D g2d): Controls the continuous movement of the game background based on the hero's actions.
//        drawRects(Graphics2D g2d): Renders the rectangles representing the platforms for the hero to traverse.
//        calcDegree(): Calculates the rotation degree for the stick during its movement.
//        Hero Movement and Animation:
//
//        drawHero(Graphics2D g2d): Manages the drawing of the hero character and handles its animations based on the hero's movement and game state.
//        calcDest(): Determines the destination for the hero based on the game state.
//        moveHero(): Governs the movement of the hero character across the screen, ensuring it reaches the intended destination smoothly.
//        checkForGameOver(): Detects conditions leading to the game over state and appropriately updates the game state.
//        Cherry Mechanics:
//
//        drawCherry(Graphics2D g2d): Renders cherries at specific positions on the screen.
//        checkForCherryTaken(): Checks if the hero character interacts with and collects cherries during gameplay.
//        Game Over and Scoring:
//
//        drawScore(Graphics2D g2d): Displays the game score and cherry count on the screen.