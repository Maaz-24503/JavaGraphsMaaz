package Factory;

import Graph.*;

import java.awt.*;

public class BarFactory extends AbstractFactory{
    public BarFactory(){

    }

    @Override
    public Color getRandomColor() {
        return null;
    }

    @Override
    public Font getFont(int fontSize,int choice) {
        return null;
    }

    public Bar getBar(double value, String label){
        ColorFactory colorFactory = new ColorFactory();
        return new Bar();
        //return new Bar(label,value,colorFactory.getRandomColor());
    }

    @Override
    public Graph getGraph(int i) {
        return null;
    }
}
