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
 *  |                       LastMovePanel                       |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Display last move info.   |   TreasureButtonListener  |
 *  |                               |      TreasureGameView     |
 *  |                               |     EmptyButtonListener   |
 *  |                               |       GameFieldPanel      |
 *  |                               |        GameInfoPanel      |
 *  |-------------------------------+---------------------------|
 */

// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.*;

public class LastMovePanel extends JPanel
{
    private JLabel lastMoveLabel;
    
    // Purpose: Create the starting contidion for the last move label and add it to the panel.
    public LastMovePanel()
    {
        lastMoveLabel = new JLabel("GOOD LUCK!");
    
        add(lastMoveLabel);
    }
    
    // Purpose: Will be activated by action listeners if an empty button is clicked.
    public void fail()
    {
        lastMoveLabel.setText("Last Move: found nothing...");
    }
    
    // Purpose: Will be activated by action listeners if a treasure button is clicked.
    public void success(int points)
    {
        lastMoveLabel.setText("Last Move: found treasure! +" + points + " points");
    }
    
    // Purpose: Will be activated if the user encounters a troll.
    public void troll()
    {
        lastMoveLabel.setText("Last Move: robbed by a troll :(");
    }
    
    // Purpose: Will be activated if the user runs out of tries.
    public void gameOver()
    {
        lastMoveLabel.setText("Game Over - You lose");
    }
    
    // Purpose: Will be activated if the user finds all treasure before running out of tries.
    public void youWin()
    {
        lastMoveLabel.setText("Game Over - You Win");
    }
}