import java.io.*;
import javax.sound.sampled.*;

public class playMusic {


	public static void startMusic()
	{
		try{
			File soundFile = new File("sample.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	    } catch (IOException e) {
	         e.printStackTrace();
	    } catch (LineUnavailableException e) {
	         e.printStackTrace();
	    }

	}
}
