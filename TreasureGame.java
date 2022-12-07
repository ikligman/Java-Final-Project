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
 *  |                                           |
 *  |-----------------------------------------------------------|
 *  |               |      |
 *  |-------------------------------+---------------------------|
 *  |        |                           |
 *  |                               |              |
 *  |                               |             |
 *  |               |              |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */

// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class TreasureGame
{
    private int tries = 20;
    private int found = 0;
    private int remaining = 10;
    private boolean gameOver = false;
    private GameInfoPanel infoPanel;
    private GameFieldPanel fieldPanel;
    private LastMovePanel lastMove;
    
    
    public TreasureGame(GameInfoPanel inputInfoPanel, GameFieldPanel inputFieldPanel, LastMovePanel inputLastMove)
    {
        infoPanel = inputInfoPanel;
        fieldPanel = inputFieldPanel;
        lastMove = inputLastMove;
    }
    
    public void reduceNumberOfTries()
    {
        if(tries > 0)
        {
            tries--;
            infoPanel.setTries("Tries left: ", tries);
        }
        
        if(isGameOver())
            endGame();
    }
    
    public void foundTreasure()
    {
        reduceNumberOfTries();
        
        if(remaining > 0)
            remaining--;
        
            infoPanel.setRemaining("Treasures left: ", remaining);
        
        if(found < 10)
            found++;
        
        infoPanel.setFound("Treasures found: ", found);
        
        
        if(found == 10)
        {
            gameOver = true;
        }
    }
    
    public void foundNothing()
    {
        reduceNumberOfTries();
        
        if(tries == 0)
        {
            gameOver = true;
        }
    }
    
    public boolean isGameOver()
    {
        return gameOver;
    }
    
    public void endGame()
    {
        if(tries == 0 && remaining > 0)
        {
            lastMove.gameOver();
            fieldPanel.endGame();
        }
        
        if(found == 10)
        {
            lastMove.youWin();
            fieldPanel.endGame();
        }
    }
}
