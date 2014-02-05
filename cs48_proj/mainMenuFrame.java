import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;


public class mainMenuFrame {

    public void drawFrame() throws IOException{

		//New Window Creation
		JFrame frame = new JFrame("Tanks!!");
		frame.getContentPane().add(new JPanelWithBackground("sss.jpg"));
		
		JLabel titleLabel = new JLabel("Welcome to Tanks!!!");
		titleLabel.setOpaque(false);
		titleLabel.repaint();
		
	
		//"Play" Button
		JButton playButton = new JButton("Play!");
		playButton.addActionListener (new playAction());

		//"How to Play" Button
		JButton htpButton = new JButton("How to Play!");
		htpButton.addActionListener (new htpAction());
	
		//"Credits" Button
		JButton credButton = new JButton("Credits!");
		credButton.addActionListener(new credAction());		
		
		//buttonPanel creation
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(playButton);
		buttonPanel.add(htpButton);
		buttonPanel.add(credButton);
		buttonPanel.setOpaque(false);
		
		//Layout
		//frame.add(titleLabel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		
		//Frame creation
		frame.setVisible(true);
		frame.setSize(541, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
