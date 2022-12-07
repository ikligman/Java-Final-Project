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
 *  |                        GameFieldPanel                     |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create the game tiles     |   TreasureButtonListener  |
 *  |                               |      TreasureGameView     |
 *  |                               |     EmptyButtonListener   |
 *  |                               |       GameFieldPanel      |
 *  |     Randomly assign Treasure  |        GameInfoPanel      |
 *  |-------------------------------+---------------------------|
 */

// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import java.util.Random;

public class GameFieldPanel extends JPanel
{
    private GameInfoPanel info;
    private LastMovePanel lastMove;
    private int random;
    private final int NUMBER_OF_TILES = 25;
    private JButton[] buttons = new JButton[25];
    private boolean isGameOver;
    private int[] positionArray = new int[10];
    private ImageIcon treasure = new ImageIcon("treasure.PNG");
    private TreasureGame game;
    
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
    public int[] makeRandomArray()
    {
        int[] randomArray = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        
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
    
    /* Purpose: Constructor sets the layout and assigns random positions to the 10 treasure buttons. Each button
     * is added to an array of buttons as it gets created. Constructor takes a LastMovePanel and GameInfoPanel.
     */
    public GameFieldPanel(GameInfoPanel inputInfo, LastMovePanel lastMove, TreasureGame inputGame)
    {
        info = inputInfo;
        
        game = inputGame;
        
        setLayout(new GridLayout(5,5));
        
        int[] treasurePositionArray = makeRandomArray();
        
        positionArray = treasurePositionArray;
        
        for(int i=0; i<NUMBER_OF_TILES; i++)
        {
            if (contains(treasurePositionArray, i))
            {
                TreasureButton treasure = new TreasureButton(info);
                treasure.addActionListener(new TreasureButtonListener(treasure,lastMove,game));
                add(treasure);
                addButton(treasure, i);
            }
            else
            {
                EmptyButton empty = new EmptyButton(info);
                empty.addActionListener(new EmptyButtonListener(empty,lastMove,game));
                add(empty);
                addButton(empty, i);
            }
        }
    }
    
    // Purpose: Allows for the creation of the JButton array. Used in the constructor.
    public void addButton(JButton inputButton, int index)
    {
        buttons[index] = inputButton;
    }
    
    // Purpose: Getter for the JButton array.
    public JButton[] getButtons()
    {
        return buttons;
    }
    
    public void endGame()
    {
        for(int i = 0; i<25; i++)
        {
            buttons[i].setEnabled(false);
            
            if(contains(positionArray, i))
                buttons[i].setIcon(treasure);
        }
    }
}
