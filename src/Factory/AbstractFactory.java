package Factory;

import Graph.Bar;
import Graph.Graph;

import java.awt.*;

public abstract class AbstractFactory {
    public AbstractFactory(){

    }

    public abstract Color getRandomColor();
    public abstract Font getFont(int fontSize, int choice);
    public abstract Bar getBar(double value, String label);
    public abstract Graph getGraph(int i);

}
