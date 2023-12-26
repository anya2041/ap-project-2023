import gameController.GameController;
import gameEngine.GameEngine;
import gamePanel.GamePanel;
import utils.SoundPlayer;

import javax.swing.*;

public class StickHero {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Stick Hero");
        String name;

        SoundPlayer.playSound("C:\\Users\\Anya\\Downloads\\for stick hero game\\for stick hero game\\Stick-Hero-master\\Stick-Hero-master\\src\\resources\\sounds\\spooky.wav");

        name = JOptionPane.showInputDialog(frame, "Enter Your Name", "Welcome", JOptionPane.QUESTION_MESSAGE);

        GameEngine engine = new GameEngine(name);
        GameController controller = new GameController();
        GamePanel panel = new GamePanel();

        engine.init();
        controller.init(engine, panel);
        panel.init(engine, controller);

        controller.start();

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}


//IN DEPTH CODE EXPLANATION :
//The StickHero class represents the entry point of the Stick Hero game. Here's an elaborate breakdown of its functionalities:
//
//        Main Method:
//
//        The main method is the starting point of execution for the Stick Hero game.
//        Invokes SwingUtilities.invokeLater to schedule the creation and display of the Swing components on the Event Dispatch Thread (EDT).
//
//
//        Create and Show GUI:
//
//        createAndShowGUI method initializes the game's graphical user interface (GUI) components.
//        Creates a JFrame named frame with the title "Stick Hero."
//
//
//        SoundPlayer Integration:
//
//        Uses SoundPlayer.playSound to play a spooky sound upon launching the game.
//
//
//        User Input:
//
//        Utilizes JOptionPane.showInputDialog to prompt the user to enter their name via a dialog box. The entered name is stored in the name variable.
//
//
//        Game Initialization:
//
//        Instantiates GameEngine, GameController, and GamePanel objects.
//        Initializes the GameEngine (engine) with the provided name.
//        Initializes the GameController (controller) and GamePanel (panel) with references to the engine and controller.
//
//
//        Game Start:
//
//        Calls engine.init() to initialize the game engine.
//        Initializes the controller with the engine and panel references using controller.init(engine, panel).
//        Initializes the panel with the engine and controller references using panel.init(engine, controller).
//        Initiates the game loop by calling controller.start().
//
//
//        Frame Configuration:
//
//        Adds the panel (containing the game interface) to the frame using frame.getContentPane().add(panel).
//        Packs the components within the frame using frame.pack().
//        Sets the frame's location to the center of the screen (frame.setLocationRelativeTo(null)).
//        Sets the default close operation to terminate the application upon closing the frame (frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)).
//        Makes the frame visible (frame.setVisible(true)) and disables its resizability (frame.setResizable(false)).