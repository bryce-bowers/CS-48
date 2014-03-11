import java.io.*;
import javax.sound.sampled.*;

public class playMusic {
    public static File soundFile;


    public playMusic(String musicFile){
        soundFile = new File(musicFile);
    }

	public static void startMusic()
	{
		try{
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
