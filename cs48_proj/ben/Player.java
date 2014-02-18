public class Player{

	static int playerCount;
	private String name;
	private int playerNumber;
	private int health;
	private int fuel;
	//public Color color;
	public double x, y;
	public double degree = 90;
	
	public Player(String s, double newX, double newY){
		name = s;
		x = newX;
		y = newY;
	}
	
	public double getX(){ return x; }
	
	public double getY(){ return y; }
	
	public double getDegree(){ return degree; }
	
	public void setX(double newX){
		if(( newX >= (2 * keyMovement2.size))  &&  (newX <= keyMovement2.maxX -(3 * keyMovement2.size)))
			x = newX;
	}
	
	public void setY(double newY){
		//System.out.println("new y = 10 * Math.sin(.1 * x)   ==> " + 10 * Math.sin(.05 * x));
		y =  400 - 10 * Math.sin(.05 * x);
	 	//y = newY;
	}
	
	public void setDegree(double newDeg){
		if((newDeg <= 180) && (newDeg >= 0))
			degree = newDeg;
	}

	public void goUp(){
		setDegree( getDegree() + 2);
		keyMovement2.drawPanel.repaint();
		
    }
    
    public void goDown(){
		setDegree( getDegree() - 2);
		keyMovement2.drawPanel.repaint();
    }
    
    public void goLeft(){
		setX( getX() - 2);
		keyMovement2.drawPanel.repaint();
    }
    
    public void goRight(){
		setX( getX() + 2);
		keyMovement2.drawPanel.repaint();
    }
    
 




}