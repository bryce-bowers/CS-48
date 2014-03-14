import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;




public class MainMenu{
    JFrame jf;

    //Music for the background
    playMusic BGM = new playMusic("./soundResources/tank_maintheme.wav");
    
    // Three buttons on main menu
    public PlayMenu playMenu;
    public CreditMenu credMenu;
    public HowToPlayMenu htpMenu;


    public MainMenu()
    {
	jf = new JFrame("Tanks!");
	setUpBackgroundImage( "./levSelResources/mainPic.jpg" );
	
	addMainButtonPanel();

	jf.setSize(541, 500);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setVisible(true);
	BGM.startMusic();
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
    
    // The three buttons on the main menu: play, how to play and credits
    private void addMainButtonPanel() {

	JPanel mainButtonPanel = new JPanel();

	// play button
	JButton playBtn = new JButton( "Play!" );
	mainButtonPanel.add(playBtn);
	playBtn.setFocusable( false );
	playBtn.addActionListener( new PlayGameListener() );
	
	// how to play button
	JButton htpBtn = new JButton( "How to Play!" );
	mainButtonPanel.add(htpBtn);
	htpBtn.setFocusable( false );
	htpBtn.addActionListener( new HowToPlayListener() );
	
	// credits button
	JButton credBtn = new JButton( "Credits!" );
	mainButtonPanel.add(credBtn);
	credBtn.setFocusable( false );
	credBtn.addActionListener( new CreditsListener() );

	jf.add( mainButtonPanel, BorderLayout.SOUTH );
    }
 
    // Play Button action
    class PlayGameListener implements ActionListener{
	public void actionPerformed( ActionEvent ae ){
	    if( playMenu == null )
		{
		playMenu = new PlayMenu();
		jf.dispose();
		}
	    else
		{
		playMenu.setToVisible();
		jf.dispose();
		}
	}
    }
    
    // Credits Button action
    class CreditsListener implements ActionListener{
	public void actionPerformed( ActionEvent ae ){
	    if( credMenu == null )
		credMenu = new CreditMenu();
	    else
		credMenu.setToVisible();
	}
    }
    
    // How To Play action
    class HowToPlayListener implements ActionListener{
	public void actionPerformed( ActionEvent ae ){
	    if( htpMenu == null )
		htpMenu = new HowToPlayMenu();
	    else
		htpMenu.setToVisible();
	}
    }
}

