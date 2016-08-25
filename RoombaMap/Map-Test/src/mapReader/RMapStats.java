package mapReader;
import java.awt.Color;
import java.util.HashMap;

/**
 * A class taken from the Fox's and rabbits simulation this software was
 * converted to store information about the map.
 * 
 * This class collects and provides some statistical data on the state 
 * of a map. It is flexible: it will create and maintain a counter 
 * for any class of object that is found within the field.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class RMapStats
{
    // Counters for each type of entity in the map.
    private HashMap<Class, Counter> counters;
    // Whether the counters are currently up to date.
    private boolean countsValid;

    /**
     * Construct a RMapStats object.
     */
    public RMapStats()
    {
        // Set up a collection for counters for each type of place that
        // we might find
        counters = new HashMap<Class, Counter>();
        countsValid = true;
    }

    /**
     * Get details of what is in the map.
     * @return A string describing what is in the map.
     */
    public String getPopulationDetails(RMap field)
    {
        StringBuffer buffer = new StringBuffer();
        if(!countsValid) {
            generateCounts(field);
        }
        for(Class key : counters.keySet()) {
            Counter info = counters.get(key);
            buffer.append(info.getName());
            buffer.append(": ");
            buffer.append(info.getCount());
            buffer.append(' ');
        }
        return buffer.toString();
    }
    
    /**
     * Invalidate the current set of statistics; reset all 
     * counts to zero.
     */
    public void reset()
    {
        countsValid = false;
        for(Class key : counters.keySet()) {
            Counter count = counters.get(key);
            count.reset();
        }
    }

    /**
     * Increment the count for one class of place.
     * @param animalClass The class of place to increment.
     */
    public void incrementCount(Class placeClass)
    {
        Counter count = counters.get(placeClass);
        if(count == null) {
            // We do not have a counter for this species yet.
            // Create one.
            count = new Counter(placeClass.getName());
            counters.put(placeClass, count);
        }
        count.increment();
    }

    /**
     * Indicate that an place count has been completed.
     */
    public void countFinished()
    {
        countsValid = true;
    }
    
    /**
     * Generate counts of the number of places.
     * These are not kept up to date as places
     * are placed in the field, but only when a request
     * is made for the information.
     * @param field The field to generate the stats for.
     */
    private void generateCounts(RMap field)
    {
        reset();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                Object animal = field.getObjectAt(row, col);
                if(animal != null) {
                    incrementCount(animal.getClass());
                }
            }
        }
        countsValid = true;
    }
}
