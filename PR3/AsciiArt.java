/*
 * @author Wankai Liu
 * @version CSE11 Spring 2015
 */

import java.util.Scanner;
import java.util.*;
public class AsciiArt
{
	public static void main (String [] args)
	{
		Scanner scnr = new Scanner (System.in);
        final int ONE_PARAMETERS = 1;
        final int THREE_PARAMETERS = 3;
        final int FOUR_PARAMETERS = 4;
        ArrayList<AsciiShape> shape = new ArrayList<AsciiShape>();
        AsciiGrid grid = null;
        
        while (true) {
            System.out.print("> ");
            String strLine = scnr.nextLine();
            String [] args2 = strLine.trim().split("\\s+");
            if (args2[0].compareToIgnoreCase("grid") == 0) {
                if (args2.length != THREE_PARAMETERS
                    ||Integer.parseInt(args2[1]) < 0
                    ||Integer.parseInt(args2[2]) < 0) {
                    System.out.println("BAD INPUT: Invalid grid parameters");
                    continue;
                }
                grid = new AsciiGrid(Integer.parseInt(args2[1]),Integer.parseInt(args2[2]));
                System.out.println("OK");
            }
            else if (args2[0].compareToIgnoreCase("print") == 0) {
                if (args2.length != ONE_PARAMETERS) {
                    System.out.println("BAD INPUT: Invalid print parameters");
                    continue;
                }
                System.out.println(grid);
                System.out.println("OK");
            }
            else if (args2[0].compareToIgnoreCase("oval") == 0) {
                if (args2.length != THREE_PARAMETERS
                    ||Integer.parseInt(args2[1]) < 0
                    ||Integer.parseInt(args2[2]) < 0) {
                    System.out.println("BAD INPUT: Invalid shape parameters");
                    continue;
                }
                shape.add(new Oval(Integer.parseInt(args2[1]),Integer.parseInt(args2[2]),'#'));
                System.out.println("OK");
            }
            else if (args2[0].compareToIgnoreCase("rectangle") == 0) {
                if (args2.length != THREE_PARAMETERS
                    ||Integer.parseInt(args2[1]) < 0
                    ||Integer.parseInt(args2[2]) < 0) {
                    System.out.println("BAD INPUT: Invalid shape parameters");
                    continue;
                }
                shape.add(new Rectangle(Integer.parseInt(args2[1]),Integer.parseInt(args2[2]),'#'));
                System.out.println("OK");
            }
            else if (args2[0].compareToIgnoreCase("triangle") == 0) {
                if (args2.length != THREE_PARAMETERS
                    ||Integer.parseInt(args2[1]) < 0
                    ||Integer.parseInt(args2[2]) < 0) {
                    System.out.println("BAD INPUT: Invalid shape parameters");
                    continue;
                }
                shape.add(new Triangle(Integer.parseInt(args2[1]),Integer.parseInt(args2[2]),'#'));
                System.out.println("OK");
            }
            else if (args2[0].compareToIgnoreCase("list") == 0) {
                if (args2.length != ONE_PARAMETERS) {
                    System.out.println("BAD INPUT: Invalid list parameters");
                    continue;
                }
                for(int i = 0; i < shape.size(); i++) {
                    System.out.println("" + i + ":");
                    System.out.format("%s\n",shape.get(i).toString());
                }
                System.out.println("OK");
            }
            else if (args2[0].compareToIgnoreCase("place") == 0) {
                if (args2.length != FOUR_PARAMETERS
                    || Integer.parseInt(args2[1]) >= shape.size()
                    || grid == null) {
                    System.out.println("BAD INPUT: Invalid place parameters");
                    continue;
                }
                grid.placeShape(shape.get(Integer.parseInt(args2[1])),
                                Integer.parseInt(args2[2]),Integer.parseInt(args2[3]));
                System.out.println("OK");
                
            }
            else if (args2[0].compareToIgnoreCase("clear") == 0) {
                if (args2.length != FOUR_PARAMETERS
                    || Integer.parseInt(args2[1]) >= shape.size()
                    || grid == null) {
                    System.out.println("BAD INPUT: Invalid clear parameters");
                    continue;
                }
                grid.clearShape(shape.get(Integer.parseInt(args2[1])),
                                Integer.parseInt(args2[2]),Integer.parseInt(args2[3]));
                System.out.println("OK");
            }
            else if (args2[0].compareToIgnoreCase("symbol") == 0) {
                if (args2.length != THREE_PARAMETERS
                    || Integer.parseInt(args2[1]) >= shape.size()) {
                    System.out.println("BAD INPUT: Invalid set parameters");
                    continue;
                }
                shape.get(Integer.parseInt(args2[1])).setSymbol(args2[2].charAt(0));
                System.out.println("OK");
            }
            else if (args2[0].compareToIgnoreCase("exit") == 0) {
                System.out.println("OK");
                return;
            }
            else {
                System.out.println("BAD INPUT: Invalid Command");
            }
        }
	}
}
