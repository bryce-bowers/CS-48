import javax.swing.*;
import java.awt.*;

public class Test extends Thread{
    private double xCord, yCord;
    private final double velocity;
    private final double degrees;

    private final double yStartCord;
    private final double xStartCord;



    public Test(double x, double y, double v, double deg){
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

    public double getDegrees() { return degrees; }
    public double getVelocity() { return velocity; }


    public String toStringXY()
    { return "(" + getTheX() + ", " + getTheY() + ")"; }
    
    public String toStringStartCord()
    { return "xStart = " + getXStart() + ", yStart = " + getYStart() ; }

    public String toStringTimeInAir()
    { return  "Traveled in air the air for a total of " + 
	    String.format( "%.2f", timeInAir() ) + " seconds"; 
    }

    public String toStringXDistance()
    { return "Traveled a total distance of " + 
	    (int)( getTheX() - getXStart() ) + " pixels" ; 
    }
    
    public String toStringYMaxHeight()
    { return "Traveled to a max height of " + (int)( maxHeight() ) + " pixels" ; } 

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

    public void setNewX(double t)
    {
	double X;
	X = xStartCord + ( getVelocity() * t *
			   Math.cos( Math.toRadians( getDegrees() ) ) );
	setX(X);
    }

    public void setNewY(double t)
    {
	double Y;
	Y = getYStart() - ( ( getVelocity() * t * 
			      Math.sin( Math.toRadians( getDegrees() ) ) )  
			    - ( 4.9 * t * t ));
	setY(Y);
    }
    
    public void go()
    {
	PixelFly drawPanel = new PixelFly();
	JFrame jf = new JFrame( "Test Pixel Move" );
	jf.setSize( 900, 600 );
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	jf.setVisible( true );
	jf.getContentPane().add(drawPanel);

	System.out.println( toStringStartCord() );
	for(double t = 0; t < timeInAir(); t = t + .25)
	    {	
		setNewX( t );
		setNewY( t );
		drawPanel.repaint();
		
		try{ 
		    Thread.sleep( 50 );
		}catch( InterruptedException ie ){
		    System.out.println( ie );
		}
	    }
	setNewX( timeInAir() );
	setNewY( timeInAir() );
	drawPanel.repaint();
	
	System.out.println( toStringXY() );
	System.out.println( toStringTimeInAir() );
	System.out.println( toStringXDistance() );
	System.out.println( toStringYMaxHeight() );
    }
    
    class PixelFly extends JPanel {
	public void paintComponent( Graphics g )
	{	    
	    super.paintComponent(g);
	    g.fillOval( getTheX(), getTheY(), 20, 20 );
	}
    }
    
    public static void main(String[] args)
    {
	//               ( x,    y,  vel,  angle )
	Test t = new Test( 10,   530,   80,    80 );
	t.go();
	
    }

}

