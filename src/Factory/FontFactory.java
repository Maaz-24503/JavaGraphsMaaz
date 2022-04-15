package Factory;

import Graph.*;

import java.awt.*;

public class FontFactory extends AbstractFactory{
    public FontFactory(){

    }

    @Override
    public Color getRandomColor() {
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

    public Font getFont(int fontSize,int choice){
        return switch (choice) {
            case (0) -> new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
            case (1) -> new Font(Font.SANS_SERIF, Font.PLAIN, fontSize);
            case (2) -> new Font(Font.SANS_SERIF, Font.ITALIC, fontSize);
            default -> new Font(Font.SANS_SERIF, Font.BOLD, 18);
        };
    }
}
