package Factory;

import Graph.Bar;
import Graph.Graph;

import java.awt.*;

public abstract class AbstractFactory {


    /**
     * @return returns a randomly generated color
     */
    public abstract Color getRandomColor();

    /**
     * @param fontSize - The font size of the text
     * @param choice   0-Bold, 1-Italics,2-Plain
     * @return Font of the preferred size and description
     */
    public abstract Font getFont(int fontSize, int choice);

    /**
     * @param value Numerical value of bar
     * @param label Qualitative name
     * @return A bar with the provided numerical value and label
     */
    public abstract Bar getBar(double value, String label);

    /**
     * @param i : 0-Vertical Bar Graph, 1- Horizontal Bar Graph
     * @return returns either a Horizontal or a Vertical Graph
     */
    public abstract Graph getGraph(int i);

}
