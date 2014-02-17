import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class keyMovement2 implements ActionListener, KeyListener {
    private static double x = 40 , y = 391;       // start x Cord and y Cord
    private final double xGround = 0; double yGround = 600;
    private static int degrees = 0;
    private static double radians = 0;
    private int tShift = 200;                 // amount shifted of frame
    private int maxX = 700, maxY = 600;             // max frame size x and y
    private double velx = 0, vely = 0;              // start velx,  vely
    private Color myColor = Color.BLACK;            // myColor
    private int size = 10;                          // size of image

    private String player1;
    private String player2;

    private MyDrawPanel drawPanel;

    public double getXCord() { return x; }             // Returns x
    public double getYCord() { return y; }             // Returns y
    
    public String toString(){                  // For Printing (x,y) location
	return "(" + x + ", " + y + ")";       //     in a string
    }

    //public static void main(String[] args)
    //{
    //	keyMovement2 km = new keyMovement2("a","b");
    //}

    public keyMovement2(String p1, String p2) {
	player1 = p1;
	player2 = p2;

	JFrame jf = new JFrame("Test Tank Game");
	drawPanel = new MyDrawPanel();
	jf.getContentPane().add(drawPanel);
	jf.setSize(maxX,maxY);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setVisible(true);


	jf.addKeyListener(this);
	jf.setFocusTraversalKeysEnabled(false);
    }
    
    public void actionPerformed(ActionEvent ae){}

    public void keyPressed(KeyEvent e) {
	int code = e.getKeyCode();
	if(code == KeyEvent.VK_SPACE){           // Space bar
	    System.out.println(toString()); 
	}              
	else if(code == KeyEvent.VK_UP){         // UP arrow
	    goUp();
	}
	else if(code == KeyEvent.VK_DOWN){       // DOWN arrow
	    goDown();
	}
	else if(code == KeyEvent.VK_LEFT){       // LEFT arrow
	    goLeft();
	}
	else if(code == KeyEvent.VK_RIGHT){      // RIGHT arrow
	    goRight();
	}
	else if(code == KeyEvent.VK_SHIFT){      // SHIFT key
	    System.out.println("Stub, SHIFT");   
	}
	else if(code == KeyEvent.VK_ENTER){      // Enter key
	    System.out.println("Stub, ENTER");  
	}
    }
    
    public void goUp(){
	setDegrees(2);
	drawPanel.repaint();
    }
    
    public void goDown(){
	setDegrees(-2);
	drawPanel.repaint();
    }
    
    public void goLeft(){
	setXCord(-2);
	drawPanel.repaint();
    }
    
    public void goRight(){
	setXCord(2);
	drawPanel.repaint();
    }
    
    public void setDegrees(int change)
    {
	int diff = degrees + change;
	if((diff <= 180) && (diff >= 0))
	    {
		degrees = diff;
		radians = Math.toRadians(degrees);
	    }
	return;
    }

    public void setXCord(double change)
    {
	double diff = x + change;
	if((diff >= (2 * size))  &&  (diff <= maxX -(3 * size)))
	    {
		x = diff;
		setYCord();
	    }
	return;
    }    
    public void setYCord()
    {
	System.out.println(toString());
	System.out.println("new y = 10 * Math.sin(.1 * x)   ==> " + 
			   10 * Math.sin(.05 * x));
	y =  400 - 10 * Math.sin(.05 * x);

    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    class MyDrawPanel extends JPanel {

	public int angle;
	public int start = 0;
	
	public void paintComponent(Graphics g) {
	    //paintComponent draws things
	    super.paintComponent(g);       // runs super class, then this class
	    Graphics2D d = (Graphics2D) g;

	    // middle of tank
	    d.fillRect((int)x - (2 * size), (int)y + size + (size / 2),
		       (4 * size),(size / 2));
	    d.fillRoundRect((int)x - (2 * size), (int)y + size, 
			    4 * size, size, 40, 40 );
	    
	    // the wheels of the tank
	    d.fillOval((int)x -(2 * size), (int)(y + (1.5 * size)), size, size);
	    d.fillOval((int)x - size, (int)(y + (1.5 * size)), size, size);
	    d.fillOval((int)x , (int)(y + (1.5 * size)), size, size);
	    d.fillOval((int)x + size, (int)(y + (1.5 * size)), size, size);
	    
	    //the line at the bottom
	    d.drawLine((int)(x - (1.5 * size)), (int)(y + (2.5 * size)),
		       (int)(x + (1.5 * size)), (int)(y + (2.5 * size)));
	    
	    // the top part of the tank
	    d.fillOval((int)x - size,(int)y, 2 * size, 2 *size);
	 
	    // Cannon of tank which rotates*****************
	    d.rotate(-radians,x ,y + (size / 5));
	    d.fillRect((int)x, (int)y + (size / 24), (3 * size), (size / 3));
	    // *********************************************
   
	}
    }
}   


