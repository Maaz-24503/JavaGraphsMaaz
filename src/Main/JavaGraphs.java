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
    private int delay = 30;
    private GraphArea area;
    private FactoryCreator factoryCreator = new FactoryCreator();
    private AbstractFactory abf;
    private Graph barGraph;
    private String[][] store;
    private JButton button;
    private boolean isPressed;

    private boolean printOnce = false;

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
        button.setBounds(width - 160, height - 70, 100, 20);
        area = new GraphArea(width, height);
        abf = factoryCreator.createFactory(3);
        //select type of graph
        barGraph = abf.getGraph(0);
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
        barGraph.setGraphArea(area);
        //converting into bars
        abf = factoryCreator.createFactory(0);

        for (int i = 0; i < store.length; i++) {
            barGraph.addBar(abf.getBar(Double.parseDouble(store[i][1]), store[i][0]));
        }


        //****************************
        timer = new Timer(delay, this);
        timer.start();
    }

    void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        //*****Add your code here*****
        g.setColor(Color.BLACK);
        area.printGraphArea(g2d);
        button.repaint();
        barGraph.drawGraph(g2d);


        if (isPressed) {
            g.setColor(Color.WHITE);
            g2d.fillRect(0, 0, width, height);
            isPressed = false;

        }
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

        if (isPressed == true) {
            abf = factoryCreator.createFactory(3);

            if (barGraph.isVertical()) {


                barGraph = abf.getGraph(1);
                barGraph.setGraphArea(area);
                abf = factoryCreator.createFactory(0);
                for (int i = 0; i < store.length; i++) {
                    barGraph.addBar(abf.getBar(Double.parseDouble(store[i][1]), store[i][0]));
                }
                printOnce = false;
            } else {


                barGraph = abf.getGraph(0);
                barGraph.setGraphArea(area);
                abf = factoryCreator.createFactory(0);
                for (int i = 0; i < store.length; i++) {
                    barGraph.addBar(abf.getBar(Double.parseDouble(store[i][1]), store[i][0]));
                }
                printOnce = false;
            }


        }
        repaint();
    }

}
