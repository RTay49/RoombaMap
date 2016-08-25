package mapReader;

/**
 * A class taken from the Fox's and rabbits simulation this software was
 * converted from this class will keep count of elements in the map
 * 
 * original
 * @author David J. Barnes and Michael Kölling
 *	converted by Richard Taylor
 */
public class Counter
{
   
    private String name;
 
    private int count;

   
    public Counter(String name)
    {
        this.name = name;
        count = 0;
    }
    
    /**
     * @return The short description of this type.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The current count for this type.
     */
    public int getCount()
    {
        return count;
    }

    /**
     * Increment the current count by one.
     */
    public void increment()
    {
        count++;
    }
    
    /**
     * Reset the current count to zero.
     */
    public void reset()
    {
        count = 0;
    }
}
