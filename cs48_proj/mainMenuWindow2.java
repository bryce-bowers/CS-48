import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;




public class mainMenuWindow2 {
	
	
	public static void main(String[] args) throws IOException {
	       
	    mainMenuFrame startFrame = new mainMenuFrame();
	    playMusic BGM = new playMusic();

	    startFrame.drawFrame();
	    BGM.startMusic();
		

	}

}

