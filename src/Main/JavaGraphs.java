package Main;

import javax.swing.*;

import Factory.AbstractFactory;
import Factory.FactoryCreator;
import Graph.Graph;
import Graph.GraphArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class JavaGraphs extends JFrame implements ActionListener
{

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
   // private
	public JavaGraphs() 
	{
        super("Graphs Program");
        button = new JButton("Change");
        button.addActionListener(e -> {
            isPressed = true;
        });
        button.setBounds(width-200,height - 40,100,20);
        JPanel panel = new JPanel();
        //panel.setBackground(Color.orange);
       // panel.setBounds(0,0,width,height);



        setLayout(null);
       // panel.add(button);
       // getContentPane().setBackground(Color.WHITE);
        getContentPane().add(button);
        setSize(width+width, height+height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //*****Add your code here*****
        area = new GraphArea(width,height);
        abf = factoryCreator.createFactory(3);
        //select type of graph
        barGraph = abf.getGraph(0);
        barGraph.setGraphArea(area);



        Path path = Paths.get("src/Main/data.txt");
        long lines = 0;
        try{
            lines = Files.lines(path).count();
        }catch (Exception e){
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        store = new String[(int)lines][2];
        try{
            File file = new File("src/Main/data.txt");
            sc = new Scanner(file);
        }catch (Exception e){System.out.println("file not found");
        }
        int count1 = 0;

        //storing data
        while(sc.hasNextLine()){
            String temp = sc.nextLine();
            int count2 =0;
            for (String s:temp.split("\\s")){
                store[count1][count2] = s;
                count2++;
            }

            count1++;

        }
        barGraph.setGraphArea(area);
        //converting into bars
        abf = factoryCreator.createFactory(0);

        for(int i =0; i<store.length;i++){
            barGraph.addBar(abf.getBar(Double.parseDouble(store[i][1]),store[i][0]));
        }



        //****************************
        timer =  new Timer(delay, this);
        timer.start();
    }
 
    void draw(Graphics g) 
    {
    	
        Graphics2D g2d = (Graphics2D) g;
        //*****Add your code here*****
        if(isPressed == true){
            g.clearRect(0,0,2000,2000);
            ((Graphics2D) g).setBackground(Color.WHITE);
            isPressed = false;
        }
        area.printGraphArea(g);
        barGraph.drawGraph(g);
        button.paint(g);
        //System.out.println("draw");
        //****************************
 
    }
    @Override
    public void paint(Graphics g) 
    {
        draw(g);
        button.repaint();
        g.dispose();
    }
 
    public static void main(String[] args) throws Exception 
    {
 
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() 
            {
                new JavaGraphs().setVisible(true);
                
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        barGraph.setValue();
        //check if the button is pressed
        if(isPressed == true){
            abf = factoryCreator.createFactory(3);

            if (barGraph.isVertical()) {

                System.out.println("Maaz");

                barGraph = abf.getGraph(1);
                barGraph.setGraphArea(area);
                abf = factoryCreator.createFactory(0);
                for (int i = 0; i < store.length; i++) {
                    barGraph.addBar(abf.getBar(Double.parseDouble(store[i][1]), store[i][0]));
                }
            }else{

                System.out.println("Bilal");

                barGraph = abf.getGraph(0);
                barGraph.setGraphArea(area);
                abf = factoryCreator.createFactory(0);
                for (int i = 0; i < store.length; i++) {
                    barGraph.addBar(abf.getBar(Double.parseDouble(store[i][1]), store[i][0]));
                }
            }


        }
		repaint();
	}

}
