import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A JPanel that renders all of the map objects.
 * 
 * @author Frank Lai
 * @version 2018-05-18
 */
public class RenderPanel extends JLayeredPane
{
    // constants
    private static final int TILE_HEIGHT = 64;
    private static final int TILE_WIDTH = 64;
    // instance variables
    private Map map;
    private ImageStore tileLib;
    private ImagePanel[][] mapTiles;
    private ArrayList <MapObject> mapObjects;
    
    private int width;
    private int height;
    
    // offset ensures moving
    private int current_x;
    private int current_y;
    /**
     * Creates a default render panel with width and height features
     * 
     * @param width the width of the render
     * @param height the height of the render
     */
    public RenderPanel(int mapWidth, int mapHeight)
    {
        // initializes vars
        map = new Map(20,10);
        mapObjects = new ArrayList<MapObject>();
        // creates the main character
        MapObject mainchar = new MapObject(5,0,0);
        map.addMapObject(mainchar);
        mapObjects.add(mainchar);
        
        // adds the offset
        
        // hard coded npcs 
        MapObject legionaries[] = new MapObject[]{
                new MapObject(1,1,3)
            ,new MapObject(2,5,2)
            ,new MapObject(3,3,1)
            ,new MapObject(9,9,3)};

        for (MapObject mapO: legionaries)
        {
            map.addMapObject(mapO);
        }
        
        width = mapWidth;
        height = mapHeight;
        
        // local variables
        String[] tileLibPaths = new String[6];

        // declare all of the imagepaths
        tileLibPaths[0] = "example.png";
        tileLibPaths[1] = "images/plains.bmp";
        tileLibPaths[2] = "images/forest.bmp";
        tileLibPaths[3] = "images/castle.bmp";
        tileLibPaths[4] = "images/lake.bmp";
        tileLibPaths[5] = "images/dryplains.bmp";
        
        // loads all the images
        tileLib = new ImageStore(tileLibPaths);

        // Other inits
        MapObject.initLoadImages();

        // Setup content JPanel
        setSize(width,height);
        // Ensure custom layouts and abs positioning works
        setLayout(null); 
        
        ImagePanel[] legionaryPics = new ImagePanel[legionaries.length];
        int i = 0;
        for (ImagePanel imgPnl: legionaryPics)
        {
            imgPnl = new ImagePanel(MapObject.characterSprites.getImage(legionaries[i].getImageIndex()));

            imgPnl.setLocation(legionaries[i].getX() *TILE_WIDTH, legionaries[i].getY() *TILE_HEIGHT);
            imgPnl.setSize(TILE_WIDTH,TILE_HEIGHT);
            imgPnl.setOpaque(false);
            add(imgPnl,new Integer(1));
            i++;
        }
        // Make sure it is visible
        setVisible(true);
    } // end of constructor RenderPanel(int mapWidth, int mapHeight)

    /**
     * Updates components.
     * 
     * @param graphics the graphics component
     */
    public void paintComponent(Graphics graphics)
    {
        // Establish the graphics context.
        super.paintComponent(graphics);
        Graphics2D graphicsContext = (Graphics2D)graphics;
        
        // Sets up a map
        // Should be customizable to some degree
        // Will be controlled by a x-y coordinate system
        // That will allow the map to "move" so to speak
 
        // Draw the tiles. (Layer 0)
        for (int x = 0; x < map.getXSize(); x ++)
        {
            for (int y = 0; y < map.getYSize(); y ++)
            {
                // draws and scales tile images on the fly
                graphicsContext.drawImage(tileLib.getImage(map.getTileType(x,y)),x*TILE_WIDTH,y*TILE_HEIGHT,(x+1)*TILE_WIDTH,(y+1)*TILE_HEIGHT
                    ,0,0, tileLib.getImage(map.getTileType(x,y)).getWidth(),tileLib.getImage(map.getTileType(x,y)).getHeight(), this);
            } // end for (int y = 0; y < 5; y ++)
        } // end for (int x = 0; x < 5; x ++)
        
        // Draw the map locations. (Layer 1)
        
        // Draw the map objects. (Layer 2)
        
        
        
        // Draws main character.
        int mapObjectIndex = 0;
        
        graphicsContext.drawImage(MapObject.characterSprites.getImage(map.getMapObject(mapObjectIndex).getImageIndex())
            , map.getMapObject(mapObjectIndex).getX() * TILE_WIDTH
            , map.getMapObject(mapObjectIndex).getY() * TILE_HEIGHT
            , (map.getMapObject(mapObjectIndex).getX()+1) * TILE_WIDTH,(map.getMapObject(mapObjectIndex).getY()+1) * TILE_HEIGHT
            , 0
            , 0
            , MapObject.characterSprites.getImage(map.getMapObject(mapObjectIndex).getImageIndex()).getWidth()
            , MapObject.characterSprites.getImage(map.getMapObject(mapObjectIndex).getImageIndex()).getHeight()
            , this);

    } // end of method paintComponent(Graphics graphics)
    
    /**
     * Gets a mapobject from the map.
     * 
     * @param index the index of the object to be gotten
     */
    public MapObject getMapObject(int index)
    {
        return map.getMapObject(index);
    }
    /**
     * Adds new mapobject to the map.
     * 
     * @param index the index of the object to be added
     */
    public void addMapObject(MapObject mapObject)
    {
        map.addMapObject(mapObject);        
    } // end of method addMapObject(MapObject mapObject)
    
    /**
     * Moves a mapobject on this map to a new location on the map.
     * 
     * @param objectIndex the object to be moved
     * @param x the new x coordinate
     * @param y the new y coordinate
     */
    public void moveMapObject(int objectIndex, int x, int y)
    {
        map.getMapObject(objectIndex).setXY(x,y);
    } // end of method moveMapObject(int x, int y)
}