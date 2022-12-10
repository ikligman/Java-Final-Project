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
 *  |                        GameFieldPanel                     |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create the game tiles     |   TreasureButtonListener  |
 *  |                               |      TreasureGameView     |
 *  |                               |     EmptyButtonListener   |
 *  |                               |       GameFieldPanel      |
 *  |     Randomly assign Treasure  |        GameInfoPanel      |
 *  |                               |       TreasureButton      |
 *  |                               |         EmptyButton       |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */

// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameFieldPanel extends JPanel
{
    private GameInfoPanel info;
    private LastMovePanel lastMove;
    private final int NUMBER_OF_TILES = 25;
    private EmptyButton[] buttons = new EmptyButton[25];
    private int[] treasurePositionArray = new int[10];
    private int[] trollPositionArray = new int[5];
    private ImageIcon empty = new ImageIcon("empty.JPG");
    private ImageIcon locked = new ImageIcon("locked.PNG");
    private ImageIcon troll = new ImageIcon("troll.PNG");
    private int tries = 20;
    private int foundTreasures = 0;
    private int remainingTreasures = 10;
    
    // Purpose: Checks the inputted array for the inputed number. Returns true if the array has the number.
    public static boolean contains(int[] inputArray, int number)
    {
        for (int index = 0; index < inputArray.length; index++)
        {
            if (inputArray[index] == number)
                return true;
        }
        return false;
    }
    
    // Purpose: Returns a random array of 10 random numbers from 1-25.
    public int[] makeTreasureArray()
    {
        int[] randomArray = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int random;
        
        for (int index = 0; index < randomArray.length; index++)
        {
            do
            {
                random = new Random().nextInt(NUMBER_OF_TILES);
            }
            while (contains(randomArray, random));
            
            randomArray[index] = random;
        }
        
        return randomArray;
    }
    
    /* Purpose: Returns a random array of 5 random numbers from 1-25 that aren't already in the treasure
     * position array.
     */
    public int[] makeTrollArray()
    {
        int[] randomArray = {-1,-1,-1,-1,-1};
        int random;
        
        for (int index = 0; index < randomArray.length; index++)
        {
            do
            {
                random = new Random().nextInt(NUMBER_OF_TILES);
            }
            while (contains(randomArray, random) || contains(treasurePositionArray, random));
            
            randomArray[index] = random;
        }
        
        return randomArray;
    }
    
    /* Purpose: Constructor sets the layout and assigns random positions to the 10 treasure buttons. Each button
     * is added to an array of buttons as it gets created. Constructor takes a LastMovePanel and GameInfoPanel.
     */
    public GameFieldPanel(GameInfoPanel inputInfo, LastMovePanel inputLastMove)
    {
        info = inputInfo;
        
        lastMove = inputLastMove;
        
        setLayout(new GridLayout(5,5));
        
        treasurePositionArray = makeTreasureArray();
        
        trollPositionArray = makeTrollArray();
        
        for(int i=0; i<NUMBER_OF_TILES; i++)
        {
            if (contains(treasurePositionArray, i))
            {
                TreasureButton treasure = new TreasureButton(info);
                treasure.addActionListener(new TreasureButtonListener(treasure,this,lastMove));
                add(treasure);
                addButton(treasure, i);
            }
            else if (contains(trollPositionArray, i))
            {
                TrollButton troll = new TrollButton(info);
                troll.addActionListener(new TrollButtonListener(troll,this,lastMove));
                add(troll);
                addButton(troll, i);
            }
            else
            {
                EmptyButton empty = new EmptyButton(info);
                empty.addActionListener(new EmptyButtonListener(empty,this,lastMove));
                add(empty);
                addButton(empty, i);
            }
        }
    }
    
    // Purpose: Allows for the creation of the JButton array. Used in the constructor.
    public void addButton(EmptyButton inputButton, int index)
    {
        buttons[index] = inputButton;
    }
    
    // Purpose: At the end of the game, disable all buttons and use new icons to reveal any missed treasure.
    public void endButtons()
    {
        for(int i = 0; i<25; i++)
        {
            if(buttons[i].isEnabled())
                buttons[i].setDisabledIcon(empty);
            
            if(contains(treasurePositionArray, i))
            {
                if(buttons[i].isEnabled())
                {
                    buttons[i].setDisabledIcon(locked);
                    buttons[i].setBackground(Color.GREEN);
                }
            }
            
            if(contains(trollPositionArray, i))
            {
                if(buttons[i].isEnabled())
                {
                    buttons[i].setDisabledIcon(troll);
                    buttons[i].setBackground(Color.RED);
                }
            }
            
            buttons[i].setEnabled(false);
        }
    }
    
    // Purpose: Decrement the number of tries with input validation and check for both endgame conditions.
    public void reduceNumberOfTries()
    {
        if(tries > 0)
        {
            tries--;
            info.setTries("Tries left: ", tries);
        }
        
        if(foundTreasures == 10)
        {
            endGame();
        }
        
        if(tries == 0)
        {
            endGame();
        }
    }
    
    // Purpose: Adjust counters on the info panel when a treasure is found with input validation.
    public void foundTreasure()
    {
        if(remainingTreasures > 0)
            remainingTreasures--;
        
        info.setRemaining("Treasures left: ", remainingTreasures);
        
        if(foundTreasures < 10)
            foundTreasures++;
        
        info.setFound("Treasures found: ", foundTreasures);
        
        reduceNumberOfTries();
    }
    
    // Purpose: Set found treasures to 0 when a troll is encountered and update the tries and info panel.
    public void foundTroll()
    {
        foundTreasures = 0;
        
        info.setFound("Treasures found: ", foundTreasures);
        
        reduceNumberOfTries();
    }
    
    // Purpose: Disable buttons for the end game and determine if the result was a win or a loss.
    public void endGame()
    {
        endButtons();
        
        if(foundTreasures == 10)
        {
            lastMove.youWin();
        }
        else
        {
            lastMove.gameOver();
        }
    }
}