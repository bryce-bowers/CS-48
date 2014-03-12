import java.io.*;
import javax.sound.sampled.*;

/** playMusic is a class that helps load the Tanks theme music into the game
    @author Benjamin Hartl
    @author Nick Abrahan
    @author Colin Biafore
    @author Bryce Bowers
    @version 1.0
*/

public class playMusic {
    public File soundFile;
    public Clip clip = null;

    /** Constructor creates a new file holding an audio file
	@param musicFile Name of the music file to be played in the game
    */

    public playMusic(String musicFile){
        soundFile = new File(musicFile);
	initialize();
	resetMusic();

    }

    /**
       opens an audio stream and creates a clip holding the audio file 
    */

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

    /**
       plays music
    */

    public void startMusic()
    {
	clip.start();
	resetMusic();
    }

    /**
       plays music from the beginning of the clip
    */

    public void resetMusic()
    {
	clip.setFramePosition(0);
    }

    /**
       stops music playback
    */

    public void stopMusic()
    {
	clip.stop();
    }
}

