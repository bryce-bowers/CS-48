import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class keyMovement extends JPanel implements ActionListener, KeyListener {
    private int speed = 10;                             // speed, lower = faster
    Timer tV = new Timer(speed, this);
    Timer tH = new Timer(speed,this);
    
    private int tShift = 20;                           // amount shifted of frame
    private int maxX = 680, maxY = 510;                // max frame size x and y
    private double x = tShift , y = tShift;            // start x Cord and y Cord
    private double velx = 0, vely = 0;                 // start velx,  vely
    private Color myColor = Color.BLACK;               // myColor
    private int size = 20;                             // size of image
    private int distanceLeft = 0;
    private int distanceVert = 1;
    private int distanceHoriz = 1;

    private String player1;
    private String player2;

    public double getXCord() { return x; }             // Returns x
    public double getYCord() { return y; }             // Returns y
    
    public String toString(){                      // For Printing (x,y) location
	return "(" + x + ", " + y + ")";           //     in a string
    }

    public keyMovement(String p1, String p2) {
	player1 = p1;
	player2 = p2;
	setLayout(new GridLayout(2,2));
	add(new JLabel("Player 1's name is      " +player1));
	add(new JLabel("Player 2's name is      " +player2));
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
    }

    
    public void actionPerformed(ActionEvent e) {
	repaint();                                  // redraw image at new x,y

	if(tV.isRunning())
	    {
		if(distanceVert < 1)
		    tV.stop();
		else 
		    distanceVert--;

		if(y > maxY){ y = maxY - 2; vely = 0; }        // Y coord to bottom
		
		else if(y < tShift) { y = tShift + 2; vely = 0;	} // Y coord to top
		
		else { y += vely; }                               // Else continue
		
	    }
	
	if(tH.isRunning())
	    {
		if(distanceHoriz < 1)
		    tH.stop();
		else 
		    distanceHoriz--;

		if(x > maxX) { x = maxX - 2; velx = 0; }        // X coord to right
		
		else if(x < tShift) { x = tShift + 2; velx = 0; }// X coord to left

		else { x += velx;} 
	       
	    }
	 
	System.out.print("* ");



	/*	if(distanceLeft == 1){                      // check if should move or stop
	    t.stop();
	else
	    distanceLeft--;
	// Check to make sure not off the screen    // Where to check on screen
	if(x > maxX) { x = maxX - 2; velx = 0; }          // X coord to right

	else if(x < tShift) { x = tShift + 2; velx = 0; } // X coord to left

	else { x += velx;}                                // Else continue

	if(y > maxY){ y = maxY - 2; vely = 0; }           // Y coord to bottom

	else if(y < tShift) { y = tShift + 2; vely = 0;	} // Y coord to top

	else { y += vely; }                               // Else continue 
	System.out.print("* ");*/
    }

    public void up(int d) {
	tV.start();
	velx = 0; 
	vely = -1.5; 
	distanceVert = d;

	//distanceLeft = d;
    }

    public void down(int d) {
	tV.start();
	velx = 0;
	vely = 1.5; 
	distanceVert = d;

	//distanceLeft = d;
    }

    public void left(int d) {
	tH.start();
        velx = -1.5; 
	vely = 0;
	distanceHoriz = d;


	//distanceLeft = d;
    }

    public void right(int d) {
	tH.start();
	velx = 1.5; 
	vely = 0; 
	distanceHoriz = d;

	//distanceLeft = d;
    }
    public void upAndRight(int h, int v){
	tV.start();
	tH.start();
	velx = 1.5;
	vely = -1.5;
	distanceHoriz = h;
	distanceVert = v;
    }

    /*
    public void up() { velx = 0; vely = -1.5; distanceLeft = 0;}

    public void down() { velx = 0; vely = 1.5; distanceLeft = 0; }

    public void left() { velx = -1.5; vely = 0; distanceLeft = 0; }

    public void right() { velx = 1.5; vely = 0; distanceLeft = 0; }
    */

    public void stop() { velx = 0; vely = 0; tV.stop(); tH.stop(); }
    
    public void upThenDown() {
	int v0 = 30;
	int degrees = 90;
	double maxHeight = getMaxHeight(v0, degrees);
	upAndRight((int)maxHeight,(int)maxHeight);
	//	up((int)maxHeight);
	//right((int)maxHeight);
	
	//	t.setDelay(100);


	  
    }
    public int getMaxHeight(int vel, int degrees)
    {
	System.out.println(toString());
	int maxHeight;
	double radians = Math.toRadians(degrees);
	maxHeight = (int)(Math.pow(vel,2)*(Math.pow(Math.sin(radians),2)));
	maxHeight = (int)(maxHeight/(2*9.81));
	System.out.println("Y - V = " + y + " - " + maxHeight + " = "
			   + (y - maxHeight));
	return maxHeight;
    }    
    public void keyPressed(KeyEvent e) {
	int code = e.getKeyCode();
	if(code == KeyEvent.VK_SPACE){ stop(); }              // Space bar
	else if(code == KeyEvent.VK_UP){ up(5); }             // W key
	else if(code == KeyEvent.VK_DOWN){ down(5); }         // S key 
	else if(code == KeyEvent.VK_RIGHT){ right(5); }       // D key
	else if(code == KeyEvent.VK_LEFT){ left(5); }         // A key
	else if(code == KeyEvent.VK_SHIFT){ upThenDown(); }   // Shift key
	else if(code == KeyEvent.VK_ENTER){ System.exit(0); }
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

