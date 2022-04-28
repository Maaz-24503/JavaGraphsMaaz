package Factory;

import Graph.*;

import java.awt.*;

public class FontFactory extends AbstractFactory{
	/**
	 * this constructor creates a FontFactory
	 */
    public FontFactory(){

    }
    /**
     *
     * @return  returns a randomly generated color
     */
    @Override
    public Color getRandomColor() {
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
    /**
     *
     * @param fontSize - The font size of the text
     * @param choice  1-Bold, 2-Italics,3-Plain
     * @return returns font of the prefered size and description
     */
    public Font getFont(int fontSize,int choice){
        return switch (choice) {
            case (0) -> new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
            case (1) -> new Font(Font.SANS_SERIF, Font.PLAIN, fontSize);
            case (2) -> new Font(Font.SANS_SERIF, Font.ITALIC, fontSize);
            default -> new Font(Font.SANS_SERIF, Font.BOLD, 18);
        };
    }
}
