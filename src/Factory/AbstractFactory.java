package Factory;

import Graph.Bar;
import Graph.Graph;

import java.awt.*;

public abstract class AbstractFactory {
    public AbstractFactory(){

    }

    /**
     *
     * @return returns a randomly generated color
     */
    public abstract Color getRandomColor();

    /**
     *
     * @param fontSize - The font size of the text
     * @param choice  1-Bold, 2-Italics,3-Plain
     * @return Font of the prefered size and description
     */
    public abstract Font getFont(int fontSize, int choice);

    /**
     *
     * @param value Numerical value of bar
     * @param label Qualitative name
     * @return A bar with the provided numerical value and label
     */
    public abstract Bar getBar(double value, String label);

    /**
     *
     * @param i : 1-Vertical Bar Graph, 2- Horizontal Bar Graph
     * @return returns either a Horizontal or a Vertical Graph
     */
    public abstract Graph getGraph(int i);

}
