package gamePanel;

import gameEngine.GameEngine;

import javax.swing.*;
import java.awt.*;


public class NamePanel extends JPanel {
    private static final int BORDERS_LENGTH = 2;
    private static final int MAX_SIZE = 100;

    private JLabel name;

    public NamePanel(final GameEngine engine) {
        super();

        this.setLayout(new FlowLayout());

        name = new JLabel(engine.getName());

        name.setBorder(BorderFactory.createEmptyBorder(BORDERS_LENGTH,
                BORDERS_LENGTH, BORDERS_LENGTH, BORDERS_LENGTH));

        name.setMaximumSize(new Dimension(MAX_SIZE, MAX_SIZE));

        name.setFont(new Font("Garamond", Font.PLAIN, 15));

        this.add(name);
    }
}
// CODE EXPLANATION :
//
//    The NamePanel class in the game's user interface is responsible for displaying the player's name within a labeled panel. Here's a detailed explanation of its components:
//
//        Constants:
//
//        BORDERS_LENGTH and MAX_SIZE are constant values used to define the length of the borders and the maximum size of the label, respectively.
//
//        Initialization:
//
//        Inherits from JPanel to serve as a container for the label component.
//        Sets the layout manager to FlowLayout, which arranges components in a left-to-right flow within the panel.
//
//        Label Creation:
//
//        Creates a JLabel named name initialized with the player's name retrieved from the GameEngine.
//        Adds an empty border around the label using BorderFactory.createEmptyBorder to provide padding for the label text.
//        Sets the maximum size for the label to ensure it doesn't exceed a specific size threshold using name.setMaximumSize.
//
//        Font Configuration:
//
//        Sets the font of the label text to "Garamond" with a plain style and font size 15 using name.setFont.
//
//        Component Addition:
//
//        Adds the name label to the NamePanel using this.add(name), allowing it to be displayed within the panel.
//
//        Overall, the NamePanel class constructs a panel displaying the player's name using a JLabel component. It configures the label's appearance and size constraints within the panel to ensure a consistent and visually appealing presentation of the player's name in the game's user interface.