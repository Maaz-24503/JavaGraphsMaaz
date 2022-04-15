package Graph;

import java.awt.*;

public abstract class Graph {
    public abstract void setGraphArea(GraphArea graphArea);

    public abstract void addBar(Bar b);

    public abstract void setValue(double value);

    public abstract void drawGraph(Graphics g);
}
