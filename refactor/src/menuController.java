import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;




public class menuController implements ActionListener {
    playMenu gameConfig;
    gameScreen newGame;
    creditMenu credMenu;

    //main menu Panel
    private JButton playBtn = new JButton("Play!");
    private JButton htpBtn = new JButton("How to Play!");
    private JButton credBtn = new JButton("Credits!");
    private JPanel mainButtonPanel = new JPanel();
    private JPanel creditsPanel = new JPanel();
    private JPanel howToPlayPanel = new JPanel();


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
	playBtn.setFocusable( false );
	playBtn.addActionListener(this);
	
	mainButtonPanel.add(htpBtn);
	htpBtn.setFocusable( false );
	htpBtn.addActionListener(this);
	
	mainButtonPanel.add(credBtn);
	credBtn.setFocusable( false );
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
	else if(e.getSource() == returnBtn) {
	    gameConfig.dispose();
	}
	else if(e.getSource() == confirmBtn) {
	    if( newGame == null )
		{
		    try{
			bringUpGame();
		    }catch(IOException xg){};
		}
	    gameConfig.dispose();
	}
	else if ( e.getActionCommand().equals( "Credits!" ) )
	    {
		bringUpCredits();
	    }
	else if ( e.getActionCommand().equals( "How to Play!" ) )
	    {
		System.out.println( "Stub, Open How To Play window" );
	    }
    }

    public void bringUpCredits()
    {
	credMenu = new creditMenu();
    }
    
    public void bringUpBasic() throws IOException {
	mainMenu startMenu = new mainMenu();
	addToMainButtonPanel();
	startMenu.add(mainButtonPanel, BorderLayout.SOUTH);
    }



    public void bringUpPlay() {
	gameConfig = new playMenu();
	addToConfigButtonPanel();
	gameConfig.jpTop.add(p1Name);
	gameConfig.jpTop.add(p2Name);
	gameConfig.jpTop.add(tank1);
	gameConfig.jpTop.add(tank2);
	gameConfig.jpBottom.add(configButtonPanel, BorderLayout.SOUTH);


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
	newGame = new gameScreen(p1Name.getText(), tank1.getTheColor(),
					    p2Name.getText(), tank2.getTheColor());
    }


}

