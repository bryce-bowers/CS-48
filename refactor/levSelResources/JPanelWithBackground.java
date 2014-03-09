import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelWithBackground extends JPanel {
		private Image backgroundImage;

		public JPanelWithBackground() throws IOException {
			backgroundImage = ImageIO.read(new File("imageNotFound.jpg"));
		}
		
		public JPanelWithBackground(String fileName) throws IOException {
			backgroundImage = ImageIO.read(new File(fileName));
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawImage(backgroundImage, 0, 0, this);
		}
}
