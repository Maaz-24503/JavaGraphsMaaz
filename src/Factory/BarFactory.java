package Factory;

import Graph.*;

import java.awt.*;

public class BarFactory extends AbstractFactory{
    public BarFactory(){

    }
    /**
     *
     * @return a randomly generated color
     */
    @Override
    public Color getRandomColor() {
        return null;
    }
    /**
     *
     * @param fontSize - The font size of the text
     * @param choice  1-Bold, 2-Italics,3-Plain
     * @return Font of the prefered size and description
     */
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
    public Bar getBar(double value, String label){
        ColorFactory colorFactory = new ColorFactory();
        return new Bar();
        //return new Bar(label,value,colorFactory.getRandomColor());
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
