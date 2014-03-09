import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HowToPlayMenu{
    JFrame jf;
    
    public HowToPlayMenu() {
	jf = new JFrame( "How To Play" );
	JPanel jp = new JPanel();
	JButton backToMain = new JButton( "Back To Main Menu" );
	JLabel jl = new JLabel( "Put Instructions Here" );
	jf.add( jl, BorderLayout.CENTER );
	jp.add( backToMain );
	backToMain.addActionListener( new BackToMainListener() );
	jf.add( jp, BorderLayout.SOUTH );
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	jf.setSize(700, 600);
	
	setToVisible();
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
