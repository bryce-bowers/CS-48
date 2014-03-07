import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class drawTank extends JPanel implements ActionListener {
    private Color c;
    public int xCord = 100;
    public int yCord = 150;
    public int radius = 30;
    private JRadioButton black;
    private JRadioButton blue;
    private JRadioButton green;
    private JRadioButton yellow;
    private JRadioButton red;
	
    public drawTank() {
	setTheColor( Color.BLACK );
	createButtonGroup();
    }

    public Color getTheColor() { return c; }
    public void setTheColor(Color cc) { c = cc; }

    public void createButtonGroup()
    {
	ButtonGroup colorGroup = new ButtonGroup();

	black = new JRadioButton( "black" );
	blue = new JRadioButton( "blue" );
	green = new JRadioButton( "green" );
	yellow = new JRadioButton( "yellow" );
	red = new JRadioButton( "red" );
	black.setSelected( true );

	colorGroup.add( black );
	colorGroup.add( blue );
	colorGroup.add( green );
	colorGroup.add( yellow );
	colorGroup.add( red );

	black.addActionListener( this );
	blue.addActionListener( this );
	green.addActionListener( this );
	yellow.addActionListener( this );
	red.addActionListener( this );

	this.add( black );
	this.add( blue );
	this.add( green );
	this.add( yellow );
	this.add( red );
}
	
    public void actionPerformed(ActionEvent e) {
	if(e.getSource() == black) 
	    this.setTheColor( Color.BLACK );
	
	if(e.getSource() == blue) 
	    this.setTheColor( Color.BLUE );
	
	if(e.getSource() == green) 
	    this.setTheColor( Color.GREEN );
	
	if(e.getSource() == yellow) 
	    this.setTheColor( Color.YELLOW );
	
	if(e.getSource() == red) 
	    this.setTheColor( Color.RED );
	
	this.repaint();			
    }
	
    public void paintComponent(Graphics t)
    {
        super.paintComponent(t);
        //drawRect(x,y,width,height)
	//drawOval(x,y,width,height)
        //drawRoundRect(x, y, width, height, arcWidth, arcHeight)             
	
	t.setColor( getTheColor() );

	// middle of tank                                     
        t.fillRect( xCord, yCord - ( radius / 6 ) + 5,
		    ( 4 * radius ),radius / 2);
        t.fillRoundRect( xCord, yCord - ( radius / 2 ),
			 4 * radius, radius, 40, 40 );

        // the wheels of the tank                                      
        t.fillOval( xCord, yCord, radius, radius );
        t.fillOval( xCord + radius, yCord, radius, radius );
        t.fillOval( xCord + ( 2 * radius ), yCord, radius, radius );
        t.fillOval( xCord + ( 3 * radius ), yCord, radius, radius );

        //the line at the bottom
        t.drawRect( xCord + ( radius / 2 ), yCord + ( radius / 2 ),
		   3 * radius, radius / 2 );
        // the top part of the tank                              
        t.fillOval( xCord + radius, yCord - ( 3 * radius) / 2,
		    2 * radius, 2 * radius );
        t.fillRoundRect( xCord - radius, yCord - ( 3 * radius ) / 2,
			( 3 * radius ) + ( radius / 4 ) , radius / 3, 20, 20 );
	}
	
}
