/**
 * Provide a set of Array functions on an Array of ints
 * @author Wankai Liu
 * @version CSE11-WINTER16-PR2/Users/Wankai/Google Drive/class/CSE_11/PR2/IntArray11.java
 */
import java.lang.Integer;
public class IntArray11
{
    private int[] intArray;
    private static int counter = 0; //any of the constructors have been called
	/** 
	 * 0-argument constructor. Valid instance of an Array of int,
	 * no ints are stored in the array.
	*/
	public IntArray11()
	{
        this.intArray = new int[0];
        counter++;
	}

	/**
	 * Store an array of size n. Initialize contents of the array to 
	 * be 1..n 
	 * @param size the number of elements to store in the array
	*/
	public IntArray11(int size)
	{
        this.intArray = new int[size];
        int i = 0;
        for (i = 0; i < size; i++) {
            this.intArray[i] = i + 1;
        }
        counter++;
	}

	/** 
	 * Create an array of size n and store a copy of the contents of the
	 * input argument
	 * @param intArray array of elements to copy 
	*/
	public IntArray11(int[] intArray)
	{
        this.intArray = intArray;
        counter++;
	}

	/* Make a string representation */
	/**
	 * Pretty Print  -- Empty String "[]"
	 *                  else "[e1, e2, ..., en]"
	 */
	@Override
	public String toString()
	{
        int i = 0;
        String str = new String("[");
        for(i = 0; i < this.intArray.length; i++) {
            str = str + this.intArray[i];
            if(i == this.intArray.length - 1) {
                continue;
            }
            str = str + " ";
        }
        str = str + "]";
		return str;
	}

	/* Getters and Setters */

	/** get the number of elements stored in the array  
	 * @return number of elements in the array
	*/
	public int getNelem()
	{
		return this.intArray.length;
	}
	/** get the Element at index  
	 * @param index of data to retrieve 
	 * @return element if index is valid else  return 
	 * 		Integer.MIN_VALUE
	*/
	public int getElement(int index)
	{
        if (index >= 0 && index <= this.intArray.length - 1) {
            return this.intArray[index];
        }
        else {
            return Integer.MIN_VALUE;
        }
	}
	
	/** Determine how many IntArray11 Objects have been constructed 
	 * @return the number of times any of the constructors have been called 
	*/
	public static int getNArrays()
	{
		return counter;

	}
	/** retrieve a copy of the stored Array
	 * @return a copy of the Array. A new int array should be
	 * 		constructed of the correct size and values should
	 * 		copied into it.   
	*/
	public int[] getArray()
	{
        int[] dest = new int[this.intArray.length];
        System.arraycopy( this.intArray, 0, dest, 0, this.intArray.length);
		return dest;
	}

	/** set the value of an element in the stored arra
	 * @param index of element to store. Must be a valid index 
	 * @param element the data to insert in the array
	 * @return true if element set was successful
	*/
	public boolean setElement(int index, int element)
	{
        if (index >= 0 && index <= this.intArray.length - 1) {
            this.intArray[index] = element;
            return true;
        }
        else {
            return false;
        }
	}

	/** Append element at the end of the array 
	 * @param element the data to append to the array
	 * @return true if element insertion was successful
	*/
	public boolean append(int element)
	{
        int[] largerArr = new int[this.intArray.length + 1];
        System.arraycopy(this.intArray, 0, largerArr, 0, this.intArray.length);
        largerArr[largerArr.length - 1] = element;
        this.intArray = largerArr;
		return true;
	}

	/** Delete an element at index.
	 * @param index of element to delete 
	 * @return true if element deletion was successful, false otherwise
	*/
	public boolean delete(int index)
	{
		return false;
	}

	/** Insert an element at the beginning of the array 
	 * @param element the data to insert in the array
	 * @return true if element insertion was successful
	*/
	public boolean insert(int element)
	{
        int i;
        int[] largerArr = new int[this.intArray.length + 1];
        largerArr[0] = element;
        for(i = 1; i < this.intArray.length + 1; i++) {
            largerArr[i] = this.intArray[i - 1];
        }
        this.intArray = largerArr;
		return true;
	}

	/** Insert an element at index in the array
	 * @param index where to insert. Must be between 0 and number of
	 *              elements (inclusive) in the array. Inserting at 
	 *              index N of an N-element array is an append
	 * @param element the data to insert in the array
	 * @return true if element insertion was successful
	*/
	public boolean insert(int index, int element)
	{
        int i;
        int[] largerArr = new int[this.intArray.length + 1];
        
        for(i = 0; i < this.intArray.length + 1; i++) {
            if (i < index) {
                largerArr[i] = this.intArray[i];
            }
            else if (i == index) {
                largerArr[i] = element;
            }
            else {
                largerArr[i] = this.intArray[i - 1];
            }
        }
        this.intArray = largerArr;
        return true;
	}


	/** reverse the order of the elements in the array 
	*/
	public void reverse()
	{
        int i;
        for(i = 0; i < this.intArray.length / 2; i++) {
            this.swap(i, this.intArray.length - 1 - i);
        }
        return;
	}

	/** reverse the order of the elements in the array from start to
	*   to end index. Both indexes are included in the range. start &lt;= end. 
	*   @param start beginning index of to start the reverse
	*   @param end	ending index to end the reverse
	*   @return true if start and end index are valid, false otherwise
	*
	*/
	public boolean reverse(int start, int end)
	{
        int i = 0;
        if (start < 0 || start > this.intArray.length - 1) {
            return false;
        }
        if (end < 0 || end > this.intArray.length - 1) {
            return false;
        }
        for(i = 0; i <= (end -start) / 2; i++) {
            System.out.println(i);
            this.swap(start + i, end - i);
        }
        return true;
	}

	/** swap two elements in the array
	*   @param index1 index of first element 
	*   @param index2 index of second element
	*   @return true if index1 and index2 are valid, false otherwise
	*
	*/
	public boolean swap(int index1, int index2)
	{
        int temp;
        if (index1 < 0 || index1 > this.intArray.length - 1) {
           return false;
        }
        if (index2 < 0 || index2 > this.intArray.length - 1) {
            return false;
        }
        temp = this.intArray[index1];
        this.intArray[index1] = this.intArray[index2];
        this.intArray[index2] = temp;
        return true;
	}
}
// vim: ts=4:sw=4:tw=78:
