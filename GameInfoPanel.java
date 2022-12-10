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
 *  |                        GameInfoPanel                      |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create and display the    |       TreasureButton      |
 *  | game info panel on the left   |         EmptyButton       |
 *  |                               |   TreasureButtonListener  |
 *  |                               |     EmptyButtonListener   |
 *  |                               |         LastMovePanel     |
 *  |                               |       GameFieldPanel      |
 *  |                               |        GameInfoPanel      |
 *  |-------------------------------+---------------------------|
 */

// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.*;

public class GameInfoPanel extends JPanel
{
    private JLabel remainingLabel;
    private JLabel foundLabel;
    private JLabel triesLabel;
    
    // Purpose: Constructor gives starting labels and sets the layout for the panel.
    public GameInfoPanel()
    {
        setLayout(new GridLayout(3,1));
        
        remainingLabel = new JLabel("Treasures left: " + 10);
        foundLabel = new JLabel("Treasures found: " + 0);
        triesLabel = new JLabel("Tries left: " + 20);
        
        add(remainingLabel);
        add(foundLabel);
        add(triesLabel);
    }
    
    // Purpose: Update the tries label with inputed info.
    public void setTries(String inputString, int counter)
    {
        triesLabel.setText(inputString + counter);
    }
    
    // Purpose: Update the remaining label with inputed info.
    public void setRemaining(String inputString, int counter)
    {
        remainingLabel.setText(inputString + counter);
    }
    
    // Purpose: Update the found label with inputed info.
    public void setFound(String inputString, int counter)
    {
        foundLabel.setText(inputString + counter);
    }
}