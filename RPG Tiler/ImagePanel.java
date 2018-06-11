import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * ImagePanel is a class used to load single images into a JFrame
 * 
 * @FrankLai
 * @2018-03-01
 */
public class ImagePanel extends JPanel{
    // instance fields
    private BufferedImage image;
    /**
     * constructor for reading and loading a new image into JFrame
     * 
     * @param imagePath the path of the image, either from C:\
     * or from a location within the folder 
     */
    public ImagePanel(String imagePath) {
       try 
       {                
          image = ImageIO.read(new File(imagePath));
       } catch (IOException ex) {
            // handle exception...
       }
    }
    /**
     * constructor for loading an image into JFrame when an image already
     * exists
     * 
     * @param image requires an already read and loaded image pointer
     */
    public ImagePanel(BufferedImage image) {
       this.image = image; 
    } // end of constructor ImagePanel(BufferedImage image)
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);      
    } // end of constructor paintComponent(Graphics g)

} // end of class ImagePanel