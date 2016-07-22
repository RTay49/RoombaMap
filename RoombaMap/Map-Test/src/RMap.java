import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Represent a rectangular grid of field positions.
 * Each position is able to store a single animal.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class RMap
{
 
    
    // The depth and width of the field.
    private int depth, width;
    // Storage for the animals.
    private Object[][] rMap;

    /**
     * Represent a field of the given dimensions.
     * @param depth The depth of the field.
     * @param width The width of the field.
     */
    public RMap(int depth, int width)
    {
        this.depth = depth;
        this.width = width;
        rMap = new Object[depth][width];
    }
    
    /**
     * Empty the field.
     */
    public void clear()
    {
        for(int row = 0; row < depth; row++) {
            for(int col = 0; col < width; col++) {
            	rMap[row][col] = null;
            }
        }
    }
    
    /**
     * Clear the given location.
     * @param location The location to clear.
     */
    public void clear(Location location)
    {
    	rMap[location.getRow()][location.getCol()] = null;
    }
    

    public void place(Object place, int row, int col)
    {
        place(place, new Location(width, depth,row, col));
    }
    
 
     
    public void place(Object place, Location location)
    {
    	rMap[location.getRow()][location.getCol()] = place;
    }
    
  
    public Object getObjectAt(Location location)
    {
        return getObjectAt(location.getRow(), location.getCol());
    }
    
 
    public Object getObjectAt(int row, int col)
    {
        return rMap[row][col];
    }
    
  
    public int getDepth()
    {
        return depth;
    }
    
    /**
     * Return the width of the field.
     * @return The width of the field.
     */
    public int getWidth()
    {
        return width;
    }
}
