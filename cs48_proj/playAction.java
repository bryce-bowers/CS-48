import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class playAction implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		JFrame playFrame = new JFrame("Game");
		playFrame.setSize(300, 150);
		JLabel label = new JLabel("This is where you select your char");
		JPanel panel = new JPanel();
		playFrame.add(panel);
		panel.add(label);
		
		playFrame.setVisible(true);
	}
}
