import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class keyMovement2 implements ActionListener, KeyListener {
    //private static double x = 40 , y = 391;       // start x Cord and y Cord
	//private static double x2 = 120 , y2 = 391;
    private final double xGround = 0; double yGround = 600;
    //private static int degrees = 0, degrees2 = 0;
    //private static double radians = 0, radians2 = 0;
    private int tShift = 200;                 // amount shifted of frame
    static int maxX = 700, maxY = 600;             // max frame size x and y
    private double velx = 0, vely = 0;              // start velx,  vely
    private Color myColor = Color.BLACK;            // myColor
    static int size = 10;             // size of image
	static int turn = 2;

	Player p1;
	Player p2;

    static MyDrawPanel drawPanel;

    //public double getXCord() { return x; }             // Returns x
    //public double getYCord() { return y; }             // Returns y
    
    public String toString(Player p){                  // For Printing (x,y) location
	return "(" + p.getX() + ", " + p.getY() + ")";       //     in a string
    }

    //public static void main(String[] args)
    //{
    //	keyMovement2 km = new keyMovement2("a","b");
    //}

    public keyMovement2(String player1, String player2) {
	p1 = new Player(player1, 50, 400);
	p2 = new Player(player2, 400, 400);

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
		if(code == KeyEvent.VK_SPACE){	// Space bar
			turn = 2;
		}              
		else if(code == KeyEvent.VK_ENTER){      // Enter key
			turn = 1;
		}
	
		if(turn == 2)
		{
	
			if(code == KeyEvent.VK_UP){         // UP arrow
				p1.goUp();
			}
			else if(code == KeyEvent.VK_DOWN){       // DOWN arrow
				p1.goDown();
			}
			else if(code == KeyEvent.VK_LEFT){       // LEFT arrow
				p1.goLeft();
			}
			else if(code == KeyEvent.VK_RIGHT){      // RIGHT arrow
				p1.goRight();
			}
			else if(code == KeyEvent.VK_SHIFT){      // SHIFT key
				System.out.println("Stub, SHIFT");   
			}
		}
		else 
		{
			if(code == KeyEvent.VK_W){         // UP arrow
				p2.goUp();
			}
			else if(code == KeyEvent.VK_S){       // DOWN arrow
				p2.goDown();
			}
			else if(code == KeyEvent.VK_A){       // LEFT arrow
				p2.goLeft();
			}
			else if(code == KeyEvent.VK_D){      // RIGHT arrow
				p2.goRight();
			}
			else if(code == KeyEvent.VK_SHIFT){      // SHIFT key
				System.out.println("Stub, SHIFT");   
			}
		}

	}	
    
	
    

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    class MyDrawPanel extends JPanel {
	
		public void paintComponent(Graphics g) {
			//paintComponent draws things
			super.paintComponent(g);       // runs super class, then this class
			Graphics2D d = (Graphics2D) g;
			double x = 0;
			double y = 0;
			
			
			for(int i = 1; i <= 2; i++)
			{

				if( i == 1)
					{
						x = p1.getX();
						y = p1.getY();
					}
				else
					{
						x = p2.getX();
						y = p2.getY();
					}
						
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
						
			}
		
			if( turn == 2)
				{
					// Cannon of tank which rotates*****************
					//d.fillRect((int)p2.getX(), (int)p2.getY() + (size / 24), (3 * size), (size / 3));
					d.rotate(-1 * Math.toRadians(p1.getDegree()),p1.getX() ,p1.getY() + (size / 5));
					d.fillRect((int)p1.getX(), (int)p1.getY() + (size / 24), (3 * size), (size / 3));
					// *********************************************
					d.rotate(1 * Math.toRadians(p1.getDegree()),p1.getX() ,p1.getY() + (size / 5));
					
					d.rotate(-1 * Math.toRadians(p2.getDegree()),p2.getX() ,p2.getY() + (size / 5));
					d.fillRect((int)p2.getX(), (int)p2.getY() + (size / 24), (3 * size), (size / 3));		
				}
			else
				{
					// Cannon of tank which rotates*****************
					//d.fillRect((int)p1.getX(), (int)p1.getY() + (size / 24), (3 * size), (size / 3));
					d.rotate(-1 * Math.toRadians(p2.getDegree()),p2.getX() ,p2.getY() + (size / 5));
					d.fillRect((int)p2.getX(), (int)p2.getY() + (size / 24), (3 * size), (size / 3));
					// *********************************************
					d.rotate(1 * Math.toRadians(p2.getDegree()),p2.getX() ,p2.getY() + (size / 5));
					
					d.rotate(-1 * Math.toRadians(p1.getDegree()),p1.getX() ,p1.getY() + (size / 5));
					d.fillRect((int)p1.getX(), (int)p1.getY() + (size / 24), (3 * size), (size / 3));
				}
			
		}
}

   


}