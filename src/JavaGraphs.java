package Main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Graph.GraphArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaGraphs extends JFrame implements ActionListener
{

	private static int width = 800;
	private static int height = 600;
	private Timer timer;
	private int delay = 8;
	private GraphArea area;

	public JavaGraphs() 
	{
        super("Graphs Program");
        
        getContentPane().setBackground(Color.WHITE);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //*****Add your code here*****
        
        //****************************
        timer =  new Timer(delay, this);
        timer.start();
    }
 
    void draw(Graphics g) 
    {
    	
        Graphics2D g2d = (Graphics2D) g;
        //*****Add your code here*****
        
        //****************************
 
    }
 
    public void paint(Graphics g) 
    {
        draw(g);
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
		
		repaint();
	}

}
