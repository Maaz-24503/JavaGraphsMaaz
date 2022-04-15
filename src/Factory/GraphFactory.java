package Factory;

import Graph.*;

import java.awt.*;

public class GraphFactory extends AbstractFactory {
    public GraphFactory(){

    }

    @Override
    public Color getRandomColor() {
        return null;
    }

    @Override
    public Font getFont(int fontSize,int choice) {
        return null;
    }

    @Override
    public Bar getBar(double value, String label) {
        return null;
    }

    public Graph getGraph(int choice){
        return switch (choice) {
            case (0) -> new VerticalBarGraph();
            case (1) -> new HorizontalBarGraph();
            default -> new VerticalBarGraph();
        };
    }
}
