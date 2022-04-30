package Graph;

import java.awt.*;
import java.util.ArrayList;

public class HorizontalBarGraph extends Graph {

    private GraphArea graphArea;
    private ArrayList<Bar> listOfBar = new ArrayList<Bar>(); //list to store bars
    private int count;
    private double maxValue;
    private int Spacing = 10; //spacing between the bars

    private boolean isVertical;

    /**
     * this constructs a HorizontalBarGraph object
     */

    public HorizontalBarGraph() {
        isVertical = false;
    }

    /**
     * @return returns the list of Bars
     */

    public ArrayList<Bar> getListOfBar() {
        return listOfBar;
    }

    /**
     * @return returns the GraphArea
     */

    public GraphArea getGraphArea() {
        return graphArea;
    }

    /**
     * @return returns the count
     */

    public int getCount() {
        return count;
    }

    /**
     * @return returns the MaxValue of the bar
     */

    public double getMaxValue() {
        return maxValue;
    }

    /**
     * @return returns the spacing between the bars
     */

    public int getSpacing() {
        return Spacing;
    }

    /**
     * @param count sets the count to the count specified
     */

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @param listOfBar sets the list to the list specified
     */

    public void setListOfBar(ArrayList<Bar> listOfBar) {
        this.listOfBar = listOfBar;
    }

    /**
     * @param bar adds the bar to the list
     */

    public void appendBarList(Bar bar) {
        listOfBar.add(bar);
        count++;
        if (bar.getValue() > maxValue) maxValue = bar.getValue();


    }

    /**
     * @param Value calculates the width with the value provided
     * @return returns the width of the bars
     */

    public int computeWidth(double Value) {
        //System.out.println(((Value * (graphArea.getWidth() / this.maxValue)) - 50));
        return (int) Math.ceil(((Value * ((graphArea.getWidth() - 50) / this.maxValue))));
    }

    /**
     * @param Spacing calculates the height with the value provided
     * @return returns the height of the bars
     */

    public int computeHeight(int Spacing) {
        return graphArea.getHeight() / (listOfBar.size()) - Spacing - (int) Math.ceil(10.0 / listOfBar.size());
    }

    /**
     * @param graphArea sets the GraphArea to the specified GraphArea
     */
    public void setGraphArea(GraphArea graphArea) {
        this.graphArea = graphArea;
    }


    /**
     * @param b adds the bar to the list
     */
    public void addBar(Bar b) {
        listOfBar.add(b);
        count++;
        if (b.getValue() > maxValue) maxValue = b.getValue();
    }

    /**
     * This method produces an animating effect by changing the values of height
     */

    public void setValue() {
        //animation code
        for (int i = 0; i < listOfBar.size(); i++) {
            Bar b = listOfBar.get(i);

            if (b.getWidth() < computeWidth(b.getValue())) {

                if (computeWidth(b.getValue()) < 10) {
                    b.setWidth((int) (b.getWidth() + computeWidth(b.getValue())));
                } else {
                    b.setWidth((int) (b.getWidth() + Math.ceil(computeWidth(b.getValue()) / 10.0)));
                }
            }
            int y1 = i * computeHeight(getSpacing()) + (i) * getSpacing() + graphArea.getY() + 10;
            b.setX(graphArea.getX());
            b.setY(y1);
            b.setHeight(computeHeight(Spacing));
        }
    }

    /**
     * Method to draw a Graph
     */

    public void drawGraph(Graphics g) {

        for (Bar b : listOfBar) {
            b.drawBar(g);
            if (b.getWidth() >= computeWidth(b.getValue())) {
                g.setColor(Color.BLACK);
                g.drawString(b.getLabel(), b.getX() + b.getWidth() + 5, b.getY() - (b.getHeight() / 2) + b.getHeight());
            }
            //drawing axis labels

        }
    }

    @Override
    public boolean isVertical() {
        return isVertical;
    }
}

