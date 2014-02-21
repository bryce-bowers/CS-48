import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;


public class mainMenu extends JFrame{

    public mainMenu() throws IOException{
	super("Tanks!");
	
	// adds Tanks background
	getContentPane().add(new menuBackground("mainPic.jpg"));
		
	
	/*
	//"Play" Button
	JButton playButton = new JButton("Play!");
	//playButton.addActionListener (new playMenu());
	
	//"How to Play" Button
	JButton htpButton = new JButton("How to Play!");
	//htpButton.addActionListener (new htpAction());
	
	//"Credits" Button
	JButton credButton = new JButton("Credits!");
	//credButton.addActionListener(new credAction());		
	
	//buttonPanel creation
	JPanel buttonPanel = new JPanel();
	buttonPanel.add(playButton);
	buttonPanel.add(htpButton);
	buttonPanel.add(credButton);
	buttonPanel.setOpaque(false);
	
	//Layout
	add(buttonPanel, BorderLayout.SOUTH);
	*/
	
	//Frame creation
	setSize(541, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
    }
    
    public void open() {
	setVisible(true);
    }
    public void close() {
	setVisible(false);
    }

}
