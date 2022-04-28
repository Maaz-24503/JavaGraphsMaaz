package Graph;

import javax.swing.*;
import java.awt.*;

public class GraphArea {

    private int x;
    private int y;
    private int width;
    private int height;


    public GraphArea(int width, int height) {
        this.x = 50;
        this.y = 50;
        this.width = width - 2 * y;
        this.height = height - 2 * x;
    }

    public void printGraphArea(Graphics G) {
        G.drawRect(x, y, width, height);
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

    public void setHeight(int height) {
        this.height = height;
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
}
