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
 *  |                   TrollButtonListener                     |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Instruct what to do when  |       TrollButton         |
 *  |  a troll button is clicked    |                           |
 *  |                               |        LastMovePanel      |
 *  |                               |       GameFieldPanel      |
 *  |                               |        GameInfoPanel      |
 *  |-------------------------------+---------------------------|
 */


// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class TrollButtonListener implements ActionListener
{
    private TrollButton button;
    private LastMovePanel lastMove;
    private GameFieldPanel field;
    
    // Purpose: Constructor takes in a troll button, info panel, and last move panel to reference.
    public TrollButtonListener(TrollButton inputButton, GameFieldPanel inputField,
                                    LastMovePanel inputLastMove)
    {
        button = inputButton;
        lastMove = inputLastMove;
        field = inputField;
    }
    
    /* Purpose: When clicked, a Troll Button will:
     * show troll icon, become unclickable, decrement the number of tries on the info panel, set found treasures
     * to 0, and update the last move panel.
     */
    public void actionPerformed(ActionEvent e)
    {   
        button.setEnabled(false);
        
        lastMove.troll();
        
        field.foundTroll();
    }
}