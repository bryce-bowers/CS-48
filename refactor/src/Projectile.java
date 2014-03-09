import javax.swing.*;
import java.awt.*;
import java.lang.Thread.*;

//p.getXChange(), p.getYChange()
//These are the starting coordinates for every Projectile panel created
//Class will be instantiated every time a player fires his cannon

public class Projectile extends JPanel {
    
    private double xCord;
    private double yCord;
    private double velocity;
    private double degrees;
    
    private double xStartCord;
    private double yStartCord;

    public Projectile(/* Player p */double vel, double deg) {
	
	//Should make screen transparent
	this.setOpaque(false);

	//set projectile variables
	
	xStartCord = 50; //p.getXChange();
	yStartCord = 50; //p.getYChange();
	xCord = xStartCord;
	yCord = yStartCord;
	velocity = vel;
	degrees = deg;
	

    }

    //Draws the projectile on screen
    public void PaintComponent(Graphics g) {
	super.paintComponent(g);
	g.fillOval(getXCord(),getYCord(), 10,10);
	System.out.println("Paint ran");
    }



    
    //get starting coordinates 
    public int getXStartCord() { return (int)xStartCord; }
    public int getYStartCord() { return (int)yStartCord; }
    
    //Returns coordinates as ints
    public int getXCord() { return (int)xCord; }
    public int getYCord() { return (int)yCord; }

    //Sets x and y coordinates
    public void setX(double newX) { xCord = newX; }
    public void setY(double newY) { yCord = newY; }

    
    public double getDegrees() { return degrees; }
    public double getVelocity() { return velocity; }


    //passes new x cord to xCord according to t value
    public void setNewX(double t) {
	double X;
	X = xStartCord + (velocity * t * Math.cos(Math.toRadians(degrees)) 
			  - (4.9 * t * t));
	setX(X);
    }
    
    //passes new y cord to yCord according to t value
    public void setNewY(double t) {
	double Y;
	Y = yStartCord + (velocity * t * Math.sin(Math.toRadians(degrees))
			  - (4.9 * t * t));
	setY(Y);
    }

    //sets how long fireProjectile loop should run for based on 
    //its velocity and degree at which it was fired
    public double timeInAir() {
	double time;
	time = 2 * velocity * Math.sin(Math.toRadians(degrees));
	time = time / 9.8;
	return time;
    }

    public void fireProjectile() {
	
	for(double t = 0; t < timeInAir(); t = t + .25) {
	    setNewX(t); //passes to setX, passes to xCord
	    setNewY(t); //passes to setY, passes to yCord
	    this.repaint(); //updates based on getXCord() and getYCord() 
	    
	    try {
		Thread.sleep(50);
	    } catch (InterruptedException ex) {
		ex.printStackTrace();
	    }
	}
	
	//sets xCord and yCord to impact coordinates
	setNewX(timeInAir());
	setNewY(timeInAir());
	this.repaint();
    }
	    
}
