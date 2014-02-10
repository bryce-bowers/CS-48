import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class MainMenu extends JFrame implements ActionListener{
    private JButton playGame;
    private JButton howToPlay;
    private JButton credits;
    private int numSelected;
    ArrayList<StringInteger> a = new ArrayList<StringInteger>();
 
    public MainMenu() {
	setSize(900,600);
	setTitle("Tanks");
	setLayout(new FlowLayout());
	createWindowArrayList();
    }

    public void doMainMenu(){
	
	/*	int i = 0;
	while(i >= 0)
	    {
		
		i = getNextWindow();
		
	    }
	*/


	playGame = new JButton("Play");
        add(playGame);
	playGame.addActionListener(this);

	howToPlay = new JButton("How To Play");
	add(howToPlay);
	howToPlay.addActionListener(this);
	
	credits = new JButton("Credits");
	add(credits);
	credits.addActionListener(this);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setBackground(Color.RED);
	setVisible(true);
	
	
    }

    public void actionPerformed(ActionEvent e) {
	NextFrame nf = new NextFrame();	
	if(e.getSource() == playGame) {
	    nf.setName("Character Select");
	    nf.createPlayerNameInput(1);
	}
	
	else if(e.getSource() == howToPlay){
	    nf.setName("How To Play");
	    nf.createJLabel("How To Play:", 100, 100);
	    
	    nf.createJLabel(getInstructions(), 200, 200);
	}
	
	else if(e.getSource() == credits){
	    nf.setName("Credits");
	    nf.createJLabel("Written in 2014 by:", 100, 100);
	    
	    nf.createJLabel("--Benjamin Hartl--", 200, 200);
	    nf.createJLabel(" --Bryce Bowers--", 200, 220);
	    nf.createJLabel(" --Colin Biafore--", 200, 240);
	    nf.createJLabel(" --Nick Abrahan--", 200, 260);

	}
	//nf.createJButton("Back To Main Menu", 500, 500);
    }
    
    public String getInstructions() {
	return("The Object of the game is to destroy the other player.");
    }
    public ArrayList createWindowArrayList()
    {
	a.add(new StringInteger("Main Menu", 0));
	a.add(new StringInteger("Character Select", 1));
	a.add(new StringInteger("How To Play", 2));
	a.add(new StringInteger("Credits", 3));
	a.add(new StringInteger("Player 1 Select", 4));
	a.add(new StringInteger("Player 2 Select", 5));
	a.add(new StringInteger("Play Game", 6));
	a.add(new StringInteger("Main Menu", 7));
	
	return a;
    }
    
}
