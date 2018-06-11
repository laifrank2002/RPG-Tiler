import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Checks the key input
 *
 * @author Frank Lai
 * @version 10/05/2018
 */
public class KeyInputListener implements KeyListener
{
    @Override
    public void keyTyped(KeyEvent event)
    {
        // do nothing
        System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
    }

    @Override
    public void keyPressed(KeyEvent event) 
    {
        // do nothing
        System.out.println("keyPressed="+KeyEvent.getKeyText(event.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent event) 
    {
        System.out.println("keyReleased="+KeyEvent.getKeyText(event.getKeyCode()));
    }
}