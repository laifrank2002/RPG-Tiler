import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * A library of images for a specific function
 * 
 * @FrankLai
 * @2018-03-01
 */
public class ImageStore
{
    // library field
    private BufferedImage[] Lib;

    /**
     * Takes a whole array of image paths and converts it into a list of 
     * image pointers; useful for grouping many similar images together
     * 
     * @param imagePath a list of image paths, either relative or from C:\
     */
    public ImageStore(String[] imagePath){
        Lib = new BufferedImage[imagePath.length];
        for (int i = 0; i<imagePath.length;i++){
            try{
                File image = new File(imagePath[i]);

                // loads image
                if(image.exists() && !image.isDirectory())
                {
                    BufferedImage img = ImageIO.read(image);
                    this.Lib[i] = img;
                }
                else
                {
                    // error logger
                }
            }
            catch(IOException e){
                System.out.println(e.toString());
                System.out.println("Cannot find " + imagePath[i]);
            } // end of catch and try
        } 

    } // end of constructor ImageStore
    /**
     * Returns an image from the image store
     * 
     * @param index index of the image required
     */
    public BufferedImage getImage(int index)
    {
        if (index < Lib.length){
            // check index is right
            return Lib[index];
        }
        return Lib[0];
    } // end of getter getImage
}
