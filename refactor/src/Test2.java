import javax.swing.*;
import java.awt.*;
import java.lang.Thread.*;

public class Test2 {

    public static void main(String[] args) {
	JFrame frame = new JFrame("Test Window");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(600,600);
	frame.setVisible(true);
	Projectile proj = new Projectile(40,80);
	frame.getContentPane().add(proj);
	proj.fireProjectile();
	

	
    }
}