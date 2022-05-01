package Factory;

import Graph.Bar;
import Graph.Graph;

import java.awt.*;

public class ColorFactory extends AbstractFactory {
    /**
     * this constructs a ColorFactory
     */
    public ColorFactory() {
    }

    /**
     * @return this method returns a randomly generated color
     */
    public Color getRandomColor() {
        return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

    }

    /**
     * @param fontSize - The font size of the text
     * @param choice   0-Bold, 1-Italics,2-Plain
     * @return Font of the preferred size and description
     */
    @Override
    public Font getFont(int fontSize, int choice) {
        return null;
    }

    /**
     * @param value Numerical value of bar
     * @param label Qualitative name
     * @return A bar with the provided numerical value and label
     */
    @Override
    public Bar getBar(double value, String label) {
        return null;
    }

    /**
     * @param i 0-Vertical Bar Graph, 1- Horizontal Bar Graph
     * @return Either a Horizontal or a Vertical Graph
     */
    @Override
    public Graph getGraph(int i) {
        return null;
    }
}
