import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NextFrame extends JFrame implements ActionListener
{
    private String playerName = "";
    private String name;
    private Color color;
    private int num = 1;

    NextFrame() {
	this.setLayout(null);
	this.setSize(900,600);
	this.getContentPane().setBackground(color);
	this.setVisible(true);
	this.createJButton("Back To Main Menu", 500, 500);
	this.createJButton("Back",200,500);
			

		
    }

    public Color getColor(){ return color; }
    public void setColor(Color c){
	color = c;
	this.getContentPane().setBackground(color);
    }

    public String getName(){ return name; }
    public void setName(String n){
	name = n; 
	this.setTitle(name);
    }

    public String getPlayerName(){ return playerName; }
    public void setPlayerName(String n){
	playerName = n; 
    }

    public void createJLabel(String input, int x, int y)
    {
	JLabel jl = new JLabel(input);
	Dimension f = jl.getPreferredSize();
	jl.setBounds(x, y, f.width, f.height);
	this.add(jl);
    }

    public void createJTextLabel(String input, String input2,
				 int x, int y)
    {
	JTextField jtf = new JTextField();
	this.createJButton(input2, x, y + 50);
	jtf.setBounds(x ,y , 50, 20);
	jtf.setSize(100, 40);
	this.add(jtf);
	jtf.addKeyListener(new KeyAdapter(){
		public void keyTyped(KeyEvent ke)
		{
		    putInName(ke);
		}
	    });
	
    }
    public void createPlayerNameInput(int n)
    {
	createJLabel("Player " + n, 200, 150);
	createJTextLabel("Enter Your Name Here", "Press Enter", 200,200);
    }
    
    public void createJButton(String input, int x, int y)
    {
	JButton jb = new JButton(input);
	Dimension f = jb.getPreferredSize();
	jb.setBounds(x, y, f.width, f.height);
	this.add(jb);
	jb.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
	System.out.println(e.getActionCommand());
	if(e.getActionCommand() == "Back"){
	    dispose();
	}

	else if(e.getActionCommand() == "Press Enter")
	    {
		
		NextFrame nf2 = new NextFrame();
		nf2.num = num + 1;
		nf2.createPlayerNameInput(num+1);
	    }    
	
	else if(e.getActionCommand() == "Back To Main Menu"){
	    dispose();
	}
    }
    
    public void putInName(KeyEvent ke)
    {
	if(ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)
	    {
		if(playerName.length() == 0)
		    return;
		else
		    playerName = playerName.substring(0,playerName.length() - 1);
	    }
	else if(ke.getKeyChar() == KeyEvent.VK_ENTER)
	    return;
	else
	    playerName = playerName + ke.getKeyChar();
    }

}
