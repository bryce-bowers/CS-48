import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;
import java.util.Scanner;
import java.lang.Integer;
import java.util.ArrayList;

class ColorWithString{
    private Color thisColor;
    private String thisString;
    ColorWithString(){}
    ColorWithString(String randomColors){setColor(getRandomColor()); setString(randomColors);}

    public Color getColor(){ return thisColor; }
    public void setColor(Color c){ thisColor = c; }

    public String getString(){ return thisString; }
    public void setString(String s){ thisString = s; }

    public Color getRandomColor(){
	int r,g,b;
	r = (int) (Math.random() * 255);
	g = (int) (Math.random() * 255);
	b = (int) (Math.random() * 255);
	return (new Color(r,g,b));


    }
    
    @Override
    public String toString(){
	return( this.getString() );
    }
}

class Tank{
    private Color tankColor = Color.BLACK;
    
    public Color getTankColor(){
        return tankColor;
    }
    public void setTankColor(Color c){
	tankColor = c;
    }

    
    public Color askForTankColor(){
	ArrayList <ColorWithString> colorList = new ArrayList<ColorWithString>(); {}
	ColorWithString cBlack = new ColorWithString();
	cBlack.setColor(Color.BLACK);
	cBlack.setString("Black");
	colorList.add(cBlack);
	
	ColorWithString cRed = new ColorWithString();
	cRed.setColor(Color.RED);
	cRed.setString("RED");
	colorList.add(cRed);

	ColorWithString cGreen = new ColorWithString();	
	cGreen.setColor(Color.GREEN);
	cGreen.setString("GREEN");
	colorList.add(cGreen);

	ColorWithString cBlue = new ColorWithString();	
	cBlue.setColor(Color.BLUE);
	cBlue.setString("BLUE");
	colorList.add(cBlue);

	ColorWithString cPink = new ColorWithString();	
	cPink.setColor(Color.PINK);
	cPink.setString("PINK");
	colorList.add(cPink);
	
	ColorWithString cRandom = new ColorWithString("Random");	
	cRandom.setString("RANDOM");
	colorList.add(cRandom);

	int i;
	System.out.println("Choose The Color Of Your Tank!");
	for( i = 0; i < colorList.size() ; i++)
	    {
		System.out.println(i + ".  " + colorList.get(i).toString());
	    }

	Scanner readInput = new Scanner(System.in);
	int input = readInput.nextInt();
	
	setTankColor(colorList.get(input).getColor());

	return getTankColor(); 
    }
}

public class mainMenuWindow2 {
    

        public static void music()
	{
		try{
			File soundFile = new File("sample.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	    } catch (IOException e) {
	         e.printStackTrace();
	    } catch (LineUnavailableException e) {
	         e.printStackTrace();
	    }

	}
	
	
	
	public static void main(String[] args) {
		
	        //New Window Creation
	        JFrame frame = new JFrame("Tanks!!");
		JLabel titleLabel = new JLabel("Welcome to Tanks!!!");
		
		//"Play" Button
		JButton playButton = new JButton("Play!");
		playButton.addActionListener (new playAction());

		//"How to Play" Button
		JButton htpButton = new JButton("How to Play!");
		htpButton.addActionListener (new htpAction());
	
		//"Credits" Button
		JButton credButton = new JButton("Credits!");
		credButton.addActionListener(new credAction());		
		
		//buttonPanel creation
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(playButton);
		buttonPanel.add(htpButton);
		buttonPanel.add(credButton);
		
		
		//Layout
		frame.add(titleLabel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		
		//Frame creation
		frame.setVisible(true);
		frame.setSize(600, 300);
		music();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class playAction implements ActionListener {
	public void actionPerformed (ActionEvent e) {
		JFrame playFrame = new JFrame("Game");
		playFrame.setSize(500, 250);
		JLabel label = new JLabel("This is where you select your char");
		JPanel panel = new JPanel();
		playFrame.add(panel);
		panel.add(label);
	
		playFrame.setVisible(true);

		Tank firstTank = new Tank();
		Color color;
		color = Color.BLACK;
		//color = firstTank.askForTankColor();

		JPanel tankColorPanel = new JPanel();
		TPanel tankImage = new TPanel(color);
		tankColorPanel.add(tankImage);
		panel.add(tankColorPanel);
		tankImage.setVisible(true);

		JRadioButton blackButton = new JRadioButton("Black",true );
		//blackButton.isSelected()

		JRadioButton redButton = new JRadioButton("Red");

		JRadioButton greenButton = new JRadioButton("Green");

		JRadioButton blueButton = new JRadioButton("Blue");

		JRadioButton pinkButton = new JRadioButton("Pink");

		JRadioButton randomButton = new JRadioButton("Random");
		
		JPanel colorPanel = new JPanel();
		//setLayout(new GridLayout(6,1));
	    	colorPanel.add(blackButton);
		colorPanel.add(redButton);
		colorPanel.add(greenButton);
		colorPanel.add(blueButton);
		colorPanel.add(pinkButton);
		colorPanel.add(randomButton);

		MyColorButtonGroup colorGroup = new MyColorButtonGroup();
		//ButtonGroup colorGroup = new ButtonGroup();
	    	colorGroup.add(blackButton);
		colorGroup.add(redButton);
		colorGroup.add(greenButton);
		colorGroup.add(blueButton);
		colorGroup.add(pinkButton);
		colorGroup.add(randomButton);
		
  		playFrame.add(colorPanel, BorderLayout.SOUTH);	
		
		//MyColorButtonGroup c = new MyColorButtonGroup();
	
	}
}

class MyColorButtonGroup extends ButtonGroup{
    public ActionListener A = new A();
}

class A implements ActionListener{
    public void actionPerformed(ActionEvent ae){
	System.out.println("**************************");
    }
}


class htpAction implements ActionListener {
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

class credAction implements ActionListener {
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

class TPanel extends JPanel {
    private Color myColor;
    
    public TPanel(Color newColor){
	System.out.println("The Color of the tank will be: " + newColor);
	setPreferredSize(new Dimension(500,250));
	myColor = newColor;
    }

    @Override    
    public void paintComponent(Graphics t) {

	int xCord = 200;
	int yCord = 70;
	int radius = 30;
	//Color color = Color.BLACK;
	/*switch (myColor){
	case 0: color = Color.RED;
	    break;
	case 1: color = Color.GREEN;
	    break;
	case 2: color = Color.BLUE;
	    break;
	default: color = Color.BLACK;
	break;
	}*/
	
	    

	super.paintComponent(t);
	//drawRect(x,y,width,height)
	//drawOval(x,y,width,height)
	//t.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
	t.setColor(myColor);
	// middle of tank
	t.fillRect(xCord,yCord - (radius / 6) + 5,(4 * radius),radius /2);
	t.fillRoundRect(xCord, yCord - (radius/2), 4 * radius, radius, 40, 40 );
	
	// the wheels of the tank
	t.fillOval(xCord,yCord,radius,radius);
	t.fillOval(xCord + radius,yCord,radius,radius);
	t.fillOval(xCord + (2 * radius),yCord,radius,radius);
	t.fillOval(xCord + (3 * radius),yCord,radius,radius);
	
	//the line at the bottom
	t.drawRect(xCord + (radius/2), yCord + (radius/2), 3 * radius, radius/2);
	// the top part of the tank
	t.fillOval(xCord + (radius), yCord - (3* radius)/2, 2 * radius,  2 *radius);
	t.fillRoundRect(xCord - radius, yCord - (3 * radius)/2, (3 * radius) + (radius / 4) , radius / 3,20,20);

    }}

