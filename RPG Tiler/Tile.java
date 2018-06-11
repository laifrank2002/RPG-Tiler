
/**
 * A representation of a map tile.
 * 
 * @author Frank Lai
 * @version 2018-03-10
 */
public class Tile
{
    // instance fields
    private int tileType;
    
    
    /**
     * Constructor for objects of class Tile
     */
    public Tile(int tileType)
    {
        // initialise instance variables
        this.tileType = tileType;
    } // end of constructor Tile()
    /**
     * method that returns the tile type
     */
    public int getTileType()
    {
        return tileType;
    } // end of method getTileType()
} // end of class Tile
