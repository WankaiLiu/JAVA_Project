/** define a 2D array of chars as a way to make ascii art.
 * can place and clear an arbitrary 2D array of chars in the grid
 * if asked-for array fits.
 * @author Wankai Liu
 * @version CSE11 Spring 2015
 */
public class AsciiGrid
{
    private int row;
    private int col;
    private char [][] charGrid;
	/** Constructor 
	 */
	public AsciiGrid()
	{
        this.row = 25;
        this.col = 40;
        charGrid = new char[row + 2][col + 2];
        for (int i = 0 ; i <= row + 1; i++) {
            for (int j = 0; j <= col + 1; j ++) {
                if (i == 0 || i == row + 1) {
                    charGrid[i][j] = '=';
                }
                else if (j == 0 || j == col + 1) {
                    charGrid[i][j] = '|';
                }
                else {
                    charGrid[i][j] = ' ';
                }
            }
        }
	}
	/** Constructor 
	 * @param row number of rows in the ascii grid 
	 * @param col number of columns in the ascii grid 
	 */
	public AsciiGrid(int row, int col)
	{
        this.row = row;
        this.col = col;
        charGrid = new char[row + 2][col + 2];
        for (int i = 0 ; i <= row + 1; i++) {
            for (int j = 0; j <= col + 1; j ++) {
                if (i == 0 || i == row + 1) {
                    charGrid[i][j] = '=';
                }
                else if (j == 0 || j == col + 1) {
                    charGrid[i][j] = '|';
                }
                else {
                    charGrid[i][j] = ' ';
                }
            }
        }
	}

	/** return a row x col array of the current char array  
	 * This should be a full/deep copy, not a reference to internal
	 * storage
	 * @return array of chars 
	 */
	public char [][] getChars()
	{
        char [][] copyChars = new char[charGrid.length][charGrid[0].length];
        for (int i = 0 ; i < charGrid.length; i++) {
            for (int j = 0; j < charGrid[0].length; j ++) {
                    copyChars[i][j] = charGrid[i][j];
            }
        }
		return (char [][]) copyChars;
	}


	/** 
	 * place the 2D shape in the grid at location (r,c) 
	 *
	 * @param shape AsciiShape object 
	 * @param r row in the grid where to place the first row of the shape
	 * @param c column in the grid where to place the first column of the shape
	 * @return true, if grid was updated, false otherwise 
	 *
	 * Implementation note: don't attempt to set anything outside of the grid.
	 * Start at coordinates (r,c). The loop through the rows and columns of
	 * the Shape (see getShape()) and adding r to the row coord, c to the
	 * column coord  of each element to 'translate the shape' to have it's
	 * upper left corner at (r,c).  Only 
	 * set of the grid element if the getShape()[i][j] element is non-null and
	 * is translated to be within the boundaries of the grid.  
	 */
	public boolean placeShape(AsciiShape shape,int r, int c)
	{
        if (r > row || c > col) {
            return false;
        }
        boolean isChange = false;
        //System.out.println("+" + shape.H + shape.W);
        for (int i = r + 1; i <= row; i++) {
            for (int j = c + 1; j <= col; j++) {
                //System.out.println("+" + r+c+i + j);
                //System.out.println("char" + shape.shape[i - 1 - r][j - 1 - c]);
                if (i - 1 - r < shape.H && j - 1 - c < shape.W
                    && shape.shape[i - 1 - r][j - 1 - c] != null) {
                    //System.out.println("" + i + j);
                    if (this.charGrid[i][j] != shape.shape[i - 1 - r][j - 1 - c]) {
                        isChange = true;
                    }
                    this.charGrid[i][j] = shape.shape[i - 1 - r][j - 1 - c];
                }
            }
        }
        return isChange;
	}
	
	/**
	 * clear the elements in the grid  defined by the 2D shape 
	 * starting at grid at location (r,c). 
	 * Clear is the inverse of place.  Instead of placing the chars 
	 * defined by the shape, place the EMPTY char (effectively clearing).
	 * Null Characters defined in the shape do not affect the grid (either
	 * placing or clearing). 
	 *
	 * @param shape AsciiShape object  
	 * @param r row in the grid where to start the clearing 
	 * @param c column in the grid where to start the clearing 
	 * @return true, if grid was updated, false otherwise 
	 *
	 * Implementation note: placeShape and clearShape are nearly identical.
	 * The ONLY difference is what you see the grid element to be (the symbol
	 * of the shape OR a ' '.  Define a helper.
	 */
	public boolean clearShape(AsciiShape shape,int r, int c)
	{
        if (r > row || c > col) {
            return false;
        }
        boolean isChange = false;
        //System.out.println("+" + shape.H + shape.W);
        for (int i = r + 1; i <= row; i++) {
            for (int j = c + 1; j <= col; j++) {
                //System.out.println("+" + r+c+i + j);
                //System.out.println("char" + shape.shape[i - 1 - r][j - 1 - c]);
                if (i - 1 - r < shape.H && j - 1 - c < shape.W
                    && shape.shape[i - 1 - r][j - 1 - c] != null) {
                    //System.out.println("" + i + j);
                    if (this.charGrid[i][j] != ' ') {
                        isChange = true;
                    }
                    this.charGrid[i][j] = ' ';
                }
            }
        }
        return isChange;
	}
	
	/** Return the width and height of the grid 
	 *  @return array where index=0 is nrows, index=1 ncolumns 
	 */
	public int [] getSize()
	{
        int [] vec = new int[2];
        vec[0] = this.row;
        vec[1] = this.col;
		return vec;
	}

	/** create a nice, printable representation of the grid and
	 * filled coordinates
	 *
	 * the grid should be framed. A row of "=' (length = width of grid + 2)
	 * should be used to frame the top and bottom of the grid. The '|' should
	 * be used to frame the left and right side of each row of the grid. e.g 
	 * 1x1  empty grid      2 x 2 empty grid
	 * ===                  ====
	 * | |                  |  |
	 * ===                  |  |
	 *                      ====
	 */
	@Override
	public String toString()
	{
		String output = "";
        for (int i = 0 ; i < charGrid.length; i++) {
            for (int j = 0; j < charGrid[0].length; j ++) {
                output = output + charGrid[i][j];
            }
            if (i == charGrid.length - 1) {
                break;
            }
            output = output + '\n';
        }
		return output;
	}
	
}
// vim: ts=4:sw=4:tw=78
