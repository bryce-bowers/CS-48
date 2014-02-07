import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

public class MainMenu extends JFrame implements ActionListener{
	
	private JButton playGame;
	private JButton howToPlay;
	private JButton Credits;
	private static JLabel label;
	
	public MainMenu() {
		setSize(900,600);
		setTitle("Tanks");
		setLayout(new FlowLayout());
		playGame = new JButton("Play");
		
		howToPlay = new JButton("How To Play");
		Credits = new JButton("Credits");
		add(playGame);
		add(howToPlay);
		add(Credits);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.RED);
		setVisible(true);
		playGame.addActionListener(this);
		howToPlay.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		//ButtonFrame buttons;
		
		if(e.getSource() == playGame) {
			/*label = new JLabel("Player 1 Enter Name");
			label.setBounds(450,450, 200, 200);
			add(label);
			//buttons = new ButtonFrame();
			setSize(900,600);
			setTitle("Character Select");
			setVisible(true);
			*/
			ButtonFrame a = new ButtonFrame("character select","player1",
											50,50,"player2",300,300);
		if(e.getSource() == howToPlay){
			
		}
			
		}
	}
}
