package gamePanel;

import gameController.GameController;
import gameEngine.GameEngine;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    private PlayPanel playPanel;
    private StartPanel startPanel;
    private NamePanel namePanel;
    private GameOverPanel gameOverPanel;

    private GameEngine engine;
    private GameController controller;

    public void init(GameEngine engine, GameController controller) {
        this.engine = engine;
        this.controller = controller;

        gameOverPanel = new GameOverPanel(engine, controller);
        namePanel = new NamePanel(engine);
        startPanel = new StartPanel(controller);
        playPanel = new PlayPanel(engine, controller);
        playPanel.addMouseListener(controller);

        this.setLayout(new BorderLayout());

        this.add(startPanel, BorderLayout.CENTER);
        this.add(namePanel, BorderLayout.PAGE_END);
    }

    public void goToGame() {
        this.remove(startPanel);
        this.add(playPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }


    public void gameOver() {
        this.remove(playPanel);
        this.add(gameOverPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void replay(GameEngine engine, GameController controller) {
        this.remove(gameOverPanel);
        this.remove(namePanel);
        revalidate();
        repaint();
        init(engine, controller);
    }
}
//CODE EXPLANATION :
//The GamePanel class acts as the central hub for the game's visual interface, coordinating various key components like the PlayPanel, StartPanel, NamePanel, and GameOverPanel.
//Using the BorderLayout, it arranges these panels strategically, ensuring an intuitive layout and seamless transitions between different game stages.
// Its pivotal methods, such as goToGame() and gameOver(), are responsible for managing the visual switches during gameplay events, while replay() ensures the game can reset accurately for a fresh round of play.
