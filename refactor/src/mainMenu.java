import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;


public class mainMenu extends JFrame{

    public mainMenu() throws IOException{
	super("Tanks!");
	
	// adds Tanks background
	getContentPane().add(new menuBackground("mainPic.jpg"));

	this.setSize(541, 500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
    }
    
    public void open() {
	this.setVisible(true);
    }
    public void close() {
	this.setVisible(false);
    }

}
