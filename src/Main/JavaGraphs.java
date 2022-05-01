package Main;

import Factory.AbstractFactory;
import Factory.FactoryCreator;
import Graph.Graph;
import Graph.GraphArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class JavaGraphs extends JFrame implements ActionListener {

    private static int width = 800;
    private static int height = 600;
    private Timer timer;
    private int delay = 8;
    private GraphArea area;
    private FactoryCreator factoryCreator = new FactoryCreator();
    private AbstractFactory abstractFactory;
    private Graph barGraph;
    private String[][] store;
    private JButton button;
    private boolean isPressed;


    // private
    public JavaGraphs() {
        super("Graphs Program");
        setLayout(null);

        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //*****Add your code here*****

        //adding button
        button = new JButton("Change");
        getContentPane().add(button); 
        //function for button
        button.addActionListener(e -> {
            isPressed = true;
        });

        area = new GraphArea(width, height);
        button.setBounds(area.getWidth(),area.getHeight()+ (area.getY()), 100, 20);
        abstractFactory = factoryCreator.createFactory(3);
        //select type of graph
        barGraph = abstractFactory.getGraph(0);
        //setting the graph area
        barGraph.setGraphArea(area);


        Path path = Paths.get("src/Main/data.txt");
        long lines = 0;
        try {
            lines = Files.lines(path).count();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        store = new String[(int) lines][2];
        try {
            File file = new File("src/Main/data.txt");
            sc = new Scanner(file);
        } catch (Exception e) {
            System.out.println("file not found");
        }
        int count1 = 0;

        //storing data
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            int count2 = 0;
            for (String s : temp.split("\\s")) {
                store[count1][count2] = s;
                count2++;
            }

            count1++;

        }

        //converting into bars
        abstractFactory = factoryCreator.createFactory(0);

        for (int i = 0; i < store.length; i++) {
            barGraph.addBar(abstractFactory.getBar(Double.parseDouble(store[i][1]), store[i][0]));
        }


        //****************************
        timer = new Timer(delay, this);
        timer.start();
    }

    void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        //*****Add your code here*****
        
        area.printGraphArea(g2d);
        button.repaint();
        barGraph.drawGraph(g2d);
        resetScreen(g2d);

        //****************************
    }


    @Override
    public void paint(Graphics g) {
        draw(g);
        button.repaint();
        g.dispose();
    }

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JavaGraphs().setVisible(true);

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        barGraph.setValue();

        //check if the button is pressed
        ifButtonPressed();

        repaint();
    }

    /**
     * check if the button is pressed, if it is then it swithes the graph from vertical to horizontal or vice versa
     */
    public void ifButtonPressed(){
        if (isPressed) {
            //get graph factory
            abstractFactory = factoryCreator.createFactory(3);
            if (barGraph.isVertical()) {
                //converting to horizontal bar graph
                //get a horizontal graph
                barGraph = abstractFactory.getGraph(1);
                //set graph area
                barGraph.setGraphArea(area);
                //set factory to bar factory
                abstractFactory = factoryCreator.createFactory(0);
                for (int i = 0; i < store.length; i++) {
                    barGraph.addBar(abstractFactory.getBar(Double.parseDouble(store[i][1]), store[i][0]));
                }

            } else {
                //converting to vertical bar graph
                //get a vertical graph
                barGraph = abstractFactory.getGraph(0);
                //set graph area
                barGraph.setGraphArea(area);
                //set factory to bar factory
                abstractFactory = factoryCreator.createFactory(0);
                for (int i = 0; i < store.length; i++) {
                    //adding bars to the graph
                    barGraph.addBar(abstractFactory.getBar(Double.parseDouble(store[i][1]), store[i][0]));
                }

            }


        }
    }

    public void resetScreen(Graphics g){
        //clearing the screen by setting it to the background color
        if (isPressed) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
            isPressed = false;
        }

    }

}
