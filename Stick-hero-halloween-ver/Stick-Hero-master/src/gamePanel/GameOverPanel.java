//i've written this code explanation below.
package gamePanel;

import gameController.GameController;
import gameEngine.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameOverPanel extends JPanel {
    private GameEngine engine;
    JButton button;

    public GameOverPanel(final GameEngine engine, final GameController controller) {
        this.setLayout(null);
        this.engine = engine;
        button = new JButton() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.drawImage(Images.replay, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.replay();
            }
        });
        button.setBounds(Images.BACKGROUND_WIDTH / 2 - 180, Images.BACKGROUND_HEIGHT / 2 + 100, 360, 120);
        add(button);

        setPreferredSize(new Dimension(Images.BACKGROUND_WIDTH, Images.BACKGROUND_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.drawImage(Images.background, -450, 0, null);
        g2d.setFont(new Font("Times New Roman", Font.BOLD, 55));
        g2d.setColor(Color.yellow);
        g2d.drawString("GAME OVER", 100,50 );

        g2d.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        g2d.drawString("Your Score : " + engine.getScore(), 100, 100);
        g2d.drawString("Cherries : " + engine.getCherryNum(), 100, 150);

        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();

        int centerX = (panelWidth - Images.gameOver.getWidth(null)) / 2;
        int centerY = (panelHeight - Images.gameOver.getHeight(null)) / 2;

        g2d.drawImage(Images.gameOver, centerX, centerY, null);
    }
}

//ABOUT THIS CODE:
//This GameOverPanel class seems to be a part of a graphical user interface (GUI) for a game.
// It represents the panel that appears when the game is over.
    //Initialization and Layout:
//        The GameOverPanel class extends JPanel, providing a container for other GUI components.
//        The layout of this panel is set to null (setLayout(null)) which allows components to be manually positioned within the panel.
    //Components:
//        It includes a JButton named button that's used for replaying the game.
//        The button is customized using the paintComponent method to display an image (Images.replay) as its content.
//        Action Listener:
//        An ActionListener is added to the button to listen for user clicks.
//        Upon clicking this button, the actionPerformed method calls the replay() method in the GameController to restart the game.
//        Drawing Graphics:
//        The paintComponent method is overridden to draw various graphical elements on the panel.
//        It uses Graphics and Graphics2D objects to draw text and images on the panel.
//        The text "GAME OVER", the player's score, and the number of cherries collected during the game are displayed.
//        An image (Images.gameOver) is drawn at the center of the panel.
    //Panel Size and Dimension:
//        The panel's preferred size is set using setPreferredSize to ensure it fits the background and components added.