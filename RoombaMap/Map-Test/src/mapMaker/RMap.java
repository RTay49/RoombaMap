package mapMaker;
import java.util.LinkedList;
import java.util.List;


/**
 * A class taken from the Fox's and rabbits simulation this software was
 * converted to store the map.
 * 
 * Represent a rectangular grid of field positions.
 * Each position is able to store a single place.
 * 
 * Original
 * @author David J. Barnes and Michael Kölling
 * Converted by
 * 	Richard Taylor
 */
public class RMap
{
 
    
    // The depth and width of the map.
    private int depth, width;
    // Storage for the places.
    private Object[][] rMap;

    /**
     * Represent a map of the given dimensions.
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
     * Empty the map.
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
        place(place, new Location(Utilities.ConvertCoordCol(col), Utilities.ConvertCoordRow(row)));
    }
    
 
     
    public void place(Object place, Location location)
    {
    	rMap[location.getRow()][location.getCol()] = place;
    }
    
    public List<Location> adjacentLocations(Location location)
    {
        assert location != null : "Null location passed to adjacentLocations";
        // The list of locations to be returned.
        
        //int X = location.getXCord();
        //int Y = location.getYCord();
        
       // int lc = location.getCol();
        //int lr = location.getRow();
        
        List<Location> locations = new LinkedList<Location>();
        if(location != null) {
        	//System.out.println("location not null");
        	//System.out.println("finding locations for: " + X + "(" + lc + ") and  " + Y + "(" + lr + ").");
            int row = location.getRow();
            //System.out.println("location row:" + row);
            int col = location.getCol();
            //System.out.println("location col:" + col);
            for(int roffset = -1; roffset <= 1; roffset++) {
                int nextRow = row + roffset;
                //System.out.println("next row:" + nextRow);
                if(nextRow >= 0 && nextRow < depth) {
                    for(int coffset = -1; coffset <= 1; coffset++) {
                        int nextCol = col + coffset;
                        //System.out.println("next col:" + nextCol);
                        // Exclude invalid locations and the original location.
                        if(nextCol >= 0 && nextCol < width && (roffset != 0 || coffset != 0)) {
                        	Location newloc =  new Location(Utilities.ConvertCoordCol(nextCol), Utilities.ConvertCoordRow(nextRow));
                        	//System.out.println("Rmap new location added: " + newloc.getXCord() + "(" + newloc.getCol() + "), " + newloc.getYCord() + "(" + newloc.getRow() + ").") ;
                        	locations.add(newloc);
                        }
                    }
                }
            }
        }
        return locations;
    }
    
  
    public Object getObjectAt(Location location)
    {
        return getObjectAt(location.getRow(), location.getCol());
    }
    
 
    public Object getObjectAt(int row, int col)
    {
        return rMap[row][col];
    }
    
    
    public List<Location> getFreeAdjacentLocations(Location location)
    {
        List<Location> free = new LinkedList<Location>();
        List<Location> adjacent = adjacentLocations(location);
        for(Location next : adjacent) {
            if(getObjectAt(next) == null) {
                free.add(next);
            }
        }
        return free;
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
