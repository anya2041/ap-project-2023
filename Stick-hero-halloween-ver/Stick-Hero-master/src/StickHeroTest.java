import gameController.GameController;
import gameEngine.GameEngine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StickHeroTest {

    private GameEngine engine;
    private GameController controller;

    @Before
    public void setUp() {
        // Initialize GameEngine and GameController before each test
        engine = new GameEngine("Player1"); // Change name as required
        controller = new GameController();
        controller.init(engine, null); // Passing null for GamePanel in this context
    }
    //Initializes GameEngine and GameController objects before each test method (@Test).
    // The @Before annotation denotes a setup method that executes before each test method.
    // It initializes the engine and controller variables with new instances of GameEngine and GameController, respectively.

    @Test
    public void testIncreaseStickLength() {
        this.engine.increaseStickLength();
        assertEquals(3, this.engine.getStickLength());
    }

    @Test
    public void testNextRectangle() {
        int initialScore = this.engine.getScore();
        this.controller.nextRect(false); // Simulate advancing to the next rectangle without cherry
        assertEquals(initialScore + 1, this.engine.getScore());
    }

    @Test
    public void testCherryTaken() {
        int initialCherryCount = this.engine.getCherryNum();
        this.controller.nextRect(true); // Simulate advancing to the next rectangle with cherry taken
        assertEquals(initialCherryCount + 1, this.engine.getCherryNum());
    }
    //These methods are test cases annotated with @Test. They verify different functionalities of the game by calling respective methods from the GameEngine and GameController classes and then using assertions to check the expected results against the actual results.
    //testIncreaseStickLength() checks if the stick length increases by 3 when increaseStickLength() is called.
    //testNextRectangle() simulates advancing to the next rectangle and checks if the score increases by 1 when no cherry is taken.
    //testCherryTaken() simulates advancing to the next rectangle and checks if the cherry count increases by 1 when a cherry is taken.

}

//MORE ABOUT  THE TEST CODE :
//1. testIncreaseStickLength() Method:
//Purpose: This test method checks whether the stick's length increases by 3 units when the increaseStickLength() method is called.
//Assertion Used: assertEquals(3, this.engine.getStickLength())
//This assertion verifies that the getStickLength() method of the GameEngine returns a value of 3 after calling increaseStickLength().

//2.testNextRectangle() Method:
//Purpose: This method checks if the game score increases by 1 when moving to the next rectangle without collecting a cherry.
//Assertion Used: assertEquals(initialScore + 1, this.engine.getScore())
//It ensures that the game's score increases by exactly 1 from its initial value after calling controller.nextRect(false).

//3.testCherryTaken() Method:
// Purpose: This test verifies whether the cherry count increases by 1 when moving to the next rectangle after collecting a cherry.
//Assertion Used: assertEquals(initialCherryCount + 1, this.engine.getCherryNum())
//It ensures that the cherry count increases by exactly 1 from its initial value after calling controller.nextRect(true).

//4.Explanation of assertEquals:
//assertEquals(expected, actual) is an assertion method provided by JUnit.
//It checks whether the actual value matches the expected value. If they are equal, the test passes; otherwise, it fails, displaying the expected and actual values for comparison.