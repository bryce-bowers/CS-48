import java.awt.*;
import javax.swing.*;

public class Player{

    static int playerCount;
    public String name;
    private int playerNumber;
    private int health;
    private int fuel;
    public Color color;
    public double x, y;
    public double degree = 90;
    public int size = 10;
	
    public Player(String s, double newX, double newY, Color c){
	name = s;
	x = newX;
	y = newY;
	color = c;
    }
	
    public double getX(){ return x; }
    public double getY(){ return y; }

    public double getXChange()
    { 
	return x + ( 30 * Math.cos( Math.toRadians( getDegree() ) ) );
    }
    public double getYChange()
    { 
	return y - ( 30 * Math.sin( Math.toRadians( getDegree() ) ) ); 
    }
	
    public double getDegree(){ return degree; }
	
    public void setX(double newX){
	if(( newX >= (2 * size))  &&  (newX <= GameScreen.maxX -(3 * size)))
	    x = newX;
    }
	
    public void setY(double newY){
	y = newY;
    }
	
    public void setDegree(double newDeg){
	if((newDeg <= 180) && (newDeg >= 0))
	    degree = newDeg;
    }

    public void tiltLeft(){
	setDegree( getDegree() + 2);
	GameScreen.drawPanel.repaint();
		
    }
    
    public void tiltRight(){
	setDegree( getDegree() - 2);
	GameScreen.drawPanel.repaint();
    }
    
    public void goLeft(){
	setX( getX() - 2);
	GameScreen.drawPanel.repaint();
    }
    
    public void goRight(){
	setX( getX() + 2);
	GameScreen.drawPanel.repaint();
    }
    
    public void draw( Graphics g )
    {
	Graphics2D d = (Graphics2D) g;	

	// sets the color of the tank
	d.setColor( color );

	// top half of the tank
	d.fillRect((int)x - (2 * size), (int)y + size + (size / 2),
		   (4 * size),(size / 2));
	d.fillRoundRect((int)x - (2 * size), (int)y + size, 
			4 * size, size, 40, 40 );
		
	// the wheels of the tank
	d.fillOval((int)x -(2 * size), (int)(y + (1.5 * size)), size, size);
	d.fillOval((int)x - size, (int)(y + (1.5 * size)), size, size);
	d.fillOval((int)x , (int)(y + (1.5 * size)), size, size);
	d.fillOval((int)x + size, (int)(y + (1.5 * size)), size, size);
		
	//the line at the bottom
	d.drawLine((int)(x - (1.5 * size)), (int)(y + (2.5 * size)),
		   (int)(x + (1.5 * size)), (int)(y + (2.5 * size)));
		
	// the top part of the tank
	d.fillOval((int)x - size,(int)y, 2 * size, 2 *size);
		
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
