import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class drawTank extends JPanel implements ActionListener {
	private int color;
    private Color c;
	private JRadioButton black;
	private JRadioButton blue;
	private JRadioButton green;
	private JRadioButton yellow;
	private JRadioButton red;
	
	public drawTank() {
		setColor(0);
		ButtonGroup colorGroup = new ButtonGroup();
		black = new JRadioButton("black");
		black.setSelected(true);
		blue = new JRadioButton("blue");
		green = new JRadioButton("green");
		yellow = new JRadioButton("yellow");
		red = new JRadioButton("red");
		colorGroup.add(black);
		colorGroup.add(blue);
		colorGroup.add(green);
		colorGroup.add(yellow);
		colorGroup.add(red);
		black.addActionListener(this);
		blue.addActionListener(this);
		green.addActionListener(this);
		yellow.addActionListener(this);
		red.addActionListener(this);
		add(black);
		add(blue);
		add(green);
		add(yellow);
		add(red);
		
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() { return color; }

    public Color getTheColor() { return c; }
    public void setTheColor(Color cc) { c = cc; }
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == black) {
			this.setColor(0);
			this.repaint();
		}
		if(e.getSource() == blue) {
			this.setColor(1);
			this.repaint();
		}
		if(e.getSource() == green) {
			this.setColor(2);
			this.repaint();
		}
		if(e.getSource() == yellow) {
			this.setColor(3);
			this.repaint();
		}
		if(e.getSource() == red) {
			this.setColor(4);
			this.repaint();
		}
			
	}
	
	public void paintComponent(Graphics t) {
        int xCord = 200;
        int yCord = 70;
        int radius = 30;

        super.paintComponent(t);
        //drawRect(x,y,width,height)                                                                                                                  
        //drawOval(x,y,width,height)                                                                                                                  
        //t.drawRoundRect(x, y, width, height, arcWidth, arcHeight)                                                                                   
        if(getColor() == 0)
	    {
		setTheColor(Color.BLACK);
	    }
        if(getColor() == 1)
	    {        
		setTheColor(Color.BLUE);
	    }
        if(getColor() == 2)
	    {
		setTheColor(Color.GREEN);
       	    }
	if(getColor() == 3)
	    {
		setTheColor(Color.YELLOW);
       	    }
	if(getColor() == 4)
	    {
		setTheColor(Color.RED);
	    }
	t.setColor(c);
	// middle of tank                                                                                                                             
        t.fillRect(xCord,yCord - (radius / 6) + 5,(4 * radius),radius /2);
        t.fillRoundRect(xCord, yCord - (radius/2), 4 * radius, radius, 40, 40 );

        // the wheels of the tank                                                                                                                     
        t.fillOval(xCord,yCord,radius,radius);
        t.fillOval(xCord + radius,yCord,radius,radius);
        t.fillOval(xCord + (2 * radius),yCord,radius,radius);
        t.fillOval(xCord + (3 * radius),yCord,radius,radius);

        //the line at the bottom                                                                                                                      
        t.drawRect(xCord + (radius/2), yCord + (radius/2), 3 * radius, radius/2);
        // the top part of the tank                                                                                                                   
        t.fillOval(xCord + (radius), yCord - (3* radius)/2, 2 * radius,  2 *radius);
        t.fillRoundRect(xCord - radius, yCord - (3 * radius)/2, (3 * radius) + (radius / 4) , radius / 3,20,20);
	}
	
}
