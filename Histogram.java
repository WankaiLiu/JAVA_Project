/**
 * Plot each value from the input file as the height of a bar in histogram.
 * @author Wankai Liu
 * @version CSE11-WINTER16-PR2/Users/Wankai/Google Drive/class/CSE_11/PR4/Histogram.java
 */
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.io.IOException;
import java.lang.Runnable;
import java.awt.event.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Histogram {
    /**
     * Plot each value from the input file as the height of a bar in histogram.
     * @param a The first two numbers of the command are the width and height of 
     * the histogram (in pixels). The third argument is the name of the input file
     * that contains only non-negative integers.
     */
	public static void main(String[] a) throws IOException{
        int width = 602;
        int height = 402;
        FileInputStream fileStream = null;
        Scanner inFS = null;
        try
        {
            if(a.length != 1 && a.length != 3) {
                throw new Exception("Reason: Improper number of arguments");
            }
        }
        catch (Exception excpt) {
            System.err.println("Usage: Histogram [ width height] filename");
            System.err.println(excpt.getMessage());
            return;
        }
        if(a.length == 3) {
            try {
                if(Integer.parseInt(a[0]) < 0 || Integer.parseInt(a[1]) < 0) {
                    throw new ArithmeticException("Reason: Invalid Dimensions");
                }
                width = Integer.parseInt(a[0]) + 2;
                height = Integer.parseInt(a[1]) + 2;
                fileStream = new FileInputStream(a[2]);
                inFS = new Scanner(fileStream);
            }
            catch (NumberFormatException excpt) {
                System.err.println("Usage: Histogram [ width height] filename");
                System.err.println("Reason: Invalid Integer");
                return;
            }
            catch (ArithmeticException excpt) {
                System.err.println("Usage: Histogram [ width height] filename");
                System.err.println(excpt.getMessage());
                return;
            }
            catch (FileNotFoundException excpt) {
                System.err.println("Usage: Histogram [ width height] filename");
                System.err.println("Reason: File system error");
                return;
            }
        }
        else {
            try {
                fileStream = new FileInputStream(a[0]);
                inFS = new Scanner(fileStream);
            }
            catch (FileNotFoundException excpt) {
                System.err.println("Usage: Histogram [ width height] filename");
                System.err.println("Reason: File system error");
                return;
            }
        }
        ArrayList<Integer> inputArray = new ArrayList<>();
        try  {
            if (!inFS.hasNext()) {
                throw new Exception("Reason: No values to display");
            }
        }
        catch (Exception excpt) {
            System.err.println("Usage: Histogram [ width height] filename");
            System.err.println(excpt.getMessage());
            return;
        }
        while (inFS.hasNextInt()) {
            inputArray.add(inFS.nextInt());
            try  {
                if (inputArray.get(inputArray.size() - 1) < 0) {
                    throw new Exception("Reason: Value is negative");
                }
            }
            catch (Exception excpt) {
                System.err.println("Usage: Histogram [ width height] filename");
                System.err.println(excpt.getMessage());
                return;
            }
        }
        try  {
            if (inFS.hasNext()) {
                throw new Exception("Non-integer in file");
            }
        }
        catch (Exception excpt) {
            System.err.println("Usage: Histogram [ width height] filename");
            System.err.println(excpt.getMessage());
            return;
        }
        int unitWidth = width / inputArray.size();
        try  {
            if (unitWidth <= 2) {
                throw new Exception("Reason: Too many bins for pixel width");
            }
        }
        catch (Exception excpt) {
            System.err.println("Usage: Histogram [ width height] filename");
            System.err.println(excpt.getMessage());
            return;
        }
		MyWindow window = new MyWindow(width, height, unitWidth, inputArray);
		SwingUtilities.invokeLater(window);
		try
		{
			System.err.format("Hit Return to exit program");
			System.in.read();
		}
		catch (IOException e){}
		window.dispatchEvent(new WindowEvent(window, 
			WindowEvent.WINDOW_CLOSING));
        window.dispose();
        
	}

}

class MyWindow extends JFrame implements Runnable
{
    private	Grid grid;
    private int width;
    private int height;
    /**
     * Find the maximum value from the input Arraylist.
     * input argument
     * @param inputArray Int ArrayList
     * @return maximum element
     */
    private int findMax(ArrayList<Integer> inputArray) {
        int maxVal = inputArray.get(0);
        for(int i = 1; i < inputArray.size(); i++) {
            maxVal = maxVal > inputArray.get(i)
                   ? maxVal
                   : inputArray.get(i);
        }
        return maxVal;
    }
    @Override
    public Dimension getPreferredSize() {
        final int EXTRA_HEIGHT = 40;
        final int EXTRA_WIDTH = 15;
        return new Dimension(width + EXTRA_WIDTH, height + EXTRA_HEIGHT);
    }
    /** Constructor
     * @param width The width of the histogram(in pixels).
     * @param height The height of the histogram(in pixels).
     * @param unitWidth The width of the bar(in pixels).
     * @param inputArray The value of the bar.
     */
    public MyWindow(int width, int height, int unitWidth, ArrayList<Integer> inputArray) {
        super();
        int maxElement = findMax(inputArray);
        this.width = width;
        this.height = height;
        Grid grid = new Grid(width, height, unitWidth);
        setSize(getPreferredSize()); //FIX
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(grid);
        setVisible(true);
        for(int i = 0; i < inputArray.size(); i++) {
            grid.fillCell(i * unitWidth, height - height * inputArray.get(i) / maxElement);
        }
    }

	public void run() {
	}
}

class Grid extends JPanel {
	private ArrayList<Point> fillCells;
    private int width;
    private int height;
    private int unitWidth;
    /** Constructor
     * @param width The width of the histogram(in pixels).
     * @param height The height of the histogram(in pixels).
     * @param unitWidth The width of the bar(in pixels).
     */
	public Grid(int width,int height,int unitWidth) {
		fillCells = new ArrayList<Point>();
        this.width = width;
        this.height = height;
        this.unitWidth = unitWidth;
	}
    /**
     * Paint all components and frame.
     * @param g
     */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        int tempWidth = 0;
		for (Point fillCell : fillCells) {
			int cellX = (fillCell.x);
			int cellY = (fillCell.y);
			g.setColor(Color.YELLOW);
			g.fillRect(cellX, cellY, unitWidth, height - cellY);
            g.setColor(Color.BLACK);
            g.drawLine(cellX, cellY, cellX, height);
            g.drawLine(cellX + unitWidth, cellY, cellX + unitWidth, height);
            tempWidth = cellX + unitWidth;
		}
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, tempWidth, height);
	}
    /**
     * Add the location of each component to the Array.
     * @param x Location of x
     * @param y Location of y
     */
	public void fillCell(int x, int y) {
		fillCells.add(new Point(x, y));
        
		repaint();
	}

}
// vim: ts=4:sw=4:tw=78
