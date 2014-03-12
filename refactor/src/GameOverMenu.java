import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

/** GameOverMenu opens a JFrame diplays the Game Over Screen and prompts the user(s) to play again
    @author Benjamin Hartl
    @author Nick Abrahan
    @author Colin Biafore
    @author Bryce Bowers
    @version 1.0
*/


public class GameOverMenu{
    JFrame jf;
    
    // Two buttons on game over menu
    public PlayMenu playMenu;


    public GameOverMenu()
    {
	jf = new JFrame("Game Over!");
	setUpBackgroundImage( "./levSelResources/game_over02.jpg" );
	
	addMainButtonPanel();

	jf.setSize(1080, 1920);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setVisible(true);
    }
    
    // adds Tanks background
    public void setUpBackgroundImage( String file )
    {
	try{
	    jf.add( new menuBackground( file ) );
	}catch( IOException ioe ){
	    ioe.printStackTrace();
	}
    }
    
    // The two buttons on the game over menu: play again and back to main menu
    private void addMainButtonPanel() {

	JPanel mainButtonPanel = new JPanel();

	// play button
	JButton playBtn = new JButton( "Play Again!" );
	mainButtonPanel.add(playBtn);
	playBtn.setFocusable( false );
	playBtn.addActionListener( new PlayAgainListener() );
/*	
	// how to play button
	JButton quitBtn = new JButton( "Back to Main Menu" );
	mainButtonPanel.add(htpBtn);
	htpBtn.setFocusable( false );
	htpBtn.addActionListener( new BackToMainListener() );

	jf.add( mainButtonPanel, BorderLayout.SOUTH );
*/
    }

 
    // Play Button action
    class PlayAgainListener implements ActionListener{
	public void actionPerformed( ActionEvent ae ){
		if( playMenu == null )
		    playMenu = new PlayMenu();
		else
			playMenu.setToVisible();
	}
    }
/*    
    // BackToMainMenuListener Button action
    class BackToMainMenuListener implements ActionListener{
	public void actionPerformed( ActionEvent ae ){
	    	jf.setVisible(false);
	}
    }
*/
}


