package Graph;

import javax.swing.*;
import java.awt.*;

public class GraphArea {
	/**
	 * Attributes of GraphArea
	 */
    private int x; 
    private int y;
    private int width;
    private int height;

    /**
     * This constructs a GraphArea of a specified width and height
     * @param width width of the GraphArea
     * @param height height of the GraphArea
     */
    public GraphArea(int width, int height) {
        this.x = 100;
        this.y = 100;
        this.width = width - 2 * y;
        this.height = height - 2 * x;
    }
    
    /**
     * This method draws the GraphArea of specified width and heigth
     * and the center (x,y) coordinates
     * @param g takes in Graphics as a parameter
     */

    public void printGraphArea(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }
    /**
     * 
     * @return returns the height
     */

    public int getHeight() {
        return height;
    }
    /**
     * 
     * @return returns the width
     */

    public int getWidth() {
        return width;
    }
    
    /**
     * 
     * @return returns the x-coordinate
     */

    public int getX() {
        return x;
    }
    /**
     * 
     * @return returns the y-coordinate
     */

    public int getY() {
        return y;
    }
    /**
     * 
     * @param height this sets the height of the GraphArea
     */

    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * 
     * @param width this sets the width of the GraphArea
     */

    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * 
     * @param x this sets the x-coordinate
     */

    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * 
     * @param y this sets the y-coordinate
     */

    public void setY(int y) {
        this.y = y;
    }
}
