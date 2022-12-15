/**
 * Lead Author:
 * Ian Kligman; 5550139764
 *
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 *
 * Version: 12/12/2022
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
import java.awt.*;

public class TreasureButton extends EmptyButton
{
    private ImageIcon treasure = new ImageIcon("treasure.PNG");
    private ImageIcon locked = new ImageIcon("locked.PNG");
    
    // Purpose: Constructor passes the info panel to the superclass and sets the disabled icon.
    public TreasureButton(GameInfoPanel inputInfo)
    {
        super(inputInfo);
        
        setDisabledIcon(treasure);
    }
    
    // Purpose: Determine how a disabled treasure button should be revealed at end game.
    public void reveal()
    {
        setDisabledIcon(locked);
        setBackground(Color.GREEN);
    }
}