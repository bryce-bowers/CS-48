import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/** menuBackground is a class that paints mainPic.jpg to the main menu
    @author Benjamin Hartl
    @author Nick Abrahan
    @author Colin Biafore
    @author Bryce Bowers
    @version 1.0
*/

public class menuBackground extends JPanel {
    public Image backgroundImage;

    /** Constructor
	creates a JPanel to put the background image on
    */

    public menuBackground() {
	super();
    }
    
    /** Constructor 
	reads in the name of an image for the background image
       @param fileName name of the image to be set as the main menu background
    */
    public menuBackground(String fileName) throws IOException {
	backgroundImage = ImageIO.read(new File(fileName));
    }

    /**
       draws the background image
    */

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	g.drawImage(backgroundImage, 0, 0, this);
    }
}
