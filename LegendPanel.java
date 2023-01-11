/**
 * Lead Author:
 * Ian Kligman; 5550139764
 *
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 * 
 * brain stormbrain storm 29.2k6464 gold badges213213 silver badges385385 bronze badges,
 * et al. “How to Center Jlabel in Jframe Swing?” Stack Overflow, 
 * 1 Dec. 1960, https://stackoverflow.com/questions/19506769/how-to-center-jlabel-in-jframe-swing. 
 * 
 *
 * Version: 12/7/2022
 */

/**
 *  |-----------------------------------------------------------|
 *  |                         LegendPanel                       |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |      Display the legend.      |                           |
 *  |                               |      TreasureGameView     |
 *  |                               |                           |
 *  |                               |                           |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */

// Required library imports for GUI and event listeners.
import javax.swing.*;
import java.awt.*;

public class LegendPanel extends JPanel
{
    private JLabel title;
    private JLabel divider;
    private JLabel unclickedLabel;
    private JLabel noTreasureLabel;
    private JLabel trollLabel;
    private JLabel treasureLabel;
    private ImageIcon troll = new ImageIcon("trolllegend.PNG");
    private ImageIcon notreasure = new ImageIcon("notreasurelegend.PNG");
    private ImageIcon empty = new ImageIcon("emptylegend.JPG");
    private ImageIcon treasure = new ImageIcon("treasurelegend.PNG");
    
    // Purpose: Constructor for the legend panel creates all the labels and adds to panel.
    public LegendPanel()
    {
        setLayout(new GridLayout(6,1));
        
        title = new JLabel("Legend", SwingConstants.CENTER);
        title.setFont(new Font("Algerian", Font.PLAIN, 32));
        
        divider = new JLabel("--------------", SwingConstants.CENTER);
        divider.setFont(new Font("Algerian", Font.PLAIN, 32));
        
        unclickedLabel = new JLabel("Unclicked: ", empty, SwingConstants.LEFT);
        unclickedLabel.setFont(new Font("Algerian", Font.PLAIN, 16));
        unclickedLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        
        noTreasureLabel = new JLabel("No Treasure: ", notreasure, SwingConstants.LEFT);
        noTreasureLabel.setFont(new Font("Algerian", Font.PLAIN, 16));
        noTreasureLabel.setHorizontalTextPosition(SwingConstants.LEFT);
            
        trollLabel = new JLabel("Troll: ", troll, SwingConstants.LEFT);
        trollLabel.setFont(new Font("Algerian", Font.PLAIN, 16));
        trollLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        
        treasureLabel = new JLabel("Treasure: ", treasure, SwingConstants.LEFT);
        treasureLabel.setFont(new Font("Algerian", Font.PLAIN, 16));
        treasureLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        
        add(title);
        add(divider);
        add(unclickedLabel);
        add(noTreasureLabel);
        add(trollLabel);
        add(treasureLabel);
    }
}
