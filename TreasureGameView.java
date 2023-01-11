/**
 * Lead Author:
 * Ian Kligman; 5550139764
 *
 * References:
 * Gaddis, T. (2015). Starting Out With Java Myprogramming Lab 
 * From Control Structures Through Objects. (6th ed.). Addison-Wesley. 
 * 
 *
 * Version: 12/15/2022
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
import java.awt.event.*;

public class TreasureGameView extends JFrame
{
    private JPanel titlePanel;
    private JLabel title;
    private GameInfoPanel west;
    private LastMovePanel south;
    private GameFieldPanel center;
    private LegendPanel east;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitItem;
    private JMenuItem aboutItem;
    
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
        
        east = new LegendPanel();
        
        center = new GameFieldPanel(west, south);
        
        buildTitlePanel();
        
        add(titlePanel, BorderLayout.NORTH);
        add(west, BorderLayout.WEST);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        add(center, BorderLayout.CENTER);
        
        buildMenuBar();
    
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
    
    // Purpose: Build the menu bar.
    private void buildMenuBar()
    {
        menuBar = new JMenuBar();
        
        buildFileMenu();
        
        menuBar.add(fileMenu);
        
        setJMenuBar(menuBar);
    }
    
    // Purpose: Build the components of the File menu.
    private void buildFileMenu()
    {
        fileMenu = new JMenu("File");
        
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ExitListener());
        
        aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(new AboutListener());
        
        fileMenu.add(exitItem);
        fileMenu.add(aboutItem);
    }
    
    // Purpose: Action Listener for the exit menu item.
    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    
    // Purpose: Action Listener for the about menu item.
    private class AboutListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, "About\n" + "------------------------------\n\n" + 
                "Lead author: Ian Kligman\n" + "Play tester: Sean Kim\n" + "Version: 12/15/22\n");
        }
    }
}