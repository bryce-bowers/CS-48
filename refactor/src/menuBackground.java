import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class menuBackground extends JPanel {
    public Image backgroundImage;

    public menuBackground() {
	super();
    }
    
    public menuBackground(String fileName) throws IOException {
	backgroundImage = ImageIO.read(new File(fileName));
    }
    
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	
	g.drawImage(backgroundImage, 0, 0, this);
    }
}
