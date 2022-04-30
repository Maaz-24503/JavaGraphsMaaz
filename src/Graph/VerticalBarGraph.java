package Graph;


import java.awt.*;
import java.util.ArrayList;

public class VerticalBarGraph extends Graph {

    private GraphArea graphArea;
    private ArrayList<Bar> listOfBar = new ArrayList<Bar>();
    private int count;
    private double maxValue;
    private int Spacing = 10;

    private boolean isVertical;
    
    /**
     * this constructs a HorizontalBarGraph object
     */

    public VerticalBarGraph() {
        isVertical = true;
    }
    /**
     * 
     * @return returns the list of Bars
     */

    public ArrayList<Bar> getListOfBar() {
        return listOfBar;
    }
    
    /**
     * 
     * @return returns the GraphArea
     */

    public GraphArea getGraphArea() {
        return graphArea;
    }
    
    /**
     * 
     * @return returns the count
     */

    public int getCount() {
        return count;
    }
    
    /**
     * 
     * @return returns the MaxValue of the bar
     */

    public double getMaxValue() {
        return maxValue;
    }
    
    /**
     * 
     * @return returns the spacing between the bars
     */

    public int getSpacing() {
        return Spacing;
    }
    
    /**
     * 
     * @param count sets the count to the count specified
     */

    public void setCount(int count) {
        this.count = count;
    }
    
    /**
     * 
     * @param listOfBar sets the list to the list specified
     */

    public void setListOfBar(ArrayList<Bar> listOfBar) {
        this.listOfBar = listOfBar;
    }
    
    /**
     * 
     * @param bar adds the bar to the list
     */

    public void appendBarList(Bar bar) {
        listOfBar.add(bar);
        count++;
        if (bar.getValue() > maxValue) maxValue = bar.getValue();


    }
    
    /**
     * 
     * @param Value calculates the width with the value provided
     * @return returns the width of the bars
     */

    public int computeheight(double Value) {
        return (int) ((Value * ((graphArea.getHeight()-40) / this.maxValue)) );
    }
    
    /**
     * 
     * @param Spacing calculates the height with the value provided
     * @return returns the height of the bars
     */

    public int computeWidth(int Spacing) {
        return graphArea.getWidth() / (listOfBar.size()) - Spacing;
    }
    
    /**
     * @param graphArea sets the GraphArea to the specified GraphArea
     */

    public void setGraphArea(GraphArea graphArea) {
        this.graphArea = graphArea;
    }
    

    /**
     * 
     * @param b adds the bar to the list
     */

    public void addBar(Bar b) {
        listOfBar.add(b);
        count++;
        if (b.getValue() > maxValue) maxValue = b.getValue();
        b.setX(graphArea.getX());
        b.setY(graphArea.getHeight()+ graphArea.getY());
    }
    
    /**
     * This method produces an animating effect by changing the values of height
     */

    public void setValue() {
        //animation code
        for(int i = 0; i < listOfBar.size(); i++){
            Bar b =listOfBar.get(i);

            if(b.getHeight() < computeheight(b.getValue())){
                int temp = computeheight(b.getValue()/10);
                b.setHeight((int)b.getHeight() + computeheight(b.getValue()/10));
                b.setY(b.getY() - temp);
            }
           //int x1 = (int) ((listOfBar.get(i).getValue() / 2) + graphArea.getX());
            int y1 = i * computeWidth(getSpacing()) + (i) * getSpacing() + graphArea.getX();
            b.setWidth(computeWidth(Spacing));
            b.setX(y1);

        }
    }
    
    /**
     * Method to draw a Graph
     */

    public void drawGraph(Graphics g) {
//        graphArea.printGraphArea(g);
//        ColorFactory temp = new ColorFactory();
//        FontFactory temp1 = new FontFactory();
//        for (int i = 0; i < count; i++) {
//            int x1 = (int) ((listOfBar.get(i).getValue() / 2) + graphArea.getX());
//            int y1 = i * computeHeight(getSpacing()) + i * getSpacing() + graphArea.getY();
//            g.setColor(temp.getRandomColor());
//            g.fillRect(x1, y1, computeHeight(Spacing), computeWidth(listOfBar.get(i).getValue()));
//            g.setColor(Color.BLACK);
//            g.drawString(listOfBar.get(i).getLabel(), x1, y1);
//        }
        for(Bar b:listOfBar){
            b.drawBar(g);
            b.drawBar(g);
            if(b.getHeight() >= computeheight(b.getValue())){
                g.drawString(b.getLabel(),b.getX(),b.getY());
            }
        }
        g.setColor(Color.BLACK);
        for(int i= 1; i<=10;i++){
            //VerticalBarGraph temp2 =(VerticalBarGraph) barGraph;
            float temp = (float)((this.getMaxValue()/10.0) * i);
            String print = temp +"";
            g.drawString(print, (graphArea.getX()), graphArea.getY() + graphArea.getHeight() - ((graphArea.getHeight()-50)/10)*i);
        }
    }

    @Override
    public boolean isVertical() {
        return isVertical;
    }
}

