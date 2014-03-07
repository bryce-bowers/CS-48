import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class gameScreen implements ActionListener, KeyListener{

    private final double xGround = 0; double yGround = 600;
    private int tShift = 200;                 // amount shifted of frame
    static int maxX = 700, maxY = 600;             // max frame size x and y
    private double velx = 0, vely = 0;              // start velx,  vely
    private Color myColor = Color.BLACK;            // myColor
    static int size = 10;             // size of image
    static boolean right = false;
     
    Player p1;
    Player p2;

    static MyDrawPanel drawPanel;

    public gameScreen(String player1, Color p1c, String player2, Color p2c) throws IOException {
	p1 = new Player(player1, 55, 400, p1c);
	p2 = new Player(player2, 400, 400, p2c);

	JFrame jf = new JFrame("Test Tank Game");
	drawPanel = new MyDrawPanel();
	jf.getContentPane().add(drawPanel);
	jf.setSize(maxX,maxY);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.addKeyListener(this);
	jf.setFocusTraversalKeysEnabled(false);
       	jf.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){}

    public void keyPressed(KeyEvent e)
    {
	int code = e.getKeyCode();
	if(code == KeyEvent.VK_SPACE){	// Space bar
	    right = true;
	}              
	else if(code == KeyEvent.VK_ENTER){      // Enter key
	    right = false;
	}
	
	if(right == true)
	    {
		
		if(code == KeyEvent.VK_UP){         // UP arrow
		    p2.goUp();
		}
		else if(code == KeyEvent.VK_DOWN){       // DOWN arrow
		    p2.goDown();
		}
		else if(code == KeyEvent.VK_LEFT){       // LEFT arrow
		    p2.goLeft();
		}
		else if(code == KeyEvent.VK_RIGHT){      // RIGHT arrow
		    p2.goRight();
		}
		else if(code == KeyEvent.VK_SHIFT){      // SHIFT key
		    System.out.println("Stub, SHIFT");
		    System.out.println("Player 2 x,y = " + p2.getX() + ", " + p2.getY() );
		    System.out.println("Player 2 new x,y = " + p2.getXChange() + ", "
				       + p2.getYChange() );
				    
		}
	    }
	else 
	    {
		if(code == KeyEvent.VK_W){         // UP arrow
		    p1.goUp();
		}
		else if(code == KeyEvent.VK_S){       // DOWN arrow
		    p1.goDown();
		}
		else if(code == KeyEvent.VK_A){       // LEFT arrow
		    p1.goLeft();
		}
		else if(code == KeyEvent.VK_D){      // RIGHT arrow
		    p1.goRight();
		}
		else if(code == KeyEvent.VK_SHIFT){      // SHIFT key
		    System.out.println("Stub, SHIFT");  
		    System.out.println("Player 1 x,y = " + p1.getX() + ", " + p1.getY() );
		    System.out.println("Player 1 new x,y = " + p1.getXChange() + ", "
				       + p1.getYChange() );
		}
	    }
	
    }

  public void keyTyped(KeyEvent e) {}
  public void keyReleased(KeyEvent e) {}

class MyDrawPanel extends JPanel {
    
    //Image img = Toolkit.getDefaultToolkit().createImage("background.jpg");
    public void paintComponent(Graphics g) 
    {
	//paintComponent clears the screen
	super.paintComponent(g);       // runs super class, then this class
	
	///////////////////////////////////////////////////
	//g.drawImage(img, 0, 0, null);
	///////////////////////////////////////////////////

	p1.draw( g );
	p2.draw( g );
    }
}

   


}
