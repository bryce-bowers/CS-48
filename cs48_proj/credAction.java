import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class credAction implements ActionListener {
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
