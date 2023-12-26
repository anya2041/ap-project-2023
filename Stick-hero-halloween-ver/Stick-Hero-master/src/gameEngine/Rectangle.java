//readme of this file is menetioned below
package gameEngine;

import java.util.Random;

public class Rectangle {
    public static final int MIN_SIZE = 50;
    public static final int MAX_SIZE = 100;
    private int width;

    public Rectangle() {
        Random rand = new Random();

        width = 0;
        while (width < Rectangle.MIN_SIZE)
            width = rand.nextInt(Rectangle.MAX_SIZE);
    }

    public int getWidth() {
        return width;
    }
}
//explanation of code:
//This Rectangle class is designed to create rectangles with varying widths for use in a game scenario. Here's an elaboration on its functionality:
//
//Initialization and Randomization:
//The Rectangle class includes a constructor method that initializes the object.
//Inside the constructor, it generates a random width for the rectangle using the Random class.
//The width is randomly set within a predefined range, specified by MIN_SIZE and MAX_SIZE.
//        Width Getter Method:
//        The class provides a method called getWidth().
//        This method allows external classes, such as the GameEngine, to access the width of the created rectangle.
//        External access to this width is essential for various game mechanisms, like collision detection or visual representation of the rectangles.

//By utilizing the Rectangle class, the game engine can dynamically generate and manage different-sized rectangles, contributing to the diversity and complexity of the game's visual and gameplay elements.