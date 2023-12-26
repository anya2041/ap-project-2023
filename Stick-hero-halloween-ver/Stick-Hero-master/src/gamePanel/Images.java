package gamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Images {
    public static Image background;

    public static Image backgroundLevel2;

    public static Image backgroundLevel3;
    public static Image gameOver;

    public static Image startButton;
    public static Image stand;
    public static Image walk1;
    public static Image walk2;
    public static Image walk3;
    public static Image walk4;
    public static Image replay;
    public static Image cherry;

    public static final int BACKGROUND_WIDTH = 500;
    public static final int BACKGROUND_HEIGHT = 600;
    public static final int HERO_WIDTH = 25;
    public static final int HERO_HEIGHT = 50;

    static {

        try {

            background = ImageIO.read(new File("images/background.png"));
            backgroundLevel2 = ImageIO.read(new File("images/backgroundLevel2.png"));
            backgroundLevel3 = ImageIO.read(new File("images/backgroundLevel3.png"));
            startButton = ImageIO.read(new File("images/StartButton.png"));
            stand = ImageIO.read(new File("images/stand.png"));
            walk1 = ImageIO.read(new File("images/walk1.png"));
            walk2 = ImageIO.read(new File("images/walk2.png"));
            walk3 = ImageIO.read(new File("images/walk3.png"));
            walk4 = ImageIO.read(new File("images/walk2.png"));
            replay = ImageIO.read(new File("images/replay.png"));
            cherry = ImageIO.read(new File("images/cherry.png"));
            gameOver = ImageIO.read(new File("images/GameOver.png"));

        } catch (IOException e) {

        }
    }
}
// CODE EXPLANATION:
//The Images class is a utility that manages the loading of image assets used within the game. It reads various images such as background art, buttons, character sprites, and other visual elements essential for the game's graphical representation. Here's an explanation of its components:
//
//        Image Loading:
//
//        The class uses ImageIO.read(new File("path/to/image.png")) to load images from specific file paths on the disk.
//        background, backgroundLevel2, and backgroundLevel3 store different background images for various game levels.
//        startButton, replay, gameOver, and cherry represent buttons, game-over screens, and collectible cherry images respectively.
//        stand, walk1, walk2, walk3, and walk4 are character sprite images representing different frames of the walking animation.
//
//
//        Image Dimensions:
//
//        Constants like BACKGROUND_WIDTH and BACKGROUND_HEIGHT store the dimensions of the background images.
//        HERO_WIDTH and HERO_HEIGHT define the dimensions of the game's character sprite.
//
//
//        Static Initialization:
//
//        The static block ensures that the images are loaded when the class is first accessed.
//        In case an IOException occurs during image loading, it doesn't handle the exception but allows the program to continue execution silently.