import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

private class htpAction implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		JFrame htpFrame = new JFrame("How to Play");
		htpFrame.setSize(300, 150);
		JLabel label = new JLabel("This is how you play");
		JPanel panel = new JPanel();
		panel.add(label);
		htpFrame.add(panel);
		
		htpFrame.setVisible(true);
	}
}
