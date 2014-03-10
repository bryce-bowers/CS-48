import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HowToPlayMenu{
    JFrame jf;
    public JPanel jpTop;
    public JPanel jpBottom;
    public JPanel jpNames;

    /* Instruction on How to Play */

    public JLabel jlCreators = new JLabel("**   How to Play   **", JLabel.CENTER);

    public JLabel jlFlow2 = new JLabel("MOVE THE TANK. Player 1: a and d keys, Player 2: left and right arrow keys", JLabel.CENTER);
    public JLabel jlFlow3 = new JLabel("ADJUST ANGLE OF CANON. Player 1: w and d keys, Player 2: up and down arrow keys", JLabel.CENTER);
    public JLabel jlFlow4 = new JLabel("FIRE THE PROJECTILE. Player 1: space bar, Player 2: Enter", JLabel.CENTER);
    public JLabel jlFlow5 = new JLabel("If projectile hits the other Player's tank, then the appropriate damage is subtracted. Turn ends", JLabel.CENTER);
    public JLabel jlFlow6 = new JLabel("and other Player's turn begins. If tanks's health reaches zero, then Player loses and game ends.", JLabel.CENTER);
    public JLabel jlLastly = new JLabel("If a Player's tanks's health reaches zero, then the Player loses and the game ends.", JLabel.CENTER);
    
    public HowToPlayMenu() {

	JPanel jp = new JPanel();
	jf = new JFrame( "How To Play" );
	JButton backToMain = new JButton( "Back To Main Menu" );
		
	jpTop = new JPanel();
	jpBottom = new JPanel();
	jpNames = new JPanel();
	jpTop.setLayout( new GridLayout( 3, 2 ) );
	jpTop.add( new JLabel() );
	jpNames.setLayout( new GridLayout( 10,2 ) ); // controls space alloted for text

	/* displays Instruction on Panel line by line */

	jpNames.add( jlCreators);
	jpNames.add( new JPanel() );
	jpNames.add( jlFlow2 );
	jpNames.add( jlFlow3 );
	jpNames.add( jlFlow4 );
	jpNames.add( jlFlow5 );
	jpNames.add( jlFlow6 );
	jpNames.add( jlLastly );

	jpTop.add(jpNames);

	jf.add( jpTop );

	jp.add( backToMain );
	backToMain.addActionListener( new BackToMainListener() );
	
	jf.add( jp, BorderLayout.SOUTH );
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); // kills program if X button is pressed

	jf.setSize(700, 600);
	setToVisible(); // displays Frame on screen
    }

    public void setToVisible()
    {
	jf.setVisible( true );
    }
    
    class BackToMainListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    jf.setVisible(false);
	}
    }
}
