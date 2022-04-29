package Factory;

import Graph.*;

import java.awt.*;

public class GraphFactory extends AbstractFactory {
	/**
	 * this constructs a GraphFactory
	 */
    public GraphFactory(){

    }

    /**
     *
     * @return a randomly generated color
     */
    @Override
    public Color getRandomColor() {
        return null;
    }

    @Override
    public Font getFont(int fontSize,int choice) {
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
     * @param choice 0-Vertical Bar Graph, 1- Horizontal Bar Graph
     * @return Either a Horizontal or a Vertical Graph
     */
    public Graph getGraph(int choice){
        return switch (choice) {
            case (0) -> new VerticalBarGraph();
            case (1) -> new HorizontalBarGraph();
            default -> new VerticalBarGraph();
        };
    }
}
