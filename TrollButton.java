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
 *  |                        TrollButton                        |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create button functions   |   TrollButtonListener     |
 *  |                               |                           |
 *  |                               |         EmptyButton       |
 *  |                               |       GameFieldPanel      |
 *  |   Shows Troll when picked     |        GameInfoPanel      |
 *  |-------------------------------+---------------------------|
 */

// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.*;

public class TrollButton extends EmptyButton
{
    private ImageIcon troll = new ImageIcon("troll.PNG");
    
    // Purpose: Constructor passes the info panel to the superclass and sets the disabled icon.
    public TrollButton(GameInfoPanel inputInfo)
    {
        super(inputInfo);
        
        setDisabledIcon(troll);
    }
    
    // Purpose: Determine how a disabled troll button should be revealed at end game.
    public void reveal()
    {
        setDisabledIcon(troll);
        setBackground(Color.RED);
    }
}
