//import IntArray11.*;

public class Test
{
    public static void main(String [] args)
    {
        IntArray11 test1 = new IntArray11(); // none input
        IntArray11 test2 = new IntArray11(10); // size = 10
        int [ ] inputArray = {0, 1, 2, 3, 4, 5};
        //System.out.println("Case5: Test getNArrays" + test2.getNArrays());
        //double [ ]  temperature = { 13.5, 18.4, 19.6, 21.4};
        IntArray11 test3 = new IntArray11(inputArray); // size = 10
        System.out.println("Test IntArray11--------->");
        System.out.println("Case1: Input none:");
        String test1out = test1.toString() ;
        System.out.println("Case1: Output of toString:");
        System.out.println(test1out);
        System.out.println("Case2: return the index = 0");
        System.out.println("Case2: Output of the value of index = 0:" + test1.getElement(0));
        
        System.out.println(">>>>>>>>>--------------<<<<<<<<<<<<<<");
        System.out.println("Case1: Input size = 10:");
        String test2out = test2.toString() ;
        System.out.println("Case2: Output of toString:");
        System.out.println(test2out);
        System.out.println("Case2: return the index = 0");
        System.out.println("Case2: Output of the value of index = 9:" + test2.getElement(9));
        System.out.println("Case2: Output of the value of index = 10:" + test2.getElement(10));
        
        System.out.println(">>>>>>>>>--------------<<<<<<<<<<<<<<");
        System.out.println("Case1: Input Array 0 ~ 5:");
        String test3out = test3.toString() ;
        System.out.println("Case2: Output of toString:");
        System.out.println(test3out);
        System.out.println(test1out);
        System.out.println("Case2: return the index = 0");
        System.out.println("Case2: Output of the value of index = 5:" + test3.getElement(5));
        System.out.println("Case2: Output of the value of index = 6:" + test3.getElement(6));
        System.out.println("Case2: Output of the value of index = -1:" + test3.getElement(-1));
        System.out.println("Case4: Test getArray" + test3.getArray()[5]);
        System.out.println("Case5: Test getNArrays" + test2.getNArrays());
        
        System.out.println("Case6: Test setElement6,7" + test3.setElement(6,7));
        System.out.println("Case6: Test setElement3,7" + test3.setElement(3,7));
        System.out.println("Case6: Test getArray3:" + test3.getArray()[3]);
        System.out.println("Case7: Test Array append 99: " + test3.append(99));
        System.out.println("Case7: Test getArray " + test3.toString());
        System.out.println("Case7: Test Array insert -1:" + test3.insert(-1));
        System.out.println("Case7: Test getArray " + test3.toString());
        System.out.println("Case7: Test Array insert 3 11:" + test3.insert(3,11));
        System.out.println("Case7: Test getArray " + test3.toString());
        System.out.println("Case8: Swap two items 0 - 2 :" + test3.swap(2,0));
        System.out.println("Case8: Test getArray " + test3.toString());
        System.out.println("Case9: Reverse :" );
        test3.reverse();
        System.out.println("Case9: Test getArray " + test3.toString());
        System.out.println("Case8: Reverse items 3-6 :" + test3.reverse(3,6));
        System.out.println("Case8: Test getArray " + test3.toString());
	int[] aaa = new int[50];
	System.out.println("------>" + aaa[20]);        
    }
}
