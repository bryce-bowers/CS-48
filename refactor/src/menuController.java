import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;




public class menuController implements ActionListener {
    
    //main menu Panel
    private JButton playBtn = new JButton("Play!");
    private JButton htpBtn = new JButton("How to Play!");
    private JButton credBtn = new JButton("Credits!");
    private JPanel mainButtonPanel = new JPanel();


    //play menu Panel
    private JButton returnBtn = new JButton("Back to Main Menu!");
    private JButton confirmBtn = new JButton("Confirm!");
    private JTextArea p1Name = new JTextArea("");
    private JTextArea p2Name = new JTextArea("");
    private JPanel configButtonPanel = new JPanel();
    private JPanel panelWest = new JPanel();
    private JPanel panelEast = new JPanel();
    public drawTank tank1 = new drawTank();
    public drawTank tank2 = new drawTank();


    //Main Menu Button Panel Creator
    private void addToMainButtonPanel() {
	
	mainButtonPanel.add(playBtn);
	playBtn.addActionListener(this);
	mainButtonPanel.add(htpBtn);
	htpBtn.addActionListener(this);
	mainButtonPanel.add(credBtn);
	credBtn.addActionListener(this);
    }

    //Config Button Panel Creator
    private void addToConfigButtonPanel() {
	
	
	configButtonPanel.add(confirmBtn);
	confirmBtn.addActionListener(this);
	configButtonPanel.add(returnBtn);
	returnBtn.addActionListener(this);
    }

    //Button Slavers
    public void actionPerformed(ActionEvent e){
	if(e.getSource() == playBtn) {
	    bringUpPlay();
	}
	if(e.getSource() == returnBtn) {
	    try{
	    bringUpBasic();
	    }catch(IOException xe){};
	}
	if(e.getSource() == confirmBtn) {
	    try{
		bringUpGame();
	    }catch(IOException xg){};
	}
	//if(e.getSource() == confirmBtn) {
	//try{
	//  bringUpEnviro();
	// }catch(IOException xd){};
	//}

    }






    
    public void bringUpBasic() throws IOException {
	mainMenu startMenu = new mainMenu();
	addToMainButtonPanel();
	startMenu.add(mainButtonPanel, BorderLayout.SOUTH);
    }



    public void bringUpPlay() {
	playMenu gameConfig = new playMenu();
	addToConfigButtonPanel();
	gameConfig.add(p1Name);
	gameConfig.add(p2Name);
	gameConfig.add(tank1);
	gameConfig.add(tank2);
	gameConfig.add(configButtonPanel, BorderLayout.SOUTH);
    }

    public void bringUpEnviro() throws IOException {
	SwingUtilities.invokeLater(new Runnable() {
		public void run(){
		    try{
			enviroMenu envSelect = new enviroMenu();
		    } catch (IOException e){
			e.printStackTrace();
		    }
		}
	    });
    }

    public void bringUpGame() throws IOException {
	gameScreen newGame = new gameScreen(p1Name.getText(), tank1.getTheColor(),
					    p2Name.getText(), tank2.getTheColor());
    }


}

