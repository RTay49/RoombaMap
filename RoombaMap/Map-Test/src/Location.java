/**
 * Represent a location in a rectangular grid.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Location
{
    // Row and column positions.
    private int row;
    private int col;
    private int width;
    private int depth;

    /**
     * Represent a row and column.
     * @param row The row.
     * @param col The column.
     */
    public Location(int width, int depth, int X, int Y)
    {
        this.width = width;
        this.depth = depth;
        col = convertCoordX(X);
        row = convertCoordY(Y);
    }
    
    /**
     * Implement content equality.
     */
    public int convertCoordX (int X){
    	
    	int w_conv = (width-1)/2;
		
    	int col = X + w_conv;
    	
    	return col;
    }
    
    public int convertCoordY (int Y){
	
		int d_conv = (depth-1)/2;
	
		int row = (Y * -1) + d_conv;
		
		return row;
		
		
    }
    
    
    public boolean equals(Object obj)
    {
        if(obj instanceof Location) {
            Location other = (Location) obj;
            return row == other.getRow() && col == other.getCol();
        }
        else {
            return false;
        }
    }
    
    /**
     * Return a string of the form row,column
     * @return A string representation of the location.
     */
    public String toString()
    {
        return row + "," + col;
    }
    
    /**
     * Use the top 16 bits for the row value and the bottom for
     * the column. Except for very big grids, this should give a
     * unique hash code for each (row, col) pair.
     * @return A hashcode for the location.
     */
    public int hashCode()
    {
        return (row << 16) + col;
    }
    
    /**
     * @return The row.
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * @return The column.
     */
    public int getCol()
    {
        return col;
    }
}
