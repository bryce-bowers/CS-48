import java.io.*;
import javax.sound.sampled.*;

public class playMusic {
    static File soundFile;
    static Clip clip = null;
    static boolean isInit = false;

    public playMusic(String musicFile){
        soundFile = new File(musicFile);
	initialize();
    }

    public void initialize(){

	try{
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	    clip = AudioSystem.getClip();
	    clip.open(audioIn);
	} catch (UnsupportedAudioFileException e) {
	    e.printStackTrace();
	    System.out.println("bananas");
	} catch (IOException e) {
	    e.printStackTrace();
	    System.out.println("darn");
	} catch (LineUnavailableException e) {
	    e.printStackTrace();
	    System.out.println("poop");
	}
    
    }


    public static void startMusic()
    {
	clip.start();
    }
    public static void resetMusic()
    {
	clip.setFramePosition(0);
    }

    public static void stopMusic()
    {
	    clip.stop();
    }
}

