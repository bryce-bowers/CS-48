import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
/** Player is a class that holds all information about a player's current status in the game
    @author Benjamin Hartl
    @author Nick Abrahan
    @author Colin Biafore
    @author Bryce Bowers
    @version 1.0
*/

public class Player{

    // Pre Determined Variables
    public  int size     = 5;               // size of tank
    private int degree   = 90;              // angle of cannon
    private int fuel     = 30;              // amount of fuel left
    private int health   = 3;               // how much health left 
    private int velocity = 16;              // velocity of each shot
    
    // Initialized by the constructor
    private Color  color = null;            // tank color
    private String name  = "";              // user's name
    private double x     = 0.0;             // center x cord of tank
    private double y     = 0.0;             // top y cord of the tank

    // Keys pressed for each user to move
    // They are hardcoded in the GameScreen class and can be set
    //   for multiple users to use different parts of the keyboard
    //   and they both can use it in the same class
    private int upKey    = 0;
    private int downKey  = 0;
    private int leftKey  = 0;
    private int rightKey = 0;
    private int fireKey  = 0;

    public boolean hit  = false;


    //Sound Effects
    playMusic launchSound = null;

    /** Constructor
	@param n Player name
	@param newX starting coordinate of player 
	@param newY starting coordinate of player
	@param c Color that player selected their tank to be
    */

    public Player(String n, double newX, double newY, Color c){
	name = n;
	setX( newX );
	setY( newY );
	color = c;
	launchSound = new playMusic("./soundResources/tank_fire.wav");
    }

    /**
       checks whether the projectile hit the opposing tank
       @param projectileX X coordinate of projectile
       @param projectileY Y coordinate of projectile
    */

    public void checkHit( int projectileX, int projectileY )
    {
	if( hit == false )
	    {
		if( ( projectileX > ( x - 10 ) ) && ( projectileX < ( x + 10 ) ) )
		    {
			if( ( projectileY > y ) && ( projectileY < ( y + 15 ) ) )
			    {
				loseHealth();
				hit = true;
			    }
			
		    }
	    }
    }
	
	
			


    /**
       get degree of the tank cannon
    */

    public int getDegree()        { return degree; }

    /**
       Checks to make sure you cannot aim down to the ground
       @param newDeg degree cannon should be set to
    */

    public void setDegree( int newDeg ){
	if((newDeg <= 180) && (newDeg >= 0))
	    degree = newDeg;
    }

    /**
       gets players remaining fuel
    */

    public int getFuel()          { return fuel; }

    /**
       refuels players tank with 5 units of fuel
     */

    public void reFuel()          { fuel += 5; }

    /**
       burns fuel when player moves their tank 
     */

    public void burnFuel()        { fuel -= 1; } 

    /**
       gets current health of the player
     */

    public int getHealth()           { return health; }

    /**
       sets the health of the player
       @param h number value of players health
     */

    public void setHealth( int h )   { health = h; }

    /**
       decreases the players health by 1
    */

    public void loseHealth()         { health -= 1; }

    /**
       gets the name of the player
     */
 
    public String getName()          { return name; }

    /**
       gets how fast the player wants to shoot a projectile
     */

    public int getVelocity()         { return velocity; }

    /**
       sets velocity and makes sure it's between 15 and 100
       @param v value of the velocity
     */

    public void setVelocity( int v ) {    // checks velocity 
	if( v < 15 )                      //   less than 15
	    return;
	if( v > 100 )                     //   or more than 100
	    return;
	velocity = v;                     //   before setting it
    }

    /**
       gets the x coordinate of the center of the tank
     */

    public double getX()             { return x; }

    /**
       Checks to make sure the new x coordinate fits on the screen
       @param newX new X coordinate of the tank
     */

    public void setX( double newX ){
	if( newX < (2 * size) )
	    return;
	else if( newX > GameScreen.maxX - ( 3 * size ) )
	    return;
	x = newX;
    }

    /**
       x coordinate at the end of the cannon
    */

    public double getXCannon(){ 
	return x + ( 3 * size * Math.cos( Math.toRadians( getDegree() ) ) );
    }

    /**
       gets the y coordinate of the center of the tank
     */

    public double getY()             { return y; }

    /**
       sets the new y coordinate of the center of the tank
       @param newY new Y coordinate of the tank 
     */

    public void setY(double newY)    { y = newY; }

    /**
       y coordinate at the end of the cannon
     */

    public double getYCannon(){ 
	return y - ( 3 * size * Math.sin( Math.toRadians( getDegree() ) ) ); 
    }

    /**
       moves the tank horizontally to the left
       as well lower the fuel
    */

    public void goLeft(){
	setX( getX() - 2);
	burnFuel();
    } 

    /**
       moves the tank horizontally to the right
       as well lower the fuel
    */
   
    public void goRight(){
	setX( getX() + 2);
	burnFuel();
    }

    /**
       Checks all the different types of buttons to adjust player
       @param code value of key pressed 
    */

    public boolean checkCodes( int code )
    {
	
	checkHorizontalCode( code );
	checkTiltCannonCode( code );
	checkVelocityCode(   code );
	return ( checkFireCannonCode( code ) );
    }

    /**
       Checks if player has chosen the shoot cannon
       @param code value of key pressed 
    */

    public boolean checkFireCannonCode( int code )
    {
	if( code == fireKey ){
	    reFuel();
	    launchSound.startMusic();
	    return true;
	}
	else
	    return false;
    }

    /**
       Checks if player has moved the tank left or right
       @param code value of key pressed 
    */

    public void checkHorizontalCode( int code )
    {
	if( code == upKey ){    
	    tiltLeft();
	}
	else if( code == downKey ){    
	    tiltRight();
	}
    }

    /**
       Checks if player has tilted the cannon of the tank
       @param code value of key pressed
    */

    public void checkTiltCannonCode( int code )
    {
	if( code == leftKey ){    
	    if( isEnoughFuel() )
		goLeft();
	}
	else if( code == rightKey ){    
	    if( isEnoughFuel() )
		goRight();
	}
    }

    /**
       Checks if player has changed the velocity of his cannon
       @param code value of key pressed
    */

    public void checkVelocityCode( int code )
    {
	if( code == KeyEvent.VK_COMMA )
	    {
		setVelocity( getVelocity() - 1 );
	    }
	else if( code == KeyEvent.VK_PERIOD )
	    {
		setVelocity( getVelocity() + 1 );
	    }
    }

    /**
       Checks if player has enough fuel left to move
    */

    public boolean isEnoughFuel()
    {
	if( fuel > 0 )
	    return true;
	else
	    return false;
    }
    
    /**
       sets key code values
       @param up value of up key
       @param down value of down key
       @param left value of left key
       @param right value of right key
       @param fire value of fire key
    */
       
    public void setCodes( int up, int down, int left, int right, int fire )
    {
	upKey    = up;
	downKey  = down;
	leftKey  = left;
	rightKey = right;
	fireKey  = fire;
    }

    /**
       adjust cannons angle to the left
    */

    public void tiltLeft(){
	setDegree( getDegree() + 2);
    }

    /**
       adjust cannons angle to the right
    */

    public void tiltRight(){
	setDegree( getDegree() - 2);
    }
    
    /**
       draws the tank
       @param shift amount game text should be shifted in the x direction
    */

    public void draw( Graphics g, int shift )
    {
	Graphics2D d = (Graphics2D) g;	

	// sets the color of the tank
	d.setColor( color );

	// top half of the tank
	d.fillOval((int)x - size, (int)y, 2 * size, 2 * size );
	d.fillRect((int)x - (2 * size), (int)y + size + (size / 2),
		   4 * size, size / 2 );
	d.fillRoundRect((int)x - ( 2 * size ), (int)y + size, 
			4 * size, size     , 40, 40 );

	// the wheels of the tank
	d.fillOval((int)x -(2 * size), (int)(y + (1.5 * size)), size, size);
	d.fillOval((int)x - size, (int)(y + (1.5 * size)), size, size);
	d.fillOval((int)x , (int)(y + (1.5 * size)), size, size);
	d.fillOval((int)x + size, (int)(y + (1.5 * size)), size, size);
		
	//the line underneath the tank
	d.drawLine((int)(x - (1.5 * size)), (int)(y + (2.5 * size)),
		   (int)(x + (1.5 * size)), (int)(y + (2.5 * size)));
				
	// rotate the cannon to the correct angle
	d.rotate( -1 * Math.toRadians( getDegree() ), getX(),
		 getY() + (size / 5));
	
	// the cannon on top of the tank
	d.fillRect( (int)getX(), (int)getY() + (size / 24),
		    (3 * size), (size / 3));
	
	// unrotate the cannon to start angle
	d.rotate( 1 * Math.toRadians( getDegree() ), getX(),
		 getY() + (size / 5));

	// sets the name under the tank to black
	d.setColor( Color.WHITE );

	// Player name under the tank
	d.drawString(name, (int)x - 7*(name.length() / 2),
		     GameScreen.startYCord - size * 5 );
	
	// Player Stats
	g.drawString( ""                + getName(),     shift, 490 );
	g.drawString( "Health: "        + getHealth(),   shift, 490 + 15 );
	g.drawString( "Cannon Degree: " + getDegree(),   shift, 490 + 30 );
	g.drawString( "Fuel: "          + getFuel(),     shift, 490 + 45 );
	g.drawString( "Velocity: "      + getVelocity(), shift, 490 + 60 );

    }
}
