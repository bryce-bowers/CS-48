import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class keyMovement extends JPanel implements ActionListener, KeyListener {
    private int speed = 10;                             // speed, lower = faster
    Timer t = new Timer(speed, this); 
    
    private double x = 0, y = 0, velx = 0, vely = 0;   // x,  y,  velx,  vely
    private Color myColor = Color.BLACK;               // myColor
    private int size = 20;                             // size of image
    private int maxX = 680, maxY = 510;                // max frame size x and y
    private int tShift = 20;                           // amount shifted of frame
    private int distanceLeft = 0;

    //    private WaitToMove justWait = new WaitToMove();

    public double getXCord() { return x; }             // Returns x
    public double getYCord() { return y; }             // Returns y
    
    public String toString(){                      // For Printing (x,y) location
	return "(" + x + ", " + y + ")";           //     in a string
    }

    public keyMovement() {
	t.start();
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
    }

    
    public void actionPerformed(ActionEvent e) {
	repaint();                                  // redraw image at new x,y
	
	if(distanceLeft == 1){                      // check if should move or stop
	    stop();                                 //    stop moving
	}
	else
	    distanceLeft--;
	// Check to make sure not off the screen    // Where to check on screen
	if(x > maxX) { x = maxX - 2; velx = 0; }          // X coord to right

	else if(x < tShift) { x = tShift + 2; velx = 0; } // X coord to left

	else { x += velx;}                                // Else continue

	if(y > maxY){ y = maxY - 2; vely = 0; }           // Y coord to bottom

	else if(y < tShift) { y = tShift + 2; vely = 0;	} // Y coord to top

	else { y += vely; }                               // Else continue 
    }
 
    public void up(int d) {
	up();
	distanceLeft = d;
    }

    public void down(int d) {
	down();
	distanceLeft = d;
    }

    public void left(int d) {
	left();
	distanceLeft = d;
    }

    public void right(int d) {
	right();
	distanceLeft = d;
    }

    public void up() { velx = 0; vely = -1.5; distanceLeft = 0; }

    public void down() { velx = 0; vely = 1.5; distanceLeft = 0; }

    public void left() { velx = -1.5; vely = 0; distanceLeft = 0; }

    public void right() { velx = 1.5; vely = 0; distanceLeft = 0; }

    public void stop() { velx = 0; vely = 0; }

    public void upThenDown() { System.out.println("Stub, void upThenDown()"); }
      

    public void keyPressed(KeyEvent e) {
	int code = e.getKeyCode();
	if(code == KeyEvent.VK_UP) { up(); }               // Up arrow
	else if(code == KeyEvent.VK_DOWN) { down(); }      // Down arrow
	else if(code == KeyEvent.VK_RIGHT) { right(); }    // Right arrow
	else if(code == KeyEvent.VK_LEFT) { left(); }      // Left arrow
	else if(code == KeyEvent.VK_SPACE){ stop(); }      // Space bar
	else if(code == KeyEvent.VK_W){ up(5); }          // W key
	else if(code == KeyEvent.VK_S){ down(5); }        // S key 
	else if(code == KeyEvent.VK_D){ right(5); }       // D key
	else if(code == KeyEvent.VK_A){ left(5); }        // A key
    }
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    	
    public void paintComponent(Graphics g) {
	//paintComponent draws things
	super.paintComponent(g);            // runs super class, then this class
	Graphics2D d = (Graphics2D) g;      
	d.translate(tShift,tShift);                 // Shifts to new x and y coord
	
	// middle of tank
	d.fillRect((int)x,(int)y - (size / 6) + 5,(4 * size),size /2);
	d.fillRoundRect((int)x,(int)y - (size/2), 4 * size, size, 40, 40 );
	
	// the wheels of the tank
	d.fillOval((int)x,(int)y,size,size);
	d.fillOval((int)x + size,(int)y,size,size);
	d.fillOval((int)x + (2 * size),(int)y,size,size);
	d.fillOval((int)x + (3 * size),(int)y,size,size);
	
	//the line at the bottom
	d.drawRect((int)x + (size/2), (int)y + (size/2), 3 * size, size/2);
	
	// the top part of the tank
	d.fillOval((int)x + (size),(int)y - (3* size)/2, 2 * size,  2 *size);
	d.fillRoundRect((int)x - size,(int)y - (3 * size)/2,
			(3 * size) + (size / 4) , size / 3,20,20);
    }   
}

class WaitToMove extends Thread {

    

}

