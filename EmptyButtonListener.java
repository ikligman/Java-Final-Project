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
 *  |                   EmptyButtonListener                     |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Instruct what to do when  |         EmptyButton       |
 *  |  an empty button is clicked   |                           |
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

public class EmptyButtonListener implements ActionListener
{
    private EmptyButton button;
    private LastMovePanel lastMove;
    private GameFieldPanel field;
    
    // Purpose: Constructor takes in an EmptyButton, GameInfoPanel, and LastMovePanel.
    public EmptyButtonListener(EmptyButton inputButton, GameFieldPanel inputField,
                                LastMovePanel inputLastMove)
    {
        button = inputButton;
        lastMove = inputLastMove;
        field = inputField;
    }
    
    /* Purpose: When clicked, an Empty Button will:
     * show empty icon, become unclickable, decrement the number of tries on the info panel
     * and update the last move panel.
     */
    public void actionPerformed(ActionEvent e)
    {
        button.setEnabled(false);
        
        lastMove.fail();
        
        field.reduceNumberOfTries();
    }
}