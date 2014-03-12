import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/** enviroMenu is a class that lets the user select a map to play on
    @author Benjamin Hartl
    @author Nick Abrahan
    @author Colin Biafore
    @author Bryce Bowers
    @version 1.0
*/

public class enviroMenu implements ActionListener{
    
    JButton firstButton, lastButton, nextButton, previousButton, selectButton;
    JPanel cardPanel;
    JLabel titleLabel, descLabel;
    String cardNames[] = new String[3];
    String cardDescription[] = new String[3];
    int cardCounter = 0;
    String tank1;
    String tank2;
    Color tankC1;
    Color tankC2;
    GameScreen newGame;
    JFrame test;

    /** Constructor
	@param t1 Player 1 name
	@param tc1 Player 1 tank color
	@param t2 Player 2 name
	@param tc2 Player 2 tank color
     */

    public enviroMenu(String t1, Color tc1, String t2, Color tc2) throws IOException{
	test = new JFrame();
        JPanel totalGUI = new JPanel();
	tank1 = t1;
	tank2 = t2;
	tankC1 = tc1;
	tankC2 = tc2;
        // We first create a JPanel to show the Buttons.
        // This is an ideal place to show how easy it is to set up a panel
        // of well spaced buttons using a BoxLayout.
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
        
        previousButton = new JButton("<- Previous");
        previousButton.addActionListener(this);
        buttonPanel.add(previousButton);
        buttonPanel.add(Box.createHorizontalGlue());	
                
        firstButton = new JButton("First");
        firstButton.addActionListener(this);
        buttonPanel.add(firstButton);
        buttonPanel.add(Box.createHorizontalGlue());
                
        lastButton =  new JButton("Last");
        lastButton.addActionListener(this);
        buttonPanel.add(lastButton);
        buttonPanel.add(Box.createHorizontalGlue());
        
        nextButton = new JButton("Next ->");
        nextButton.addActionListener(this);
        buttonPanel.add(nextButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));

	selectButton = new JButton("Select");
	selectButton.addActionListener(this);
	buttonPanel.add(selectButton);
	buttonPanel.add(Box.createHorizontalGlue());

       
        // Now we need to create three demonstration panels to show
        // the various ways we can align panels in a BoxLayout.
        // To make this a bit quicker, we've created a method called
        // createSquareJPanel that will generate the colored panels 
        // without loads of lines of code.

        // Shows the default alignment.
	menuBackground align_1, align_2, align_3;
	try {
                align_1 = new menuBackground("./levSelResources/level_01.jpg");
		align_1.setLayout(new BoxLayout(align_1, BoxLayout.LINE_AXIS));
	}catch(IOException e){
	    System.out.println("ERROR");
	    align_1 = new menuBackground();
	}       
	align_1.setLayout(new BoxLayout(align_1, BoxLayout.LINE_AXIS));
	align_1.add(Box.createRigidArea(new Dimension(800,518)));

	try {
	     align_2 = new menuBackground("./levSelResources/level_02.jpg");
	    align_2.setLayout(new BoxLayout(align_1, BoxLayout.LINE_AXIS));
	}catch(IOException e){
	    System.out.println("ERROR");
	    align_2 = new menuBackground();
	}  
	align_2.setLayout(new BoxLayout(align_2, BoxLayout.LINE_AXIS));
	align_2.add(Box.createRigidArea(new Dimension(5,5)));

	try {
	    align_3 = new menuBackground("./levSelResources/bikini_bottom.jpg");
	align_3.setLayout(new BoxLayout(align_1, BoxLayout.LINE_AXIS));
	}catch(IOException e){
	    System.out.println("ERROR");
	    align_3 = new menuBackground();
	}  
	align_3.setLayout(new BoxLayout(align_3, BoxLayout.LINE_AXIS));
	align_3.add(Box.createRigidArea(new Dimension(5,5)));


        // This is the important bit of this application.
        // We use a JPanel with a cardPanel, and add the three panels in order.
        // Note that we have to instantiate this Panel outside of this method
        // so the ActionListener can change it on a buttons command.
        
        cardPanel = new JPanel(new CardLayout(150, 50));
        
        // To add a panel to a cardPanel Panel, we also provide a string
        // to explain the panel added.
        // To make it easier for the label on the GUI, we're going to put
        // the names into an array.
                
        cardDescription[0] = " - Level 1";
        cardDescription[1] = " - Level 2";
        cardDescription[2] = " - Level 3";
        
        cardPanel.add(align_1, cardNames[0]);
        cardPanel.add(align_2, cardNames[1]);
        cardPanel.add(align_3, cardNames[2]);
        
        // Now we've completed all that, we add our toolbar to the content pane
        // along with this cardPanel panel.
        // We will use a BorderLayout this time to position the toolbar above 
        // the CardPanels and the titlebar below.
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
               
        bottomPanel.add(buttonPanel, BorderLayout.PAGE_START);
        bottomPanel.add(cardPanel, BorderLayout.CENTER);
        
        // To add a little bit extra, we'll put a label at the bottom
        // telling you what alignment we have.
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.PAGE_AXIS));
        
        titleLabel = new JLabel(cardNames[0]);
        descLabel = new JLabel(cardDescription[0]);
        
        titlePanel.add(titleLabel);
        titlePanel.add(descLabel);
        
        bottomPanel.add(titlePanel, BorderLayout.PAGE_END);

        // Finally we add that JPanel to the content pane.
        totalGUI.add(bottomPanel);
        totalGUI.setOpaque(true);
	test.add(totalGUI);
	test.setSize(1366, 768);
	test.setVisible(true);
    }

    /**
       Changes the JPanel on the display holding varying map graphics,
       and the title/description at the bottom of the screen
     */
    
    public void actionPerformed(ActionEvent e) {
        
        // We need to get the current layout of the CardLayout panel
        // before we can change it.
        CardLayout cl = (CardLayout)(cardPanel.getLayout());

        // This section of code finds out the button that has been pressed
        // and changes the card displayed on the cardLayout.
        if(e.getSource() == firstButton)
        {
            cl.first(cardPanel);
            cardCounter = 0;
        }
        else if(e.getSource() == lastButton)
        {
            cl.last(cardPanel);
            cardCounter = 2;
        }
        else if(e.getSource() == nextButton)
        {
            cl.next(cardPanel);
            if(cardCounter < 2)
            { 
                cardCounter++;
            }
            else 
            {
                cardCounter = 0;  
            } 
        }
        else if(e.getSource() == previousButton)
        {
            cl.previous(cardPanel);
            if(cardCounter > 0)
            {
                cardCounter--;
            }
            else
            {
                cardCounter = 2;
            }
        }
	else if(e.getSource() == selectButton)
	{
	    try{
		bringUpGame(cardCounter);
	    }catch(IOException ioe){
		ioe.printStackTrace();
	    }
	}

        titleLabel.setText(cardNames[cardCounter]);
        descLabel.setText(cardDescription[cardCounter]);
    }

    /**
       calls GameScreen which will start gameplay
       @param cc Integer representation of the background to be passed to the game screen
     */

     public void bringUpGame(int cc) throws IOException
    {
	newGame = new GameScreen(tank1, tankC1, tank2, tankC2, cc);
	test.dispose();
    }
}
