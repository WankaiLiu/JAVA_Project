
/***********************************************************************
 * Name : Wankai Liu
 * Email : wal033@ucsd.edu
 * ID : A53066548
 *************************************************************************/
import java.util.Scanner;
import java.util.Random;
public class ModRandom
{
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        //System.out.println("Enter your X value:");
        Random randGen = new Random();  // New random number generator
        int seedVal = scnr.nextInt();
        if(seedVal > 0) {
            randGen.setSeed(seedVal);
        }
        System.out.println("Seed : " + seedVal);
        int divisor = randGen.nextInt(10) + 1;
        int number1 = randGen.nextInt(1000) + 1;
        int number2 = randGen.nextInt(1000) + 1;
        int remainder1 = number1 % divisor;
        int remainder2 = number2 % divisor;
        System.out.println("Divisor : " + divisor);
        System.out.print("Number 1 : " + number1 + " ");
        if(remainder1 == 0) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        
        System.out.print("Number 2 : " + number2 + " ");
        if(remainder2 == 0) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        
        if ((remainder1 == 0) && (remainder2 == 0)) {
            System.out.println("Very Lucky!");
        }
        else if ((remainder1 == 0) || (remainder2 == 0)) {
            System.out.println("Push");
        }
        else {
            System.out.println("Not Your Day");
        }
        return;
    }
}

