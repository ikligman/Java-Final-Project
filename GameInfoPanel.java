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
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class GameInfoPanel extends JPanel
{
    private LastMovePanel lastMove;
    private JLabel remainingLabel;
    private JLabel foundLabel;
    private JLabel triesLabel;
    private boolean isGameOver = false;
    
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
    
    // Purpose: count down tries.
    // public void decrementTries()
    //{
       // if(tries > 0)
       // {
       //     tries--;
       //     triesLabel.setText("Tries left: " + tries);
       // }
      //  if(tries == 0)
      //  {
        //    isGameOver = true;
            
            // JButton[] buttons = getButtons();
       // }
  //  }
    
    // Purpose: count down treasures.
    //public void decrementTreasures()
    //{
     //   if(treasures > 0)
     //       treasures--;
            
     //   remainingLabel.setText("Treasures left: " + treasures);
   //}
    
    // Purpose: increment the found accumulator.
   // public void incrementFound()
   // {
    //    if(found < 10)
     //       found++;
        
     //   foundLabel.setText("Treasures found: " + found);
   // }
    
    // Return whether or not it is game over.
    public boolean getIsGameOver()
    {
        return isGameOver;
    }
    
    public void setTries(String inputString, int counter)
    {
        triesLabel.setText(inputString + counter);
    }
    
    public void setRemaining(String inputString, int counter)
    {
        remainingLabel.setText(inputString + counter);
    }
    
    public void setFound(String inputString, int counter)
    {
        foundLabel.setText(inputString + counter);
    }
}
    
    
