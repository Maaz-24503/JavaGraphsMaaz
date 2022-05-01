package Graph;


import java.awt.*;
import java.util.ArrayList;

public class VerticalBarGraph extends Graph {

    private GraphArea graphArea;
    private ArrayList<Bar> listOfBar = new ArrayList<Bar>();
    private int count;
    private double maxValue;
    private int Spacing = 20;


    /**
     * this constructs a VerticalBarGraph object
     */
    public VerticalBarGraph() {
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

    public int computeHeight(double Value) {
        return (int) ((Value * ((graphArea.getHeight() - 20) / this.maxValue)));
    }

    /**
     * @param Spacing calculates the height with the value provided
     * @return returns the height of the bars
     */
    public int computeWidth(int Spacing) {
        return graphArea.getWidth() / (listOfBar.size()) - Spacing - (int) Math.ceil(40.0 / (listOfBar.size()));  // we subtract 40/size so that there is space for the axis labels on the left
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
        //starting for the bars
        //which is the bottom axis
        b.setX(graphArea.getX());
        b.setY(graphArea.getHeight() + graphArea.getY());
    }

    /**
     * This method produces an animating effect by changing the values of height
     */
    public void setValue() {
        //animation code
        for (int i = 0; i < count; i++) {
            Bar b = listOfBar.get(i);
            int computedHeight = computeHeight(b.getValue());

            //if the height is less than the computed height
            if (b.getHeight() < computedHeight) {

                int increment = computedHeight/10;
                //if the change is less than the increment
                if (Math.abs(b.getHeight() - computedHeight) <= increment) {
                    //then directly set the height
                    b.setValue(computedHeight);
                }else{
                    //otherwise increase by 1/10 th of the computed height
                    b.setHeight(b.getHeight() + computedHeight/10);
                    //we subtract the y coordinate as it increase as we go down
                    b.setY(b.getY()-increment);
                }
                //+40 so that there is room for the label
                int xCoordinate = i * computeWidth(getSpacing()) + (i) * getSpacing() + graphArea.getX() + 40;
                //the width of the bar
                b.setWidth(computeWidth(Spacing));
                //setting x coordinate
                b.setX(xCoordinate);

            }

        }
    }

    /**
     * Method to draw a Graph
     */
    public void drawGraph(Graphics g) {

        FontMetrics fontSize = g.getFontMetrics();//Font metrics allows us to check how many pixels a string is taking
        //this will help us in centering the font
        for (Bar b : listOfBar) {
            b.drawBar(g);
            b.drawBar(g);
            if (b.getHeight() >= computeHeight(b.getValue())) {
                g.setColor(Color.BLACK);
                g.drawString(b.getLabel(), b.getX() + (b.getWidth() / 2) - (fontSize.stringWidth(b.getLabel()) / 2), b.getY() - 5);
            }
        }
        // drawing axis labels
        g.setColor(Color.BLACK);
        for (int i = 1; i <= 10; i++) {

            float temp = (float) ((this.getMaxValue() / 10.0) * i);
            String print = temp + "";
            g.drawString(print, (graphArea.getX()) + 2, graphArea.getY() + graphArea.getHeight() - ((graphArea.getHeight() - 50) / 10) * i);
        }
    }

    /**
     *
     * @return true if it's a vertical bar graph and false if it's a HorizontalBarGraph
     */
    @Override
    public boolean isVertical() {
        return true;
    }
}

