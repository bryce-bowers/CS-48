import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;
import java.util.Scanner;



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
	
	
	
	
	public static void main(String[] args) {
		
	        //New Window Creation
	        JFrame frame = new JFrame("Tanks!!");
		JLabel titleLabel = new JLabel("Welcome to Tanks!!!");
		
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
		
		
		//Layout
		frame.add(titleLabel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		
		//Frame creation
		frame.setVisible(true);
		frame.setSize(600, 300);
		music();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Draw Tank
		/*int color = 0;
		
		JPanel tankColorPanel = new JPanel();
		
		TPanel tankImage = new TPanel(color);
		tankColorPanel.add(tankImage);
		frame.add(tankColorPanel);
		tankImage.setVisible(true);*/


		
		

		

	}

}

class playAction implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		JFrame playFrame = new JFrame("Game");
		playFrame.setSize(500, 250);
		JLabel label = new JLabel("This is where you select your char");
		JPanel panel = new JPanel();
		playFrame.add(panel);
		panel.add(label);
		
		playFrame.setVisible(true);

		int color = 0;
		JPanel tankColorPanel = new JPanel();
		
		TPanel tankImage = new TPanel(color);
		tankColorPanel.add(tankImage);
		panel.add(tankColorPanel);
		tankImage.setVisible(true);



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

class TPanel extends JPanel {
    public TPanel(int color){
	System.out.println("The Color of the tank will be: " + color);
	setPreferredSize(new Dimension(500,250));
    }

    @Override    
    public void paintComponent(Graphics t) {

	int xCord = 200;
	int yCord = 70;
	int radius = 30;

	super.paintComponent(t);
	//drawRect(x,y,width,height)
	//drawOval(x,y,width,height)
	//t.drawRoundRect(x, y, width, height, arcWidth, arcHeight);

	// middle of tank
	t.fillRect(xCord,yCord - (radius / 6) + 5,(4 * radius),radius /2);
	t.fillRoundRect(xCord, yCord - (radius/2), 4 * radius, radius, 40, 40 );
	
	// the wheels of the tank
	t.fillOval(xCord,yCord,radius,radius);
	t.fillOval(xCord + radius,yCord,radius,radius);
	t.fillOval(xCord + (2 * radius),yCord,radius,radius);
	t.fillOval(xCord + (3 * radius),yCord,radius,radius);
	
	//the line at the bottom
	t.drawRect(xCord + (radius/2), yCord + (radius/2), 3 * radius, radius/2);
	// the top part of the tank
	t.fillOval(xCord + (radius), yCord - (3* radius)/2, 2 * radius,  2 *radius);
	t.fillRoundRect(xCord - radius, yCord - (3 * radius)/2, (3 * radius) + (radius / 4) , radius / 3,20,20);

		
    }}

