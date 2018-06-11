
/**
 * An object on a map
 *
 * @author Frank Lai
 * @version 2018-03-10
 */
public class MapObject
{
    // class variables
    /**
     * All of the mapObject possible sprites
     */
    public static ImageStore characterSprites;
    private static int nextSerial = 0;
    // instance variables
    
    private int imageIndex;
    private int serial;
    private int x;
    private int y;
    
    /**
     * Init function that loads all sprite images for the class
     */
    public static void initLoadImages()
    {
        // imagePaths
        String [] imagePaths = new String [4];
        imagePaths[0] = "images/MainCharacter.png";
        imagePaths[1] = "images/equites.png";
        imagePaths[2] = "images/legionary.png";
        imagePaths[3] = "images/velite.png";
        
        characterSprites = new ImageStore(imagePaths);
    }
    /**
     * Constructor for a map object with all parameters defined.
     * 
     * @param x the initial X position
     * @param y the initial Y position
     * @param imageIndex the image of the sprite
     */
    public MapObject(int startingX, int startingY, int imageIndex)
    {
        // initialise instance variables
        x = startingX;
        y = startingY;
        serial = ++nextSerial;
        this.imageIndex = imageIndex;
    } // end of constructor MapObject(int startingX, int startingY, int imageIndex)
    
    /**
     * Constructor for a map object with starting position defined.
     * 
     * @param x the initial X position
     * @param y the initial Y position
     */
    public MapObject(int startingX, int startingY)
    {
        // initialise instance variables
        x = startingX;
        y = startingY;
        serial = ++nextSerial;
        imageIndex = 0;
    } // end of constructor MapObject(int startingX, int startingY)
    
    /**
     * Constructor for a map object with default characteristics.
     */
    public MapObject()
    {
        x = 0;
        y = 0;
        serial = ++nextSerial;
        imageIndex = 0;
    } // end of constructor MapObject()
    
    /**
     * Returns x coordinate.
     *
     * @return x the x coordinate of the object
     */
    public int getX()
    {
        return x;
    } // end of method getX()
    
    /**
     * Returns y coordinate.
     * 
     * @return y the y coordinate of the object 
     */
    public int getY()
    {
        return y;
    } // end of method getY()
    
    /**
     * Returns the serial number of the map object.
     * 
     * @return serial the serial number of the map object
     */
    public int getSerial()
    {
        return serial;
    } // end of method getSerial()
    
    /**
     * Gets the image of the sprite.
     * 
     * @return index the index of the image in the imageStore
     */
    public int getImageIndex()
    {
        return imageIndex;
    } // end of method getImageIndex()
    
    /**
     * Sets the new X of the object
     * 
     * @param x the x coordinate to move to
     */
    public void setX(int newx)
    {
        this.x = newx;
    } // end of method setX(int x)
    
    /**
     * Sets the new Y of the object
     * 
     * @param y the y coordinate to move to
     */
    public void setY(int newy)
    {
        this.y = newy;
    } // end of method setY(int y)    
    
    /**
     * Sets both the new X and the new Y of the object
     * 
     * @param x the x coordinate to move to
     * @param y the y coordinate to move to
     */
    public void setXY (int newx, int newy)
    {
        this.x = newx;
        this.y = newy;
    } // end of method setXY (int x, int y)
}