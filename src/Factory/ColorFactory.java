package Factory;

import java.awt.*;
import Graph.*;

public class ColorFactory extends AbstractFactory{
	/**
	 * this constructs a ColorFactory
	 */
    public ColorFactory(){
    }

    /**
     *
     * @return this method returns a randomly generated color
     */
    public Color getRandomColor(){
        return new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));

    }
    /**
     *
     * @param fontSize - The font size of the text
     * @param choice  1-Bold, 2-Italics,3-Plain
     * @return Font of the prefered size and description
     */
    @Override
    public Font getFont(int fontSize, int choice ) {
        return null;
    }
    /**
     *
     * @param value Numerical value of bar
     * @param label Qualitative name
     * @return A bar with the provided numerical value and label
     */
    @Override
    public Bar getBar(double value, String label) {
        return null;
    }
    /**
     *
     * @param i 1-Vertical Bar Graph, 2- Horizontal Bar Graph
     * @return Either a Horizontal or a Vertical Graph
     */
    @Override
    public Graph getGraph(int i) {
        return null;
    }
}
