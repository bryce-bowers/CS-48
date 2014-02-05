import javax.swing.JFrame;


public class move {
    public static void main(String[] args) throws Exception {
	JFrame f = new JFrame();
	keyMovement s = new keyMovement();
	f.add(s);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(800,600);
    }    
}


