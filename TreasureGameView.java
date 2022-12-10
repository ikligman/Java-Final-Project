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
 *  |                       TreasureGameView                    |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create the game window.   |                           |
 *  |                               |        GameInfoPanel      |
 *  |                               |       GameFieldPanel      |
 *  |     Uses BorderLayout         |        LastMovePanel      |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */

// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.*;

public class TreasureGameView extends JFrame
{
    private JPanel titlePanel;
    private JLabel title;
    private GameInfoPanel west;
    private LastMovePanel south;
    private GameFieldPanel center;
    
    // Purpose: Create an instance of TreasureGameView.
    public static void main(String[] args)
    {
        new TreasureGameView();
    }
    
    // Purpose: Define the GUI window and panel layout for the game veiw.
    public TreasureGameView()
    {
        setTitle("Treasure Hunt");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        setLayout(new BorderLayout());
        
        west = new GameInfoPanel();
        
        south = new LastMovePanel();
        
        center = new GameFieldPanel(west, south);
        
        buildTitlePanel();
        
        add(titlePanel, BorderLayout.NORTH);
        add(west, BorderLayout.WEST);
        add(south, BorderLayout.SOUTH);
        add(center, BorderLayout.CENTER);
    
        pack();
        
        setVisible(true);
    }
    
    // Purpose: Create the title shown at the top of the screen. Customize the look of the font.
    public void buildTitlePanel()
    {
        title = new JLabel("Treasure Hunt");
        
        title.setFont(new Font("Parchment", Font.PLAIN, 48));
        
        titlePanel = new JPanel();
        
        titlePanel.add(title);
    }
}