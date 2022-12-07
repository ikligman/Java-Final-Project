/**
 * Lead Author:
 * Ian Kligman; 5550139764
 *
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 *
 * Version: 12/3/2022
 */

/**
 *  |-----------------------------------------------------------|
 *  |                        TreasureButton                     |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create button functions   |   TreasureButtonListener  |
 *  |                               |                           |
 *  |                               |         EmptyButton       |
 *  |                               |       GameFieldPanel      |
 *  |   Shows Treasure when picked  |        GameInfoPanel      |
 *  |-------------------------------+---------------------------|
 */

// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class TreasureButton extends EmptyButton
{
    public GameInfoPanel info;
    private ImageIcon treasure = new ImageIcon("treasure.PNG");
    
    // Purpose: Constructor passes the info panel to the superclass and assigns it to the local instance variable.
    public TreasureButton(GameInfoPanel inputInfo)
    {
        super(inputInfo);
        
        info = inputInfo;
    }
    
    // Purpose: Reveals the location and disables the button at the end of the game.
    public void endGame()
    {
        setIcon(treasure);
        setEnabled(false);
    }
}
