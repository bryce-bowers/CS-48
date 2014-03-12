import java.io.*;
import javax.sound.sampled.*;

public class playMusic {
    public File soundFile;
    public Clip clip = null;

    public playMusic(String musicFile){
        soundFile = new File(musicFile);
	initialize();
	resetMusic();

    }

    public void initialize(){

	try{
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	    clip = AudioSystem.getClip();
	    clip.open(audioIn);
	} catch (UnsupportedAudioFileException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (LineUnavailableException e) {
	    e.printStackTrace();
	}
    
    }


    public void startMusic()
    {
	clip.start();
	resetMusic();
    }

    public void resetMusic()
    {
	clip.setFramePosition(0);
    }

    public void stopMusic()
    {
	clip.stop();
    }
}

