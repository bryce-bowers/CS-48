import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/** GameScreen is a class that controls all in-game sequences 
    @author Benjamin Hartl
    @author Nick Abrahan
    @author Colin Biafore
    @author Bryce Bowers
    @version 1.0
*/

public class GameScreen implements KeyListener{

    playMusic hitSound = new playMusic("./soundResources/tank_hit.wav");
    static int maxX = 700;             // max frame x
    static int maxY = 600;             // max frame y

    static final int startYCord = 450; // where to place the tanks
    
    // player on the right is player 2
    public boolean rightTurn = false;        // determines whose turn

    // determined by level select
    public Color backgroundColor = Color.BLACK;    // color of the ground
    public Image backImage;                        // image on background
 
    Player p1   = null;                    // player 1
    Player p2   = null;                    // player 2
    Shoot shoot = null;                    // used for firing cannon

    static double time = 0;
    public boolean inAir = false;
    public MyDrawPanel mdp;
    
    public Graphics doublebufferG;
    public Image doublebufferImg;
    static JFrame jf;
    JPanel jp;

    /** Constructor creates 2 players and loads information given in the play menu and enviroMenu, sets background image 
	@param player1 Name of player 1
	@param p1c Tank color for player 1
	@param player2 Name of player 2
	@param p2c Tank color for player 2
	@param cc Integer that represents a background image
     */

    public GameScreen(String player1, Color p1c, 
		      String player2, Color p2c, int cc) throws IOException {
	p1 = new Player( player1, 55, startYCord, p1c );
	p2 = new Player( player2, 640, startYCord, p2c );
	setUpPlayerKeys();
	setUpFrame();
	shoot = new Shoot();
	selectBackgroundImage( cc );
    }

    /**
       Creates the frame in which Tanks will be played
    */

    public void setUpFrame()
    {
	jf = new JFrame("Tank Game");

	mdp = new MyDrawPanel();
	jf.add( mdp );

	jf.setSize(maxX,maxY);
 	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.addKeyListener( this );
       	jf.setVisible(true);
    }

    /**
       assigns keys to player 1 and player 2
       player 1 uses ASWD for movement and spacebar to fire, 
       player 2 uses arrow keys for movement and the return key to fire 
     */

    public void setUpPlayerKeys()
    {
	p1.setCodes( KeyEvent.VK_W, KeyEvent.VK_S, 
		     KeyEvent.VK_A, KeyEvent.VK_D, 
		     KeyEvent.VK_SPACE );

	p2.setCodes( KeyEvent.VK_UP,   KeyEvent.VK_DOWN, 
		     KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, 
		     KeyEvent.VK_ENTER );
    }

    /**
       loads the background image into the game screen
       @param cc integer representing the background selected in enviroMenu
     */
    
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

    /**
	Checks whether it is player 1 or 2's turn
	@param e KeyEvent representing user's key press
     */

    public void keyPressed(KeyEvent e)
    {
	// Turns keyPressed into an integer
	int code = e.getKeyCode();       // Get the keyCode that was typed
	boolean fire;
	Player tmpP;
	if( time != 0 )
	    return;
	if( rightTurn == true )                // Check if p2's turn
	    tmpP = p2;
	else 
	    tmpP = p1;
	p1.hit = false;
	p2.hit = false;
	fire = tmpP.checkCodes( code );
	shootProjectile( tmpP, fire );
	if(p1.getHealth() == 0)
		lose(p1);
	if(p2.getHealth() == 0)
		lose(p2);
    }
   
    /**
	Calls Game Over screen when one Player's health reaches zero
	@param p Player who won
    */
   public void lose(Player p) {
	GameOverMenu gdoto = new GameOverMenu(p);
	jf.dispose();
   }
	

   
    /** Sets all the variables for the projectile
       @param p Player who's cannon is going to fire
       @param fire Boolean to set state of the projectile
     */    

    public void shootProjectile( Player p, boolean fire )
    {
	if( inAir == true )
	    return;
	if( fire != true )
	    return;
	
	shoot.setXStart(   p.getXCannon()  );
	shoot.setYStart(   p.getYCannon()  );
	shoot.setDegrees(  p.getDegree()   );
	shoot.setVelocity( p.getVelocity() );
	
	rightTurn = !( rightTurn );          // Switch to other players turn
	inAir = true;                        // Start cannon to shoot
	shoot.isAirborne = true;
    }

    /**
	Closes Game Screen
    */
	public static void shutMeDown(){
		jf.dispose();
	}
	
    /**
       Checks whether the projectile is in the air or not 
     */

    public void checkBounds()
    {
	if( inAir )
	    {
		if( shoot.getTheX() > maxX )
		    {
			shoot.setNewX( 50 );
			inAir = false;
		    }
		if( shoot.getTheY() > startYCord + 10 )
		    {
			shoot.setNewY( 50 );
			inAir = false;
		    }
		if( inAir == false )
		    hitSound.startMusic();
	    }
	
	p1.checkHit( shoot.getTheX(), shoot.getTheY() );
	p2.checkHit( shoot.getTheX(), shoot.getTheY() );
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
	    // super.paintComponent(g);
	    
	    ///////////////////////////////////////////////////
	    g.drawImage( backImage, 0, 0, null );
	    ///////////////////////////////////////////////////
	    
	    
	    // sets the ground color depending on level
	    g.setColor( backgroundColor );
	    
	    // draws the ground as a big rectangle
	    g.fillRect( 0, (int)( startYCord + p1.size * 2.5 ), 
	    		maxX, (int)( maxY - startYCord));

	    // redraws both players when one of them moves
	    p1.draw( g, 50 );                    // draws player 1
	    p2.draw( g, 500 );                   // draws player 2
	    g.setColor( Color.RED );
	  
	    if( inAir == true )
		{
		    shoot.setNewX( time );
		    shoot.setNewY( time );
		    shoot.draw( g );
		    time = time + .01;
		}
	    else 
		{
		    time = 0;
		}
	    checkBounds();
	    mdp.repaint();
	}
    }	

    
    // Both of these methods are needed since KeyListener is implemented
    //   KeyListener is an interface so it has 100% abstract methods
    //   This means they are needed to be declared
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
