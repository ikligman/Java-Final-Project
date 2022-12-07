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
 *  |                   TreasureButtonListener                  |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Instruct what to do when  |       TreasureButton      |
 *  |  a treasure button is clicked |                           |
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

public class TreasureButtonListener implements ActionListener
{
    private TreasureButton button;
    private LastMovePanel lastMove;
    private ImageIcon treasure = new ImageIcon("treasure.PNG");
    private TreasureGame game;
    
    // Purpose: Constructor takes in a treasure button, info panel, and last move panel to reference.
    public TreasureButtonListener(TreasureButton inputButton,
                                    LastMovePanel inputLastMove, TreasureGame inputGame)
    {
        button = inputButton;
        lastMove = inputLastMove;
        game = inputGame;
    }
    
    /* Purpose: When clicked, a Treasure Button will:
     * show treasure icon, become unclickable, decrement the number of tries on the info panel, increment the
     * number of treasures found on the info panel, decrement the number of remaining tresures on the info panel,
     * and update the last move panel.
     */
    public void actionPerformed(ActionEvent e)
    {   
        button.setIcon(treasure);
        
        button.setEnabled(false);
        
        game.foundTreasure();
        
        lastMove.success();
    }
    
}
