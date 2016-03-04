import java.util.Scanner;
public class GridTestLWK
{
	public static void main (String [] args)
	{
		Scanner scnr = new Scanner (System.in);
		System.out.println("Enter height, width");
		int h = scnr.nextInt();
		int w = scnr.nextInt();
		System.out.println("=== Grid with Centered Oval === ");
		AsciiGrid grid = new AsciiGrid(h,w);
        //grid.toString();
		AsciiShape shape = new Oval(h/2,w/2,'*');
		grid.placeShape(shape,h/4,w/4);
		System.out.println(grid);
        System.out.println("=== Grid with Clear Oval === ");
        shape = new Oval(h/4,w/4,'#');
        grid.clearShape(shape,h/3,w/3);
        System.out.println(grid);
System.out.println(grid.getSize()[0] + "+" + grid.getSize()[1]);
		System.out.println("=== Grid with Partially Overlapped Oval === ");
		grid = new AsciiGrid(h,w);
		grid.placeShape(shape,h/4,3*w/4);
		System.out.println(grid);
	}
}
