import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.lang.NullPointerException;

public class MainMenu extends JFrame implements ActionListener{
    String player1;
    String player2;

    JFrame mainFrame;
    JFrame characterSelectFrame1;
    JFrame characterSelectFrame2;
    JFrame howToPlayFrame;
    JFrame creditsFrame;
    JFrame tankColorFrame;
    JFrame playFrame;

    JButton playBtn = new JButton("Play");
    JButton htpBtn = new JButton("How To Play");
    JButton credBtn = new JButton("Credits");
    JButton enterBtn = new JButton("Enter");
    JButton startBtn = new JButton("Start");
    JButton mainBtn = new JButton("Back To Main Menu");
    JButton exitBtn = new JButton("Exit");

    JPanel mainPanel = new JPanel();
    JPanel charSelectPanel1 = new JPanel();
    JPanel charSelectPanel2 = new JPanel();
    JPanel howToPlayPanel = new JPanel();
    JPanel creditsPanel = new JPanel();

    JPanel tankPanel = new DrawTank(390,50,30,Color.BLUE);

    JTextField j = new JTextField("");

    int next = 0;

    MainMenu(){
	mainFrame = new JFrame("Tanks!!");
	mainFrame.setSize(900,600);
	mainFrame.setVisible(true);
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setButtonsForMain();
	setActionListeners();

	mainFrame.add(mainPanel, BorderLayout.CENTER);

	decideNextFrame("mainMenu");
    }
    
    public void setActionListeners()
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

    public void actionPerformed(ActionEvent ae)
    {
	decideNextFrame(ae.getActionCommand());
    }
    

    public void setButtonsForMain()
    {
	mainPanel.setLayout( new GridLayout(4,3,10,10) );
	mainPanel.add(playBtn);
	mainPanel.add(htpBtn);
	mainPanel.add(credBtn);
	mainPanel.add(tankPanel);
    }

    public void setButtonsForCharacterSelect1()
    {
	charSelectPanel1.setLayout( new GridLayout(5,3,0,10) );
	charSelectPanel1.add(j);
	charSelectPanel1.add(enterBtn);
	enterBtn.setActionCommand("charSelect2");
	charSelectPanel1.add(mainBtn);
	charSelectPanel1.add(exitBtn);
	charSelectPanel1.add(tankPanel);
    }
    
    public void setButtonsForCharacterSelect2()
    {
	charSelectPanel2.setLayout( new GridLayout(5,3,0,10) );
	charSelectPanel2.add(j);
	charSelectPanel2.add(enterBtn);
	enterBtn.setActionCommand("playGame");
	charSelectPanel2.add(mainBtn);
	charSelectPanel2.add(exitBtn);
	charSelectPanel2.add(tankPanel);
    }

    public void setButtonsForHowToPlay()
    {
	howToPlayPanel.setLayout( new GridLayout(3,3,0,10) );
	howToPlayPanel.add(mainBtn);
	howToPlayPanel.add(exitBtn);
	howToPlayPanel.add(tankPanel);
    }
    
    public void setButtonsForCredits()
    {
	creditsPanel.setLayout( new GridLayout(3,3,0,10) );
	creditsPanel.add(mainBtn);
	creditsPanel.add(exitBtn);
	creditsPanel.add(tankPanel);
    }

    public void createPlayGameFrame()
    {
	keyMovement km = new keyMovement(player1,player2);
	playFrame = new JFrame("Play Game");
	playFrame.add(km);
	playFrame.setVisible(true);
	playFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	playFrame.setSize(800,600);

    }
    public void disposeAllFrames() throws NullPointerException
    {
	try{
	    howToPlayFrame.setVisible(false);
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
