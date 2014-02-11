import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.awt.event.*;


public class newMMF implements ActionListener {

    JButton playButton, htpButton, credButton;
    JPanel cardPanel;
    String cardNames[] = new String[3];
    String cardDescriptions[] = new String[3];
    int cardCounter = 0;

    public JPanel createContentPane(){
	
	JPanel totalGUI = new JPanel();
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
	
	buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));


	//PLAY BUTTON AND PANEL CREATION
	playButton = new JButton("Play!");
	playButton.addActionListener(this);
	buttonPanel.add(playButton);
	buttonPanel.add(Box.createHorizontalGlue());

	JPanel playPanel = new JPanel();
	JLabel playLabel = new JLabel("Test Page 1");
	playPanel.add(playLabel);


	//HTP BUTTON AND PANEL CREATION
	htpButton = new JButton("How to Play!");
	htpButton.addActionListener(this);
	buttonPanel.add(htpButton);
	buttonPanel.add(Box.createHorizontalGlue());
	
	JPanel htpPanel = new JPanel();
	JLabel htpLabel = new JLabel("Test Page 2");
	htpPanel.add(htpLabel);


	//CRED BUTTON AND PANEL CREATION
	credButton = new JButton("Credits!");
	credButton.addActionListener(this);
	buttonPanel.add(credButton);
	buttonPanel.add(Box.createHorizontalGlue());

	JPanel credPanel = new JPanel();
	JLabel credLabel = new JLabel("WE MADE IT");
	credPanel.add(credLabel);


	//CardPanel set
	cardPanel = new JPanel(new CardLayout(150, 50));


	cardPanel.add("play", playPanel);
	cardPanel.add("cred", credPanel);
	cardPanel.add("htp", htpPanel);



	//ACTUAL PANE SET

	JPanel bottomPanel = new JPanel();
	bottomPanel.setLayout(new BorderLayout());

	bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
	bottomPanel.add(cardPanel, BorderLayout.CENTER);

	totalGUI.add(bottomPanel);
	totalGUI.setOpaque(true);
	return totalGUI;
    }


    public void actionPerformed(ActionEvent e) {


	CardLayout cl = (CardLayout)(cardPanel.getLayout());

	if(e.getSource() == playButton)
	    {
		cl.show(cardPanel, "play");
	    }
	else if(e.getSource() == htpButton)
	    {
		cl.show(cardPanel, "htp");
	    }
	else if(e.getSource() == credButton)
	    {
		cl.show(cardPanel, "cred");
	    }

    }

    private static void createAndShowGUI(){
	
	JFrame.setDefaultLookAndFeelDecorated(true);
	JFrame frame = new JFrame("Tanks!");
	
	newMMF demo = new newMMF();
	frame.setContentPane(demo.createContentPane());
       
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[] args) {

	SwingUtilities.invokeLater(new Runnable() {
		public void run(){
		    createAndShowGUI();
		}
	    });
    }
}
