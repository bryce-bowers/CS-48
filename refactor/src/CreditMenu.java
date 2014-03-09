import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CreditMenu{
    JFrame jf;
    public JPanel jpTop;
    public JPanel jpBottom;
    public JPanel jpNames;
    public JLabel jlCreators = new JLabel("**   The Creators Of The Game   **",
					  JLabel.CENTER);
    public JLabel jlBen = new JLabel("---  Benjamin Hartl  ---", 
				     JLabel.CENTER);
    public JLabel jlNick = new JLabel("---  Nick Abrahan  ---", 
				      JLabel.CENTER);
    public JLabel jlColin = new JLabel("---  Colin Biafore  ---", 
				       JLabel.CENTER);
    public JLabel jlBryce = new JLabel("---  Bryce Bowers  ---", 
				       JLabel.CENTER);
   
    public CreditMenu() {
	jf = new JFrame("The Credits");
    	
	jpTop = new JPanel();
	jpBottom = new JPanel();

	jpNames = new JPanel();
	jpTop.setLayout( new GridLayout( 3, 1 ) );
	jpTop.add( new JLabel() );
	jpNames.setLayout( new GridLayout( 6,1 ) );
	jpNames.add( jlCreators);
	jpNames.add( new JPanel() );
	jpNames.add( jlNick );
	jpNames.add( jlBen );
	jpNames.add( jlColin);
	jpNames.add( jlBryce);
	
	jpTop.add(jpNames);
	JButton backToMain = new JButton( "Back To Main Menu" );
	jpBottom.add( backToMain );
	backToMain.addActionListener( new BackToMainListener() );
	jf.add( jpTop );
	jf.add( jpBottom, BorderLayout.SOUTH );

	jf.setSize(700, 600);
	
	setToVisible();
    }

    public void setToVisible()
    {
	jf.setVisible( true );
    }
    
    class BackToMainListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    jf.setVisible( false );
	}
    }
}
