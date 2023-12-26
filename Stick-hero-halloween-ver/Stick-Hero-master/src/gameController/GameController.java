//i've given readme for this file below
package gameController;

import gameEngine.GameEngine;
import gamePanel.GamePanel;
import utils.SoundPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameController implements MouseListener, ActionListener{
    public static final int FPS = 80;
    private GameEngine engine;
    private GamePanel panel;
    private boolean isIncreasing;
    private boolean isRunning;
    public boolean upsideDown;

    public void init(GameEngine engine, GamePanel panel) {
        this.engine = engine;
        this.panel = panel;
    }

    public void start() {
        Thread gameLoop = new Thread(new Runnable() {
            @Override
            public void run() {
                isRunning = true;
                while (isRunning) {
                    panel.repaint();
                    try {
                        Thread.sleep(1000 / GameController.FPS);
                    } catch (Exception e) {

                    }
                }
            }
        });

        gameLoop.start();
    }


    public void nextRect(boolean isCherryTaken) {
        if (isCherryTaken) {
            SoundPlayer.playSound("C:\\Users\\Anya\\Downloads\\for stick hero game\\for stick hero game\\Stick-Hero-master\\Stick-Hero-master\\src\\resources\\sounds\\soundy.wav");
            engine.cherryTaken();
        }
        engine.nextRectangle();
    }



    public void gameOver() {
        panel.gameOver();
    }

    public void replay() {
        engine.init();
        panel.replay(engine, this);
    }


    public boolean isUpsideDown() {
        return upsideDown;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        upsideDown = !upsideDown;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (engine.isMoving()) {
            return;
        }

        Thread increaseStick = new Thread(new Runnable() {
            @Override
            public void run() {
                isIncreasing = true;
                while (isIncreasing) {
                    engine.increaseStickLength();
                    try {
                        Thread.sleep(1000 / GameController.FPS);
                    } catch (Exception e) {

                    }
                }
            }
        });

        increaseStick.start();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isIncreasing = false;
        engine.setMoving(true);
        engine.checkForGameOver();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.goToGame();
    }

}

//MORE ON THE CODE :
//package gameController;: Declares that the class belongs to the gameController package.
//import statements: Import necessary classes from other packages, including GameEngine, GamePanel, SoundPlayer, and event-related classes.
//public class GameController implements MouseListener, ActionListener{: Defines the GameController class that implements the MouseListener and ActionListener interfaces, enabling it to handle mouse and action events.

//Package Declaration and Imports: This section defines the package where the class resides and imports necessary classes and libraries required for this class to function properly.
//
//Class Definition and Variables: The GameController class is declared as a public class that implements the MouseListener and ActionListener interfaces.
// It includes variables for the GameEngine, GamePanel, and flags (isIncreasing, isRunning, upsideDown) to control game behavior.

//init() method: Initializes the GameEngine and GamePanel instances to set up the game.
//start() method: Initiates a game loop in a separate thread, responsible for continuously updating and repainting the GamePanel.
//nextRect() method: Progresses the game to the next rectangle, triggering actions based on whether a cherry is taken. If a cherry is taken, it plays a sound using SoundPlayer and increments the cherry count in the GameEngine.
//The remaining methods (gameOver(), replay(), and event handlers) handle game-over scenarios, replay functionality, and mouse events (e.g., clicking, pressing, releasing the mouse). These methods facilitate the game's interaction with the user interface and game logic.
//
//Please note: You need to adjust the sound file path in the SoundPlayer.playSound() method to the correct location of your soundy.wav file in your project structure.
//