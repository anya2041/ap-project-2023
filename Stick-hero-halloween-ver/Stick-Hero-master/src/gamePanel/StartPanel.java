package gamePanel;

import gameController.GameController;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    private GameController controller;
    private JButton button;

    public StartPanel(GameController controller) {
        this.controller = controller;
        this.setLayout(null);

        button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.drawImage(Images.startButton, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        button.addActionListener(controller);
        button.setBounds(Images.BACKGROUND_WIDTH / 2 - 75, Images.BACKGROUND_HEIGHT / 2 + 25, 150, 150);
        add(button);

        setPreferredSize(new Dimension(Images.BACKGROUND_WIDTH, Images.BACKGROUND_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(Images.background, -450, 0, null);


        // Fn to Draw "Halloween Edition" text in yellow color within the black box
        g2d.setFont(new Font("Times New Roman", Font.BOLD, 40));
        g2d.setColor(Color.YELLOW);
        g2d.drawString("Halloween Edition", 80, 310);

        g2d.setFont(new Font("Times New Roman", Font.BOLD, 100));
        g2d.setColor(Color.yellow);
        g2d.drawString("STICK", 100, 120);
        g2d.drawString("HERO", 105, 220);
    }
}
//CODE EXPLANATION :
//
//The StartPanel class is an integral part of the game's interface, serving as the initial panel when the game launches. Here's an in-depth explanation of its functionalities:
//
//
//        Initialization:
//
//        Inherits from JPanel to serve as the container for the start interface components.
//        Sets the layout manager to null (this.setLayout(null)) for absolute positioning of the components within the panel.
//
//
//        Button Creation:
//
//        Creates a JButton named button that acts as a clickable element within the panel.
//        Overrides the paintComponent method of the button to customize its appearance using an image obtained from the Images class. This image is drawn using Graphics2D.drawImage to fit the button's dimensions.
//
//
//        Button Configuration:
//
//        Associates an action listener (controller) with the button using button.addActionListener(controller) to handle button clicks.
//        Sets the button's bounds (position and size) using button.setBounds.
//
//
//        Panel Painting:
//
//        Overrides the paintComponent method to customize the appearance of the panel's background and text.
//        Draws the background image (Images.background) at a specific position (-450, 0) using g2d.drawImage.
//        Sets the font to a spooky style ("Georgia", bold, size 40) for displaying "Halloween Edition" at the specified coordinates (50, 300) using g2d.drawString.
//        Displays "STICK" and "HERO" in large font sizes (Font: Times New Roman, bold, size 100) with yellow color at defined positions (100, 120) and (105, 220), respectively.