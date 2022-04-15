package Factory;

import java.awt.*;
import Graph.*;

public class ColorFactory extends AbstractFactory{
    public ColorFactory(){
    }

    public Color getRandomColor(){
        return new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));

    }

    @Override
    public Font getFont(int fontSize, int choice ) {
        return null;
    }

    @Override
    public Bar getBar(double value, String label) {
        return null;
    }

    @Override
    public Graph getGraph(int i) {
        return null;
    }
}
