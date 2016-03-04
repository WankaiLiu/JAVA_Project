import java.util.Scanner;
public class TestScan
{
	public static void main (String [] args)
	{
		//Scanner scnr = new Scanner (System.in);
        //String str = "sdaf 123 1 23\n";
        Scanner scnr = new Scanner ("123      1 23\n");
        //String = String.toLowerCase(scnr)
        String str1 = "ojuDo 123      1 23".toLowerCase();
        String [] args2 = str1.trim().split("\\s+");
        int h = scnr.nextInt();
		int w = scnr.nextInt();
		System.out.println(args2[0]);
        System.out.println(args2[4]);
		
	}
}
