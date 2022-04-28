package Graph;

import Factory.ColorFactory;
import Factory.FontFactory;

import java.awt.*;
import java.util.ArrayList;

public class HorizontalBarGraph extends Graph {

    private GraphArea graphArea;
    private ArrayList<Bar> listOfBar = new ArrayList<Bar>();
    private int count;
    private double maxValue;
    private int Spacing = 10;

    public HorizontalBarGraph() {

    }

    public ArrayList<Bar> getListOfBar() {
        return listOfBar;
    }

    public GraphArea getGraphArea() {
        return graphArea;
    }

    public int getCount() {
        return count;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public int getSpacing() {
        return Spacing;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setListOfBar(ArrayList<Bar> listOfBar) {
        this.listOfBar = listOfBar;
    }

    public void appendBarList(Bar bar) {
        listOfBar.add(bar);
        count++;
        if (bar.getValue() > maxValue) maxValue = bar.getValue();


    }

    public int computeWidth(double Value) {
        return (int) ((Value * (graphArea.getWidth() / this.maxValue)) - 50);
    }

    public int computeHeight(int Spacing) {
        return graphArea.getHeight() / (listOfBar.size()) - Spacing;
    }

    public void setGraphArea(GraphArea graphArea) {
        this.graphArea = graphArea;
    }

    public void addBar(Bar b) {
        listOfBar.add(b);
        count++;
        if (b.getValue() > maxValue) maxValue = b.getValue();
    }

    public void setValue() {
        //animation code
        for(int i = 0; i < listOfBar.size(); i++){
            Bar b =listOfBar.get(i);
            if(b.getWidth() < computeWidth(b.getValue())){
                System.out.println(b.getWidth() + (computeWidth(b.getValue())/10));
                b.setWidth((int)(b.getWidth() + (computeWidth(b.getValue())/10)));
            }
            //int x1 = (int) ((listOfBar.get(i).getValue() / 2) + graphArea.getX());
            int y1 = i * computeHeight(getSpacing()) + (i) * getSpacing() + graphArea.getY() ;
            b.setX(graphArea.getX());
            b.setY(y1);
            b.setHeight(computeHeight(Spacing));
        }
    }

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
        }
    }
}

