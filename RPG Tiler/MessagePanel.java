import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
;
/**
 * Displays messages to the user.
 * 
 * @author Frank Lai
 * @version 2018-05-18
 */
public class MessagePanel extends JLayeredPane
{
    // instance variables
    private int width;
    private int height;
    /**
     * Creates a default message panel with width and height
     * 
     * @param width the width of the render
     * @param height the height of the render
     */
    public MessagePanel(int panelWidth, int panelHeight)
    {
        // creates the panel
        setBackground(Color.GREEN);
        // init 
        width = panelWidth;
        height = panelHeight;
        
        Button button = new Button();
        add(button);
        
        // Setup content JPanel.
        setSize(width,height);
        // Ensure custom layouts and abs positioning works.
        setLayout(null); 
        // Make sure it is visible.
        setVisible(true);
    }
    
    /**
     * Updates components.
     * 
     * @param graphics the graphics component
     */
    public void paintComponent(Graphics graphics)
    {
        
        
    }
} // end of class MessagePanel
