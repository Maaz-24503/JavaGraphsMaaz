package Graph;

import java.awt.*;

public class Bar {
    /**
     * Attributes of the Bar
     */
    private int x;
    private int y;
    private int height;
    private int width;
    private Color color;
    private String label;
    private double value;
    private int fontSize;

    /**
     * This constructs a Bar with specified label, value and color
     *
     * @param label the label for the bar
     * @param value the value the bar would represent
     * @param color the color of the bar
     */
    public Bar(String label, double value, Color color) {
        this.color = color;
        this.label = label;
        this.value = value;
    }

    /**
     * @return this returns the color of the current bar
     */

    public Color getColor() {
        return color;
    }

    /**
     * @return this returns the value of the bar
     */
    public double getValue() {
        return value;
    }

    /**
     * @return this returns the fontSize of the label
     */

    public int getFontSize() {
        return fontSize;
    }

    /**
     * @return this returns the height of the bar
     */

    public int getHeight() {
        return height;
    }

    /**
     * @return this returns the width of the bar
     */

    public int getWidth() {
        return width;
    }

    /**
     * @return this returns the X-coordinate of the bar
     */

    public int getX() {
        return x;
    }

    /**
     * @return this returns the Y-coordinate of the bar
     */

    public int getY() {
        return y;
    }

    /**
     * @return returns the label
     */

    public String getLabel() {
        return label;
    }


    /**
     * @param color sets the color of the bar
     */

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @param fontSize sets the font size of the label
     */

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * @param height sets the height
     */

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param label sets the label
     */

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @param value sets the value
     */

    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @param width sets the width
     */

    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param x sets the X-coordinate
     */

    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y sets the Y-coordinate
     */

    public void setY(int y) {
        this.y = y;
    }


    /**
     * This method draws the Bar
     *
     * @param g graphics to be used in drawing the bar
     */

    public void drawBar(Graphics g) {
        g.setColor(Color.BLACK);
        //-1 and +1 so that it does not the overlap with the axis
        g.drawRect(x - 1, y - 1, width + 1, height + 1);
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    /**
     * Private function that computes the Font size
     *
     * @return returns the font size
     */
    private int computeFontSize() {
        
        // this function was not used because font factory was glitching on windows

        fontSize = (int) (width * 10);
        return fontSize;
    }
}
