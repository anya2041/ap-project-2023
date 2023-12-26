
PROJECT:   STICK HERO 
      "HALLOWEEN EDITION"


SUBMITTED BY: Anya Hooda(2022088) and Mananya Kohli(2022275)

We have focused on implementing the basic technicalities of the original game Stick Hero and made our version--STICK HERO "HALLOWEEN EDITION".



DESIGN PATTERNS------------------------------------------------------------------


Creational Patterns:

Factory Method: USAGE---when creating instances of different panels (StartPanel, GameOverPanel, etc.), and the GameEngine and GameController.

Structural Patterns:

Decorator: USAGE---- in the GamePanel or PlayPanel classes where various graphical elements, like characters, are drawn or manipulated based on the game state.

Behavioral Patterns:

Observer: USAGE----in classes like MouseListener and ActionListener implementations in GameController, which observe and react to user input and game events.
State: The game appears to have different states like game running, game over, replay, etc., managed by different panels (StartPanel, GameOverPanel, etc.) and controlled by the GameController.



MULTITHREADING--------------------------------------------------------------------

In the Stick Hero game project, multithreading has been employed in the GameController class to manage different game functionalities simultaneously. Specifically, the start() method in GameController initiates a separate thread responsible for the game loop. This loop continually updates the game state and repaints the game panel at a defined frame rate.

Here's an overview of how multithreading is implemented in the game project:

Game Loop Thread:

The start() method initializes a game loop running in a separate thread using Thread and Runnable. This loop controls the game's execution by constantly updating the game state and refreshing the game panel.

code is:
public void start() {
    Thread gameLoop = new Thread(new Runnable() {
        @Override
        public void run() {
            isRunning = true;
            while (isRunning) {
                panel.repaint(); // Update the game panel
                try {
                    Thread.sleep(1000 / GameController.FPS); // Set frame rate
                } catch (InterruptedException e) {
                    // Handle exception if needed
                }
            }
        }
    });

    gameLoop.start(); // Start the game loop thread
}
Within the loop, the panel.repaint() method is called to refresh the game display. The Thread.sleep() method controls the frame rate by pausing the loop for a specified time, ensuring smooth animation and updating the game at a consistent rate.

Concurrency Handling:

The game loop thread operates independently of the main thread. It allows the game to run concurrently, ensuring the user interface remains responsive while the game logic executes in the background.

Thread Interruption Handling:

The loop includes a try-catch block to catch InterruptedException. This allows proper handling if the thread is interrupted while sleeping, although in this specific case, the catch block is left empty.

Multithreading in this context allows the game loop to run independently of the main application thread, ensuring a smooth and responsive gaming experience by separating the rendering and logic updates from the main UI thread.


THE COMPONENTS-------------------------

1.GameController
Controls the flow of game.
2.GameEngine
3.Rectangle
4.GameOverPanel
5.GamePanel
6.Images
7.NamePanel
8.PlayPanel
9.StartPanel
10.StickHero
11.StickHeroTest----our JUnit tests




------------------------------------------------------------------Game Components--------------------------------------------------------------------------------------
GAME ENGINE:
Manages the game's logic and state:
Keeps track of player details (name).
Controls game elements (stick length, score, cherry count).
Handles the game's progression (checking game over, advancing rectangles).

Player's Name and Initialization:

The GameEngine is constructed with the player's name provided as an argument.
The init() method sets up the initial state of the game, creating the two rectangles for the hero to cross.
Rectangle Generation:

assignDistance() method generates random distances between the two rectangles, ensuring each game round has varied challenges.
These distances are crucial as they determine the difficulty of each jump the hero must make.
Stick Length and Scoring Logic:

increaseStickLength() method increments the stick's length, indicating the hero is attempting to cross the gap.
checkForGameOver() method verifies whether the stick length aligns with the gap or overshoots it, ending the game if conditions are not met.
Transitioning to Next Rectangles:

nextRectangle() method switches to the next set of rectangles once the hero successfully crosses.
It increments the score and prepares the game for the next challenge.
Cherries and Game State Management:

cherryTaken() method increments the cherry count whenever the hero collects a cherry during the game.
reduceCherriesForRevival() decreases the cherry count when used for revival, ensuring fair gameplay.
Background Image Handling:

setBackground() method allows setting a background image path for the game environment, enhancing visual appeal.
Game Over and Game State Accessors:

isGameOver() method checks whether the game is in the "game over" state.
getCherryNum(), getScore(), and other getter methods provide access to game-related data for display purposes or further game logic.
Maintaining Game State:

It keeps track of crucial game states like moving, gameOver, and upsideDown (which might be a part of the hero's movement logic).
Randomization and Fairness:

The random assignment of distances and cherry positions ensures each game round is unique, promoting replayability and fairness.
Responsibilities and Decisions:

It plays a pivotal role in determining the hero's success or failure, managing game mechanics, and ensuring a challenging yet enjoyable gaming experience.

GAME CONTROLLER:


Game State Management:

Controls the flow of the game from start to end.
Manages different game states (start screen, gameplay, game over).
Interaction Handling:

Listens and responds to user inputs or events, typically through listeners or actions.
Initiates actions based on user interactions (e.g., mouse clicks, key presses).
Game Progression:

Orchestrates the game's progress based on user actions.
Triggers changes in the GameEngine to update the game state (score, obstacles, player movement).
Key Components:
init(GameEngine, GamePanel):

Initializes the GameController with references to the GameEngine and GamePanel.
Sets up the initial game state and screen.
start():

Initiates the start of the game.
Controls the transition from the start screen to the gameplay.
gameOver():

Handles the end of the game.
Triggers actions to display the game over screen and final score.
nextRect(boolean):

Advances the game to the next obstacle or rectangle.
Controls the game's progression based on whether a cherry is collected or not.
Detailed Actions:
Initialization:

Sets up the initial state of the game, linking the GameController with the GameEngine and GamePanel.
Starting the Game:

Controls the start of the game, transitioning from the start screen to the gameplay area.
Initiates the game loop or logic to begin the game flow.
Handling Game Over:

Detects conditions leading to the end of the game (e.g., collision, falling off the screen).
Triggers actions to display the game over screen and final results.
Advancing Game State:

Controls the game's progression by advancing to the next obstacle or rectangle.
Updates the GameEngine's state (score, obstacles) based on the player's actions.
Conclusion:
The GameController acts as the orchestrator of the Stick Hero game, managing the game's flow, interaction handling, and progression. It acts as the bridge between the user's actions and the game's logic, coordinating the game's states and transitions for a seamless gaming experience.

Initialization (init):

Connects the GameEngine and GamePanel with the GameController.
Allows the GameController to interact with and manipulate game elements.
Game Loop (start):

Initiates a game loop in a separate thread to maintain the game's flow.
Regularly updates the game panel to display changes at a specified Frames Per Second (FPS).
Progression Handling (nextRect):

Handles the transition to the next obstacle or rectangle in the game.
Triggers actions in the GameEngine to progress the game state.
Plays a sound effect if a cherry is taken.
Game Over Handling (gameOver):

Signals the game panel to display the game over screen.
Ends the current game session.
Replay (replay):

Resets the game state in the GameEngine and restarts the game panel.
Invoked when the player decides to replay after game over.
Mouse Interaction Handling (MouseListener implementation):

Detects mouse events like clicks, presses, and releases for player interactions.
Determines if the stick length should increase or the game should progress based on user input.
Manages stick length increase while the mouse is pressed and moves the stick upon release.
Action Handling (ActionListener implementation):

Listens for actions such as button clicks within the game panel.
Triggers actions to transition the panel to the gameplay state.
Thread Management:
Utilizes threads to manage stick length increase and the game loop to ensure smooth gameplay without blocking the main thread.
Sound Effect Handling:
Incorporates the SoundPlayer utility to play sound effects at specific game events (e.g., cherry collection).
Conclusion:
The GameController acts as the intermediary between user inputs and game logic, managing game states, 
interactions, and progression. It handles mouse events, orchestrates gameplay actions, and controls the game loop,
 ensuring a responsive and engaging gaming experience in the Stick Hero game.




GAME PANEL:
Represents the visual display area:
Displays various game screens (start, play, game over).
Handles user inputs and interactions during gameplay.
Panel Setup and Game State Handling:

The GamePanel extends JPanel and manages different game states using various internal panels (PlayPanel, StartPanel, NamePanel, GameOverPanel).
It relies on GameEngine and GameController instances to manage these panels and control the game flow.
Initialization:

The init() method initializes the GamePanel with provided GameEngine and GameController instances.
It initializes different panels (gameOverPanel, namePanel, startPanel, playPanel) with the associated game instances.
Layout Management:

The layout is set to BorderLayout to arrange panels in specific regions (CENTER and PAGE_END).
startPanel is placed at the center, while namePanel is positioned at the bottom.
Transitions between Game Screens:

goToGame() method transitions the display from the start panel to the gameplay screen.
It removes the startPanel and replaces it with the playPanel in the center, refreshing the layout.
Game Over Handling:

gameOver() method manages the transition to the game over screen.
It replaces the playPanel with the gameOverPanel in the center, providing a visual cue that the game has ended.
Replay and Refresh:

replay() method restarts the game by removing the gameOverPanel and namePanel, then re-initializing the panels with new GameEngine and GameController instances.
This allows the player to restart the game with a fresh setup.
User Interaction:

PlayPanel is responsive to mouse clicks as it implements MouseListener, enabling interaction with the game controller.
Interaction between panels and user input helps control the game flow.
Dynamic Panel Management:

Dynamic addition and removal of panels using layout management ensure smooth transitions between different game screens, providing a seamless gaming experience.
Game Flow Control:

It serves as the intermediary between the user interface and the game logic, orchestrating the display of different game states based on user actions and game events.
Responsibilities:

The GamePanel plays a crucial role in managing the visual representation of the game, switching between various game screens, and responding to user inputs for transitioning game states.



NAME PANEL:
Displays the player's name during the game:
Shows the player's name within the game interface.
Panel Initialization:

The NamePanel extends JPanel and initializes the player's name within a labeled panel.
Constants:

Defines constants:
BORDERS_LENGTH: Specifies the border length around the label.
MAX_SIZE: Determines the maximum size of the label.
Constructor:

Accepts a GameEngine object to retrieve the player's name.
Sets the layout of this panel to FlowLayout.
Label Creation:

Initializes a JLabel (name) with the player's name obtained from the GameEngine.
Configures the label:
Sets empty borders around the label to provide space.
Defines a maximum size for the label.
Specifies the font for the label text (Garamond, plain style, size 15).
Layout Management:

Utilizes FlowLayout to arrange the label in a row, maintaining its preferred size.
Display:

Adds the configured JLabel to the NamePanel.
Responsibility:

NamePanel focuses on creating and configuring a labeled panel to display the player's name within the game interface.
This panel essentially serves to present the player's name in a user-friendly manner within the game's graphical interface, utilizing a JLabel to display the name with specified formatting and layout.




PLAY PANEL:
Renders the actual gameplay area:
Displays game elements (hero, obstacles, cherries).
Handles rendering and movement during gameplay.
Drawing Play Environment:

The PlayPanel class extends JPanel and manages the game's play environment.
Initialization:

Initializes variables and states related to gameplay.
Handles background movement for a parallax effect.
Painting the Game:

Overrides paintComponent(Graphics g) to render the game elements.
Manages the rendering of various game components like rectangles, stick, hero, cherry, and score.
Rectangles and Stick:

Controls the movement of rectangles and stick based on game logic.
Manages the rotation of the stick, its movement, and collision detection with rectangles.
Background Movement:

Controls the background movement for a scrolling effect during gameplay.
Hero Movements:

Manages hero movement and animations based on game conditions and controls.
Handles hero flipping when upside down and determines movement based on rotation.
Cherry Mechanics:

Handles the appearance, detection, and taking of cherries during gameplay.
Game Over Conditions:

Monitors conditions leading to the game over state and executes relevant actions.
Manages hero's movements and game-ending scenarios.
Drawing Scores:

Renders the game score and cherry count on the screen during gameplay.
Responsibilities:

PlayPanel primarily deals with rendering gameplay elements, managing their movements, and detecting collision or game-ending situations within the play environment.
This class is central to displaying the game interface during gameplay, rendering the hero, obstacles, and other game components while ensuring proper movement and collision detection.



START PANEL:
Represents the initial game screen:
Displays the start screen where the player begins or restarts the game.
Start Screen Display:

StartPanel is a panel designed to display the game's initial screen when the game is launched.
Initialization and Layout:

Inherits from JPanel and sets a null layout to manually place components.
Contains a custom-designed button (JButton) to initiate gameplay.
Button Creation and Customization:

Creates a custom button using JButton with overridden paintComponent() to display the "Start" button using an image.
Associates an ActionListener from the GameController to handle button clicks.
Graphics and Visuals:

Renders the background image and text using overridden paintComponent() method.
Displays the background image and stylized "STICK" and "HERO" text at specific coordinates using Graphics objects.
Layout and Dimensions:

Positions and sizes the button and panel based on predefined dimensions and background image size (Images.BACKGROUND_WIDTH and Images.BACKGROUND_HEIGHT).
Responsibilities:

StartPanel is responsible for rendering the initial screen, displaying the game's title, and providing a graphical "Start" button for user interaction. It relies on predefined images and text to create the visual interface for the game's starting point.







STICK HERO:
Main class that sets up the game:
Initializes the game's graphical interface.
Manages starting and controlling the game loop.
Main Class:

StickHero serves as the main class orchestrating the game setup and initiation.
Swing Application Execution:

main() method within StickHero starts the Swing application.
SwingUtilities.invokeLater() ensures the application runs safely in the Swing event dispatch thread.
Frame Initialization:

A new JFrame named "Stick Hero" is created to host the game's visual interface (frame).
The title is set to "Stick Hero" via JFrame constructor.
User Interaction:

Displays a JOptionPane dialog to prompt the user to input their name.
The entered name is stored in the variable name.
Game Components Initialization:

GameEngine, GameController, and GamePanel instances are created.
GameEngine is initialized with the player's entered name.
GameController and GamePanel are initialized.
Game Setup and Connectivity:

engine.init() initializes the game engine's state.
controller.init(engine, panel) establishes the connection between the engine and controller.
panel.init(engine, controller) connects the engine and controller with the game panel.
Game Start:

controller.start() initiates the game controller, which manages the game's flow and processes user input.
Frame Configuration:

The GamePanel is added to the frame's content pane (frame.getContentPane().add(panel)).
frame.pack() sizes the frame to fit its contents.
frame.setLocationRelativeTo(null) centers the frame on the screen.
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE) ensures the application exits when the frame is closed.
frame.setVisible(true) makes the frame visible.
frame.setResizable(false) disables frame resizing to maintain the game's layout integrity.
Responsibilities:

StickHero manages the setup and initialization of game components, handles user interaction for player identification, launches the game using Swing components, and configures the game frame for display.




IMAGES:

Handles loading and storing game images:
Stores images used for backgrounds, characters, and other visual elements.
Purpose:
The Images class in the game's architecture is responsible for managing the loading and accessibility of various image assets used throughout the game.

Image Assets:
Background Images:
background, backgroundLevel2, and backgroundLevel3: Different background images for different game levels.
Game Elements:
startButton: Image used for the game's start button.
stand, walk1, walk2, walk3, walk4: Images representing character movements/animations.
replay: Image for the replay button.
cherry: Image representing cherries within the game.
gameOver: Image displayed when the game ends.
Image Dimensions:
Defines dimensions for various game elements:

BACKGROUND_WIDTH and BACKGROUND_HEIGHT: Dimensions of the background images.
HERO_WIDTH and HERO_HEIGHT: Dimensions of the game's character.
Static Initialization Block:
Utilizes ImageIO.read(new File("path/to/image.png")) to load images.
Attempts to load images from specific file paths.
Handles IOException in case of image loading failure.
Usage in the Game:
These loaded images are utilized in different parts of the game.
They are drawn onto the game panels to create the visual representation of the game environment, characters, buttons, and other elements.
The images are an integral part of rendering the game interface and providing a graphical representation of the game's elements and interactions.



RECTANGLE:

Represents the obstacles (rectangles) in the game:
Defines the properties and behavior of obstacles in the game.
The Rectangle class is designed to represent the obstacles or platforms in the game. It generates rectangles with varying widths within a specified range.

Properties:
Constants:

MIN_SIZE and MAX_SIZE: Define the minimum and maximum sizes for the generated rectangles.
Width:

width: Represents the width of the rectangle.
Constructor:
Initializes a Rectangle object:
Utilizes a Random object to generate random values for the width.
The width is constrained to fall within the defined range (MIN_SIZE to MAX_SIZE).
Methods:
getWidth():
Getter method to retrieve the width of the rectangle.
Usage:
The Rectangle instances are created by the GameEngine to represent the platforms or obstacles in the game environment.
Their widths are used to create the visual representation of the game's playing area, determining the distance between platforms for the player's character to traverse.

GAMEOVERPANEL:
Properties:
engine: Reference to the GameEngine instance, allowing access to game-related data and methods.
button: A JButton instance serving as the replay button.
Constructor:
GameOverPanel(GameEngine engine, GameController controller):
Initializes the panel and its components, taking in instances of GameEngine and GameController.
Sets the layout to null for manual component positioning.
Creates the replay button, setting its appearance with a customized JButton overridden by the paintComponent method.
Associates an ActionListener with the button to trigger the replay() method in the GameController upon clicking.
Methods:
paintComponent(Graphics g):
Overrides the paintComponent method to control the visual representation of the panel.
Draws the background image, "Game Over" text, player's score, cherry count, and the "Game Over" image at specific positions.
Utilizes Images.gameOver and Images.replay for visual elements.
Usage:
Display on Game End: This panel is shown when the game concludes, presenting vital details like the score and cherry count.
Visual Representation: Renders visual elements such as the "Game Over" text, score, and cherries collected.
Replay Functionality: Provides a button allowing players to restart the game through the GameController.
Overall, the GameOverPanel serves as the visual interface that appears at the end of the game, presenting crucial information and allowing players to replay the game seamlessly.

SoundPlayer:
Manages playing audio effects:
Handles playing sound files for background music or game sound effects.


STICK HERO TEST
(OUR JUNIT TESTS)
Purpose:
The StickHeroTest class comprises JUnit test cases to validate the functionality of essential methods in the GameEngine and GameController classes.

Properties:
engine: An instance of GameEngine used for testing game-related functionalities.
controller: An instance of GameController responsible for controlling the game state.
Methods:
setUp():

Setup Method: Runs before each test case.
Initialization: Initializes instances of GameEngine and GameController.
Engine-Controller Binding: Initializes the GameController with the GameEngine.
testIncreaseStickLength():

Purpose: Validates the functionality of the increaseStickLength() method in GameEngine.
Test Flow:
Invokes increaseStickLength() and checks if the stick length increases by 3 units.
testNextRectangle():

Purpose: Verifies the behavior of the nextRect() method in GameController.
Test Flow:
Determines the initial score.
Simulates the advancement to the next rectangle without a cherry.
Validates if the score increases by 1 after moving to the next rectangle.
testCherryTaken():

Purpose: Confirms the behavior of the nextRect() method when a cherry is collected.
Test Flow:
Records the initial cherry count.
Simulates moving to the next rectangle with a cherry taken.
Ensures that the cherry count increases by 1 after collecting a cherry.
Test Usage:
Validation of Game Logic: Confirms the correctness of key game logic methods such as stick length increase, advancing to the next rectangle, and cherry collection.
Assessment of Method Behavior: Checks if the methods in GameEngine and GameController perform as expected under different scenarios.
These tests ascertain the reliability and accuracy of critical game functionalities, ensuring that the game operates according to the specified logic and expected behavior.


----------------Conclusion-----------------------------------------------------------------------------
Each part of Stick Hero project contributes uniquely to the game's functionality and user experience.
The GameEngine and GameController manage the game's logic, while the UI components (NamePanel, PlayPanel, StartPanel) 
handle the visual representation and user interaction. Supporting classes like Images, Rectangle,
 and SoundPlayer assist in providing a complete and engaging gaming experience.



-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
