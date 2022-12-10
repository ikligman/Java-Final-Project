/**
 * Lead Author:
 * Ian Kligman; 5550139764
 *
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 *
 * Version: 12/7/2022
 */

/**
 *  |-----------------------------------------------------------|
 *  |                          EmptyButton                      |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create functionality      |                           |
 *  |     of the buttons            |     EmptyButtonListener   |
 *  |                               |       TreasureButton      |
 *  |     Shows empty when clicked  |        TreasureGame       |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */

// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.*;

public class EmptyButton extends JButton
{
    public GameInfoPanel info;
    private ImageIcon notreasure = new ImageIcon("notreasure.PNG");
    private ImageIcon empty = new ImageIcon("empty.JPG");
    
    // Purpose: Constructor takes in the info panel and styles the unclicked button.
    public EmptyButton(GameInfoPanel inputInfo)
    {
        info = inputInfo;
        
        setIcon(empty);
        setBackground(Color.WHITE);
        setDisabledIcon(notreasure);
    }
}