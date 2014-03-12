import javax.swing.*;
import java.awt.*;

/** Shoot is a class that holds and updates information regarding a tank projectile's current x and y coordinates
    @author Benjamin Hartl
    @author Nick Abrahan
    @author Colin Biafore
    @author Bryce Bowers
    @version 1.0
*/

public class Shoot {
    private double xCord, yCord;
    private double velocity;
    private double degrees;

    private double yStartCord;
    private double xStartCord;

    public boolean isAirborne;

    /** Constructor
	default constructor sets the coordinates at 0,0, the velocity to 60, and the degree to 0
     */

    public Shoot( )
	{
	    this( 0, 0, 60, 0 );
	}

    /** Constructor
	creates a projectile and holds its current coordinates, firing velocity, and firing degree
	@param x X starting coordinate 
	@param y Y starting coordinate
	@param v Velocity of the projectile
	@param deg Degree the projectile should be fired at 
     */

    public Shoot( double x, double y, double v, double deg ){
	xStartCord = x;
	yStartCord = y;
	xCord = x;
	yCord = y;
	velocity = v;
	degrees = deg;
    }

    /**
       gets the updated X coordinate
     */

    public int getTheX() { return (int)xCord; }

    /**
       updates the X coordinate
       @param newX 
     */

    public void setX(double newX) { xCord = newX; } 

    /**
       gets the updated Y coordinate
     */
    
    public int getTheY() { return (int)yCord; }

    /**
       updates the Y coordinate
       @param newY
     */

    public void setY(double newY) { yCord = newY; } 

    /**
       gets the starting X coordinate
     */

    public int getXStart() { return (int)xStartCord; }

    /**
       gets the starting Y coordinate
     */

    public int getYStart() { return (int)yStartCord; }

    /**
       sets the starting X coordinate
       @param x starting x coordinate
     */

    public void setXStart( double x ) { xStartCord = (int)x; }

    /**
       sets the starting Y coordinate
       @param y starting y coordinate
     */

    public void setYStart( double y ) { yStartCord = (int)y; }

    /**
       gets the degree the projectile is fired at
     */

    public double getDegrees() { return degrees; }

    /**
       sets the degree the projectile should be fired at
       @param deg degree of cannon 
     */ 

    public void setDegrees( double deg ) { degrees = deg; }

    /**
       gets the velocity the projectile should be fired at  
     */

    public double getVelocity() { return velocity; }

    /**
       sets the velocity the projectile should be fired at 
       @param vel projectile velocity
     */

    public void setVelocity( double vel ) { velocity = vel; }

    /**
       returns the time the projectile will take to hit the ground after fired 
     */
    
    public double timeInAir()
    {
	double time;
	time = 2 * getVelocity() * Math.sin( Math.toRadians( getDegrees() ) );
	time = time / 9.8;
	return time;
    }

    /**
       adjusts X coordinate according to the velocity and degree at which the projectile 
       is set to be fired, and passes that value to setX, which updates the X coordinate
       @param t time projectile has been in the air 
     */

    public void setNewX( double t )
    {
	double X;
	X = getXStart() + ( getVelocity() * t *
			   Math.cos( Math.toRadians( getDegrees() ) ) );
	setX(X);
    }

    /**
       adjusts Y coordinate according to the velocity and degree at which the projectile
       is set to be fired, and passes that value to setY, which updates the Y coordinate
       @param t time projectile has been in the air
     */

    public void setNewY( double t )
    {
	double Y;
	Y = getYStart() - ( ( getVelocity() * t * 
			      Math.sin( Math.toRadians( getDegrees() ) ) )  
			    - ( 4.9 * t * t ));
	setY(Y);
    }

    /**
       draws the projectile
     */

    public void draw( Graphics g )
    {
	g.fillOval( getTheX(), getTheY(), 5, 5 );
    }

}

