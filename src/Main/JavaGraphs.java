package Main;

import javax.swing.*;

import Factory.AbstractFactory;
import Factory.FactoryCreator;
import Graph.*;

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

    private boolean printOnce = false;
   // private
	public JavaGraphs() 
	{
        super("Graphs Program");
        button = new JButton("Change");
        button.addActionListener(e -> {
            isPressed = true;
        });
        button.setBounds(width-200,height - 60,100,20);
        JPanel panel = new JPanel();
        //panel.setBackground(Color.orange);
       // panel.setBounds(0,0,width,height);



        setLayout(null);
       // panel.add(button);
       // getContentPane().setBackground(Color.WHITE);
        getContentPane().add(button);
        setSize(width, height);
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

        area.printGraphArea(g2d);
        barGraph.drawGraph(g2d);
        button.repaint();

        if(isPressed){
           // g2d.clearRect(0,0,width,height);
            g.setColor(Color.WHITE);
            g2d.fillRect(0,0,width,height);
            isPressed = false;

        }
        if(printOnce == false){
            for(int i = 1; i <= 10; i++){
                //10 to make 10 divisions
                if(barGraph.isVertical()){
//                    VerticalBarGraph temp2 =(VerticalBarGraph) barGraph;
//                    float temp = (float)((temp2.getMaxValue()/10.0) * i);
//                    String print = temp +"";
//                    g.drawString(print, (area.getX()), area.getY() + area.getHeight() - ((area.getHeight()-50)/10)*i);
                    //printOnce = true;
                }else{
                    HorizontalBarGraph temp2 =(HorizontalBarGraph) barGraph;
                    float temp = (float)((temp2.getMaxValue()/10.0) * i);
                    String print = temp +"";
                    g.drawString(print, area.getX()+ ((area.getWidth()-50)/10)*i, area.getY());
                   // printOnce = true;
                }
            }
        }


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
                printOnce= false;
            }else{

                System.out.println("Bilal");

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
