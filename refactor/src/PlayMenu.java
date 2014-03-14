import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/** PlayMenu is a class that allows users to name their tanks, and select a tank color
    @author Benjamin Hartl
    @author Nick Abrahan
    @author Colin Biafore
    @author Bryce Bowers
    @version 1.0
*/

public class PlayMenu{
    JFrame jf;
    
    GameScreen newGame;

    public JPanel jpTop;
    public JPanel jpBottom;
    public JPanel configButtonPanel = new JPanel();
    public drawTank tank1 = new drawTank();
    public drawTank tank2 = new drawTank();
    private JTextArea p1Name = new JTextArea( "" );
    private JTextArea p2Name = new JTextArea( "" );
    private JButton confirmBtn = new JButton( "Confirm!" );
    private JButton backToMain = new JButton( "Back To Main Menu" );

    /** Constructor
	creates the menu to name a player and set tank color
    */

    public PlayMenu() {
	jf= new JFrame( "Forge your Character!" );
    	
	jpTop = new JPanel();
	jpBottom = new JPanel();

	addToConfigButtonPanel();

	jf.add( jpTop );
	jf.add( jpBottom, BorderLayout.SOUTH );

	jpTop.setLayout( new GridLayout(2, 2, 5, 5) );
	jf.setSize(700, 600);
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	setToVisible();
    }

    /**
       Creates a panel with text fields and buttons to take user to next and previous menu
    */
    
    private void addToConfigButtonPanel() {
	
	jpTop.add( p1Name );
	jpTop.add( p2Name );
	jpTop.add( tank1 );
	jpTop.add( tank2 );
	
	backToMain.addActionListener( new BackToMainListener() );
	confirmBtn.addActionListener( new StartGameListener() );
	
	configButtonPanel.add( backToMain );
	configButtonPanel.add( confirmBtn );
       	jpBottom.add( configButtonPanel, BorderLayout.SOUTH );
    }    
    
    class StartGameListener implements ActionListener{
	public void actionPerformed( ActionEvent ae ){
	    try{
	      	enviroMenu envMenu = new enviroMenu(p1Name.getText(), 
						    tank1.getTheColor(),
						    p2Name.getText(),
						    tank2.getTheColor() );
			jf.dispose();
	    }catch( IOException ioe ){
		ioe.printStackTrace();
	    }
	}
    }
    
    class BackToMainListener implements ActionListener{
	public void actionPerformed( ActionEvent e ){
	    jf.setVisible( false );
	}
    }

    /**
       makes the play menu visible on the screen
    */

    public void setToVisible()
    {
	jf.setVisible( true );
    }
    
}
