package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Cage extends StaticBody {

    //create cage object;

    private static SoundClip cageSound;

    private static final Shape cageShape = new PolygonShape(-1.01f,-1.4f, -1.01f,0.28f, 0.0f,1.48f, 0.94f,0.28f, 1.01f,-1.38f);

    private static final BodyImage image =
            new BodyImage("data/cage.png",3f);

    // creates the sound for the cage
    static {
        try {
            cageSound = new SoundClip("data/cageSA.wav");
            System.out.println("Loading cage sound");
        }  catch (UnsupportedAudioFileException | LineUnavailableException | IOException e){
            System.out.println(e);
        }
    }

    // Creates the cage image when it is created
    public Cage(World w) {
        super(w,cageShape);
        addImage(image);
    }

    //methods to play the cage sound effect
    public static void playCageSA(){
        cageSound.play();
    }
}
