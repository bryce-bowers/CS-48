import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameScreen implements KeyListener{

    static int maxX = 700, maxY = 600;             // max frame size x and y
    // player on the right is player 2
    public boolean right = false;                  // determines whose turn

    public final int startYCord = 400;
    private double velx = 0, vely = 0;             // start velx,  vely
    public Color backgroundColor = Color.BLACK;
    public Image backImage;
 
    Player p1;
    Player p2;
    Test test;
    static double total = 0;
    public boolean shoot = false;
    static MyDrawPanel mdp;
    
    public Graphics doublebufferG;
    public Image doublebufferImg;
    JFrame jf;
    JPanel jp;

    public GameScreen(String player1, Color p1c, 
		      String player2, Color p2c, int cc) throws IOException {
	p1 = new Player( player1, 55, startYCord, p1c );
	p2 = new Player( player2, 400, startYCord, p2c );
	selectBackgroundImage( cc );
	jf = new JFrame("Test Tank Game");
	jf.setSize(maxX,maxY);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.addKeyListener(this);
	jf.setFocusTraversalKeysEnabled(false);
       	jf.setVisible(true);
	mdp = new MyDrawPanel();
	jf.add( mdp );
	test = new Test( 40,  startYCord,  60,   60 );
	//t.go();
    }
    
    public void selectBackgroundImage( int cc )
    {
	try{
	    if( cc == 0 )
		backImage = ImageIO.read(new File("./levSelResources/level_01.jpg"));
	    else if( cc == 1 )
		backImage = ImageIO.read(new File("./levSelResources/level_02.jpg"));
	    else
		backImage = ImageIO.read(new File("./levSelResources/bikini_bottom.jpg"));
	}catch(IOException ioe){
	    ioe.printStackTrace();
	}

    }
    
    public void keyPressed(KeyEvent e)
    {
	// Turns keyPressed into an integer
	int code = e.getKeyCode();         // Get the keyCode that was typed

	if( right == true )                // Check if p2's turn
	    movePlayer2( code );
	else                               // Check if p1's turn
	    movePlayer1( code );
	
    }

    // Checks the code typed in with 
    //   the different Keyboard codes
    public void movePlayer1( int code )             // Button Pressed
    {
	if( code == KeyEvent.VK_W ){                // W,  tilt cannon left
	    p1.tiltLeft();
	}
	else if( code == KeyEvent.VK_S ){           // S,  tilt cannon right
	    p1.tiltRight();
	}
	if(p1.getFuel() > 0){

	    if( code == KeyEvent.VK_A ){           // A,  move tank left
		p1.goLeft();
	    }
	    else if( code == KeyEvent.VK_D ){      // D,  move tank right
		p1.goRight();
	    }
	    p1.burnFuel();
	}

	else if( code == KeyEvent.VK_SPACE ){       // Space bar
	    //                                      // Shoot Projectile
	    test.setX( p1.getXChange() );
	    test.setY( p1.getYChange() );
	    //	    System.out.println( "p1 new (x,y) = " +
	    //			p1.getXChange() + ", " +
	    //p1.getYChange() );
	    right = true;                           // Switch to p2's turn
	    shoot = true;
	    //shootProjectile();
	}
    }
    
   
    // Checks the code typed in with 
    //   the different Keyboard codes
    public void movePlayer2( int code )             // Button Pressed
    {
	if( code == KeyEvent.VK_UP ){               // UP,    tilt cannon left
	    p2.tiltLeft();
	}
	else if( code == KeyEvent.VK_DOWN ){        // DOWN,  tilt cannon right
	    p2.tiltRight();
	}
	if(p2.getFuel() > 0){
	    
	    if( code == KeyEvent.VK_LEFT ){        // LEFT,  move cannon left
		p2.goLeft();
	    }
	    else if( code == KeyEvent.VK_RIGHT ){       // RIGHT, move cannon right
		p2.goRight();
	    }
	    p2.burnFuel();
	}

	else if(code == KeyEvent.VK_ENTER){         // Enter key
	    //                                      // Shoot Projectile
	    System.out.println("p2 new (x,y) = " +
			       p2.getXChange() + ", " +
			       p2.getYChange() );
	    right = false;                          // Switch to p1's turn
	}
    }

    // Both of these methods are needed since KeyListener is implemented
    //   KeyListener is an interface so it has 100% abstract methods
    //   This means they are needed to be declared
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    public void setTime()
    {
	test.setNewX( total / 10 );
	test.setNewY( total / 10 );

    }

    // Inner Class
    // Used to draw both the tanks on the screen
    // It has access to all the instances declared in the GameScreen class
    class MyDrawPanel extends JPanel{
	public void paint(Graphics g){
	    doublebufferImg = jf.createImage( jf.getWidth(), jf.getHeight());
	    doublebufferG = doublebufferImg.getGraphics();
	    draw( doublebufferG );
	    g.drawImage( doublebufferImg, 0, 0, jf );
	}
	
	public void draw( Graphics g )
	{
	    // runs super class, which clears the screen
	    //super.paintComponent(g);
	    
	    ///////////////////////////////////////////////////
	    g.drawImage(backImage, 0, 0, null);
	    ///////////////////////////////////////////////////
	    
	    
	    // sets the ground color depending on level
	    g.setColor( backgroundColor );
	    
	// draws the ground as a big rectangle
	    g.fillRect( 0, (int)( startYCord + p1.size * 2.5 ), 
			maxX, (int)(maxY - startYCord - (p1.size * 6.5) ) );

	    // redraws both players when one of them moves
	    p1.draw( g );                    // draws player 1
	    p2.draw( g );                    // draws player 2
	    g.setColor( Color.RED );
	    if( shoot == true )
		{
		    test.setNewX( total / 50 );
		    test.setNewY( total / 50 );
		    test.draw( g );
		    mdp.repaint();
		}

	    else 
		{
		    System.out.println("False");
		    mdp.repaint();
		}
		/*	    if( ( test.getTheX() > maxX ) || ( test.getTheY() > startYCord + 50 ) )
		{ 
		    total = 0;
		    //test.setX( 400 );
		    test.setY( startYCord );
		    
		}
	    else
		{
		    total = total + .5;
		    test.setNewX( total / 50 );
		    test.setNewY( total / 50 );
		    test.draw( g );
		    }*/
	    //mdp.repaint();
	    // redraws p1 stats
	    g.drawString( ""+p1.getName(), 50, 460);
	    g.drawString( "Health: " + p1.getHealth(), 50, 475);
	    g.drawString( "Fuel: " + p1.getFuel(), 50, 490);

	    // redraws p2 stats
	    g.drawString( ""+p2.getName(), 500, 460);
	    g.drawString( "Health: " + p2.getHealth(), 500, 475);
	    g.drawString( "Fuel: " + p2.getFuel(), 500, 490);
	}
	
    }	
}
