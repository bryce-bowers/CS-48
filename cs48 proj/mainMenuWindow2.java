import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.*;

import javax.sound.sampled.*;




public class mainMenuWindow2 {

	
	public static void music()
	{
		try{
			File soundFile = new File("sample.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	    } catch (IOException e) {
	         e.printStackTrace();
	    } catch (LineUnavailableException e) {
	         e.printStackTrace();
	    }

	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		
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
		music();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}

class playAction implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		JFrame playFrame = new JFrame("Game");
		playFrame.setSize(300, 150);
		JLabel label = new JLabel("This is where you select your char");
		JPanel panel = new JPanel();
		playFrame.add(panel);
		panel.add(label);
		
		playFrame.setVisible(true);
	}
}

class htpAction implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		JFrame htpFrame = new JFrame("How to Play");
		htpFrame.setSize(300, 150);
		JLabel label = new JLabel("This is how you play");
		JPanel panel = new JPanel();
		panel.add(label);
		htpFrame.add(panel);
		
		htpFrame.setVisible(true);
	}
}

class credAction implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		JFrame credFrame = new JFrame("Credits");
		credFrame.setSize(300,150);
		JPanel panel = new JPanel();
		JLabel BeLabel = new JLabel("--Benjamin Hartl--");
		JLabel CoLabel = new JLabel("--Colin Biafore--");
		JLabel BrLabel = new JLabel("--Bryce Bowers--");
		JLabel NiLabel = new JLabel("--Nicholas Abrahan--");
		panel.add(BeLabel, BorderLayout.CENTER);
		panel.add(CoLabel, BorderLayout.CENTER);
		panel.add(BrLabel, BorderLayout.CENTER);
		panel.add(NiLabel, BorderLayout.CENTER);
		credFrame.add(panel);
		
		credFrame.setVisible(true);
	}	
}
