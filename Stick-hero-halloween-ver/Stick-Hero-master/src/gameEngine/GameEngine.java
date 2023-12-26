//i've given readme for this file below'
package gameEngine;

import java.util.Random;


public class GameEngine {
    public static final int MIN_DISTANCE = 100;
    public static final int MAX_DISTANCE = 250;
    private String name;
    private boolean gameOver;
    private boolean moving;
    private Rectangle first, second;
    private int distance;
    private int stickLength;
    private int score;

    private String backgroundImagePath;

    private int cherryNum;
    private int cherryPos;

    public GameEngine(String name) {
        this.name = name;
    }

    public void init() {
        first = new Rectangle();
        second = new Rectangle();

        assignDistance();
        stickLength = 0;
        score = 0;
        cherryNum = 0;

        gameOver = false;
        moving = false;
    }

    private void assignDistance() {
        Random rand = new Random();

        distance = 0;
        while (distance < GameEngine.MIN_DISTANCE)
            distance = rand.nextInt(GameEngine.MAX_DISTANCE);

        cherryPos = 0;
        while (cherryPos < 50) {
            cherryPos = rand.nextInt(distance - 50);
        }
    }

    public void increaseStickLength() {
        stickLength+= 3;
    }

    public void checkForGameOver() {
        if (stickLength < distance + 5 || distance + second.getWidth() + 5 < stickLength)
            gameOver = true;
    }

    public void nextRectangle() {
        first = second;
        second = new Rectangle();
        assignDistance();

        moving = false;
        stickLength = 0;
        score++;
    }
    public void reduceCherriesForRevival(int cherriesUsed) {
        int currentCherries = getCherryNum();
        if (currentCherries >= cherriesUsed) {
            cherryNum -= cherriesUsed;
        }
    }
    public void setBackground(String path) {
        this.backgroundImagePath = path;
    }

    // You might want a getter for the background image path as well
    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }




    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Rectangle getFirstRect() {
        return first;
    }

    public Rectangle getSecondRect() {
        return second;
    }

    public int getDistance() {
        return distance;
    }

    public int getStickLength() {
        return stickLength;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getCherryPos() {
        return cherryPos;
    }

    public void cherryTaken() {
        cherryNum++;
    }

    public int getCherryNum() {
        return cherryNum;
    }
}

//EXPLANATION OF ABOVE CODE
//This GameEngine class represents the core functionality of the game and manages its state. It controls the game's logic, including player movement, game progress, cherry collection, and background settings.

//Initialization and State Management: The class initializes various parameters required for the game, such as the player's stick length, score, cherry count, and positions. It also manages the game's state (whether it's over or not) and tracks movement within the game.

//Randomization of Game Elements: It contains methods to generate random distances between rectangles and cherry positions, essential for the dynamic generation of game elements.

//Gameplay Mechanisms:
//increaseStickLength(): Increases the stick length as the player progresses.
//checkForGameOver(): Checks if the game is over based on the stick's length and the distance between rectangles.
//nextRectangle(): Advances to the next rectangle, updating game parameters like the score, distance, and stick length.
//Cherry Mechanics: Tracks cherry collection and provides methods to handle cherries, such as reducing cherries for revival (reduceCherriesForRevival) and updating the cherry count when a cherry is taken (cherryTaken).

//Background Management:
//
//setBackground(String path): Sets the path for the background image of the game.
//getBackgroundImagePath(): Retrieves the path of the background image.

//Overall, the GameEngine class serves as the backbone of the game, controlling and managing crucial game mechanics and state transitions.