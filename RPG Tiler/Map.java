import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * map will create a 2d array that will store values as to what is contained there
 * this physically represents a map in 2d space
 * 
 * Code for tiles
 * 0 - null
 * 1 - nothing
 * 2 - forest
 * 3 - castle
 * 4 - lake
 * 5 - desert
 * 
 * @author Frank Lai
 * @version 2018-02-26
 */
public class Map
{
    /* map is made of tile object used to represent its state */
    // instance fields
    private Tile[][] mapArray;
    private ArrayList <MapObject> mapObjects;
    private String name;
    private int x_size;
    private int y_size;
    /**
     * Constructs a Map object with all params defined
     * 
     * @param x the length of the map
     * @param y the width of the map
     * @param name the name of the map
     */
    public Map(int x_size, int y_size, String map_name)
    {
        // initialises the array
        this.mapArray = new Tile[x_size][y_size];

        for (int y = 0; y < y_size; y ++)
        {
            for (int x = 0; x < x_size; x ++)
            {
                // makes sure tiletype returned random
                this.mapArray[x][y] = new Tile(generateTile());
            } // end for(int x = 0; x < 5; x ++)
        } // end for(int y = 0; y < 5; y ++)

        this.name = map_name;
        this.x_size = x_size;
        this.y_size = y_size;
        mapObjects = new ArrayList<MapObject>();
    } // end constructor Map(int x_size, int y_size, String map_name)
    /**
     * Constructs a Map object that defines the size
     * 
     * @param x the length of the map
     * @param y the width of the map;
     */
    public Map(int x_size, int y_size)
    {
        // initialises the array
        this.mapArray = new Tile[x_size][y_size];

        for (int y = 0; y < y_size; y ++)
        {
            for (int x = 0; x < x_size; x ++)
            {
                // makes sure tiletype returned random
                this.mapArray[x][y] = new Tile(generateTile());
            } // end for(int x = 0; x < 5; x ++)
        } // end for(int y = 0; y < 5; y ++)

        this.name = "Map";
        this.x_size = x_size;
        this.y_size = y_size;
        mapObjects = new ArrayList<MapObject>();
    } // end constructor Map(int x_size, int y_size)

    /**
     * Constructs a map with default characteristics; programmer's lazy characteristics
     */
    public Map()
    {
        // initializes the array
        this.mapArray = new Tile[10][10];
        for (int y = 0; y < 10; y ++)
        {
            for (int x = 0; x < 10; x ++)
            {
                // makes sure tiletype returned random
                this.mapArray[x][y] = new Tile(generateTile());
            } // end for(int x = 0; x < 10; x ++)
        } // end for(int y = 0; y < 10; y ++)

        this.name = "Map";
        this.x_size = 10;
        this.y_size = 10;
        mapObjects = new ArrayList<MapObject>();
    } // end constructor Map()

    /**
     * returns whether or not a cartesian coordinate lies within the map
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public boolean isValidCoordinate (int x,int y)
    {
        if( x >= 0 && x < mapArray.length)
        {
            if(y >= 0 && y < mapArray[x].length)
            {
                return true;
            }
        }
        return false;

    } // end isValidCoordinate (int x, int y,)
    /**
     * returns a mapobject on the map (NOT ERROR PROOFED)
     * 
     * @param index the index of the object
     * 
     * @return the map object
     */
    public MapObject getMapObject(int index)
    {
        return mapObjects.get(index);
    }

    /**
     * returns the tile type only if the coordinate is valid
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     * 
     * @return the type of tile, -1 is the error code 
     */
    public int getTileType(int x,int y)
    {
        if (isValidCoordinate(x,y))
        {
            return mapArray[x][y].getTileType();
        }
        // -1 is the general error code 
        return -1; 
    } // end of getTileType(int x,int y)

    /**
     * returns the length of the map
     */
    public int getXSize(){
        return x_size;
    } // end of method getXSize()
    /**
     * returns the width of the map
     */
    public int getYSize(){
        return y_size;
    } // end of method getYSize()

    /**
     * returns the name of the map
     */
    public String getName()
    {
        return this.name;
    } // end of method getName()

    /**
     * Adds new MapObject to the map
     */
    public void addMapObject(MapObject mapObject)
    {
        mapObjects.add(mapObject);
    }

    /**
     * removes MapObject from the map by its index
     * 
     * @param index the index of the object
     */
    public void removeMapObjectByIndex(int index)
    {
        mapObjects.remove(index);
    }

    /**
     * removes MapObject from the map by its serial
     * 
     * @param serial the serialID of the object
     */
    public void removeMapObjectBySerial(int serial)
    {
        // searches for its serial
        for (MapObject mapO: mapObjects)
        {

            if (serial == mapO.getSerial())
            {
                mapObjects.remove(mapO);
                return;
            }
        }
        return;
        // write an error into log or something
    }

    /**
     * removes MapObject from the map by specifying the object
     * 
     * @param mapObject the object wished the remove
     */
    public void removeMapObject(MapObject mapObject)
    {
        mapObjects.remove(mapObject);
    }

    /**
     * returns random value within range
     * 
     * @return a random number
     * @param min the miniumum
     * @param max the maximum
     */
    public int randomRange(int min, int max)
    {
        int range = (max - min) + 1;     
        return (int)(Math.random() * range) + min;
    }

    /**
     * map generator that generates according to a set of predefined parameters
     */
    public int generateTile()
    {
        int roll = randomRange(1,12);
        if (roll < 6){
            return 1;
        }
        else if (roll < 9)
        {
            return 5;
        }
        else if(roll < 11){
            return 2;
        }    
        else if(roll < 12){
            return 3;
        }
        else if(roll < 13){
            return 4;
        }
        else{
            return 0;
        }
    }

    /**
     * Loads a map from a text file.
     * 
     * @param file the name of the file with extension
     */

    /**
     * Exports a map to a text file. Only exports tiles, not the things on it!
     */
    public void exportMapToFile()
    {
        PrintWriter outputFile;
        try
        {
            // establish connection
            outputFile = new PrintWriter(new FileWriter(name + ".rpgtMap"));

            // write header information
            outputFile.println("Map Name:" + name);
            outputFile.println("Width:" + x_size);
            outputFile.println("Height:" + y_size);

            // write tiles
            for (int y = 0; y < y_size; y ++)
            {
                for (int x = 0; x < x_size; x ++)
                {
                    outputFile.print(mapArray[x][y].getTileType() + " ");
                } // end of for (x = 0; x < x_size; x ++)
                // new line
                outputFile.println("");
            } // end of for (y = 0; y < y_size; y ++)
            
            // close connection
            outputFile.close();
        }
        catch(IOException exception)
        {
            System.out.println("Connection not established, export failed: " + exception);
        }
    }
    /**
     * Exports a map to a text file that is named. Only exports tiles, not the things on it!
     * 
     * @param name the name of the file
     */
    public void exportMapToFile(String fileName)
    {
        PrintWriter outputFile;
        try
        {
            // establish connection
            outputFile = new PrintWriter(new FileWriter(fileName + ".rpgtMap"));

            // write header information
            outputFile.println("Map Name:" + name);
            outputFile.println("Width:" + x_size);
            outputFile.println("Height:" + y_size);

            // write tiles
            for (int y = 0; y < y_size; y ++)
            {
                for (int x = 0; x < x_size; x ++)
                {
                    outputFile.print(mapArray[x][y].getTileType() + " ");
                } // end of for (x = 0; x < x_size; x ++)
                // new line
                outputFile.println("");
            } // end of for (y = 0; y < y_size; y ++)
            
            // close connection
            outputFile.close();
        }
        catch(IOException exception)
        {
            System.out.println("Connection not established, export failed: " + exception);
        }
    }
} // end class Map
