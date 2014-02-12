import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class DrawTank extends JPanel{
    DrawTank(int xcord, int ycord, int s, Color c){
	size = s;
	x = xcord;
	y = ycord;
	color = c;
    }
    
    private Color color = Color.RED;
    private int size = 20; 
    private int tShift = 20;
    private double x = tShift , y = tShift;
    
    @Override
    public void paint(Graphics g) {
	//paintComponent draws things
	//	super.paintComponent(g);            // runs super class, then this class
	Graphics2D d = (Graphics2D) g;      
	d.translate(tShift,tShift);                 // Shifts to new x and y coord
	d.setColor(color);
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
