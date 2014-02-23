import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class playMenu extends JFrame {
    
    public JPanel jpTop;
    public JPanel jpBottom;
    
    public playMenu() {
	super("Forge your Character!");
    	
	jpTop = new JPanel();
	jpBottom = new JPanel();

	this.add( jpTop );
	this.add( jpBottom, BorderLayout.SOUTH );

	jpTop.setLayout( new GridLayout(2, 2, 5, 5) );
	setSize(700, 600);
	setVisible(true);
    }
}
