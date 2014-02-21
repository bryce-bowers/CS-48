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

public class LevelSelect extends JFrame implements ActionListener{
    
    JButton firstButton, lastButton, nextButton, previousButton, selectButton;
    JLabel titleLabel, descLabel;

    public JPanel createContentPane () throws IOException{
        
        JPanel totalGUI = new JPanel();
        
        // We first create a JPanel to show the Buttons.
        // This is an ideal place to show how easy it is to set up a panel
        // of well spaced buttons using a BoxLayout.
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        
        buttonPanel.add(Box.createRigidArea(new Dimension(10,0)));
        
        previousButton = new JButton("<- Previous");
        previousButton.addActionListener(this);
        buttonPanel.add(previousButton);
                
        firstButton = new JButton("First");
        firstButton.addActionListener(this);
        buttonPanel.add(firstButton);
                
        lastButton =  new JButton("Last");
        lastButton.addActionListener(this);
        buttonPanel.add(lastButton);
        
        nextButton = new JButton("Next ->");
        nextButton.addActionListener(this);
        buttonPanel.add(nextButton);

	selectButton = new JButton("Select");
	selectButton.addActionListener(this);
	buttonPanel.add(selectButton);
       
        // Now we need to create three demonstration panels to show
        // the various ways we can align panels in a BoxLayout.
        // To make this a bit quicker, we've created a method called
        // createSquareJPanel that will generate the colored panels 
        // without loads of lines of code.

        // Shows the default alignment.
	JPanelWithBackground align_1, align_2, align_3;
	try {
        	align_1 = new JPanelWithBackground("level_01.jpg");
	}catch(IOException e){
		align_1 = new JPanelWithBackground();
	}       
	
	try {
    	align_2 = new JPanelWithBackground("level_02.jpg");
	}catch(IOException e){
		align_2 = new JPanelWithBackground();
	}  

	try {
    	align_3 = new JPanelWithBackground("level_03.jpg");
	}catch(IOException e){
		align_3 = new JPanelWithBackground();
	}  

	
        // This is the important bit of this application.
        // We use a JPanel with a cardPanel, and add the three panels in order.
        // Note that we have to instantiate this Panel outside of this method
        // so the ActionListener can change it on a buttons command.
        
        
        // To add a panel to a cardPanel Panel, we also provide a string
        // to explain the panel added.
        // To make it easier for the label on the GUI, we're going to put
        // the names into an array.

        
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
        
	int level = 0; 
        titleLabel = new JLabel("- Level " + level);
        descLabel = new JLabel(cardDescription[0]);
        
        titlePanel.add(titleLabel);
        titlePanel.add(descLabel);
        
        bottomPanel.add(titlePanel, BorderLayout.PAGE_END);

        // Finally we add that JPanel to the content pane.
        totalGUI.add(bottomPanel);
        totalGUI.setOpaque(true);
        return totalGUI;
    }
    
    // The action performed changes the JPanel on display 
    // and the title/description bar at the bottom.
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

        titleLabel.setText(cardNames[cardCounter]);
        descLabel.setText(cardDescription[cardCounter]);
    }


    private static void createAndShowGUI() throws IOException{
    
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] Level Selection [=]");

        LevelSelect demo = new LevelSelect();
        frame.setContentPane(demo.createContentPane());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
		try {
                	createAndShowGUI();
		} catch (IOException e) {
			e.printStackTrace();
		}
            }
        });
    }
}
