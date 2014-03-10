import java.awt.*;
import javax.swing.*;

public class Player{

    // Pre Determined Variables
    public  int size     = 5;
    private int degree   = 90;
    private int fuel     = 30;
    private int health   = 3;
    private int velocity = 60;

    // Initialized by the user
    private Color  color = null;
    private String name  = "";
    private double x     = 0.0;
    private double y     = 0.0;;

    // 2 arg constructor
    //           (  name  ,     x      ,      y     ,  color )
    public Player(String n, double newX, double newY, Color c){
	name = n;
	setX( newX );
	setY( newY );
	color = c;
    }

    // degree
    // the angle of the cannon
    public int getDegree()        { return degree; }
    // Checks to make sure you cannot aim down to the ground 
    public void setDegree( int newDeg ){
	if((newDeg <= 180) && (newDeg >= 0))
	    degree = newDeg;
    }

    
    // fuel
    // used for how far the tank can travel
    public int getFuel()             { return fuel; }
    public void setFuel( int f )     { fuel = f; }
    public void burnFuel()           { fuel -= 1; } 


    // health
    // each tank hit, the health decreases
    public int getHealth()           { return health; }
    public void setHealth( int h )   { health = h; }


    // name
    public String getName()          { return name; }


    // velocity
    // how much power each cannon shot has
    public int getVelocity()         { return velocity; }
    public void setVelocity( int v ) {        // checks velocity to be 
	if( ( v > 15 ) && ( v < 100 ) )       //   within 15 and 100
	    velocity = v;                     //   before setting it
    }


    // x
    // location of the center of the tank
    public double getX()             { return x; }
    // Checks to make sure the new x coordinates fit on the screen 
    public void setX( double newX ){
	if(( newX >= (2 * size))  &&  (newX <= GameScreen.maxX -(3 * size)))
	    x = newX;
    }
    // x coordinate at the end of the cannon
    public double getXChange(){ 
	return x + ( 3 * size * Math.cos( Math.toRadians( getDegree() ) ) );
    }

    
    // y
    // location to the top of the tank
    public double getY()             { return y; }
    public void setY(double newY)    { y = newY; }
    // y coordinate at the end of the cannon
    public double getYChange(){ 
	return y - ( 3 * size * Math.sin( Math.toRadians( getDegree() ) ) ); 
    }


    // moves the tank horizontally
    public void goLeft(){
	setX( getX() - 2);
	burnFuel();
    }    
    public void goRight(){
	setX( getX() + 2);
	burnFuel();
    }


    // adjust cannons angle
    public void tiltLeft(){
	setDegree( getDegree() + 2);
    }
    public void tiltRight(){
	setDegree( getDegree() - 2);
    }
    
  
    // draws the tank
    public void draw( Graphics g )
    {
	Graphics2D d = (Graphics2D) g;	

	// sets the color of the tank
	d.setColor( color );

	// top half of the tank
	d.fillOval(      (int)x - size      , (int)y                    ,
			 2 * size, 2 * size );
	d.fillRect(      (int)x - (2 * size), (int)y + size + (size / 2),
			 4 * size, size / 2 );
	d.fillRoundRect( (int)x - ( 2 * size ), (int)y + size, 
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

	// centers the string under the tank
	d.drawString(name, (int)x - 7*(name.length() / 2), 
		     (int)(y + (size * 4)));
    }
}
