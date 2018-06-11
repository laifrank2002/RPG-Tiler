import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Map renderer
 * It is a main function, so to speak
 *
 * @author Frank Lai
 * @version 2018-03-23
 */
public class OutputWindow
{
    // constants
    
    // window init 
    public static final int WINDOW_X = 1368;
    public static final int WINDOW_Y = 800;
    
    // instance variables
    private static RenderPanel contentPanel;
    private static MessagePanel messagePanel;
    /**
     * The executable function
     * 
     * @param String[] args
     */
    public static void main (String[] args)
    {
        // Setup GUI Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("RPG Tiler");
        frame.setSize(WINDOW_X,WINDOW_Y);
        
        // ensures focus in order to respond to calls
        frame.setFocusable(true);
        frame.requestFocus();
        
        // set up content panel
        contentPanel = new RenderPanel(640,640);
        contentPanel.setLocation(0,0);
        
        // set up message panel 
        messagePanel = new MessagePanel(320,640);
        messagePanel.setLocation(640,0);
        
        // keylistner
        MovementKeyHandler keyInput = new MovementKeyHandler();
        frame.addKeyListener(keyInput);

        // Ensure custom layouts and abs positioning works
        frame.setLayout(null);
        // Build onto the skeleton
        frame.add(contentPanel);
        frame.add(messagePanel);
        // Make sure the JFrame is visible when all is done
        frame.validate();
        frame.setVisible(true);
    } // end of method(String[] args)
    /**
     * Updates the graphics frame
     */
    public static void updateFrame()
    {
        contentPanel.repaint();
    } // end of method updateFrame()
    /**
     * Handles movement for the main character
     */
    private static class MovementKeyHandler implements KeyListener
    {
        // Set of currently pressed keys.
        private final Set<Character> pressed = new HashSet<Character>();

        @Override
        public void keyTyped(KeyEvent event){}

        @Override
        public void keyPressed(KeyEvent event) 
        {
            // Debug
            // System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
            pressed.add(event.getKeyChar());
            
            if (pressed.size() > 1) {
                 //System.out.println("SJI");
                // More than one key is currently pressed.
                // Iterate over pressed to get the keys in order to diagonal movment.
                
                // Movement Keys diagonal
                if ((pressed.contains('A') || pressed.contains('a')) && (pressed.contains('W') || pressed.contains('w')))
                {
                    System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
                    contentPanel.moveMapObject(0, contentPanel.getMapObject(0).getX()-1, contentPanel.getMapObject(0).getY()-1);
                    contentPanel.repaint();
                }
                else if ((pressed.contains('S') || pressed.contains('s')) && (pressed.contains('A') || pressed.contains('a')))
                {
                    System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
                    contentPanel.moveMapObject(0, contentPanel.getMapObject(0).getX()-1, contentPanel.getMapObject(0).getY()+1);
                    contentPanel.repaint();
                }
                else if ((pressed.contains('D') || pressed.contains('d')) && (pressed.contains('S') || pressed.contains('s')))
                {
                    System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
                    contentPanel.moveMapObject(0, contentPanel.getMapObject(0).getX()+1, contentPanel.getMapObject(0).getY()+1);
                    contentPanel.repaint();
                }
                else if ((pressed.contains('W') || pressed.contains('w')) && (pressed.contains('D') || pressed.contains('d')))
                {
                    System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
                    contentPanel.moveMapObject(0, contentPanel.getMapObject(0).getX()+1, contentPanel.getMapObject(0).getY()-1);
                    contentPanel.repaint();
                }
            }
            else {
                //System.out.println("keyPressed="+event.getKeyChar());
                // Movement Keys straight
                if (pressed.contains('A') || pressed.contains('a'))
                {
                    System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
                    contentPanel.moveMapObject(0, contentPanel.getMapObject(0).getX()-1, contentPanel.getMapObject(0).getY());
                    contentPanel.repaint();
                }
                else if (pressed.contains('S') || pressed.contains('s'))
                {
                    System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
                    contentPanel.moveMapObject(0, contentPanel.getMapObject(0).getX(), contentPanel.getMapObject(0).getY()+1);
                    contentPanel.repaint();
                }
                else if (pressed.contains('D') || pressed.contains('d'))
                {
                    System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
                    contentPanel.moveMapObject(0, contentPanel.getMapObject(0).getX()+1, contentPanel.getMapObject(0).getY());
                    contentPanel.repaint();
                }
                else if (pressed.contains('W') || pressed.contains('w'))
                {
                    System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
                    contentPanel.moveMapObject(0, contentPanel.getMapObject(0).getX(), contentPanel.getMapObject(0).getY()-1);
                    contentPanel.repaint();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent event)
        {
            pressed.remove(event.getKeyChar());
        }
    } // end of class MovementKeyHandler
} // end of class OutputWindow
