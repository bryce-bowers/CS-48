import javax.swing.*;
import java.awt.*;

public class Test {
    private double xCord, yCord;
    private double velocity;
    private double degrees;

    private double yStartCord;
    private double xStartCord;

    public Test( )
	{
	    this( 0, 0, 60, 0 );
	}

    public Test( double x, double y, double v, double deg ){
	xStartCord = x;
	yStartCord = y;
	xCord = x;
	yCord = y;
	velocity = v;
	degrees = deg;
    }

    public int getTheX() { return (int)xCord; }
    public void setX(double newX) { xCord = newX; } 
    
    public int getTheY() { return (int)yCord; }
    public void setY(double newY) { yCord = newY; } 

    public int getXStart() { return (int)xStartCord; }
    public int getYStart() { return (int)yStartCord; }

    public void setXStart( double x ) { xStartCord = (int)x; }
    public void setYStart( double y ) { yStartCord = (int)y; }

    public double getDegrees() { return degrees; }
    public void setDegrees( double deg ) { degrees = deg; }

    public double getVelocity() { return velocity; }
    public void setVelocity( double vel ) { velocity = vel; }




    public String toStringXY(){
	return "(" + getTheX() + ", " + getTheY() + ")"; 
    }
    
    public String toStringStartCord(){
	return "xStart = " + getXStart() + ", yStart = " + getYStart() ; 
    }

    public String toStringTimeInAir(){
	return  "Traveled in air the air for a total of " + 
	    String.format( "%.2f", timeInAir() ) + " seconds"; 
    }

    public String toStringXDistance(){
	return "Traveled a total distance of " + 
	    (int)( getTheX() - getXStart() ) + " pixels" ; 
    }
    
    public String toStringYMaxHeight(){
	return "Traveled to a max height of " + 
	    (int)( maxHeight() ) + " pixels" ; } 

    public double maxHeight()
    {
	return ( ( timeInAir() * getVelocity() * 
		   Math.sin( Math.toRadians( getDegrees() ) ) ) / 4);
    }
    
    public double timeInAir()
    {
	double time;
	time = 2 * getVelocity() * Math.sin( Math.toRadians( getDegrees() ) );
	time = time / 9.8;
	return time;
    }

    public void setNewX( double t )
    {
	double X;
	X = getXStart() + ( getVelocity() * t *
			   Math.cos( Math.toRadians( getDegrees() ) ) );
	setX(X);
    }

    public void setNewY( double t )
    {
	double Y;
	Y = getYStart() - ( ( getVelocity() * t * 
			      Math.sin( Math.toRadians( getDegrees() ) ) )  
			    - ( 4.9 * t * t ));
	setY(Y);
    }

    public void draw( Graphics g )
    {
	g.fillOval( getTheX(), getTheY(), 5, 5 );
    }

}

