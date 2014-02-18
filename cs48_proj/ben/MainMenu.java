import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;

public class MainMenu extends JFrame implements ActionListener{
    String player1;                    // Where to store player 1's name
    String player2;                    // Where to store player 2's name

    //   The JFrames Initialized
    JFrame mainFrame;                  // The Original frame to start
    JFrame characterSelectFrame1;      // Where User1 input is prompted
    JFrame characterSelectFrame2;      // Where User2 input is prompted
    JFrame howToPlayFrame;             // Directions on how to play
    JFrame creditsFrame;               // Where the credits are given
    JFrame tankColorFrame;             // Where to choose Tank Color
    JFrame playFrame;                  // Open of Tank Movement

    //   The JButtons being Initialized and declared
    JButton playBtn = new JButton("Play");         // Play, Prompt User1 input
    JButton htpBtn = new JButton("How To Play");   // How To Play, Directions
    JButton credBtn = new JButton("Credits");      // Credits, How Written By
    JButton enterBtn = new JButton("Enter");       // Enter, Prompt User2 input
    JButton startBtn = new JButton("Start");       // Start, Open Tank Movement
    JButton mainBtn = new JButton("Back To Main Menu"); // Back to mainFrame
    JButton exitBtn = new JButton("Exit");         // Close the Window

    //   The JPanels with Buttons on them
    JPanel mainPanel = new JPanel();           // Main Menu Panel 
    JPanel charSelectPanel1 = new JPanel();    // User1 input Panel
    JPanel charSelectPanel2 = new JPanel();    // User2 input Panel
    JPanel howToPlayPanel = new JPanel();      // How To Play Panel
    JPanel creditsPanel = new JPanel();        // Credits Panel
	
	//	Button panel creation for main menu - NICK

    JPanel tankPanel = new DrawTank(390,50,30,Color.BLUE);  // Tank Image

    JTextField j = new JTextField("");         // Blank for user input

    MainMenu() throws IOException{            // Default Constructor, No Args
	mainFrame = new JFrame("Tanks!!");     // Title of Main Frame
	mainFrame.getContentPane().add(new JPanelWithBackground("mainPic.jpg")); // Background - NICK
	mainFrame.add(mainPanel, BorderLayout.SOUTH);
	mainFrame.setSize(541,600);            // Size of Frame( width, height )
	mainFrame.setVisible(true);            // Setting Main Frame visible
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Close Window
	setButtonsForMain();                   // Put Main Buttons on mainPanel
	setActionListeners();                  // Makes Buttons Respond to click

	//mainFrame.add(mainPanel, BorderLayout.CENTER);// Puts Panel on mainFrame

	decideNextFrame("mainMenu");     // Decides what the next Frame will be
    }

    // Puts Each Button To Have Special Action Command
    public void setActionListeners()     // Sets what each button click will be
    {
	playBtn.addActionListener(this);
	playBtn.setActionCommand("charSelect1");

	htpBtn.addActionListener(this);
	htpBtn.setActionCommand("howToPlay");

	credBtn.addActionListener(this);
	credBtn.setActionCommand("credits");

	enterBtn.addActionListener(this);
	enterBtn.setActionCommand("charSelect2");

	startBtn.addActionListener(this);
	startBtn.setActionCommand("playGame");

	mainBtn.addActionListener(this);
	mainBtn.setActionCommand("mainMenu");

	exitBtn.addActionListener(this);
	exitBtn.setActionCommand("exit");
    }

    // Calls which frame to open depending on button clicked
    public void actionPerformed(ActionEvent ae)
    {
	decideNextFrame(ae.getActionCommand()); // sends Action Command
    }
    

    public void setButtonsForMain()     // Puts main menu buttons in mainPanel
    {                       // sets layout to be ( rows, columns, separation )
	mainPanel.setLayout( new GridLayout(4,3,5,5) );
	mainPanel.add(playBtn);  
	mainPanel.add(htpBtn);
	mainPanel.add(credBtn);
	//mainPanel.add(tankPanel);         // Adds tank Image to Panel
    }

    public void setButtonsForCharacterSelect1()
    {                       // sets layout to be ( rows, columns, separation )
	charSelectPanel1.setLayout( new GridLayout(5,3,0,10) );
	charSelectPanel1.add(j);              // The JTextField, which is blank
	charSelectPanel1.add(enterBtn);        
	enterBtn.setActionCommand("charSelect2");//changes enter button command 
	charSelectPanel1.add(mainBtn);        
	charSelectPanel1.add(exitBtn);
	charSelectPanel1.add(tankPanel);  // Adds tank Image to Panel
    }
    
    public void setButtonsForCharacterSelect2()
    {                       // sets layout to be ( rows, columns, separation )
	charSelectPanel2.setLayout( new GridLayout(5,3,0,10) );
	charSelectPanel2.add(j);
	charSelectPanel2.add(enterBtn);
	enterBtn.setActionCommand("playGame");
	charSelectPanel2.add(mainBtn);
	charSelectPanel2.add(exitBtn);
	charSelectPanel2.add(tankPanel);  // Adds tank Image to Panel
    }

    public void setButtonsForHowToPlay()
    {                       // sets layout to be ( rows, columns, separation )
	howToPlayPanel.setLayout( new GridLayout(3,3,0,10) );
	howToPlayPanel.add(mainBtn);
	howToPlayPanel.add(exitBtn);
	howToPlayPanel.add(tankPanel);    // Adds tank Image to Panel
    }
    
    public void setButtonsForCredits()
    {                      // sets layout to be ( rows, columns, separation )
	creditsPanel.setLayout( new GridLayout(3,3,0,10) );
	creditsPanel.add(mainBtn);
	creditsPanel.add(exitBtn);
	creditsPanel.add(tankPanel);      // Adds tank Image to Panel
    }

    public void createPlayGameFrame()  // Opens tank movement on another Frame
    {   // Initializes keyMovement class, which has tank Movement
	keyMovement2 km = new keyMovement2(player1,player2); // (String, String)
	//playFrame = new JFrame("Play Game"); // Title of Frame
	//playFrame.add(km);
	//playFrame.setVisible(true);
	//playFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//playFrame.setSize(800,600);    // ( width, height )

    }   
    // Clears all of the frames every button click
    public void disposeAllFrames() throws NullPointerException
    {
	try{
	    howToPlayFrame.setVisible(false); // checks if Frames have been
	}catch(NullPointerException nex){} 

	try{
	    characterSelectFrame1.setVisible(false);
	}catch(NullPointerException nex){}
	
	try{
	    characterSelectFrame2.setVisible(false);
	}catch(NullPointerException nex){}

	try{
	    creditsFrame.setVisible(false);
	}catch(NullPointerException nex){}

	try{
	    tankColorFrame.setVisible(false);
	}catch(NullPointerException nex){}
    }
    
    public void decideNextFrame(String s){
	disposeAllFrames();
	
	if(s.equals("charSelect1"))
	    {
		createCharacterSelectFrame1();
	    }
	else if(s.equals("charSelect2"))
	    {
		player1 = j.getText();
		j.setText("");
		createCharacterSelectFrame2();
	    }
	else if(s.equals("playGame"))
	    {
		player2 = j.getText();
		j.setText("");
		System.out.println("\n\nPlayer 1's name is " + player1);
		System.out.println("Player 2's name is " + player2 + "\n\n");
		createPlayGameFrame();
	    }	
	else if(s.equals("howToPlay"))
	    {
		createHowToPlayFrame();
	    }
	else if(s.equals("credits"))
	    {
		createCreditsFrame();
	    }
	else if(s.equals("exit"))    
	    System.exit(0);
    }

    

    public void createCharacterSelectFrame1() throws NullPointerException{
	//one
	try{
	    characterSelectFrame1.isVisible();

	}catch(NullPointerException nex){// do if havent created Jframe yet
	    System.out.println("NullPointerException");
	    characterSelectFrame1 = new JFrame("Select Character 1's Name");
	    characterSelectFrame1.setSize(900,600);

	    return;
	}finally{
	    setButtonsForCharacterSelect1();
	    characterSelectFrame1.add(charSelectPanel1);
	    characterSelectFrame1.setVisible(true);
	    characterSelectFrame1.setFocusable(true);
	}
    }
    
    public void createCharacterSelectFrame2() throws NullPointerException{
	//one
	try{
	    characterSelectFrame2.isVisible();

	}catch(NullPointerException nex){// do if havent created Jframe yet
	    System.out.println("NullPointerException");
	    characterSelectFrame2 = new JFrame("Select Character 2's Name");
	    characterSelectFrame2.setSize(900,600);

	    return;
	}finally{
	    setButtonsForCharacterSelect2();
	    characterSelectFrame2.add(charSelectPanel2);
	    characterSelectFrame2.setVisible(true);
	    characterSelectFrame2.setFocusable(true);
	}
    }

    public void createHowToPlayFrame() throws NullPointerException{
       	try{
	    howToPlayFrame.isVisible();

	}catch(NullPointerException nex){// do if havent created Jframe yet
	    System.out.println("NullPointerException");
	    howToPlayFrame = new JFrame("How To Play");
	    howToPlayFrame.setSize(900,600);
	    return;
	}finally{
	    setButtonsForHowToPlay();
	    howToPlayFrame.add(howToPlayPanel);
	    howToPlayFrame.setVisible(true);
	    howToPlayFrame.setFocusable(true);
	}
    }
    
    public void createCreditsFrame() throws NullPointerException{
       	
	try{
	    creditsFrame.isVisible();

	}catch(NullPointerException nex){// do if havent created Jframe yet
	    System.out.println("NullPointerException");
	    creditsFrame = new JFrame("Credits");
	    creditsFrame.setSize(900,600);
	    return;
	}finally{
	    setButtonsForCredits();
	    creditsFrame.add(creditsPanel);
	    creditsFrame.setVisible(true);
	    creditsFrame.setFocusable(true);
	}
	
    }
    public void createTankColorFrame(String num) throws NullPointerException{
	//one and two
    }

    public void createDisplayWinnerFrame() throws NullPointerException{

    }

    
}
