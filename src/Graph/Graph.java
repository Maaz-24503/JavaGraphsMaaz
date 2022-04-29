package Graph;

import java.awt.*;
/**
 * 
 * This abstract class Graph helps to draw a Graph 
 *
 */
public abstract class Graph {
	/**
	 * 
	 * @param graphArea takes in the parameter as a GraphArea
	 */
    public abstract void setGraphArea(GraphArea graphArea);
    
    /**
     * 
     * @param bar takes in the parameter as a Bar
     */

    public abstract void addBar(Bar bar);
    
    /**
     * this method sets the value
     */

    public abstract void setValue();
    
    /**
     * this method draws the Graph
     * @param g takes in the parameter as Graphics
     */

    public abstract void drawGraph(Graphics g);

    public abstract boolean isVertical();
}
