package Graph;

import java.awt.*;

public class Bar {
    private int x;
    private int y;
    private int height;
    private int width;
    private Color color;
    private String label;
    private double value;
    private int fontSize;
    private boolean isHorizontal;

    public Bar(String label, double value, Color color) {
        this.color = color;
        this.label = label;
        this.value = value;
        //this.isHorizontal;
    }

    public Color getColor() {
        return color;
    }

    public double getValue() {
        return value;
    }

    public int getFontSize() {
        return fontSize;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getLabel() {
        return label;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    public void drawBar(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);

        //g.drawString(this.label, x +width+5, y+ height/2);
    }

    private int computeFontSize() {
        if (isHorizontal) {
            fontSize = (int) (width * 10);
            return fontSize;
        } else {
            fontSize = (int) (width * 10);
            return fontSize;
        }
    }
}
